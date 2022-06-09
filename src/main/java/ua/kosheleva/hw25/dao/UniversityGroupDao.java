package ua.kosheleva.hw25.dao;

import ua.kosheleva.hw25.config.HibernateFactoryUtil;
import ua.kosheleva.hw25.model.Student;
import ua.kosheleva.hw25.model.UniversityGroup;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UniversityGroupDao extends AbstractDao<UniversityGroup> {
    @Override
    protected void init() {
        aClass = UniversityGroup.class;
    }

    /*public List<UniversityGroup> getAmountOfStudentsInEachGroup(String id) {
    }*/

}
