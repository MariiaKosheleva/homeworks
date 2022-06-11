package ua.kosheleva.hw24.dao;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;
import ua.kosheleva.hw24.model.Device;
import ua.kosheleva.hw24.model.Factory;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.List;

public class FactoryDao extends AbstractDao<Factory> {
    @Override
    protected void init() {
        aClass = Factory.class;
    }

    public List<Device> getDevicesInfoFromFactory(Factory factory) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Device> query = criteriaBuilder.createQuery(Device.class);
        final Root<Device> from = query.from(Device.class);
        query.where(criteriaBuilder.equal(from.get("factory"), factory));
        return entityManager.createQuery(query).getResultList();
    }

    public List<Object[]> getAmountOfDevicesForEachFactoryAndTheirPriceSum() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = builder.createQuery();
        Root<Device> from = criteriaQuery.from(Device.class);
        Join<Device, Factory> typeJoin = from.join("factory");
        criteriaQuery.multiselect(typeJoin.get("id"), builder.count(from.get("id")), builder.sum(from.get("price")));
        criteriaQuery.groupBy(typeJoin.get("id"), typeJoin.get("name"));
        Query query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
