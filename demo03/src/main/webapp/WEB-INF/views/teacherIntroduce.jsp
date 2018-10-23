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
导师姓名：${teacherInfo.getteacherName()}<br/>
导师年龄：${teacherInfo.getteacherAge()}<br/>
导师性别：${teacherInfo.getteacherGender()}<br/>
导师住址：${teacherInfo.getteacherAddress()}<br/>
导师专业：${teacherInfo.getteacherMajor()}<br/>
导师邮箱：${teacherInfo.getteacherEmail()}<br/>
导师手机：${teacherInfo.getteacherPhone()}<br/>
</body>
</html>
