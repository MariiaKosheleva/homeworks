package ua.kosheleva.hw24;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;
import ua.kosheleva.hw24.service.DeviceService;
import ua.kosheleva.hw24.service.FactoryService;

public class Main {
    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        FactoryService.createFactoryInfrastructure();
        FactoryService.getFactoryInfo(0);
        System.out.println(DeviceService.getDeviceInfo(0));
        DeviceService.changeDeviceInfo(1);
        DeviceService.deleteDeviceFromDataBase(0);
        System.out.println(DeviceService.getDeviceInfo(0));
        FactoryService.showDevicesFromSpecificFactory(0);
        FactoryService.showAmountOfDevicesForEachFactoryAndTheirPriceSum();
    }
}
