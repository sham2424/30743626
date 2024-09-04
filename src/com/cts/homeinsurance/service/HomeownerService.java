package com.cts.homeinsurance.service;

import com.cts.homeinsurance.dao.HomeownerDAO;
import com.cts.homeinsurance.model.Homeowner;

public class HomeownerService {
    private HomeownerDAO homeownerDAO = new HomeownerDAO();

    public void addHomeowner(Homeowner homeowner) {
        homeownerDAO.addHomeowner(homeowner);
    }

    public Homeowner viewHomeowner(int homeownerId) {
        Homeowner homeowner = homeownerDAO.getHomeownerById(homeownerId);
        if (homeowner != null) {
            System.out.println("Homeowner ID: " + homeowner.getHomeownerId());
            System.out.println("Name: " + homeowner.getName());
            System.out.println("Email: " + homeowner.getEmail());
            System.out.println("Phone Number: " + homeowner.getPhoneNumber());
            System.out.println("Address: " + homeowner.getAddress());
        } else {
            System.out.println("Homeowner not found!");
        }
        return homeowner;
    }

    public void updateHomeowner(Homeowner updateHomeowner) {
        boolean isUpdated = homeownerDAO.updateHomeowner(updateHomeowner);
        if (isUpdated) {
            System.out.println("Homeowner updated successfully!");
        } else {
            System.out.println("Failed to update homeowner. Homeowner ID might not exist.");
        }
    }

    public void deleteHomeowner(int deleteHomeownerId) {
        boolean isDeleted = homeownerDAO.deleteHomeowner(deleteHomeownerId);
        if (isDeleted) {
            System.out.println("Homeowner deleted successfully!");
        } else {
            System.out.println("Failed to delete homeowner. Homeowner ID might not exist.");
        }
    }
}
