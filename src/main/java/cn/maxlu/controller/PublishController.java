package cn.maxlu.controller;

import cn.maxlu.request.ArticleRequest;
import cn.maxlu.entity.Article;
import cn.maxlu.annotation.LoginRequired;
import cn.maxlu.service.PublishService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PublishController {

    @Inject
    private PublishService publishService;

    @LoginRequired
    @RequestMapping(value = "/publish", method = {RequestMethod.GET})
    public String toPublishPage(Map<String, Object> map) {
        map.put("category", new HashMap<String, Object>());
        return "article_publish";
    }

    @LoginRequired
    @RequestMapping(value = "/publish", method = {RequestMethod.POST})
    public String publish(Map<String, Object> map, ArticleRequest articleRequest) {
        Article article = publishService.publish(articleRequest);
        map.put("article", article);
        return "article_preview";
    }
}
