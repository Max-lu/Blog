package cn.maxlu.service;

import cn.maxlu.dao.ArticleDao;
import cn.maxlu.request.ArticleRequest;
import cn.maxlu.entity.Article;
import cn.maxlu.util.DataConvert;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

@Service
public class PublishService {

    @Inject
    private ArticleDao articleDao;

    @Transactional
    public Article publish(ArticleRequest articleRequest) {
        fillInForm(articleRequest);
        Article article = new Article();
        DataConvert.convert(article, articleRequest);
        article.setUpdatedDate(articleRequest.getCreatedDate());
        article.setCommentAmount(0);
        int id = articleDao.insert(article);
        evictCache();
        return articleDao.get(Article.class, id);
    }

    @CacheEvict(value = "test")
    private void evictCache() {
        //clear cache
    }

    private void fillInForm(ArticleRequest articleRequest) {
        articleRequest.setCommentAmount(0);
        articleRequest.setCreatedDate(new Date());
    }
}
