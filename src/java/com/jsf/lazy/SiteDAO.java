///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package com.jsf.lazy;
//
//import java.nio.file.Path;
//import java.util.Collection;
//import java.util.Map;
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Root;
//import javax.sql.rowset.Predicate;
//import org.hibernate.engine.JoinSequence.Join;
//import org.primefaces.model.SortOrder;
//
///**
// *
// * @author Lokesh Kotha
// */
//public class SiteDAO extends GenericDAO<Site>{
//
//    public SiteDAO(EntityManager entityManager) {
//        super(entityManager);
//    }
//
//    public Collection<Site> getAll(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
//        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Site> q = cb.createQuery(Site.class);
//        Root<Site> site = q.from(Site.class);
//        Join<Site,SiteType> siteType = site.join(Site_.siteType);
//        q.select(site);
//
//
//        Path<?> path = getPath(sortField, site, siteType);
//        if (sortOrder == null){
//            //just don't sort
//        }else if (sortOrder.equals(SortOrder.ASCENDING)){
//            q.orderBy(cb.asc(path));
//        }else if (sortOrder.equals(SortOrder.DESCENDING)){
//            q.orderBy(cb.asc(path));
//        }else if (sortOrder.equals(SortOrder.UNSORTED)){
//            //just don't sort
//        }else{
//            //just don't sort
//        }
//       
//        //filter
//        Predicate filterCondition = cb.conjunction();
//        for (Map.Entry<String, String> filter : filters.entrySet()) {
//            if (!filter.getValue().equals("")) {
//                //try as string using like
//                Path<String> pathFilter = getStringPath(filter.getKey(), site, siteType);
//                if (pathFilter != null){
//                    filterCondition = cb.and(filterCondition, cb.like(pathFilter, "%"+filter.getValue()+"%"));
//                }else{
//                    //try as non-string using equal
//                    Path pathFilterNonString = getPath(filter.getKey(), site, siteType);
//                    filterCondition = cb.and(filterCondition, cb.equal(pathFilterNonString, filter.getValue()));
//                }
//            }
//        }
//        q.where(filterCondition);
//       
//        //pagination
//        TypedQuery<Site> tq = entityManager.createQuery(q);
//        if (pageSize >= 0){
//            tq.setMaxResults(pageSize);
//        }
//        if (first >= 0){
//            tq.setFirstResult(first);
//        }
//        return tq.getResultList();
//    }
//
//    private Path<?> getPath(String field, Root<Site> site, Join<Site, SiteType> siteType) {
//        //sort
//        Path<?> path = null;
//        if (field == null){
//            path = site.get(Site_.name);
//        }else{
//            switch(field){
//                case "id":
//                    path = site.get(Site_.id);
//                    break;
//                case "name":
//                    path = site.get(Site_.name);
//                    break;
//                case "siteType.name":
//                    path = siteType.get(SiteType_.name);
//                    break;
//                case "ip":
//                    path = site.get(Site_.ip);
//                    break;
//                case "description":
//                    path = site.get(Site_.description);
//                    break;
//            }
//        }
//        return path;
//    }
//
//    private Path<String> getStringPath(String field, Root<Site> site, Join<Site, SiteType> siteType) {
//        //sort
//        Path<String> path = null;
//        if (field == null){
//            path = site.get(Site_.name);
//        }else{
//            switch(field){
//                case "id":
//                    path = null;
//                    break;
//                case "name":
//                    path = site.get(Site_.name);
//                    break;
//                case "siteType.name":
//                    path = siteType.get(SiteType_.name);
//                    break;
//                case "ip":
//                    path = site.get(Site_.ip);
//                    break;
//                case "description":
//                    path = site.get(Site_.description);
//                    break;
//            }
//        }
//        return path;
//    }
//}