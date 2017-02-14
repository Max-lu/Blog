package cn.maxlu.controller;

import cn.maxlu.PageModel;
import cn.maxlu.annotation.LoginRequired;
import cn.maxlu.request.ArticleRequest;
import cn.maxlu.response.ArticleResponse;
import cn.maxlu.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.Map;

@Controller
public class ArtileController {

    @Inject
    private ArticleService articleService;

    @RequestMapping(value = "/article/{articleId}", method = RequestMethod.GET)
    public String articleDetail(Map<String, Object> model, @PathVariable("articleId") Integer articleId) {
        ArticleResponse articleDetail = articleService.getArticleDetail(articleId);
        model.put("articleDetail", articleDetail);
        return "article_detail";
    }


    @RequestMapping(value = "/articles/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public String articleListPage(ModelMap model, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        PageModel<ArticleResponse> pageModel = articleService.getArticleList(pageNo, pageSize);
        model.put("pageModel", pageModel);
        return "home_page";
    }

    @LoginRequired
    @RequestMapping(value = "/article/delete/{articleId}", method = RequestMethod.GET)
    public String deleteArticle(ModelMap model, @PathVariable("articleId") Integer articleId) {
        articleService.deleteArticle(articleId);
        return "redirect:/my/home/1/10";
    }

    @LoginRequired
    @RequestMapping(value = "/article/modify/{articleId}", method = RequestMethod.GET)
    public String toModifyArticle(ModelMap model, @PathVariable("articleId") Integer articleId) {
        ArticleResponse articleDetail = articleService.getArticleDetail(articleId);
        model.put("articleDetail", articleDetail);
        return "my_article_modify";
    }

    @LoginRequired
    @RequestMapping(value = "/article/modify/{articleId}", method = RequestMethod.POST)
    public String modifyArticle(ModelMap model, @PathVariable("articleId") Integer articleId, ArticleRequest articleRequest) {
        articleService.modifyArticle(articleId, articleRequest);
        return "redirect:/my/home/1/10";
    }
}
