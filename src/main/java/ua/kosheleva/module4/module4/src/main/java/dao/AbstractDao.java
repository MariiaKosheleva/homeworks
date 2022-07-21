package dao;

import config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class AbstractDao<T> {
    protected Class<T> aClass;

    public AbstractDao() {
        init();
    }

    protected abstract void init();

    public void save(T value) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(value);
        entityManager.flush();
        transaction.commit();
    }

    public List<T> getAll() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> from = query.from(aClass);
        query.select(from);
        return entityManager.createQuery(query).getResultList();
    }
}
