package com.example.administrator.mobilepacsviewer.model;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "SEARCH_TEMPLATE_ENTITY".
 */
public class SearchTemplateEntity {

    private Long id;
    private String SearchName;
    private String AccessionNumber;
    private String Name;
    private String MedRecNO;
    private String OrganizationID;
    private String RequestDeptName;
    private String PatientClass;
    private String ServiceSectID;
    private String RequestedDateStart;
    private String RequestedDateEnd;

    public SearchTemplateEntity() {
    }

    public SearchTemplateEntity(Long id) {
        this.id = id;
    }

    public SearchTemplateEntity(Long id, String SearchName, String AccessionNumber, String Name, String MedRecNO, String OrganizationID, String RequestDeptName, String PatientClass, String ServiceSectID, String RequestedDateStart, String RequestedDateEnd) {
        this.id = id;
        this.SearchName = SearchName;
        this.AccessionNumber = AccessionNumber;
        this.Name = Name;
        this.MedRecNO = MedRecNO;
        this.OrganizationID = OrganizationID;
        this.RequestDeptName = RequestDeptName;
        this.PatientClass = PatientClass;
        this.ServiceSectID = ServiceSectID;
        this.RequestedDateStart = RequestedDateStart;
        this.RequestedDateEnd = RequestedDateEnd;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSearchName() {
        return SearchName;
    }

    public void setSearchName(String SearchName) {
        this.SearchName = SearchName;
    }

    public String getAccessionNumber() {
        return AccessionNumber;
    }

    public void setAccessionNumber(String AccessionNumber) {
        this.AccessionNumber = AccessionNumber;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMedRecNO() {
        return MedRecNO;
    }

    public void setMedRecNO(String MedRecNO) {
        this.MedRecNO = MedRecNO;
    }

    public String getOrganizationID() {
        return OrganizationID;
    }

    public void setOrganizationID(String OrganizationID) {
        this.OrganizationID = OrganizationID;
    }

    public String getRequestDeptName() {
        return RequestDeptName;
    }

    public void setRequestDeptName(String RequestDeptName) {
        this.RequestDeptName = RequestDeptName;
    }

    public String getPatientClass() {
        return PatientClass;
    }

    public void setPatientClass(String PatientClass) {
        this.PatientClass = PatientClass;
    }

    public String getServiceSectID() {
        return ServiceSectID;
    }

    public void setServiceSectID(String ServiceSectID) {
        this.ServiceSectID = ServiceSectID;
    }

    public String getRequestedDateStart() {
        return RequestedDateStart;
    }

    public void setRequestedDateStart(String RequestedDateStart) {
        this.RequestedDateStart = RequestedDateStart;
    }

    public String getRequestedDateEnd() {
        return RequestedDateEnd;
    }

    public void setRequestedDateEnd(String RequestedDateEnd) {
        this.RequestedDateEnd = RequestedDateEnd;
    }

}