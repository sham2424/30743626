package com.cts.homeinsurance.dao;

import com.cts.homeinsurance.model.Claim;
import com.cts.homeinsurance.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClaimDAO {

    public void addClaim(Claim claim) {
        String sql = "INSERT INTO claim (policy_id, homeowner_id, claim_date, status) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, claim.getPolicyId());
            preparedStatement.setInt(2, claim.getHomeownerId());
            preparedStatement.setDate(3, claim.getClaimDate());
            preparedStatement.setString(4, claim.getStatus());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Claim added successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error adding claim: " + e.getMessage());
        }
    }

    public Claim viewClaim(int claimId) {
        String sql = "SELECT * FROM claim WHERE claim_id = ?";
        Claim claim = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, claimId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int policyId = resultSet.getInt("policy_id");
                int homeownerId = resultSet.getInt("homeowner_id");
                Date claimDate = resultSet.getDate("claim_date");
                String status = resultSet.getString("status");
                claim = new Claim(claimId, policyId, homeownerId, claimDate, status);
            }
        } catch (SQLException e) {
            System.err.println("Error viewing claim: " + e.getMessage());
        }

        return claim;
    }

    public boolean updateClaim(Claim claim) {
        String sql = "UPDATE claim SET policy_id = ?, homeowner_id = ?, claim_date = ?, status = ? WHERE claim_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, claim.getPolicyId());
            preparedStatement.setInt(2, claim.getHomeownerId());
            preparedStatement.setDate(3, claim.getClaimDate());
            preparedStatement.setString(4, claim.getStatus());
            preparedStatement.setInt(5, claim.getClaimId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Claim updated successfully!");
                return true;
            } else {
                System.out.println("No claim found with ID: " + claim.getClaimId());
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error updating claim: " + e.getMessage());
            return false;
        }
    }

    public boolean deleteClaim(int claimId) {
        String sql = "DELETE FROM claim WHERE claim_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, claimId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Claim deleted successfully!");
                return true;
            } else {
                System.out.println("No claim found with ID: " + claimId);
                return false;
            }
        } catch (SQLException e) {
            System.err.println("Error deleting claim: " + e.getMessage());
            return false;
        }
    }

    public Claim getClaimById(int claimId) {
        return viewClaim(claimId);
    }
}
