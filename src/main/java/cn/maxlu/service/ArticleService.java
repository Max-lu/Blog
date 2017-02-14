package cn.maxlu.service;

import cn.maxlu.PageModel;
import cn.maxlu.dao.ArticleDao;
import cn.maxlu.dao.CommentDao;
import cn.maxlu.entity.Article;
import cn.maxlu.request.ArticleRequest;
import cn.maxlu.response.ArticleResponse;
import cn.maxlu.util.DataConvert;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArticleService {

    @Inject
    private ArticleDao articleDao;

    @Inject
    private CommentDao commentDao;

    public ArticleResponse getArticleDetail(Integer articleId) {
        Article article = articleDao.get(Article.class, articleId);
        ArticleResponse articleResponse = new ArticleResponse();
        DataConvert.convert(articleResponse, article);
        articleResponse.setCommentResponses(commentDao.getCommentByArticleId(articleId));
        return articleResponse;
    }

    public PageModel<ArticleResponse> getArticleList(int pageNo, int pageSize) {
        long totalRecords = articleDao.getTotalRecords();
        List<Article> articleList = articleDao.getArticleList(pageNo, pageSize);
        List<ArticleResponse> articleResponseList = new ArrayList<>();
        for (Article article : articleList) {
            ArticleResponse articleResponse = new ArticleResponse();
            DataConvert.convert(articleResponse, article);
            articleResponseList.add(articleResponse);
        }
        return PageModel.createPageModel(pageNo, pageSize, totalRecords, articleResponseList);
    }

    public void deleteArticle(Integer articleId) {
        articleDao.delete(Article.class, articleId);
    }

    public void modifyArticle(Integer articleId, ArticleRequest articleRequest) {
        articleRequest.setId(articleId);
        Article article = articleDao.get(Article.class, articleId);
        article.setUpdatedDate(new Date());
        article.setCategory(articleRequest.getCategory());
        article.setContent(articleRequest.getContent());
        article.setTag(articleRequest.getTag());
        article.setTitle(articleRequest.getTitle());
        article.setUpdatedDate(new Date());
        articleDao.update(article);
    }
}
