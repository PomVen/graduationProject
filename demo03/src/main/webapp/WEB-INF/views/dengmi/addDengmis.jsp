<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/3/29
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/css/dengmi.css" />
    <script src="/js/jquery.min.js"></script>
    <script src="/js/hallth/hallth.js"></script>
</head>
<body>
<div>
        <table border="1" cellspacing="0" cellpadding="0" style="width:400px;text-align: center;">
    <tr><th>部门</th><th>姓名</th><th>年龄</th><th>性别</th><th>民族</th></tr>
    <tbody id="pageInfo">
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>管理部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>应用部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>开发部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
        <tr><td>市场部</td><td>强哥</td><td>22</td><td>男</td><td>汉族</td></tr>
    </tbody>
        </table>
        <div id="pagination" style="margin-top: 10px;height: 35px;">
    <a id="firPage" onclick="firstPage()" style="margin-left: 0px;width: 35px;">首页</a>
    <a id="prePage" onclick="prevPage()">上一页</a>
    <a id="nexPage" onclick="pnextPage()">下一页</a>
    <a id="lasPage" onclick="lastPage()" style="width: 35px;">尾页</a>
    <input id="numPage" style="width: 40px;margin-left: 10px;height: 16px;" />
        </div>
</div>
</body>
</html>
