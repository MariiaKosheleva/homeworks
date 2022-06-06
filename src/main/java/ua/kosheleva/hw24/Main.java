package ua.kosheleva.hw24;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;
import ua.kosheleva.hw24.model.Factory;
import ua.kosheleva.hw24.service.DeviceService;
import ua.kosheleva.hw24.service.FactoryService;
import ua.kosheleva.hw24.util.FactoryUtil;

public class Main {
    public static void main(String[] args) {
        HibernateFactoryUtil.init();
        FactoryService.createFactoryInfrastructure();
        FactoryService.getFactoryInfo(1);
        System.out.println(DeviceService.getDeviceInfo(1));
        DeviceService.changeDeviceInfo(1);
        DeviceService.deleteDevice(2);
        FactoryService.showDevicesFromSpecificFactory(0);
        FactoryService.getAmountOfDevicesForEachFactoryAndTheirPriceSum();
    }
}
