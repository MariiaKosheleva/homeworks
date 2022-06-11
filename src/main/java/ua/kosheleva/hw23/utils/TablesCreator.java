package ua.kosheleva.hw23.utils;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TablesCreator {
    private static final String URL = "jdbc:postgresql://localhost:5432/hw23";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "mama1101";

    @SneakyThrows
    public static void createDevicesAndFactoryTables() {
        String sqlCreateDeviceTableQuery = "CREATE TABLE DEVICE " +
                "(ID Integer not Null," +
                " Type varchar(250) not Null," +
                " Model varchar(250) not Null," +
                " Price Integer not Null," +
                " Creation_date date NOT NULL, " +
                " Description text not Null," +
                " Availability boolean not Null," +
                " Factory_ID varchar(250) not Null," +
                " PRIMARY KEY (ID)," +
                " FOREIGN KEY (Factory_ID) REFERENCES FACTORY(Factory_ID))";
        String sqlCreateFactoryTableQuery = "CREATE TABLE FACTORY " +
                "(Factory_ID varchar(250) not Null," +
                " Name varchar(250) not Null," +
                " Country varchar(250) not Null," +
                " PRIMARY KEY (Factory_ID))";
        Statement statement = getStatement();
        statement.executeUpdate(sqlCreateFactoryTableQuery);
        statement.executeUpdate(sqlCreateDeviceTableQuery);
        System.out.println("The tables have been successfully created in the database!");
    }

    @SneakyThrows
    private static Connection getConnection() {
        return DriverManager.getConnection(URL, USER_NAME, PASSWORD);
    }

    @SneakyThrows
    private static Statement getStatement() {
        Connection connection = getConnection();
        return connection.createStatement();
    }

    @SneakyThrows
    public static PreparedStatement getPrepStatement(String sqlQuery) {
        Connection connection = getConnection();
        return connection.prepareStatement(sqlQuery);
    }
}
