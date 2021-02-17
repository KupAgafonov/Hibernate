package dao;

import util.HibernateSessionFactoryUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> findById(Serializable id);

    List<T> findAll();

    default void save(T entity) {
        HibernateSessionFactoryUtil.getSessionFactory().openSession().save(entity);
    }

    default void update(T entity) {
        HibernateSessionFactoryUtil.getSessionFactory().openSession().update(entity);
    }

    default void delete(T entity) {
        HibernateSessionFactoryUtil.getSessionFactory().openSession().delete(entity);
    }

    T getEntityByName(String name);
}
