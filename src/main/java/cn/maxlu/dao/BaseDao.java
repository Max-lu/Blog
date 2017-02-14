package cn.maxlu.dao;

import cn.maxlu.db.HibernateAccess;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class BaseDao<T> {
    @Inject
    protected HibernateAccess<T> hibernateAccess;

    public T get(Class<T> tClass, int id) {
        return hibernateAccess.get(tClass, id);
    }

    public int insert(T entity) {
        return hibernateAccess.insert(entity);
    }

    public void update(T entity) {
        hibernateAccess.update(entity);
    }

    public void delete(Class<T> tClass, int id) {
        hibernateAccess.delete(tClass, id);
    }

    public void delete(T entity) {
        hibernateAccess.delete(entity);
    }
}
