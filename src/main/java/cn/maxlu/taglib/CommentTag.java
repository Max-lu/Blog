package cn.maxlu.taglib;

import cn.maxlu.response.ArticleResponse;
import cn.maxlu.response.CommentResponse;
import cn.maxlu.util.Lists;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

public class CommentTag extends TagSupport {

    @Override
    public int doStartTag() throws JspException {
        StringBuilder stringBuilder = new StringBuilder("");
        String result = "";
        ArticleResponse articleDetail = (ArticleResponse) pageContext.getRequest().getAttribute("articleDetail");
        List<CommentResponse> commentResponses = articleDetail.getCommentResponses();
        if (commentResponses != null && commentResponses.size() > 0) {
            result = handlerComment(stringBuilder, commentResponses);
        }
        try {
            pageContext.getOut().write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    private String handlerComment(StringBuilder stringBuilder, List<CommentResponse> commentResponses) {
        for (CommentResponse commentResponse : commentResponses) {
            stringBuilder.append("<div style='padding-left:")
                    .append(commentResponse.getLevel() * 20).append("px;'>").append(commentResponse.getContent())
                    .append("<input type='button' class='commentBtn' data-parentId = '").append(commentResponse.getId())
                    .append("' data-level='").append(commentResponse.getLevel() + 1).append("' value='评论'/></div>");
            if (Lists.isNotEmpty(commentResponse.getChildComment())) {
                handlerComment(stringBuilder, commentResponse.getChildComment());
            }
        }
        return stringBuilder.toString();
    }
}
