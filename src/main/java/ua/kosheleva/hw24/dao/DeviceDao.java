package ua.kosheleva.hw24.dao;

import ua.kosheleva.hw24.model.Device;

public class DeviceDao extends AbstractDao<Device> {
    @Override
    protected void init() {
        aClass = Device.class;
    }
}
