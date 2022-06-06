package ua.kosheleva.hw24.dao;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;
import ua.kosheleva.hw24.model.Device;
import ua.kosheleva.hw24.model.Factory;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class FactoryDao extends AbstractDao<Factory> {
    @Override
    protected void init() {
        aClass = Factory.class;
    }

    public List<Device> getObjectsInfoFromFactory(Factory factory) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Device> query = criteriaBuilder.createQuery(Device.class);
        final Root<Device> from = query.from(Device.class);
        query.where(criteriaBuilder.equal(from.get("factory"), factory));
        return entityManager.createQuery(query).getResultList();
    }
}
