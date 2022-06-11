package ua.kosheleva.hw23.utils;

import lombok.SneakyThrows;
import ua.kosheleva.hw23.classesForTables.Device;
import ua.kosheleva.hw23.classesForTables.Factory;

import java.sql.ResultSet;

public class Mapper {
    @SneakyThrows
    public static Device mapToObjDev(final ResultSet resultSet) {
        final Device device = new Device();
        device.setId(resultSet.getInt("ID"));
        device.setType(resultSet.getString("Type"));
        device.setModel(resultSet.getString("Model"));
        device.setPrice(resultSet.getInt("Price"));
        device.setDate(resultSet.getDate("Creation_date").toLocalDate());
        device.setDescription(resultSet.getString("Description"));
        device.setAvailability(resultSet.getBoolean("Availability"));
        device.setFactoryId(resultSet.getString("Factory_ID"));
        return device;
    }

    @SneakyThrows
    public static Factory mapToObjFactory(final ResultSet resultSet) {
        final Factory factory = new Factory();
        factory.setFactoryId(resultSet.getString("Factory_ID"));
        factory.setName(resultSet.getString("Name"));
        factory.setCountry(resultSet.getString("Country"));
        return factory;
    }
}
