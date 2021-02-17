package dao;

import lombok.NonNull;
import org.hibernate.Session;
import util.HibernateSessionFactoryUtil;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public class SkillBoxDao<T> implements Dao<T> {

    private final Class<T> tClass;

    public SkillBoxDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    @Override
    public Optional<T> findById(Serializable id) {
        try {
            Object nullObject = new Object();
            T object = HibernateSessionFactoryUtil.getSessionFactory().openSession().get(this.tClass, id);
            return object.equals(nullObject) ? Optional.empty() : Optional.of(object);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Empty is not exist");
        }
    }

    public List<T> findAll() {
        return HibernateSessionFactoryUtil
                .getSessionFactory()
                .openSession()
                .createQuery("From " + this.tClass.getSimpleName(), this.tClass)
                .list();
    }

    @Override
    public T getEntityByName(@NonNull String name) throws IllegalArgumentException{

        try {

            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> tCriteriaQuery = builder.createQuery(this.tClass);
            Root<T> entityRoot = tCriteriaQuery.from(this.tClass);
            tCriteriaQuery.select(entityRoot).where(builder.equal(entityRoot.get("name"), name));
            return session.createQuery(tCriteriaQuery).getResultList().stream().findFirst().orElse(null);

        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Empty is not exist");
        }
    }
}
