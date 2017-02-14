<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
    <form class="sui-form form-horizontal" action="${pageContext.request.contextPath}/publish" method="post">
        <div class="control-group">
            <label for="title" class="control-label">标题：</label>
            <div class="controls">
                <input type="text" id="title" name="title" placeholder="Email">
            </div>
        </div>

        <div class="control-group">
            <label for="category" class="control-label">分类：</label>
            <select id="category" name="category" class="select">
                <option value="java">java</option>
                <option value="c#">c#</option>
            </select>
        </div>

        <div class="control-group">
            <label for="tag" class="control-label">标签：</label>
            <div class="controls">
                <input type="text" id="tag" name="tag" placeholder="tag1,tag2">
                <input type="button" id="addTag" value="+" class="sui-btn btn-primary">
            </div>
        </div>

        <div class="control-group">
            <label for="content" class="control-label">内容：</label>
            <div class="controls">
                <textarea id="content" name="content" rows="3"></textarea>
            </div>
        </div>


        <div class="control-group">
            <label class="control-label"></label>
            <div class="controls">
                <button type="submit" class="sui-btn btn-primary">提交</button>
            </div>
        </div>
    </form>
</div>
