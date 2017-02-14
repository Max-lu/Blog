<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="http://www.maxlu.cn/myTag" %>

<div>
    <a href="${pageContext.request.contextPath}/publish">发表新文章</a>
    <table>
        <thead>
            <tr>
                <td>标题</td>
                <td>主题</td>
                <td>标签</td>
                <td>时间</td>
                <td>操作</td>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageModel.records}" var="record">
            <tr>
                <td><a href="/article/${record.id}">${record.title}</a></td>
                <td>${record.category}</td>
                <td>${record.tag}</td>
                <td>${record.createdDate}</td>
                <td><a href="${pageContext.request.contextPath}/article/modify/${record.id}">修改</a><strong>|</strong><a href="${pageContext.request.contextPath}/article/delete/${record.id}">删除</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<div class="page">
    <myTag:page url="${pageContext.request.contextPath}/page/" pageNo="${pageModel.pageNo}" pageSize="${pageModel.pageSize}" totalRecords="${pageModel.totalRecords}"/>
</div>
