package ua.kosheleva.hw24.dao;

import ua.kosheleva.hw24.config.HibernateFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

abstract class AbstractDao<T> {
    protected Class<T> aClass;

    protected abstract void init();

    public AbstractDao() {
        init();
    }

    public void save(T value) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(value);
        entityManager.flush();
        transaction.commit();
    }

    public T getById(String id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<T> query = criteriaBuilder.createQuery(aClass);
        final Root<T> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.equal(from.get("id"), id));
        return entityManager.createQuery(query).getSingleResult();
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
