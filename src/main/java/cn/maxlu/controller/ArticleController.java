package cn.maxlu.controller;

import cn.maxlu.response.AjaxResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleController {

    @RequestMapping(value = "/article/list", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public AjaxResponse goHomePage() {
        AjaxResponse ajaxResponse = new AjaxResponse();
        ajaxResponse.setMessage("success");
        ajaxResponse.setState(true);
        ajaxResponse.setResult("hello world");
        return ajaxResponse;
    }

}