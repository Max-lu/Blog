package cn.maxlu.dao;

import cn.maxlu.entity.Comment;
import cn.maxlu.response.CommentResponse;
import cn.maxlu.util.DataConvert;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentDao extends BaseDao<Comment> {

    public List<CommentResponse> getCommentByArticleId(Integer articleId) {
        List<CommentResponse> commentResponses = new ArrayList<>();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Comment.class).add(Restrictions.eq("articleId", articleId)).add(Restrictions.eq("isTop", "Y"));
        List<Comment> topComments = hibernateAccess.find(detachedCriteria);
        getChildComments(commentResponses, topComments);
        return commentResponses;
    }

    private void getChildComments(List<CommentResponse> commentResponses, List<Comment> topComments) {
        for (Comment topComment : topComments) {
            CommentResponse commentResponse = new CommentResponse();
            DataConvert.convert(commentResponse, topComment);
            commentResponses.add(commentResponse);
            if (StringUtils.hasText(topComment.getChildCommentIds())) {
                for (String id : topComment.getChildCommentIds().split(",")) {
                    DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Comment.class).add(Restrictions.eq("id", Integer.valueOf(id)));
                    List<Comment> childComments = hibernateAccess.find(detachedCriteria);
                    getChildComments(commentResponse.getChildComment(), childComments);
                }
            }
        }
    }
}
