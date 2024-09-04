package com.cts.homeinsurance.dao;

import com.cts.homeinsurance.model.Policy;
import com.cts.homeinsurance.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PolicyDAO {

    public void addPolicy(Policy policy) {
        String sql = "INSERT INTO policy (policy_number, type, coverage_amount, premium_amount) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, policy.getPolicyNumber());
            statement.setString(2, policy.getType());
            statement.setDouble(3, policy.getCoverageAmount());
            statement.setDouble(4, policy.getPremiumAmount());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Policy viewPolicy(int policyId) {
        String sql = "SELECT * FROM policy WHERE policy_id = ?";
        Policy policy = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, policyId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String policyNumber = resultSet.getString("policy_number");
                String type = resultSet.getString("type");
                double coverageAmount = resultSet.getDouble("coverage_amount");
                double premiumAmount = resultSet.getDouble("premium_amount");
                policy = new Policy(policyId, policyNumber, type, coverageAmount, premiumAmount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policy;
    }

    public void updatePolicy(Policy policy) {
        String sql = "UPDATE policy SET policy_number = ?, type = ?, coverage_amount = ?, premium_amount = ? WHERE policy_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, policy.getPolicyNumber());
            statement.setString(2, policy.getType());
            statement.setDouble(3, policy.getCoverageAmount());
            statement.setDouble(4, policy.getPremiumAmount());
            statement.setInt(5, policy.getId());
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No policy found with ID: " + policy.getId());
            } else {
                System.out.println("Policy updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePolicy(int policyId) {
        String sql = "DELETE FROM policy WHERE policy_id = ?";
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, policyId);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected == 0) {
                System.out.println("No policy found with ID: " + policyId);
            } else {
                System.out.println("Policy deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Policy getPolicyById(int policyId) {
        String sql = "SELECT * FROM policy WHERE policy_id = ?";
        Policy policy = null;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, policyId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String policyNumber = resultSet.getString("policy_number");
                String type = resultSet.getString("type");
                double coverageAmount = resultSet.getDouble("coverage_amount");
                double premiumAmount = resultSet.getDouble("premium_amount");
                policy = new Policy(policyId, policyNumber, type, coverageAmount, premiumAmount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policy;
    }
}
