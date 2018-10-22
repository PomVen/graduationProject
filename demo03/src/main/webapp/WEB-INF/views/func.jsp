<%--
  Created by IntelliJ IDEA.
  User: 霍仰帅
  Date: 2018/9/27
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hallth - 功能列表</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="/css/bootstrap-theme.min.css"></script>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <!-- 悬浮按钮所需的CSS和JS -->
    <link href="/css/hover-button.css" rel="stylesheet" type="text/css">
    <script src="/js/hover-button.js"></script>
    <link href="/css/hallth.css" rel="stylesheet">
    <script src="/js/hallth.js"></script>
</head>
<body>
<div class="showCenter">
    <div class="pink top">
        <%--<c:if test="${loginUserName} != null">--%>
        <%--<a href="#">欢迎您，亲爱的${loginUserName}</a>--%>
        <%--</c:if>--%>
        <%--<c:if test="${loginUserName} == null">--%>
        <%--<a href="login.jsp">登陆</a> &nbsp;|&nbsp;<a href="regit.jsp">注册</a>--%>
        <%--</c:if>--%>
        <a href="javascript:login()" target="_blank">登陆</a> &nbsp;| &nbsp;<a href="javascript:regit()"  target="_blank">注册</a>
    </div>
    <div class="panel panel-default func-demo">
        <div class="panel-heading">
            <h3 class="panel-title">
                灯谜区
            </h3>
        </div>
        <div class="panel-body">
            <a href="javascript:dengmizhuye()">灯谜</a>
        </div>
    </div>
</div>
</body>
</html>
