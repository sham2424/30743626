package com.cts.homeinsurance.dao;

import com.cts.homeinsurance.model.Homeowner;
import com.cts.homeinsurance.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HomeownerDAO {

    public void addHomeowner(Homeowner homeowner) {
        String sql = "INSERT INTO homeowner (name, email, phone_number, address) VALUES (?, ?, ?, ?)";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, homeowner.getName());
            preparedStatement.setString(2, homeowner.getEmail());
            preparedStatement.setString(3, homeowner.getPhoneNumber());
            preparedStatement.setString(4, homeowner.getAddress());

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Homeowner added successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error adding homeowner: " + e.getMessage());
        }
    }

    public Homeowner getHomeownerById(int homeownerId) {
        String sql = "SELECT * FROM homeowner WHERE homeowner_id = ?";
        Homeowner homeowner = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, homeownerId);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                homeowner = new Homeowner(homeownerId, name, email, phoneNumber, address);
            }
        } catch (SQLException e) {
            System.err.println("Error viewing homeowner: " + e.getMessage());
        }

        return homeowner;
    }

    public boolean updateHomeowner(Homeowner homeowner) {
        String sql = "UPDATE homeowner SET name = ?, email = ?, phone_number = ?, address = ? WHERE homeowner_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, homeowner.getName());
            preparedStatement.setString(2, homeowner.getEmail());
            preparedStatement.setString(3, homeowner.getPhoneNumber());
            preparedStatement.setString(4, homeowner.getAddress());
            preparedStatement.setInt(5, homeowner.getHomeownerId());

            int rowsUpdated = preparedStatement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Homeowner updated successfully!");
                return true;
            } else {
                System.out.println("No homeowner found with ID: " + homeowner.getHomeownerId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating homeowner: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteHomeowner(int homeownerId) {
        String sql = "DELETE FROM homeowner WHERE homeowner_id = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, homeownerId);

            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Homeowner deleted successfully!");
                return true;
            } else {
                System.out.println("No homeowner found with ID: " + homeownerId);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting homeowner: " + e.getMessage());
        }
        return false;
    }
}
