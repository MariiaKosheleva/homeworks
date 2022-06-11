package ua.kosheleva.hw23.utils;

import lombok.SneakyThrows;
import ua.kosheleva.hw23.classesForTables.Device;
import ua.kosheleva.hw23.classesForTables.Factory;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.*;

public class DeviceAndFactoryUtils {
    private static String manufacturer;
    private static final String lenovoFactoryId = String.valueOf(UUID.randomUUID());
    private static final String samsungFactoryId = String.valueOf(UUID.randomUUID());
    private static final String appleFactoryId = String.valueOf(UUID.randomUUID());
    private static final String sonyFactoryId = String.valueOf(UUID.randomUUID());
    static final List<Device> devices = generateDevices(manufacturer);
    static final List<Factory> factories = generateFactory();

    @SneakyThrows
    public static void getAmountOfDevicesForEachFactoryAndTheirPriceSum() {
        String sqlQuery = "SELECT factory.name, COUNT(device.ID) AS count, SUM(Price) AS sum FROM factory INNER JOIN device USING (Factory_ID) GROUP BY factory.name";
        PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Factory name: " + resultSet.getString("Name") +
                    "\nAmount of devices: " + resultSet.getInt("count") +
                    "\nSum of devices' price on the factory: " + resultSet.getInt("sum"));
        }
    }

    @SneakyThrows
    public static void getDevFromFactory(String manufacturer) {
        String sqlQuery = "SELECT * FROM factory INNER JOIN device ON device.Factory_ID = factory.Factory_ID where Name = ?";
        PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
        preparedStatement.setString(1, manufacturer);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println("Factory name: " + resultSet.getString("Name") +
                    "\nDevice id: " + resultSet.getInt("ID") + ", " +
                    "\nType: " + resultSet.getString("Type") + ", " +
                    "\nModel: " + resultSet.getString("Model") + ", " +
                    "\nPrice: " + resultSet.getInt("Price") + ", " +
                    "\nCreation date: " + resultSet.getDate("Creation_date").toLocalDate() + ", " +
                    "\nDescription: " + resultSet.getString("Description") +
                    "\nAvailability: " + resultSet.getBoolean("Availability") + ";\n");
        }
    }

    @SneakyThrows
    public static void changeDeviceInfo(Integer id) {
        String sqlQuery = "UPDATE device SET Model = ?, Price = ?, Availability = ?, Description = ? where id = ?";
        Device dbDevice = getDeviceInfo(id);
        dbDevice.setModel("Secret");
        dbDevice.setPrice(40000);
        dbDevice.setAvailability(false);
        dbDevice.setDescription("New, super modern, waterproof gadget of your dream! But its model is a secret, let's wait! We are waiting for this product in 1 month");
        PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
        preparedStatement.setString(1, dbDevice.getModel());
        preparedStatement.setInt(2, dbDevice.getPrice());
        preparedStatement.setBoolean(3, dbDevice.getAvailability());
        preparedStatement.setString(4, dbDevice.getDescription());
        preparedStatement.setInt(5, dbDevice.getId());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public static Device getDeviceInfo(Integer id) {
        String sqlQuery = "select * from device where id = ?";
        PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
        preparedStatement.setInt(1, id);
        final ResultSet resultSet = preparedStatement.executeQuery();
        Optional<Device> deviceRes;
        if (resultSet.next()) {
            deviceRes = Optional.of((Mapper.mapToObjDev(resultSet)));
        } else {
            deviceRes = Optional.empty();
        }
        return deviceRes.get();
    }

    @SneakyThrows
    public static Factory getFactoryInfo(Integer id) {
        String sqlQuery = "select * from factory where Factory_ID = ?";
        PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
        preparedStatement.setString(1, getDeviceInfo(id).getFactoryId());
        final ResultSet resultSet = preparedStatement.executeQuery();
        Optional<Factory> factoryRes;
        if (resultSet.next()) {
            factoryRes = Optional.of((Mapper.mapToObjFactory(resultSet)));
        } else {
            factoryRes = Optional.empty();
        }
        return factoryRes.get();
    }

    @SneakyThrows
    public static void deleteDevice(Integer id) {
        String sqlQuery = "DELETE FROM device where id = ?";
        PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    @SneakyThrows
    public static void saveDevToDataBase() {
        String sqlQuery = "insert into device (ID, Type, Model, Price, Creation_date, Description, Availability, Factory_ID) values (?, ?, ?, ?, ?, ?, ?, ?)";
        for (Device device : devices) {
            PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
            preparedStatement.setInt(1, device.getId());
            preparedStatement.setString(2, device.getType());
            preparedStatement.setString(3, device.getModel());
            preparedStatement.setInt(4, device.getPrice());
            preparedStatement.setDate(5, Date.valueOf(device.getDate()));
            preparedStatement.setString(6, device.getDescription());
            preparedStatement.setBoolean(7, device.getAvailability());
            preparedStatement.setString(8, device.getFactoryId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }

    @SneakyThrows
    public static void saveFactoryToDataBase() {
        String sqlQuery = "insert into factory (Factory_ID, Name, Country) values (?, ?, ?)";
        for (Factory factory : factories) {
            PreparedStatement preparedStatement = TablesCreator.getPrepStatement(sqlQuery);
            preparedStatement.setString(1, factory.getFactoryId());
            preparedStatement.setString(2, factory.getName());
            preparedStatement.setString(3, factory.getCountry());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
    }

    private static List<Device> generateDevices(String manufacturer) {
        List<Device> devicesList = new ArrayList<>();
        int lenovoCounter = 0;
        int samsungCounter = 0;
        int appleCounter = 0;
        int sonyCounter = 0;
        for (int i = 0; i < 10; i++) {
            manufacturer = selectManufacturer(manufacturer);
            if ("Lenovo".equals(manufacturer)) {
                lenovoCounter++;
                if (lenovoCounter % 2 == 0) {
                    devicesList.add(new Device(i, "Laptop", "FX-21602", 28000, LocalDate.now(),
                            "Ultra thin, modern, light gaming laptop!", true, lenovoFactoryId));
                } else if (lenovoCounter % 3 == 0) {
                    devicesList.add(new Device(i, "NoteBook", "F-21602", 18000, LocalDate.now(),
                            "Ultra thin, modern, light notebook!", true, lenovoFactoryId));
                } else if (lenovoCounter % 5 == 0) {
                    devicesList.add(new Device(i, "SmartPhone", "A-736", 4500, LocalDate.now(),
                            "Ultra thin, modern, budget smartphone!", true, lenovoFactoryId));
                } else {
                    devicesList.add(new Device(i, "SmartPhone", "A-716", 8000, LocalDate.now(),
                            "Modern, light gaming smartphone with large battery capacity!", true, lenovoFactoryId));
                }
            } else if ("Samsung".equals(manufacturer)) {
                samsungCounter++;
                if (samsungCounter % 2 == 0) {
                    devicesList.add(new Device(i, "SmartPhone", "M-52", 14000, LocalDate.now(),
                            "Choose your favourite color of the phone!", true, samsungFactoryId));
                } else if (samsungCounter % 3 == 0) {
                    devicesList.add(new Device(i, "SmartPhone", "A-22", 12000, LocalDate.now(),
                            "Budget waterproof phone that everyone can afford!", true, samsungFactoryId));
                } else if (samsungCounter % 5 == 0) {
                    devicesList.add(new Device(i, "SmartPhone", "M-72", 11000, LocalDate.now(),
                            "Budget phone that everyone can afford!", true, samsungFactoryId));
                } else {
                    devicesList.add(new Device(i, "SmartPhone", "J5", 5000, LocalDate.now(),
                            "Budget phone that everyone can afford!", true, samsungFactoryId));
                }
            } else if ("Apple".equals(manufacturer)) {
                appleCounter++;
                if (appleCounter % 2 == 0) {
                    devicesList.add(new Device(i, "Iphone", "13 Pro Max", 35000, LocalDate.now(),
                            "New modern iPhone with macro photography!", true, appleFactoryId));
                } else if (appleCounter % 3 == 0) {
                    devicesList.add(new Device(i, "Iphone", "11 Pro Max", 25000, LocalDate.now(),
                            "New modern iPhone with matte glass on back!", true, appleFactoryId));
                } else if (appleCounter % 5 == 0) {
                    devicesList.add(new Device(i, "Iphone", "12 Pro ", 30000, LocalDate.now(),
                            "New modern waterproof iPhone!", true, appleFactoryId));
                } else {
                    devicesList.add(new Device(i, "Iphone", "XR", 15000, LocalDate.now(),
                            "New colors of iPhone available!", true, appleFactoryId));
                }
            } else if ("SONY".equals(manufacturer)) {
                sonyCounter++;
                if (sonyCounter % 2 == 0) {
                    devicesList.add(new Device(i, "Headphones", "WH-1000XM3", 7800, LocalDate.now(),
                            "Overhead noise canceling headphones!", true, sonyFactoryId));
                } else if (sonyCounter % 3 == 0) {
                    devicesList.add(new Device(i, "SmartPhone", "XPeria", 9800, LocalDate.now(),
                            "Waterproof genius smartphone!", true, sonyFactoryId));
                } else if (sonyCounter % 5 == 0) {
                    devicesList.add(new Device(i, "SmartPhone", "X-3000", 6900, LocalDate.now(),
                            "New modern genius smartphone!", true, sonyFactoryId));
                } else {
                    devicesList.add(new Device(i, "SmartPhone", "WH-1001XW4", 3800, LocalDate.now(),
                            "Waterproof headphones!", true, sonyFactoryId));
                }
            }
        }
        return devicesList;
    }

    private static List<Factory> generateFactory() {
        List<Factory> factoriesList = new ArrayList<>();
        factoriesList.add(new Factory(lenovoFactoryId, "Lenovo", "China"));
        factoriesList.add(new Factory(samsungFactoryId, "Samsung", "Korea"));
        factoriesList.add(new Factory(appleFactoryId, "Apple", "USA"));
        factoriesList.add(new Factory(sonyFactoryId, "SONY", "Japan"));
        return factoriesList;
    }

    private static String selectManufacturer(String manufacturer) {
        String[] manufacturers = new String[]{"Lenovo", "Samsung", "Apple", "SONY"};
        Random index = new Random();
        for (int i = 0; i < manufacturers.length; i++) {
            manufacturer = manufacturers[index.nextInt(0, manufacturers.length)];
        }
        return manufacturer;
    }
}
