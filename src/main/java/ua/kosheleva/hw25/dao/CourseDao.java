package ua.kosheleva.hw25.dao;

import ua.kosheleva.hw25.config.HibernateFactoryUtil;
import ua.kosheleva.hw25.model.Course;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class CourseDao extends AbstractDao<Course> {
    @Override
    protected void init() {
        aClass = Course.class;
    }

    public List<Course> getAllCoursesFromSpecifiedRange(Integer minRangeComplexity, Integer maxRangeComplexity){
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        final CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        final CriteriaQuery<Course> query = criteriaBuilder.createQuery(Course.class);
        final Root<Course> from = query.from(aClass);
        query.select(from).where(criteriaBuilder.between(from.get("complexity"), minRangeComplexity, maxRangeComplexity));
        return entityManager.createQuery(query).getResultList();
    }

}
