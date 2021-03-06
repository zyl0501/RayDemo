package com.example.administrator.mobilepacsviewer.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SERVICE_ORG_DO".
 */
public class ServiceOrgDO {

    private Long id;
    /** Not-null value. */
    private String OrganizationID;
    private String OrganizationName;

    public ServiceOrgDO() {
    }

    public ServiceOrgDO(Long id) {
        this.id = id;
    }

    public ServiceOrgDO(Long id, String OrganizationID, String OrganizationName) {
        this.id = id;
        this.OrganizationID = OrganizationID;
        this.OrganizationName = OrganizationName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /** Not-null value. */
    public String getOrganizationID() {
        return OrganizationID;
    }

    /** Not-null value; ensure this value is available before it is saved to the database. */
    public void setOrganizationID(String OrganizationID) {
        this.OrganizationID = OrganizationID;
    }

    public String getOrganizationName() {
        return OrganizationName;
    }

    public void setOrganizationName(String OrganizationName) {
        this.OrganizationName = OrganizationName;
    }

}
