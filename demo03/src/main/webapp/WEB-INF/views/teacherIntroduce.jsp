<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2018/10/23
  Time: 10:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>毕业设计选课系统 - 导师介绍</title>
</head>
<body>
<c:if test="${!empty teacherInfo}">
    导师姓名：${teacherInfo.getteacherName()}<br/>
    导师年龄：${teacherInfo.getteacherAge()}<br/>
    导师性别：${teacherInfo.getteacherGender()}<br/>
    导师住址：${teacherInfo.getteacherAddress()}<br/>
    导师专业：${teacherInfo.getteacherMajor()}<br/>
    导师邮箱：${teacherInfo.getteacherEmail()}<br/>
    导师手机：${teacherInfo.getteacherPhone()}<br/>
</c:if>
<c:if test="${empty teacherInfo}">
    您尚未选择课题，无法查看导师信息。
</c:if>
</body>
</html>
