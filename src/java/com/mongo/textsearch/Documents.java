/*
 * Iman Tech Solutions,
 * Hyderabad, India
 * 
 */
package com.mongo.textsearch;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Lokesh Kotha
 */
class Documents {

    private String _id;
    private String name;
    private String title;
    private String description;
//    private DocumentTypes documentType;
    private String index;
//    private List<Authors> authors;
//    private List<Authors> translators;
    private String versionNumber;
    private String noOfPages;
    private String resolution;
//    private Folders folder;
    private String iSBN;
    private Double price;
//    private Publication publication;
    private String bigImage;
    private String smallImage;
    private List<String> membershipTypes;
//    private Status status;
    private String noOfPagesByExternal;
    private Date createdDate;
    private Date modifiedDate;
//    private Members createdBy;
//    private Members modifiedBy;
//    private List<AdditionalFields> additionalFields;
    private String keywords;
    private Date publicationDate;
    private String volumeNumber;
    private String issueNumber;
    private String websiteURL;
    private String downloadURL;
    private String fileURL;
    private String shoppingURL;
    private Boolean printable;
    private Boolean downloadable;
    private Boolean viewable;
//    private Languages language;
//    private ResourceType resourceType;
//    private Subjects subjects;
    private String source;

    public Documents() {
    }

    public String getId() {
        return _id;
    }

    public void setId(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(String versionNumber) {
        this.versionNumber = versionNumber;
    }

    public String getNoOfPages() {
        return noOfPages;
    }

    public void setNoOfPages(String noOfPages) {
        this.noOfPages = noOfPages;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getiSBN() {
        return iSBN;
    }

    public void setiSBN(String iSBN) {
        this.iSBN = iSBN;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBigImage() {
        return bigImage;
    }

    public void setBigImage(String bigImage) {
        this.bigImage = bigImage;
    }

    public String getSmallImage() {
        return smallImage;
    }

    public void setSmallImage(String smallImage) {
        this.smallImage = smallImage;
    }

    public List<String> getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(List<String> membershipTypes) {
        this.membershipTypes = membershipTypes;
    }

    public String getNoOfPagesByExternal() {
        return noOfPagesByExternal;
    }

    public void setNoOfPagesByExternal(String noOfPagesByExternal) {
        this.noOfPagesByExternal = noOfPagesByExternal;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(String volumeNumber) {
        this.volumeNumber = volumeNumber;
    }

    public String getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(String issueNumber) {
        this.issueNumber = issueNumber;
    }

    public String getWebsiteURL() {
        return websiteURL;
    }

    public void setWebsiteURL(String websiteURL) {
        this.websiteURL = websiteURL;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public void setDownloadURL(String downloadURL) {
        this.downloadURL = downloadURL;
    }

    public String getFileURL() {
        return fileURL;
    }

    public void setFileURL(String fileURL) {
        this.fileURL = fileURL;
    }

    public String getShoppingURL() {
        return shoppingURL;
    }

    public void setShoppingURL(String shoppingURL) {
        this.shoppingURL = shoppingURL;
    }

    public Boolean getPrintable() {
        return printable;
    }

    public void setPrintable(Boolean printable) {
        this.printable = printable;
    }

    public Boolean getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(Boolean downloadable) {
        this.downloadable = downloadable;
    }

    public Boolean getViewable() {
        return viewable;
    }

    public void setViewable(Boolean viewable) {
        this.viewable = viewable;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
