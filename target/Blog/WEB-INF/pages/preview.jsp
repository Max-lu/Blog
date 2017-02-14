<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
    <ul>
        <li>
            <label for="title">标题</label>
            <input id="title" name="title" type="text" value="${article.title}" readonly>
        </li>
        <li>
            <label for="createdDate">时间</label>
            <input id="createdDate" name="createdDate" type="text" value="${article.createdDate}" readonly>
        </li>
        <li>
            <label for="category">分类</label>
            <input id="category" name="category" type="text" value="${article.category}" readonly>
        </li>
        <li>
            <label for="tag">标签</label>
            <input id="tag" name="tag" type="text" value="${article.tag}"/>
        </li>
        <li>
            <label for="content">内容</label>
            <textarea id="content" name="content" maxlength="10000" rows="100" cols="50">${article.content}</textarea>
        </li>
    </ul>
</div>
