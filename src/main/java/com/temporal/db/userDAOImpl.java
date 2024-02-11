package com.temporal.db;

import com.temporal.core.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class userDAOImpl implements  userDAO{

    @Override
    public void addUserinDB(User user) {

        Connection connection = null;
        String query = "INSERT INTO user (emailid, name) VALUES (?, ?)";

        try {connection = DBUtils.getConnection();

            System.out.println(user.getUsername());
            System.out.println(user.getEmailid());

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1,user.getEmailid());
            preparedStatement.setString(2, user.getUsername());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected != 0)
                System.out.println("Entry added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

//    @Override
//    public User getUserDetails(String email) {
//        return null;
//    }
}
