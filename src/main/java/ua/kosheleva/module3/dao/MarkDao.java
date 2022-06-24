package ua.kosheleva.module3.dao;

import ua.kosheleva.module3.model.Mark;

public class MarkDao extends AbstractDao<Mark> {
    @Override
    protected void init() {
        aClass = Mark.class;
    }
}
