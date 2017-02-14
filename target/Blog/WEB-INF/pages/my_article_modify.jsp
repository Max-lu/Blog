<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="content">
    <div>
        <form action="/article/modify/${articleDetail.id}" method="post">
            <ul>
                <li>
                    <label for="title">标题</label>
                    <input id="title" name="title" type="text" value="${articleDetail.title}">
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
                    <textarea id="content" name="content" maxlength="10000" rows="100" cols="50">${articleDetail.content}</textarea>
                </li>
                <li>
                    <label></label>
                    <input type="submit" value="保存">
                </li>
            </ul>
        </form>
    </div>
</div>



