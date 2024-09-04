package com.cts.homeinsurance.service;

import com.cts.homeinsurance.dao.ClaimDAO;
import com.cts.homeinsurance.model.Claim;

public class ClaimService {
    private ClaimDAO claimDAO = new ClaimDAO();

    public void addClaim(Claim claim) {
        claimDAO.addClaim(claim);
    }

    public Claim viewClaim(int claimId) {
        return claimDAO.getClaimById(claimId);
    }

    public boolean updateClaim(Claim updateClaim) {
        return claimDAO.updateClaim(updateClaim);
    }

    public boolean deleteClaim(int deleteClaimId) {
        return claimDAO.deleteClaim(deleteClaimId);
    }
}
