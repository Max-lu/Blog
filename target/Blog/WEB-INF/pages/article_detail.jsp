<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="http://www.maxlu.cn/myTag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
    <div>
        <ul>
            <input id="articleId" type="hidden" value="${articleDetail.id}">
            <li>
                <label for="title">标题</label>
                <input id="title" name="title" type="text" value="${articleDetail.title}">
            </li>
            <li>
                <label for="createdDate">时间</label>
                <input id="createdDate" name="createdDate" type="text" value="${articleDetail.createdDate}">
            </li>
            <li>
                <label for="category">分类</label>
                <input id="category" name="category" type="text" value="${articleDetail.category}">
            </li>
            <li>
                <label for="tag">标签</label>
                <input id="tag" name="tag" type="text" value="${articleDetail.tag}"/>
            </li>
            <li>
                <label for="content">内容</label>
                <textarea id="content" name="content" maxlength="10000" rows="100"
                          cols="50">${articleDetail.content}</textarea>
            </li>
        </ul>

    </div>
    <div>
        <form action="/comment" method="post">
            <input type="hidden" name="articleId" value="${articleDetail.id}">
            <input type="hidden" name="level" value="1">
            <textarea name="commentContent"></textarea>
            <input type="submit" value="评论">
        </form>
    </div>

    <div>
        <myTag:comment/>
    </div>

</div>


<script>
    $(function () {
        $(".commentBtn").on('click', function () {
            var form = $('<form action="/comment" method="post"></form>');
            var parentCommentId = $(this).data("parentid");
            var level = $(this).data("level");
            var articleIdInput = $('<input type="hidden" name="articleId" value="' + $("#articleId").val() + '">');
            var parentCommentIdInput = $('<input type="hidden" name="parentCommentId" value="' + parentCommentId + '">');
            var levelInput = $('<input type="hidden" name="level" value="' + level + '">');
            form.append(articleIdInput).append(parentCommentIdInput).append(levelInput);
            form.append('<textarea name="commentContent"></textarea><input type="submit" value="确定">');
            $(this).before(form);
            $(this).remove();
        });
    })
</script>


