package ua.kosheleva.module3.dao;

import lombok.SneakyThrows;
import ua.kosheleva.module3.config.HibernateFactoryUtil;
import ua.kosheleva.module3.model.Teacher;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class TeacherDao extends AbstractDao<Teacher> {
    @Override
    protected void init() {
        aClass = Teacher.class;
    }

    @SneakyThrows
    public void printTeacherInfo(List<Object> teacherByFirstNameLastName) {
        for (Object o : teacherByFirstNameLastName) {
            Object[] row = (Object[]) o;
            System.out.println("\nId: " + row[0] + "\nFirst name: " + row[1] + "\nLast name: " + row[2] +
                    "\nSubject id: " + row[3] + "\n");
        }
    }

    public List<Object> findTeacherByFirstNameLastName(String firstName, String lastName) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT * FROM teacher WHERE firstname LIKE :firstname " +
                "AND lastname LIKE :lastname");
        query.setParameter("firstname", firstName);
        query.setParameter("lastname", lastName);
        return query.getResultList();
    }
}
