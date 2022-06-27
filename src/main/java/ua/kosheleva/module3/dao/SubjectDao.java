package ua.kosheleva.module3.dao;

import ua.kosheleva.module3.config.HibernateFactoryUtil;
import ua.kosheleva.module3.model.Subject;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SubjectDao extends AbstractDao<Subject> {
    @Override
    protected void init() {
        aClass = Subject.class;
    }

    public void printSubjectMaxAcademicPerformance(Object maxAcademicPerformance, List<Object> subjectInfoByMaxAcademicPerformance,
                                                   Object minAcademicPerformance, List<Object> subjectInfoByMinAcademicPerformance) {
        for (Object o : subjectInfoByMaxAcademicPerformance) {
            Object[] row = (Object[]) o;
            System.out.println("\nSubject id: " + row[0] + "\nName: " + row[1]);
        }
        System.out.println("Max academic performance: " + maxAcademicPerformance);
        for (Object o : subjectInfoByMinAcademicPerformance) {
            Object[] row = (Object[]) o;
            System.out.println("\nSubject id: " + row[0] + "\nName: " + row[1]);
        }
        System.out.println("Min academic performance: " + minAcademicPerformance);
    }

    public List<Object> getSubjectInfoByMaxAcademicPerformance() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT subject.id, subject.name FROM Mark INNER JOIN Subject ON mark.subject_id = subject.id " +
                "GROUP BY subject.id HAVING AVG(mark.value) = :maxavg");
        query.setParameter("maxavg", getMaxAcademicPerformance());
        return query.getResultList();
    }

    public List<Object> getSubjectInfoByMinAcademicPerformance() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT subject.id, subject.name FROM Mark INNER JOIN Subject ON mark.subject_id = subject.id " +
                "GROUP BY subject.id HAVING AVG(mark.value) = :maxavg");
        query.setParameter("maxavg", getMinAcademicPerformance());
        return query.getResultList();
    }

    public Object getMaxAcademicPerformance() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT MAX(avg) FROM (SELECT AVG(mark.value) AS avg " +
                "FROM Mark GROUP BY mark.subject_id) AS maxAvg");
        return query.getSingleResult();
    }

    public Object getMinAcademicPerformance() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT MIN(avg) FROM (SELECT AVG(mark.value) AS avg " +
                "FROM Mark GROUP BY mark.subject_id) AS maxAvg");
        return query.getSingleResult();
    }
}
