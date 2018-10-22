<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Haltlh - index</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
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

<div class="container">
    <div class="pink top">
        <%--<c:if test="${loginUserName} != null">--%>
            <%--<a href="#">欢迎您，亲爱的${loginUserName}</a>--%>
        <%--</c:if>--%>
        <%--<c:if test="${loginUserName} == null">--%>
            <%--<a href="login.jsp">登陆</a> &nbsp;|&nbsp;<a href="regit.jsp">注册</a>--%>
        <%--</c:if>--%>
        <a href="javascript:login()" target="_blank">登陆</a> &nbsp;| &nbsp;<a href="javascript:regit()" target="_blank">注册</a>
    </div>
    <div class="row">
        <div class="col-sm-4">
            <h3>第一列</h3>
            <div>
                <pre>form -- get</pre>
                <form id="searchStudent" action="/student/searchStudent" method="get">
                    学生姓名：<input id="studentName" name="studentName" type="text" placeholder="在这里输入学生姓名"><br/>
                    学&nbsp;&nbsp;&nbsp;&nbsp;号：<input id="studentCode" name="studentCode" type="text" placeholder="在这里输入学生学号"><br/>
                    <button value="查询信息" type="submit">查询信息</button>
                </form>
            </div>
        </div>
        <div class="col-sm-4">
            <h3>第二列</h3>
            <div>
                用户名：<input type="text" name="userName" id="userName"/><br/>
                <button onclick="searchUser()">查询用户信息</button>
            </div>
        </div>
        <div class="col-sm-4">
            <h3>第三列</h3>
            <p>学的不仅是技术，更是梦想！</p>
            <p>再牛逼的梦想,也抵不住你傻逼似的坚持！</p>
        </div>
    </div>
    <a href="/message/go">我要走了。。。</a>
</div>

</body>
<script type="text/javascript">
    function searchUser(){
        window.open("/message/searchUserDetail/data=" + document.getElementById("userName").value);
    }
</script>
</html>
