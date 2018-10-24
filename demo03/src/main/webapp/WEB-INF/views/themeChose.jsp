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
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-table.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/bootstrap-table.js"></script>
    <script src="/js/bootstrap-table-zh-CN.js"></script>

</head>
<div style="width: 1000px;">
    <p id="page-content" class="animated fadeInRight">
    <p class="col-sm-4 col-md-3 col-lg-3" style="width: 100%;">
    <form  id="search_User">
        <p class="panel-body search_box">
        <p class="search_p">
            <label for="teacherName">导师姓名：</label>
            <input type="text" class="form-control" id="teacherName" name="teacherName" >
        </p>
        <p class="search_p">
            <label for="themeTitle">课题名称：</label>
            <input type="text" class="form-control" id="themeTitle" name="themeTitle" >
        </p>
        <p class="search_p" style="text-align: center;">
            <input type="button" class="btn btn-primary btn_search" value="搜索" onclick="serachUser()"/>
        </p>
        </p>
    </form>
    </p>
</div>
<div style="height:auto;">
    <table id="userListTable" ></table>
</div>
</p>
</html>
<script>
    $(function(){
        var columns=[
            {
                checkbox: true,
                align: 'center',
                valign: 'middle',
            },
            {
                title: 'ID',
                field: 'id',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '用户姓名',
                field: 'name',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '性别',
                field: 'sex',
                align: 'center',
            },
            {
                title: '用户账号',
                field: 'username',
                align: 'center',
            },
            {
                title: '手机号',
                field: 'phone',
                align: 'center',
            },
            {
                title: '邮箱',
                field: 'email',
                align: 'center',
            },
            {
                title: '权限',
                field: 'rolename',
                align: 'center',
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter:function(value,row,index){
                    var e = '<button href="#" class="btn btn-primary"  onclick="edit(\''+ row.id + '\')">编辑</button> ';
                    var d = '<button href="#" class="btn btn-danger"  onclick="del(\''+ row.id +'\')">删除</button> ';
                    return e+d;
                }
            }
        ];
        a('/login/queryTheme',columns);

    });
    function a (dataurl,columns) {
        $('#userListTable').bootstrapTable({
            url: dataurl,
            method:"post",
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
            pageSize:2,
            pageList:[5,10, 25, 50, 100],
            undefinedText:'--',
            uniqueId: "id", //每一行的唯一标识，一般为主键列
            queryParamsType:'',
            queryParams: queryParams,//传递参数（*）
            columns: columns
        });

        //得到查询的参数
        function queryParams (params) {
            var temp = {  //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                pageSize: params.pageSize,  //页面大小
                pageNumber: params.pageNumber, //页码
                teacherName: $("#teacherName").val(),//后台请求传的查询参数
                themeTitle:$("#themeTitle").val(),
            };
            return temp;
        };
    }

    //搜索
    function serachUser() {
        $("#userListTable").bootstrapTable('refresh');
    }
</script>