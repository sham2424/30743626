package com.cts.homeinsurance.util;
import java.util.*;

import com.cts.homeinsurance.model.Policy;
import com.cts.homeinsurance.model.Homeowner;
import com.cts.homeinsurance.model.Claim;
import com.cts.homeinsurance.service.PolicyService;
import com.cts.homeinsurance.service.HomeownerService;
import com.cts.homeinsurance.service.ClaimService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PolicyService policyService = new PolicyService();
        HomeownerService homeownerService = new HomeownerService();
        ClaimService claimService = new ClaimService();

        int choice;
        do {
            System.out.println("Home Insurance Management System");
            System.out.println("1. Policy Management");
            System.out.println("2. Homeowner Management");
            System.out.println("3. Claim Management");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1:
                        policyManagement(scanner, policyService);
                        break;
                    case 2:
                        homeownerManagement(scanner, homeownerService);
                        break;
                    case 3:
                        claimManagement(scanner, claimService);
                        break;
                    case 4:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (Exception e) {
                System.err.println("An error occurred: " + e.getMessage());
            }
        } while (choice != 4);
    }

    public static void policyManagement(Scanner scanner, PolicyService policyService) {
        System.out.println("Policy Management");
        System.out.println("1. Add Policy");
        System.out.println("2. View Policy");
        System.out.println("3. Update Policy");
        System.out.println("4. Delete Policy");
        System.out.print("Enter your choice: ");
        int policyChoice = scanner.nextInt();

        switch (policyChoice) {
            case 1:
                System.out.print("Enter policy number: ");
                String policyNumber = scanner.next();
                System.out.print("Enter policy type: ");
                String type = scanner.next();
                System.out.print("Enter coverage amount: ");
                double coverageAmount = scanner.nextDouble();
                System.out.print("Enter premium amount: ");
                double premiumAmount = scanner.nextDouble();
                Policy policy = new Policy(0, policyNumber, type, coverageAmount, premiumAmount);
                policyService.addPolicy(policy);
                break;
            case 2:
                System.out.print("Enter policy ID: ");
                int policyId = scanner.nextInt();
                policyService.viewPolicy(policyId);
                break;
            case 3:
                System.out.print("Enter policy ID to update: ");
                int updatePolicyId = scanner.nextInt();
                System.out.print("Enter new policy number: ");
                String newPolicyNumber = scanner.next();
                System.out.print("Enter new policy type: ");
                String newType = scanner.next();
                System.out.print("Enter new coverage amount: ");
                double newCoverageAmount = scanner.nextDouble();
                System.out.print("Enter new premium amount: ");
                double newPremiumAmount = scanner.nextDouble();
                Policy updatePolicy = new Policy(updatePolicyId, newPolicyNumber, newType, newCoverageAmount, newPremiumAmount);
                policyService.updatePolicy(updatePolicy);
                break;
            case 4:
                System.out.print("Enter policy ID to delete: ");
                int deletePolicyId = scanner.nextInt();
                policyService.deletePolicy(deletePolicyId);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void homeownerManagement(Scanner scanner, HomeownerService homeownerService) {
        System.out.println("Homeowner Management");
        System.out.println("1. Register Homeowner");
        System.out.println("2. View Homeowner");
        System.out.println("3. Update Homeowner");
        System.out.println("4. Delete Homeowner");
        System.out.print("Enter your choice: ");
        int homeownerChoice = scanner.nextInt();

        switch (homeownerChoice) {
            case 1:
                System.out.print("Enter homeowner name: ");
                String name = scanner.next();
                System.out.print("Enter homeowner email: ");
                String email = scanner.next();
                System.out.print("Enter homeowner phone number: ");
                String phoneNumber = scanner.next();
                System.out.print("Enter homeowner address: ");
                String address = scanner.next();
                Homeowner homeowner = new Homeowner(0, name, email, phoneNumber, address);
                homeownerService.addHomeowner(homeowner);
                break;
            case 2:
                System.out.print("Enter homeowner ID: ");
                int homeownerId = scanner.nextInt();
                homeownerService.viewHomeowner(homeownerId);
                break;
            case 3:
                System.out.print("Enter homeowner ID to update: ");
                int updateHomeownerId = scanner.nextInt();
                System.out.print("Enter new homeowner name: ");
                String newName = scanner.next();
                System.out.print("Enter new homeowner email: ");
                String newEmail = scanner.next();
                System.out.print("Enter new homeowner phone number: ");
                String newPhoneNumber = scanner.next();
                System.out.print("Enter new homeowner address: ");
                String newAddress = scanner.next();
                Homeowner updateHomeowner = new Homeowner(updateHomeownerId, newName, newEmail, newPhoneNumber, newAddress);
                homeownerService.updateHomeowner(updateHomeowner);
                break;
            case 4:
                System.out.print("Enter homeowner ID to delete: ");
                int deleteHomeownerId = scanner.nextInt();
                homeownerService.deleteHomeowner(deleteHomeownerId);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void claimManagement(Scanner scanner, ClaimService claimService) {
        System.out.println("Claim Management");
        System.out.println("1. Submit Claim");
        System.out.println("2. View Claim");
        System.out.println("3. Update Claim");
        System.out.println("4. Delete Claim");
        System.out.print("Enter your choice: ");
        int claimChoice = scanner.nextInt();

        switch (claimChoice) {
            case 1:
                System.out.print("Enter policy ID: ");
                int policyId = scanner.nextInt();
                System.out.print("Enter homeowner ID: ");
                int homeownerId = scanner.nextInt();
                System.out.print("Enter claim date (YYYY-MM-DD): ");
                String claimDate = scanner.next();
                System.out.print("Enter claim status (submitted/processed): ");
                String status = scanner.next();
                Claim claim = new Claim(0, policyId, homeownerId, java.sql.Date.valueOf(claimDate), status);
                claimService.addClaim(claim);
                break;
            case 2:
                System.out.print("Enter claim ID: ");
                int claimId = scanner.nextInt();
                claimService.viewClaim(claimId);
                break;
            case 3:
                System.out.print("Enter claim ID to update: ");
                int updateClaimId = scanner.nextInt();
                System.out.print("Enter new claim date (YYYY-MM-DD): ");
                String newClaimDate = scanner.next();
                System.out.print("Enter new claim status (submitted/processed): ");
                String newStatus = scanner.next();
                Claim updateClaim = new Claim(updateClaimId, 0, 0, java.sql.Date.valueOf(newClaimDate), newStatus);
                claimService.updateClaim(updateClaim);
                break;
            case 4:
                System.out.print("Enter claim ID to delete: ");
                int deleteClaimId = scanner.nextInt();
                claimService.deleteClaim(deleteClaimId);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
}
