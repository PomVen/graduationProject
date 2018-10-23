<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2018/10/23
  Time: 10:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>毕业设计选课系统 - 课题介绍</title>
</head>
<body>
<c:if test="${!empty theme}">
    课题名称：${theme.getteacherName()}<br/>
    课题描述：${theme.getteacherAge()}<br/>
    课题导师：${theme.getteacherGender()}<br/>
</c:if>
<c:if test="${empty theme}">
    您尚未选择课题，无法查看课题信息。
</c:if>
</body>
</html>
