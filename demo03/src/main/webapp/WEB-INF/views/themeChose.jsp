<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
Created by IntelliJ IDEA.
User: 霍仰帅
Date: 2018/9/27
Time: 14:04
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hallth - 灯谜首页</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- 可选的Bootstrap主题文件（一般不使用） -->
    <script src="/css/bootstrap-theme.min.css"></script>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="/js/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="/js/bootstrap.min.js"></script>
    <!-- 悬浮按钮所需的CSS和JS -->
    <link href="/css/hover-button.css" rel="stylesheet" type="text/css">
    <script src="/js/hover-button.js"></script>
    <link href="/css/hallth.css" rel="stylesheet">
    <script src="/js/hallth.js"></script>
</head>
<body>
<div class="showCenter">
    <c:if test="${userRole == 1}">
        <input type="button" class="btn btn-primary" value="新增灯谜" data-toggle="modal" data-target="#addDengmi" onclick=""/><br/>
    </c:if>
    <hr/>
    <span style="color : red; font-size: medium">*支持模糊查询</span>
    <div style="text-align: center; width: 100%; height: auto;">
        <div id="queryZone">
            <form id="dengmiQuery" action="/login/query">
                导师姓名：<input id="teacherName" name="teacherName" type="text" class="input-sm" placeholder="在此输入导师名称">
                课题名称：<input id="themeTitle" name="themeTitle" type="text" class="input-sm" placeholder="在此输入课题名称"><br/>
                <div class="query-btn">
                    <button class="btn btn-primary" type="submit" id="querySubmit">查询</button>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <button class="btn btn-primary" id="reset" type="reset">重置</button>
                </div>
            </form>
        </div>
        <table border="1" cellpadding="10" cellspacing="0" class="table1">
            <thead>
            <tr>
                <td style="width: 5%">序号</td>
                <td style="width: 30%">课题名称</td>
                <td style="width: 10%">课题简介</td>
                <td style="width: 10%">课题导师</td>
                <td style="width: 10%">导师联系方式</td>
                <td style="width: 20%">已选人数</td>
                <td style="width: 20%">操作</td>

            </tr>
            </thead>
            <c:forEach items="${requestScope.pagemsg.lists}" var="u">
                <tr>
                    <th>${u.themeSeq }</th>
                    <th>${u.themeTitle }</th>
                    <th>${u.themeIntroduction }</th>
                    <th>${u.themeTeacher }</th>
                    <th>${u.teacherPhone }</th>
                    <th>${u.count }</th>
                    <th>选择该课题</th>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${0 == requestScope.pagemsg.totalCount}">
                <span style="font-size: medium;">当前没有复核条件的查询结果</span>
        </c:if>
    </div>
<%--</c:if>--%>
    <table border="0" cellspacing="0" cellpadding="0" width="900px">
        <tr>
            <td class="td2">
                <span>第${requestScope.pagemsg.currPage }/ ${requestScope.pagemsg.totalPage}页</span>&nbsp;&nbsp;
                <span>总记录数：${requestScope.pagemsg.totalCount }&nbsp;&nbsp;每页显示:${requestScope.pagemsg.pageSize}</span>&nbsp;&nbsp;
                <span>
               <c:if test="${requestScope.pagemsg.currPage != 1}">
                   <a href="${pageContext.request.contextPath }/dengmi/chaxun?mimian=&mimumige=&midi=&shangxi=&author=&currentPage=1">[首页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath }/dengmi/chaxun?mimian=&mimumige=&midi=&shangxi=&author=&currentPage=${requestScope.pagemsg.currPage-1}">[上一页]</a>&nbsp;&nbsp;
               </c:if>

               <c:if test="${requestScope.pagemsg.currPage != requestScope.pagemsg.totalPage}">
                   <a href="${pageContext.request.contextPath }/dengmi/chaxun?mimian=&mimumige=&midi=&shangxi=&author=&currentPage=${requestScope.pagemsg.currPage+1}">[下一页]</a>&nbsp;&nbsp;
                   <a href="${pageContext.request.contextPath }/dengmi/chaxun?mimian=&mimumige=&midi=&shangxi=&author=&currentPage=${requestScope.pagemsg.totalPage}">[尾页]</a>&nbsp;&nbsp;
               </c:if>
            </span>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
