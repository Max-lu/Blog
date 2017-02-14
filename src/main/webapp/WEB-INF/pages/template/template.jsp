<%--
  Created by IntelliJ IDEA.
  User: max.lu
  Date: 2016/2/17
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><tiles:insertAttribute name="title" ignore="true"/></title>
    <tiles:insertAttribute name="script"/>
</head>
<body>
<tiles:insertAttribute name="header" flush="true"/>
<%--<div class="main">--%>
<%--&lt;%&ndash;<tiles:insertAttribute name="side"/>&ndash;%&gt;--%>
<%--<tiles:insertAttribute name="menu"/>--%>
<%--<tiles:insertAttribute name="body"/>--%>
<%--</div>--%>
<div class="sui-container">
    <div class="sui-row">
        <div class="span2"><tiles:insertAttribute name="menu"/></div>
        <div class="span6" style="min-height: 891px"><tiles:insertAttribute name="body"/></div>
    </div>
</div>


<tiles:insertAttribute name="footer"/>


</body>
</html>
