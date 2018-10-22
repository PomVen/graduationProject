<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 霍仰帅
  Date: 2018/10/9
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>学生毕设 - 用户注册</title>
    <link rel="stylesheet" type="text/css" href="/css/normalize.css" />
    <link rel="stylesheet" type="text/css" href="/css/demo.css" />
    <!--必要样式-->
    <link rel="stylesheet" type="text/css" href="/css/component.css" />
    <!--[if IE]>
    <script src="/js/html5.js"></script>
    <![endif]-->
</head>
<body>
<div class="container demo-1">
    <div class="content">
        <div id="large-header" class="large-header">
            <canvas id="demo-canvas"></canvas>
            <div class="logo_box">
                <h3>用户注册</h3>
                <form action="/login/userRegit" name="f" method="post">
                    <div class="input_outer">
                        <span class="u_user"></span>
                        <input name="regitUserName" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户" autocomplete="off">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="regitPassword" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码" autocomplete="off">
                    </div>
                    <div class="input_outer">
                        <span class="us_uer"></span>
                        <input name="regitPasswordCheck" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请再次确认密码" autocomplete="off" required>
                    </div>

                    <button type="submit" class="mb2 act-but submit">注册</button>
                    已有账户，我要去<a href="/login/login" class="word-btn">登陆</a>
                </form>
                <c:if test="errMsg!=null">
                    errMsg!=null
                    <div class="input_outer">
                            ${errMsg}
                    </div>
                </c:if>
                <c:if test="errMsg!=''">
                    errMsg!=''
                    <div class="input_outer">
                            ${errMsg}
                    </div>
                </c:if>
                <c:if test="${errMsg}!=null">
                    ${errMsg}!=null
                    <div class="input_outer">
                            ${errMsg}
                    </div>
                </c:if>
                <c:if test="${errMsg}!=''">
                    ${errMsg}!=''
                    <div class="input_outer">
                            ${errMsg}
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div><!-- /container -->
<script src="/js/TweenLite.min.js"></script>
<script src="/js/EasePack.min.js"></script>
<script src="/js/rAF.js"></script>
<script src="/js/demo-1.js"></script>
</body>
</html>