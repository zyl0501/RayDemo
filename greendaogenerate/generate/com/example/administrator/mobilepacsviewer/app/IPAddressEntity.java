package com.example.administrator.mobilepacsviewer.app;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT. Enable "keep" sections if you want to edit. 
/**
 * Entity mapped to table "IPADDRESS_ENTITY".
 */
public class IPAddressEntity {

    private Long id;
    private String IPName;
    private String IPLogInAddrLan;
    private String IPImageAddrLan;
    private String IPLogInAddrNet;
    private String IPImageAddrNet;
    private String OrganizationID;
    private Boolean isSelLan;

    public IPAddressEntity() {
    }

    public IPAddressEntity(Long id) {
        this.id = id;
    }

    public IPAddressEntity(Long id, String IPName, String IPLogInAddrLan, String IPImageAddrLan, String IPLogInAddrNet, String IPImageAddrNet, String OrganizationID, Boolean isSelLan) {
        this.id = id;
        this.IPName = IPName;
        this.IPLogInAddrLan = IPLogInAddrLan;
        this.IPImageAddrLan = IPImageAddrLan;
        this.IPLogInAddrNet = IPLogInAddrNet;
        this.IPImageAddrNet = IPImageAddrNet;
        this.OrganizationID = OrganizationID;
        this.isSelLan = isSelLan;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIPName() {
        return IPName;
    }

    public void setIPName(String IPName) {
        this.IPName = IPName;
    }

    public String getIPLogInAddrLan() {
        return IPLogInAddrLan;
    }

    public void setIPLogInAddrLan(String IPLogInAddrLan) {
        this.IPLogInAddrLan = IPLogInAddrLan;
    }

    public String getIPImageAddrLan() {
        return IPImageAddrLan;
    }

    public void setIPImageAddrLan(String IPImageAddrLan) {
        this.IPImageAddrLan = IPImageAddrLan;
    }

    public String getIPLogInAddrNet() {
        return IPLogInAddrNet;
    }

    public void setIPLogInAddrNet(String IPLogInAddrNet) {
        this.IPLogInAddrNet = IPLogInAddrNet;
    }

    public String getIPImageAddrNet() {
        return IPImageAddrNet;
    }

    public void setIPImageAddrNet(String IPImageAddrNet) {
        this.IPImageAddrNet = IPImageAddrNet;
    }

    public String getOrganizationID() {
        return OrganizationID;
    }

    public void setOrganizationID(String OrganizationID) {
        this.OrganizationID = OrganizationID;
    }

    public Boolean getIsSelLan() {
        return isSelLan;
    }

    public void setIsSelLan(Boolean isSelLan) {
        this.isSelLan = isSelLan;
    }

}
