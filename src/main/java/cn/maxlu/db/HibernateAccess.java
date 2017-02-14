package cn.maxlu.db;

import cn.maxlu.exception.BusinessException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * Created by maxResults.lu on 2016/2/24.
 */
public class HibernateAccess<T> {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session openSession() {
//        return sessionFactory.getCurrentSession();
        return sessionFactory.openSession();
    }

    public int insert(Object entity) {
        Session session = openSession();
        try {
            return (Integer) session.save(entity);
        } finally {
            session.close();
        }
    }

    public void delete(Object entity) {
        Session session = openSession();
        session.delete(entity);
        session.close();
    }

    public void delete(Class<T> tClass, int id) {
        Session session = openSession();
        T t = this.get(tClass, id);
        if (t != null) {
            session.delete(t);
        }
        session.flush();
        session.close();
    }

    public void update(Object entity) {
        Session session = openSession();
        session.saveOrUpdate(entity);
        session.flush();
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<T> find(DetachedCriteria detachedCriteria) {
        return find(detachedCriteria, 1, 100);
    }

    @SuppressWarnings("unchecked")
    public T findUniqueResult(DetachedCriteria detachedCriteria) {
        List<T> list = find(detachedCriteria);
        if (list.size() < 1) return null;
        if (list.size() > 1) {
            throw new BusinessException("expect one but more than one...");
        }
        return list.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<T> find(DetachedCriteria detachedCriteria, int pageNo, int pageSize) {
        Session session = openSession();
        try {
            Criteria criteria = detachedCriteria.getExecutableCriteria(session);
            criteria.setMaxResults(pageSize);
            criteria.setFirstResult(pageSize * (pageNo - 1));
            return criteria.list();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public T get(Class<T> entity, Integer id) {
        Session session = openSession();
        try {
            return (T) session.get(entity, id);
        } finally {
            session.close();
        }
    }

    public long getTotalRecords(DetachedCriteria detachedCriteria) {
        Session session = openSession();
        try {
            return detachedCriteria.getExecutableCriteria(session).list().size();
        } finally {
            session.close();
        }
    }
}
