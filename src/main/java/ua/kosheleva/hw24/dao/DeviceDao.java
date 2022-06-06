package ua.kosheleva.hw24.dao;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;
import ua.kosheleva.hw24.model.Device;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DeviceDao extends AbstractDao<Device> {
    @Override
    protected void init() {
        aClass = Device.class;
    }

    public void deleteDevice(String id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.createQuery("delete from Device where id = :id")
                .setParameter("id", id)
                .executeUpdate();
        entityManager.flush();
        transaction.commit();
    }
}
