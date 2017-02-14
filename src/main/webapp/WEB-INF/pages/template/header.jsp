<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="myTag" uri="http://www.maxlu.cn/myTag" %>
<%--<div class="header">--%>
    <%--<a class="webImg" href="#"><img src="${pageContext.request.contextPath}/static/img/img1.jpg" width="50px" height="50px"></a>--%>
    <%--<h1>Max's Blog</h1>--%>
    <%--<div class="loginBtn">--%>
        <%--<myTag:login/>--%>
    <%--</div>--%>
<%--</div>--%>

<div class="sui-navbar navbar-inverse">
    <div class="navbar-inner"><a href="#" class="sui-brand">Max's Blog</a>
        <ul class="sui-nav">
            <li class="active"><a href="#">首页</a></li>
            <li><a href="#">组件</a></li>
            <li class="sui-dropdown"><a href="javascript:void(0);" data-toggle="dropdown" class="dropdown-toggle">其他 <i class="caret"></i></a>
                <ul role="menu" class="sui-dropdown-menu">
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">关于</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">项目组成员</a></li>
                    <li role="presentation"><a role="menuitem" tabindex="-1" href="#">版权</a></li>
                </ul>
            </li>
        </ul>
        <form class="sui-form sui-form pull-right">
            <input type="text" placeholder="文章名称...">
            <button class="sui-btn">搜索</button>
        </form>
    </div>
</div>