<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 霍仰帅
  Date: 2018/9/20
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hallth - ${loginUserName}找回密码</title>
</head>
<body>
<div>
    <form action="/login/resetPassword">
        <%--<c:if test="${loginUserName}== \"\"">--%>
            <%--用户名：<input type="text" name="userName" id="userName" value="${loginUserName}"><br/>--%>
        <%--</c:if>--%>
        <%--<c:if test="${loginUserName}!= \"\"">--%>
            用户名：<input type="text" name="userName" id="userName" value="${loginUserName}" placeholder="在这里输入用户名"><br/>
        <%--</c:if>--%>
        新密码：<input type="password" name="newPassword" id="newPassword" placeholder="在这里输入新的密码" required/><br/>
        确认新密码：<input type="password" name="newPasswordCheck" id="newPasswordCheck" placeholder="再次输入新的密码" required/><br/>
        <button id="foundPasswordBtn" type="submit">确认修改</button>
    </form>
</div>
</body>
</html>
