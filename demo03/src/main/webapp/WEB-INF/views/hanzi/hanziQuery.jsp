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
<form id="hanziQuery" name="hanziQuery" method="get" action="/hanzi/hanziQuery/10/1">
    汉字：<input type="text" name="hanziQ" id="hanziQ" value="${hanziQ}">&nbsp;&nbsp;&nbsp;&nbsp;声母：<input type="text" name="shengmuQ" id="shengmuQ" value="${shengmuQ}"><br/>
    韵母：<input type="text" name="yunmuQ" id="yunmuQ" value="${yunmuQ}">&nbsp;&nbsp;&nbsp;&nbsp;声调：<input type="text" name="shengdiaoQ" id="shengdiaoQ" value="${shengdiaoQ}"><br/>
    字义：<input type="text" name="ziyiQ" id="ziyiQ" value="${ziyiQ}">&nbsp;&nbsp;&nbsp;&nbsp;笔画数：<input type="text" name="bihuashuQ" id="bihuashuQ" value="${bihuashuQ}"><br/>
    <button value="查询" type="submit">查询</button>&nbsp;<button type="reset" value="重置">重置</button>
</form>
<hr/>
<c:if test="${empty isNull}">
    ${noResult}
</c:if>
<c:if test="${!empty isNull}">
    每页显示<input style="width: 3%;" onblur="setPageSize()" id="setPageSize" value="${pageSize}"/>条;
    共${countRows}条，当前${pageNum} / ${pageMax}页
    <c:if test="${pageNum > 1}">
        <a href="javascript:fanye(1)">首页</a>
        <a href="javascript:fanye(${pageNum - 1})">上一页</a>
    </c:if>
    <c:if test="${pageNum > 3 && pageMax > 5}">
        &nbsp;&nbsp;...&nbsp;&nbsp;
    </c:if>
    <c:if test="${pageNum > 2}">
        <a href="javascript:fanye(${pageNum - 2})">${pageNum - 2}</a>
    </c:if>
    <c:if test="${pageNum > 1}">
        <a href="javascript:fanye(${pageNum - 1})">${pageNum - 1}</a>
    </c:if>
    <a href="javascript:fanye(${pageNum})"><strong>${pageNum}</strong></a>
    <c:if test="${pageNum < pageMax}">
        <a href="javascript:fanye(${pageNum + 1})">${pageNum + 1}</a>
    </c:if>
    <c:if test="${(pageNum + 1) < pageMax}">
        <a href="javascript:fanye(${pageNum + 2})">${pageNum + 2}</a>
    </c:if>
    <c:if test="${(pageMax - pageNum) > 2 && pageMax > 5}">
        &nbsp;&nbsp;...&nbsp;&nbsp;
    </c:if>
    <c:if test="${pageNum < pageMax}">
        <a href="javascript:fanye(${pageNum + 1})">下一页</a>
        <a href="javascript:fanye(${pageMax})">尾页</a>
    </c:if>
    跳到第<input style="width: 3%;" onblur="turnToPage()" id="tiaozhuan"/>页
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
                    <c:if test="${!empty item.shengmu}">
                        <td class="th1"><a href="/hanzi/modifyHanzi/${item.hanzi}/${item.shengdiao}/${item.yunmu}/${item.shengmu}">修改</a></td>
                    </c:if>
                    <c:if test="${empty item.shengmu}">
                        <td class="th1"><a href="/hanzi/modifyHanzi/${item.hanzi}/${item.shengdiao}/${item.yunmu}/无">修改</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</c:if>
</body>
</html>
<script type="text/javascript">
    function getURIParam(){
        return "?hanziQ=${hanziQ}&shengmuQ=${shengmuQ}&shengdiaoQ=${shengdiaoQ}&yunmuQ=${yunmuQ}&ziyiQ=${ziyiQ}&bihuashuQ=${bihuashuQ}"
    }
    function setPageSize(){
        var pageSize = document.getElementById("setPageSize").value;
        var param = getURIParam();
        if(pageSize == ""){
            //不进行任何操作
        } else {
            var hrefStr = "/hanzi/hanziQuery/" + pageSize + "/${pageNum}"+ param;
            window.location.href = hrefStr;
        }
    }
    function fanye(pageNum){
        window.location.href =  "/hanzi/hanziQuery/${pageSize}/" + pageNum + getURIParam();
    }
    function turnToPage(){
        var pageNum = document.getElementById("tiaozhuan").value;
        if(pageNum == ""){
            //不进行任何操作
        } else if(pageNum > ${pageMax} || pageNum < 1){
            alert("页码值无效！");
        } else {
            window.location.href = "/hanzi/hanziQuery/${pageSize}/" + pageNum + getURIParam();
        }
    }
</script>
