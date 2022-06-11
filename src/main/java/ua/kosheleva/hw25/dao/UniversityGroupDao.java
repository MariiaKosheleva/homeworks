package ua.kosheleva.hw25.dao;

import ua.kosheleva.hw25.config.HibernateFactoryUtil;
import ua.kosheleva.hw25.model.UniversityGroup;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UniversityGroupDao extends AbstractDao<UniversityGroup> {
    @Override
    protected void init() {
        aClass = UniversityGroup.class;
    }

    public List<Object> getAmountOfStudentsInEachGroup() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT universityGroup.id, " +
                "universityGroup.universityGroupName, COUNT(universityGroup_student.student_id)" +
                "FROM universityGroup " +
                "INNER JOIN universityGroup_student " +
                "ON universityGroup.id = universityGroup_student.universityGroup_id " +
                "GROUP BY universityGroup.id");
        return query.getResultList();
    }
}
