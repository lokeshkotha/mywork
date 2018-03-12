/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.mongo.textsearch;

import com.mongo.location.SpringMongoConfig;
import com.mongodb.BasicDBObject;
import static com.mongodb.client.model.Filters.text;
import static java.lang.ProcessBuilder.Redirect.to;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale.Category;
import java.util.Map;
import org.bson.types.ObjectId;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import static org.springframework.data.mongodb.core.aggregation.Fields.field;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.TypedAggregation;
import org.springframework.data.mongodb.core.index.TextIndexDefinition;
import org.springframework.data.mongodb.core.index.TextIndexDefinition.TextIndexDefinitionBuilder;
import org.springframework.data.mongodb.core.query.Criteria;
import static org.springframework.data.mongodb.core.query.Criteria.byExample;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;

/**
 *
 * @author Lokesh Kotha
 */
public class TextSearch {

    private final MongoOperations mongoOperation;
    private Query q;
    private Criteria criteria;
    private final String SUCCESS = "Success";
    private final String FAILURE = "Failure";

    public TextSearch() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringMongoConfig.class);
        mongoOperation = (MongoOperations) ctx.getBean("mongoTemplate");
    }

    public List<Documents> getDocumentsByFieldsSearch(String searchField, String searchText, Map<String, String> extraSearchFields, int chunkSize, int storedChunkSize) {
        List<Criteria> criteriaList = new ArrayList<>();
        extraSearchFields.put(searchField, searchText);
        for (Map.Entry<String, String> entry : extraSearchFields.entrySet()) {
            if (!entry.getKey().equals("all") && entry.getKey().equals("authors") && entry.getKey().equals("translators") && entry.getKey().equals("additionalFields")) {
                criteriaList.add(Criteria.where(entry.getKey()).regex(entry.getValue(), "i"));
            } else if (entry.getKey().equals("authors")) {
                criteriaList.add(Criteria.where("authors.name").regex(entry.getValue(), "i"));
            } else if (entry.getKey().equals("translators")) {
                criteriaList.add(Criteria.where("translators.name").regex(entry.getValue(), "i"));
            } else if (entry.getKey().equals("additionalFields")) {
                criteriaList.add(Criteria.where("additionalFields.value").regex(entry.getValue(), "i"));
            }
        }
        q = new Query();
        criteria = new Criteria();
        criteria.andOperator(criteriaList.toArray(new Criteria[criteriaList.size()]));
        q.addCriteria(criteria);
        q.limit(chunkSize);
        q.skip(storedChunkSize);
        List<Documents> documentsList = mongoOperation.find(q, Documents.class);
        return documentsList;
    }

    public void test() {
        String searchText = "text";
        int storedChunkSize = 0;
        int chunkSize = 0;
        MatchOperation matchOperation = new MatchOperation(Criteria.where("_id").is(new ObjectId("58a18eaf63e8f60da4d57b98")));
        LookupOperation lookupOperation = LookupOperation.newLookup().
                from("membershipSubscriptions").
                localField("memberships._id").
                foreignField("memberships._id").
                as("memberships");
        Aggregation aggregation = Aggregation.newAggregation(lookupOperation);
        List<BasicDBObject> results = mongoOperation.aggregate(aggregation, "membershipListings", BasicDBObject.class).getMappedResults();
        List<MembershipListings> listinglist = new LinkedList<MembershipListings>();
        q = new Query();
        q.addCriteria(Criteria.where("expiryofsubscription").gte(new Date()));
        if (storedChunkSize > 0) {
            q.skip(storedChunkSize);
        }
        q.limit(chunkSize);
        q.with(new Sort(Sort.Direction.DESC, "plans.planamount"));
        List<MembershipSubscriptions> membershipSubscriptionList = mongoOperation.find(q, MembershipSubscriptions.class);
        for (MembershipSubscriptions membershipSubscriptions : membershipSubscriptionList) {
            q = new Query();
            q.addCriteria(Criteria.where("memberships._id").is(new ObjectId(membershipSubscriptions.getId())));
            MembershipListings listingsObj = mongoOperation.findOne(q, MembershipListings.class);
            if (listingsObj != null) {
                listinglist.add(listingsObj);
            }
        }
        q = new Query();
        q.limit(10);
        q.addCriteria(TextCriteria.forDefaultLanguage().matchingPhrase("aut"));
//        to put text index to particular field 
        TextIndexDefinition textIndex = new TextIndexDefinitionBuilder().onField("categoryname").build();
        mongoOperation.indexOps(Category.class).ensureIndex(textIndex);
//        search by whole word
        TextCriteria tc = new TextCriteria().matching("/" + searchText + "/");
        q = TextQuery.queryText(tc).sortByScore();
        q.fields().include("categoryname");
        q.limit(10);
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingPhrase("aut");
        q = TextQuery.queryText(criteria).sortByScore().with(new PageRequest(0, 5));
    }

    public MembershipListings getBannerListingByState(String stateId) {
        MatchOperation matchOperation = new MatchOperation(Criteria.where("membershipSubscriptions.plans.bannerimage").is(true).andOperator(Criteria.where("bannerimageurl").ne(""), Criteria.where("states._id").is(new ObjectId(stateId)), Criteria.where("status.statusname").is("Approved")));
        CustomSampleOperation customSampleOperation = new CustomSampleOperation(1);
        TypedAggregation<MembershipListings> typedAggr = Aggregation.newAggregation(MembershipListings.class, matchOperation, customSampleOperation);
        AggregationResults<MembershipListings> aggregationResults = mongoOperation.aggregate(typedAggr, MembershipListings.class);
        if (!aggregationResults.getMappedResults().isEmpty()) {
            MembershipListings dbObject = aggregationResults.getMappedResults().get(0);
            return dbObject;
        } else {
            return null;
        }
    }

    public List<MembershipListings> textSearchByListings(String searchText, int limit) {
        ExampleMatcher matcher = ExampleMatcher.matching().withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnoreCase();
        MembershipListings listings = new MembershipListings();
        listings.setTitleofthecompany(searchText);
        Example<MembershipListings> listingMatcher = Example.of(listings, matcher);
        q = new Query();
        q.limit(limit);
        q.addCriteria(Criteria.where("membershipSubscriptions.expiryofsubscription").gte(new Date()));
        q.addCriteria(Criteria.where("status.statusname").is("Approved"));
        q.addCriteria(byExample(listingMatcher));
        q.fields().include("_id");
        q.fields().include("titleofthecompany");
        q.fields().include("category");
        q.fields().include("subcategory");
        List<MembershipListings> listingses = mongoOperation.find(q, MembershipListings.class);
        return listingses;
    }
}
