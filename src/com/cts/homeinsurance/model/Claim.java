package com.cts.homeinsurance.model;

import java.sql.Date;

public class Claim {
    private int claimId;
    private int policyId;
    private int homeownerId;
    private Date claimDate;
    private String status;

    public Claim(int claimId, int policyId, int homeownerId, Date claimDate, String status) {
        this.claimId = claimId;
        this.policyId = policyId;
        this.homeownerId = homeownerId;
        this.claimDate = claimDate;
        this.status = status;
    }
    //HERE I USED THE GETTER SETTER METHOD
    public int getClaimId() {
        return claimId;
    }

    public void setClaimId(int claimId) {
        this.claimId = claimId;
    }

    public int getPolicyId() {
        return policyId;
    }

    public void setPolicyId(int policyId) {
        this.policyId = policyId;
    }

    public int getHomeownerId() {
        return homeownerId;
    }

    public void setHomeownerId(int homeownerId) {
        this.homeownerId = homeownerId;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Added getter for claimId
    public int getId() {
        return claimId;
    }
}
