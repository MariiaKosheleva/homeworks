package ua.kosheleva.hw25.dao;

import ua.kosheleva.hw25.config.HibernateFactoryUtil;
import ua.kosheleva.hw25.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentDao extends AbstractDao<Student> {
    @Override
    protected void init() {
        aClass = Student.class;
    }

    public List<Object> getAllInfoAboutCertainStudent(String id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT student.id, student.studentName, " +
                "universityGroup.universityGroupName, curator.curatorName, university.universityName " +
                "FROM curator INNER JOIN (university INNER JOIN (universitygroup INNER JOIN (student " +
                "INNER JOIN universitygroup_student ON student.id = universitygroup_student.student_id) " +
                "ON universitygroup.id = universitygroup_student.universitygroup_id) " +
                "ON university.id = universitygroup.university_id) " +
                "ON curator.id = universitygroup.curator_id WHERE student.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
