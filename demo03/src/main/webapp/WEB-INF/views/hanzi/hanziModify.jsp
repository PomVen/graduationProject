<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/4/22
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/hanzi/modifyHanzi" method="get" name="hanziModifyForm">
    <input id="hanziM" name="hanziM" style="width: 3%;" value="${entry.hanzi}">&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="shengmuM" name="shengmuM" style="width: 3%;" value="${entry.shengmu}">
    <input id="yunmuM" name="yunmuM" style="width: 3%;" value="${entry.yunmu}">
    <input id="shengdiaoM" name="shengdiaoM" style="width: 3%;" value="${entry.shengdiao}">&nbsp;&nbsp;&nbsp;&nbsp;
    <input id="bihuashuM" name="bihuashuM" style="width: 3%;" value="${entry.bihuashu}">笔<br/>
    <textarea id="ziyiM" name="ziyiM" style="width: 20%;">${entry.ziyi}</textarea><br/>
    <button type="submit">修改</button>&nbsp;&nbsp;<button type="reset">重置</button>
</form>
</body>
</html>
