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
</head>
<body>
批量添加灯谜
${result}
<div>
    <form action="/dengmi/addDengmis" name="mulAddDengmiForm" method="get">
        <input name="mulAddFile" type="file" required/><br/>
        <button type="submit">添加灯谜</button><a id="path" href="javascript:showPath()">路径查看</a>
    </form>
</div>
</body>
</html>
<script type="text/javascript">
    function showPath(){
        var path = document.getElementById("path").value;
        console.log(path);
    }
</script>
