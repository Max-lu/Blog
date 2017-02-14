package cn.maxlu.controller;

import cn.maxlu.PageModel;
import cn.maxlu.response.ArticleResponse;
import cn.maxlu.service.ArticleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class MySpaceController {

    @Inject
    private ArticleService articleService;


    @RequestMapping(value = "/my/home/{pageNo}/{pageSize}", method = RequestMethod.GET)
    public String goToMyHomePage(ModelMap model, @PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        PageModel<ArticleResponse> pageModel = articleService.getArticleList(pageNo, pageSize);
        model.put("pageModel", pageModel);
        return "my_home";
    }
}
