<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="myTag" uri="http://www.maxlu.cn/myTag" %>

<div>
<ul>
  <c:forEach items="${testPageModel.records}" var="test">
    <li>name:${test.name}  age:${test.age}</li>
  </c:forEach>
</ul>
</div>
<div class="page">
  <myTag:page url="${pageContext.request.contextPath}/page/" pageNo="${testPageModel.pageNo}" pageSize="${testPageModel.pageSize}" totalRecords="${testPageModel.totalRecords}"/>
</div>

