package cn.maxlu.service;

import cn.maxlu.dao.CommentDao;
import cn.maxlu.request.CommentRequest;
import cn.maxlu.entity.Comment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.Date;

@Service
public class CommentService {

    @Inject
    private CommentDao commentDao;


    @Transactional
    public void comment(CommentRequest commentRequest) {
        Integer articleId = commentRequest.getArticleId();
        Integer parentCommentId = commentRequest.getParentCommentId();
        Comment comment = new Comment();
        comment.setArticleId(articleId);
        comment.setParentCommentId(parentCommentId);
        comment.setContent(commentRequest.getCommentContent());
        comment.setIsTop(parentCommentId == null ? "Y" : "N");
        comment.setCreatedDate(new Date());
        comment.setLevel(commentRequest.getLevel());
        int newId = commentDao.insert(comment);

        if (parentCommentId != null) {
            Comment parentComment = commentDao.get(Comment.class, parentCommentId);
            String childCommentIds = parentComment.getChildCommentIds();
            parentComment.setChildCommentIds(childCommentIds == null ? String.valueOf(newId) : (newId + "," + newId));
            commentDao.update(parentComment);
        }
    }
}
