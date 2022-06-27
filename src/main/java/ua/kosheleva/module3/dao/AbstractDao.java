package ua.kosheleva.module3.dao;

abstract class AbstractDao<T> {
    protected Class<T> aClass;

    public AbstractDao() {
        init();
    }

    protected abstract void init();
}
