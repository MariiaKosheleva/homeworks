package dao;

import config.HibernateFactoryUtil;
import model.Part;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PartDao extends AbstractDao<Part> {
    @Override
    protected void init() {
        aClass = Part.class;
    }

    public List<Object> getStatistics() {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT COUNT(*), SUM(part.brokenChips) AS amountOfBrokenChips, " +
                "SUM(part.producedFuel) AS amountOfProducedFuel FROM part");
        return query.getResultList();
    }

    public List<Object> getInfoAboutCertainPart(String id) {
        final EntityManager entityManager = HibernateFactoryUtil.getEntityManager();
        Query query = entityManager.createNativeQuery("SELECT part.id, part.date, part.usedTime, part.producedFuel, " +
                "part.brokenChips FROM part WHERE part.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
