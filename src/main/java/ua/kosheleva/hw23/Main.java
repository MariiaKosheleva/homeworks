package ua.kosheleva.hw23;

import ua.kosheleva.hw23.utils.DeviceAndFactoryUtils;
import ua.kosheleva.hw23.utils.TablesCreator;

public class Main {
    public static void main(String[] args) {
        TablesCreator.createDevicesAndFactoryTables();
        DeviceAndFactoryUtils.saveFactoryToDataBase();
        DeviceAndFactoryUtils.saveDevToDataBase();
        DeviceAndFactoryUtils.getDeviceInfo(3);
        DeviceAndFactoryUtils.getFactoryInfo(3);
        DeviceAndFactoryUtils.changeDeviceInfo(3);
        DeviceAndFactoryUtils.deleteDevice(2);
        DeviceAndFactoryUtils.getDevFromFactory("Lenovo");
        System.out.println("\n\n");
        DeviceAndFactoryUtils.getAmountOfDevicesForEachFactoryAndTheirPriceSum();
    }
}
