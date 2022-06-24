package ua.kosheleva.module3.dao;

import lombok.SneakyThrows;
import ua.kosheleva.module3.config.HibernateFactoryUtil;
import ua.kosheleva.module3.model.UniGroup;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GroupDao extends AbstractDao<UniGroup> {
    @Override
    protected void init() {
        aClass = UniGroup.class;
    }

    public void printAverageMarkValueForEachGroups(List<Object> averageMarkValueForGroups) {
        for (Object o : averageMarkValueForGroups) {
            Object[] row = (Object[]) o;
            System.out.println("\nGroup id: " + row[0] + "\nName: " + row[1] + "\nAverage mark value: " + row[2]);
        }
    }

    public List<Object> getAverageMarkValueForGroups() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT unigroup.id, unigroup.name, AVG(mark.value) " +
                "FROM Mark INNER JOIN (Undergraduate INNER JOIN Unigroup ON undergraduate.unigroup_id = unigroup.id) " +
                "ON mark.undergraduate_id = undergraduate.id GROUP BY unigroup.id");
        return query.getResultList();
    }

    public void printAmountOfStudentsForEachGroup(List<Object> amountOfStudentsInEachGroup) {
        for (Object o : amountOfStudentsInEachGroup) {
            Object[] row = (Object[]) o;
            System.out.println("\nGroup id: " + row[0] + "\nName: " + row[1] + "\nAmount of students: " + row[2]);
        }
    }

    public List<Object> getAmountOfStudentsInEachGroup() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT unigroup.id, unigroup.name, COUNT(undergraduate.id) " +
                "FROM Undergraduate INNER JOIN Unigroup ON undergraduate.unigroup_id = unigroup.id " +
                "GROUP BY unigroup.id");
        return query.getResultList();
    }

    @SneakyThrows
    public void printGroupsInfo(Object[] groupsByFewSighs) {
        for (Object o : groupsByFewSighs) {
            System.out.println(o);
        }
    }

    public Object[] findGroupsByFewSighs(String name) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT unigroup.name FROM unigroup WHERE name LIKE CONCAT('%', :name, '%')");
        query.setParameter("name", name);
        return new List[]{query.getResultList()};
    }
}
