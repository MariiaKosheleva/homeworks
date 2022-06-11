package ua.kosheleva.hw25.dao;

import ua.kosheleva.hw25.model.University;

public class UniversityDao extends AbstractDao<University> {
    @Override
    protected void init() {
        aClass = University.class;
    }
}
