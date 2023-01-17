package org.example;

//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.Calendar;
import java.sql.*;
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "rootroot";

//    private static final String INSERT_NEW = "INSERT INTO dish VALUES (?,?,?,?,?,?,?)";

    private static final String GET_ALL = "SELECT * FROM dish";

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet res = preparedStatement.executeQuery();

            while (res.next()) {
                int id = res.getInt("id");
                String title = res.getString("title");
                String desc = res.getString("description");
                float rating = res.getFloat("rating");
                boolean published = res.getBoolean("published");
                Date date = res.getDate("created");
                byte[] icon = res.getBytes("icon");

                System.out.println("id: " + id + ", title: " + title + ", description: " + desc + ", rating: " + rating + ", published: " +
                        published + ", date: " + date + ", icon lenght: " + icon.length);
            }


//            preparedStatement = connection.prepareStatement(INSERT_NEW);
//
//            preparedStatement.setInt(1,2);
//            preparedStatement.setString(2,"Inserted title");
//            preparedStatement.setString(3,"Inserted desc");
//            preparedStatement.setFloat(4, 0.2F);
//            preparedStatement.setBoolean(5,true);
//            preparedStatement.setDate(6, new Date(Calendar .getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("smile.png"));

            preparedStatement.execute();
//        } catch (SQLException | FileNotFoundException e) {
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}