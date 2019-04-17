<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/4/17
  Time: 13:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>露春检测</title>
</head>
<body>
<div>
    <form action="/dengmi/louchunCheck" name="mulAddDengmiForm" method="get">
        <input name="louchunFile" type="file" required/><br/>
        <button type="submit">检测露春</button>
    </form>
</div>
文件格式要求：<br/>
只支持txt文件：谜面 谜目+谜格 谜底<br/>
<hr/>
<c:if test="${!empty checkResult}">
    检测结果：
    ${checkResult}<br/>
</c:if>
<c:if test="${!empty louchunDengmi}">
    <textarea readonly style="width: 60%; height: 40%; font-size: medium;">${louchunDengmi}</textarea>
</c:if>
</body>
</html>
