package ua.kosheleva.hw24.dao;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;
import ua.kosheleva.hw24.model.Device;
import ua.kosheleva.hw24.model.Factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

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
