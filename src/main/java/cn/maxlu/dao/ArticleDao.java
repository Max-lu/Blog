package cn.maxlu.dao;

import cn.maxlu.entity.Article;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleDao extends BaseDao<Article> {

//    @Cacheable(value = "test")
    public List<Article> getArticleList(int pageNo, int pageSize) {
        DetachedCriteria criteria = DetachedCriteria.forClass(Article.class);
        return hibernateAccess.find(criteria, pageNo, pageSize);
    }

    public long getTotalRecords() {
        DetachedCriteria totalRecordCriteria = DetachedCriteria.forClass(Article.class);
        return hibernateAccess.getTotalRecords(totalRecordCriteria);
    }
}
