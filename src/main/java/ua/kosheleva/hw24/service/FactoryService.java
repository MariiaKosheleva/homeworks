package ua.kosheleva.hw24.service;

import ua.kosheleva.hw24.model.Device;
import ua.kosheleva.hw24.util.FactoryUtil;
import ua.kosheleva.hw24.dao.FactoryDao;
import ua.kosheleva.hw24.model.Factory;


import java.util.List;

public class FactoryService {
    private static final FactoryDao factoryDao = new FactoryDao();


    public static void createFactoryInfrastructure() {
        final List<Factory> factories = FactoryUtil.createFactory();
        FactoryUtil.setDevices(factories);
        for (Factory factory : factories) {
            factoryDao.save(factory);
        }
    }

    public static void getAmountOfDevicesForEachFactoryAndTheirPriceSum() {
        factoryDao.getAll().forEach(factory -> System.out.println("\nFactory name: " + factory.getName() +
                "\nAmount of devices on this factory: " + factory.getDeviceSet().size() +
                "\nSum of devices' price on this factory: " + factory.getDeviceSet().stream()
                .mapToInt(Device::getPrice)
                .sum()));
    }

    public static void showDevicesFromSpecificFactory(Integer index) {
        System.out.println("\n\nDevices from factory - " + factoryDao.getAll().get(index).getName());
        System.out.println(getDevicesInfoFromSpecificFactory(index));
    }

    private static List<Device> getDevicesInfoFromSpecificFactory(Integer index) {
        return factoryDao.getObjectsInfoFromFactory(factoryDao.getAll().get(index));
    }

    public static void getFactoryInfo(Integer index) {
        System.out.println(factoryDao.getById((factoryDao.getAll().get(index)).getId()));
    }
}
