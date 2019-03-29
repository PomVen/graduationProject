<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/3/28
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>灯谜</title>
    <link rel="stylesheet" href="/css/dengmi.css" />
</head>
<body>
<div id="queryDengmiDiv">
    <form name="addDengmiForm" action="/dengmi/queryDengmi" method="get">
        谜面：<input id="mimianQ" name="mimianQ"><br/>
        谜目：<input id="mimuQ" name="mimuQ"><br/>
        谜格：<input id="migeQ" name="migeQ"><br/>
        谜底：<input id="midiQ" name="midiQ"><br/>
        作者：<input id="zuozheQ" name="zuozheQ"><br/>
        类型：<input id="leixingQ" name="leixingQ"><br/>
        <button type="submit" value="查询">查询</button>
    </form>
</div>
<hr/>
<c:if test="${!empty isNull}">
    灯谜结果如下：
    <table>
        <tr>
            <th>谜面</th>
            <th>谜目</th>
            <th>谜底</th>
            <th>作者</th>
            <th>注</th>
        </tr>
        <c:forEach items="${dengmiList}" var="item">
            <tr>
                <td>${item.mimian}</td>
                <td>${item.mimu}${item.mige}</td>
                <td>${item.midi}</td>
                <td>${item.zuozhe}</td>
                <td>${item.mizhu}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
