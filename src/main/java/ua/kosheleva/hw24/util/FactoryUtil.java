package ua.kosheleva.hw24.util;

import ua.kosheleva.hw24.model.Device;
import ua.kosheleva.hw24.model.Factory;
import ua.kosheleva.hw24.service.DeviceService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FactoryUtil {
    private static final DeviceService deviceService = new DeviceService();

    public static void setDevices(List<Factory> factories) {
        factories.get(0).setDeviceSet(createLenovoDevices(factories));
        factories.get(1).setDeviceSet(createSonyDevices(factories));
        factories.get(2).setDeviceSet(createAppleDevices(factories));
        factories.get(3).setDeviceSet(createSamsungDevices(factories));
    }

    private static Set<Device> createLenovoDevices(List<Factory> factories) {
        final Set<Device> lenovoDevSet = new HashSet<>();
        final Factory lenovo = factories.get(0);
        final Device smartPhone1 = deviceService.createDevice("A-236", "smartPhone", 4500,
                LocalDate.now(), "Budget smartPhone that can afford everyone!", true, lenovo);
        final Device smartPhone2 = deviceService.createDevice("A-216", "smartPhone", 3500,
                LocalDate.now(), "Budget smartPhone that can afford everyone!", true, lenovo);
        final Device laptop = deviceService.createDevice("FX-21602", "laptop", 13500,
                LocalDate.now(), "Budget laptop that can afford everyone!", true, lenovo);
        lenovoDevSet.add(smartPhone1);
        lenovoDevSet.add(smartPhone2);
        lenovoDevSet.add(laptop);
        return lenovoDevSet;
    }

    private static Set<Device> createSonyDevices(List<Factory> factories) {
        final Set<Device> sonyDevSet = new HashSet<>();
        final Factory sony = factories.get(1);
        final Device headphones1 = deviceService.createDevice("WX-1000XM3", "headphones", 7800,
                LocalDate.now(), "Overhead noise canceling headphones!", true, sony);
        final Device headphones2 = deviceService.createDevice("WX-1000XM4", "headphones", 3800,
                LocalDate.now(), "Budget waterproof headphones which can afford almost everyone :)", true, sony);
        sonyDevSet.add(headphones1);
        sonyDevSet.add(headphones2);
        return sonyDevSet;
    }

    private static Set<Device> createAppleDevices(List<Factory> factories) {
        final Set<Device> appleDevSet = new HashSet<>();
        final Factory apple = factories.get(2);
        final Device iPhone1 = deviceService.createDevice("11 Pro", "iPhone", 21000,
                LocalDate.now(), "iPhone, in many colors, with matte glass on its back", true, apple);
        final Device iPhone2 = deviceService.createDevice("12 Pro Max", "iPhone", 23500,
                LocalDate.now(), "Waterproof iPhone, in many colors", true, apple);
        final Device airPods = deviceService.createDevice("Pro_2", "airPods", 14000,
                LocalDate.now(), "Waterproof headphones that you can take everywhere", true, apple);
        appleDevSet.add(iPhone1);
        appleDevSet.add(iPhone2);
        appleDevSet.add(airPods);
        return appleDevSet;
    }

    private static Set<Device> createSamsungDevices(List<Factory> factories) {
        final Set<Device> samsungDevSet = new HashSet<>();
        final Factory samsung = factories.get(3);
        final Device phone1 = deviceService.createDevice("M-52", "smartPhone", 14500,
                LocalDate.now(), "Let's choose your favourite color of the phone!", true, samsung);
        final Device phone2 = deviceService.createDevice("A-21", "smartPhone", 12000,
                LocalDate.now(), "Almost budget smartPhone that can afford almost everyone :)", true, samsung);
        samsungDevSet.add(phone1);
        samsungDevSet.add(phone2);
        return samsungDevSet;
    }

    public static List<Factory> createFactory() {
        final Factory lenovo = new Factory("lenovo", "China");
        final Factory sony = new Factory("sony", "Japan");
        final Factory apple = new Factory("apple", "USA");
        final Factory samsung = new Factory("samsung", "Korea");
        return Arrays.asList(lenovo, sony, apple, samsung);
    }
}
