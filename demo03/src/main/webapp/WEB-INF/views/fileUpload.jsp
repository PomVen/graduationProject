<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2019/3/27
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传 - hallth</title>
</head>
<body>
<form method="get" name="fileUp" action="/file/fileUpload">
    <input type="file" value="请选择文件" id="importFile" name="uploadFilePath">
    <button type="submit" value="读取文件" >读取文件</button>
</form>
<hr>
<c:if test="${!empty uploadFileName}">
    系统编码格式：${encoding}
    <br/>上传的文件名： ${uploadFileName} <br/>
    文件类型：${fileType}
    <br/>文件内容展示：<br/>
    <textarea style="width: 800px; height: 300px;" readonly>${fileContent}</textarea>
</c:if>
<script type="text/javascript">
    function upload(f) {
        var filename = document.getElementById("importFilePath").value;
        // 这时的filename不是 importFile 框中的值
        var file = window.URL.createObjectURL(f.files[0]);
        document.getElementById("importFile").value = file;
        console.log("f = " + file)
        console.log(filename);
    }
</script>
</body>
</html>
