package cn.maxlu.dao;

import cn.maxlu.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends BaseDao<User> {

    public User getUser(String userName, String password) {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
        detachedCriteria.add(Restrictions.eq("userName", userName)).add(Restrictions.eq("password", password));
        return hibernateAccess.findUniqueResult(detachedCriteria);
    }

}
