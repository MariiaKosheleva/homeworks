package ua.kosheleva.hw25.dao;

import ua.kosheleva.hw25.config.HibernateFactoryUtil;
import ua.kosheleva.hw25.model.Curator;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.List;

public class CuratorDao extends AbstractDao<Curator> {
    @Override
    protected void init() {
        aClass = Curator.class;
    }

    public List<Curator> getAllTeachersBornBeforeXDateAndWithMoreThanYWorkExperience(Integer year, Integer month, Integer day, Integer workExperience) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Curator> query = criteriaBuilder.createQuery(Curator.class);
        final Root<Curator> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.lessThan(from.get("dateOfBirth"),
                LocalDate.of(year, month, day)), criteriaBuilder.greaterThan(from.get("workExperience"), workExperience));
        return entityManager.createQuery(query).getResultList();
    }
}
