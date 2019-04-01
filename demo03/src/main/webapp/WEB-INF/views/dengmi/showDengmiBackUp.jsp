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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-table.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script src="/js/bootstrap-table-zh-CN.js"></script>
</head>
<body>
<div id="queryDengmiDiv">
    <div>
        <form  id="search_User" method="/dengmi/queryDengmi" name="queryDengmiForm" method="get">
            <%--<p class="search_p">--%>
            <%--<label for="teacherName">导师姓名：</label>--%>
            <%--<input type="text" class="form-control" id="teacherName" name="teacherName" >--%>
            <%--</p>--%>
            谜面：<input id="mimianQ" name="mimianQ"><br/>
            谜目：<input id="mimuQ" name="mimuQ"><br/>
            谜格：<input id="migeQ" name="migeQ"><br/>
            谜底：<input id="midiQ" name="midiQ"><br/>
            作者：<input id="zuozheQ" name="zuozheQ"><br/>
            类型：<input id="leixingQ" name="leixingQ"><br/>
            <button type="submit" value="查询">查询</button>
            <%--<p class="search_p" style="text-align: center;">--%>
            <%--<input type="button" class="btn btn-primary btn_search" value="搜索" onclick="serachUser()"/>--%>
            <%--</p>--%>
        </form>
    </div>
</div>
<hr/>
<div style="height:60%;">
    <table id="dengmiListTable" ></table>
</div>
<%--<c:if test="${!empty isNull}">--%>
<%--灯谜结果如下：--%>
<%--<table>--%>
<%--<tr>--%>
<%--<th>谜面</th>--%>
<%--<th>谜目</th>--%>
<%--<th>谜底</th>--%>
<%--<th>作者</th>--%>
<%--<th>注</th>--%>
<%--<th>操作</th>--%>
<%--</tr>--%>
<%--<c:forEach items="${dengmiList}" var="item">--%>
<%--<tr>--%>
<%--<td>${item.mimian}</td>--%>
<%--<td>${item.mimu}${item.mige}</td>--%>
<%--<td>${item.midi}</td>--%>
<%--<td>${item.zuozhe}</td>--%>
<%--<td>${item.mizhu}</td>--%>
<%--<td>删除</td>--%>
<%--</tr>--%>
<%--</c:forEach>--%>
<%--</table>--%>
<%--</c:if>--%>

</body>
</html>
<script type="text/javascript">
    $(function(){
        var columns=[
            {
                checkbox: true,
                align: 'center',
                valign: 'middle',
            },{
                title: '序号',
                field: 'dengmiSeq',
                align: 'center',
                valign: 'middle',
            },{
                title: '谜面',
                field: 'mimian',
                align: 'center',
                valign: 'middle',
            },{
                title: '谜目',
                field: 'mimu',
                align: 'center',
            },{
                title: '谜格',
                field: 'mige',
                align: 'center',
            },{
                title: '谜底',
                field: 'midi',
                align: 'center',
            },{
                title: '作者',
                field: 'zuozhe',
                align: 'center',
            },{
                title: '注',
                field: 'mizhu',
                align: 'center',
            },{
                title: '操作',
                field: 'id',
                align: 'center',
                formatter:function(value,row,index){
                    var e = '<button href="#" class="btn btn-primary"  onclick="chose(\''+ row.dengmiSeq + '\')">删除</button> ';
                    return e;
                }
            }
        ];
        showTable('/dengmi/queryDengmi',columns);
    });

    function a (dataurl,columns) {
        $('#userListTable').bootstrapTable({
            url: dataurl,
            method:"get",
            dataType: "json",
            contentType: "application/x-www-form-urlencoded",
            striped:true,//隔行变色
            cache:false,  //是否使用缓存
            showColumns:false,// 列
//            toobar:'#toolbar',
            pagination: true, //分页
            paginationLoop:false,
            paginationPreText:'上一页',
            paginationNextText:'下一页',
//            showFooter:true,//显示列脚
//             showRefresh:true,//显示刷新
            showPaginationSwitch:false,//是否显示数据条数选择框
            sortable: false,           //是否启用排序
            singleSelect: false,
            search:false, //显示搜索框
            buttonsAlign: "right", //按钮对齐方式
            showRefresh:false,//是否显示刷新按钮
            sidePagination: "server", //服务端处理分页
            pageNumber:1,
            pageSize:10,
            pageList:[5,10, 25, 50, 100],
            undefinedText:'--',
            uniqueId: "dengmiSeq", //每一行的唯一标识，一般为主键列
            queryParamsType:'',
            queryParams: queryParams,//传递参数（*）
            columns: columns
        });

        //得到查询的参数
        function queryParams (params) {
            var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                mimianQ: $("#mimianQ").val(),//后台请求传的查询参数
                mimuQ: $("#mimuQ").val(),//后台请求传的查询参数
                midiQ: $("#midiQ").val(),//后台请求传的查询参数
                migeQ: $("#migeQ").val(),//后台请求传的查询参数
                zuozheQ: $("#zuozheQ").val(),//后台请求传的查询参数
                leixingQ: $("#leixingQ").val(),//后台请求传的查询参数
            };
            return temp;
        };
    }
</script>
