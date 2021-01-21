package org.rodion.homeworks.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/store", "root", "123456")) {
            Statement statement = connection.createStatement();

            int firstResult = statement.executeUpdate("CREATE TABLE IF NOT EXISTS Products\n" +
                    "(\n" +
                    "    Id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    ProductName VARCHAR(30) NOT NULL,\n" +
                    "    Manufacturer VARCHAR(20) NOT NULL,\n" +
                    "    ProductCount INT DEFAULT 0,\n" +
                    "    Price DECIMAL NOT NULL\n" +
                    ");");
            System.out.println(firstResult);

            int secondResult = statement.executeUpdate("INSERT Products(ProductName, Manufacturer, ProductCount, Price) \n" +
                    "VALUES ('iPhone X', 'Apple', 5, 76000)," +
                    " ('iPhone XX', 'Watermelon', 7, 760000);");
            System.out.println(secondResult);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products");
            while (resultSet.next()) {
                System.out.println("Id = " + resultSet.getString("Id"));
                System.out.println("ProductName = " + resultSet.getString("ProductName"));
                System.out.println("Manufacturer = " + resultSet.getString("Manufacturer"));
            }

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Products(ProductName, Manufacturer, Price) VALUES (?, ?, ?)");

            for (int i = 1; i <= 3; i++) {
                preparedStatement.setString(1, "Mi 1" + i);
                preparedStatement.setString(2, "Xiaomi");
                preparedStatement.setInt(3, 100 + i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            System.out.println("Done!");
        }
    }
}
