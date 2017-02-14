<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="http://www.maxlu.cn/myTag" %>

<div>
    <ul>
        <c:forEach items="${pageModel.records}" var="record">
            <li><a href="/article/${record.id}">${record.content}</a><span>${record.createdDate}</span></li>
        </c:forEach>
        <img src="${pageContext.request.contextPath}/static/img/xyy.jpg">
    </ul>
</div>
<div class="page">
    <myTag:page url="${pageContext.request.contextPath}/page/" pageNo="${pageModel.pageNo}" pageSize="${pageModel.pageSize}" totalRecords="${pageModel.totalRecords}"/>
</div>
