package ua.kosheleva.hw24.service;

import ua.kosheleva.hw24.dao.DeviceDao;
import ua.kosheleva.hw24.model.Device;
import ua.kosheleva.hw24.model.Factory;

import java.time.LocalDate;


public class DeviceService {
    private static final DeviceDao deviceDao = new DeviceDao();

    public Device createDevice(String model, String type, Integer price, LocalDate date,
                               String description, Boolean availability, Factory factory) {
        return new Device(model, type, price, date, description, availability, factory);
    }

    public static void deleteDevice(Integer index) {
        deviceDao.delete(deviceDao.getAll().get(index));
    }

    public static void changeDeviceInfo(Integer index) {
        Device dbDevice = getDeviceInfo(index);
        dbDevice.setModel("Secret");
        dbDevice.setPrice(40000);
        dbDevice.setDescription("New, super modern, waterproof gadget of your dream! But its model is a secret, " +
                "let's wait! We are waiting for this product in 1 month");
        dbDevice.setAvailability(false);
        deviceDao.save(dbDevice);
    }

    public static Device getDeviceInfo(Integer index) {
        return deviceDao.getById((deviceDao.getAll().get(index)).getId());
    }
}
