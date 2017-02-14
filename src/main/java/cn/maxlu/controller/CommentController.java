package cn.maxlu.controller;

import cn.maxlu.request.CommentRequest;
import cn.maxlu.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.inject.Inject;

@Controller
public class CommentController {

    @Inject
    private CommentService commentService;

    @RequestMapping(value = "/comment", method = RequestMethod.POST)
    public String comment(CommentRequest commentRequest) {
        commentService.comment(commentRequest);
        return "redirect:/article/" + commentRequest.getArticleId();
    }
}
