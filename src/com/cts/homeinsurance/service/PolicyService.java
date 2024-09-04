package com.cts.homeinsurance.service;

import com.cts.homeinsurance.dao.PolicyDAO;
import com.cts.homeinsurance.model.Policy;

public class PolicyService {
    private PolicyDAO policyDAO = new PolicyDAO();

    public void addPolicy(Policy policy) {
        policyDAO.addPolicy(policy);
    }

    public void updatePolicy(Policy updatePolicy) {
        policyDAO.updatePolicy(updatePolicy);
    }

    public void deletePolicy(int deletePolicyId) {
        policyDAO.deletePolicy(deletePolicyId);
    }

    public void viewPolicy(int policyId) {
        Policy policy = policyDAO.getPolicyById(policyId);
        if (policy != null) {
            System.out.println("Policy ID: " + policy.getPolicyId());
            System.out.println("Policy Number: " + policy.getPolicyNumber());
            System.out.println("Type: " + policy.getType());
            System.out.println("Coverage Amount: " + policy.getCoverageAmount());
            System.out.println("Premium Amount: " + policy.getPremiumAmount());
        } else {
            System.out.println("Policy not found!");
        }
    }
}
