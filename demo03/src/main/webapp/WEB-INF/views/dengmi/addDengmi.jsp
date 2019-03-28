<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/3/28
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加灯谜</title>
</head>
<body>
<form name="addDengmiForm" action="/dengmi/addDengmi" method="get">
    谜面：<input id="mimian" name="mimian"><br/>
    谜目：<input id="mimu" name="mimu"><br/>
    谜格：<input id="mige" name="mige"><br/>
    谜底：<input id="midi" name="midi"><br/>
    谜注：<textarea id="mizhu" name="mizhu"></textarea><br/>
    作者：<input id="zuozhe" name="zuozhe"><br/>
    类型：<input id="leixing" name="leixing"><br/>
    解释：<textarea id="jieshi" name="jieshi"></textarea><br/>
    赏析：<textarea id="shangxi" name="shangxi"></textarea><br/>
    <button type="submit" value="添加">添加灯谜</button>
</form>
<hr/>
<c:if test="${!empty addResult}">
    刚刚添加的灯谜信息如下：
    ${dengmi.mimian} | ${dengmi.mimu} | ${dengmi.mige} | ${dengmi.midi} / ${dengmi.zuozhe} <br/>
    【注：${dengmi.mizhu}】
</c:if>
</body>
</html>
