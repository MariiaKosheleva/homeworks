package ua.kosheleva.module3.dao;

import ua.kosheleva.module3.config.HibernateFactoryUtil;
import ua.kosheleva.module3.model.Undergraduate;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UndergraduateDao extends AbstractDao<Undergraduate> {
    @Override
    protected void init() {
        aClass = Undergraduate.class;
    }

    public void printAverageMarkValueGreaterThanLimitForEachUndergraduate(List<Object> averageMarkValueForGroups) {
        for (Object o : averageMarkValueForGroups) {
            Object[] row = (Object[]) o;
            System.out.println("\nUndergraduate id: " + row[0] + "\nName: " + row[1] + " " + row[2] + "\nAverage mark value: " + row[3]);
        }
    }

    public List<Object> getAverageMarkValueGreaterThanLimitForUndergraduates(Double limit) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT undergraduate.id, " +
                "undergraduate.firstname, undergraduate.lastname, AVG(mark.value) " +
                "FROM Mark INNER JOIN Undergraduate ON mark.undergraduate_id = undergraduate.id GROUP BY undergraduate.id " +
                "HAVING AVG(mark.value) > :limit");
        query.setParameter("limit", limit);
        return query.getResultList();
    }

}
