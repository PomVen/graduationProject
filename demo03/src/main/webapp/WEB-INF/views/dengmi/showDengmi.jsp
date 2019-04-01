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
    <form name="addDengmiForm" action="/dengmi/queryDengmi/10/1" method="get">
        谜面：<input id="mimianQ" name="mimianQ" value="${mimianQ}"><br/>
        谜目：<input id="mimuQ" name="mimuQ" value="${mimuQ}"><br/>
        谜格：<input id="migeQ" name="migeQ" value="${migeQ}"><br/>
        谜底：<input id="midiQ" name="midiQ" value="${midiQ}"><br/>
        作者：<input id="zuozheQ" name="zuozheQ" value="${zuozheQ}"><br/>
        类型：<input id="leixingQ" name="leixingQ" value="${leixingQ}"><br/>
        <button type="submit" value="查询">查询</button>
    </form>
</div>
<hr/>
<c:if test="${empty isNull}">
    ${noResult}
</c:if>

<c:if test="${countRows > 0}">
    共${countRows}条，当前${pageNum} / ${pageMax}页
    <c:if test="${pageNum > 1}">
        <a href="/dengmi/queryDengmi/10/1?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">首页</a>
        <a href="/dengmi/queryDengmi/10/${pageNum - 1}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">上一页</a>
    </c:if>
    <c:if test="${pageNum - 1 > 2}">
        &nbsp;&nbsp;...&nbsp;&nbsp;
    </c:if>
    <c:if test="${pageNum  > 2}">
        <a href="/dengmi/queryDengmi/10/${pageNum - 2}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">${pageNum - 2}</a>
    </c:if>
    <c:if test="${pageNum > 1}">
        <a href="/dengmi/queryDengmi/10/${pageNum - 1}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">${pageNum - 1}</a>
    </c:if>
    <a href="/dengmi/queryDengmi/10/${pageNum}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}"><strong>${pageNum}</strong></a>
    <c:if test="${pageNum < pageMax}">
        <a href="/dengmi/queryDengmi/10/${pageNum + 1}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">${pageNum + 1}</a>
    </c:if>
    <c:if test="${(pageNum + 1) < pageMax}">
        <a href="/dengmi/queryDengmi/10/${pageNum + 2}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">${pageNum + 2}</a>
    </c:if>
    <c:if test="${(pageMax - pageNum) > 2}">
        &nbsp;&nbsp;...&nbsp;&nbsp;
    </c:if>
    <c:if test="${pageNum < pageMax}">
        <a href="/dengmi/queryDengmi/10/${pageNum + 1}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">下一页</a>
        <a href="/dengmi/queryDengmi/10/${pageMax}?mimianQ=${mimianQ}&mimuQ=${mimuQ}&migeQ=${migeQ}&midiQ=${midiQ}&zuozheQ=${zuozheQ}&leixingQ=${leixingQ}">尾页</a>
    </c:if>
    跳到第<input style="width: 5%;"/>页
</c:if>
<c:if test="${!empty isNull}">
    <table>
        <tr>
            <th class="th1">谜面</th>
            <th class="th1">谜目</th>
            <th class="th1">谜底</th>
            <th class="th1">作者</th>
            <th class="th1">注</th>
            <th class="th1">操作</th>
        </tr>
        <c:forEach items="${dengmiList}" var="item">
            <tr>
                <td class="th1">${item.mimian}</td>
                <td class="th1">${item.mimu}${item.mige}</td>
                <td class="th1">${item.midi}</td>
                <td class="th1">${item.zuozhe}</td>
                <td class="th1">${item.mizhu}</td>
                <td class="th1"><a href="/dengmi/deleteChoesed/${item.dengmiSeq}">删除</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>

</body>
</html>
<script type="text/javascript">
    function operations(){
        return "";
    }

    function deleteChoesed(id){
        $.ajax({
            type: "GET",
            url: "/dengmi/deleteDengmi",
            data: {dengmiSeq:id},
            dataType: "json",
            success: function(data){
                if(data){
                    alert("灯谜删除成功");
                }
            }
        });
    }
</script>
