<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/4/8
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/dengmi.css" />
</head>
<body>
<c:if test="${!empty isNull}">
    <table>
        <tr>
            <th class="th1">汉字</th>
            <th class="th1">读音</th>
            <th class="th1">字义</th>
            <th class="th1">操作</th>
        </tr>
        <c:forEach items="${hanziList}" var="item">
            <tr>
                <td class="th1">${item.hanzi}</td>
                <td class="th1">${item.shengmu}${item.yunmu}${item.shengdiao}</td>
                <td class="th1">${item.ziyi}</td>
                <td class="th1"><a href="/hanzi/modifyHanzi/${item.hanzi}">修改</a></td>
            </tr>
        </c:forEach>
        <c:forEach items="${zidianList}" var="item">
            <tr>
                <td class="th1">${item.zi}</td>
                <td class="th1">${item.pinyin}</td>
                <td class="th1">${item.jijie}</td>
                <td class="th1"><a href="/hanzi/modifyHanzi/${item.id}">修改</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
