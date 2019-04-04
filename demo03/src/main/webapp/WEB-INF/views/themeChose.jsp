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
<div style="width: 90%; height: 30%">
    <!-- role: 0-管理员；1-导师；2-学生 -->
    <c:if test="${role == 1}">
        <!-- 按钮触发模态框 -->
        <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
            新增课题
        </button>
        <!-- 模态框（Modal） -->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" data-backdrop="static" data-keyboard="false">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header titleTop">
                        <h4 class="modal-title" id="myModalLabel">
                            新增课题
                        </h4>
                    </div>
                    <form id="addTheme" action="/login/addTheme">
                        <div style="border-radius: 6px; width: 90%; text-align: center">
                            <div class="form-group">
                                <label for="addThemeTitle" class="col-sm-2 control-label">课题名字</label>
                                <div class="col-sm-10">
                                    <input type="text" class="form-control input-group-lg" id="addThemeTitle" name="addThemeTitle" placeholder="请输入名字">
                                </div>
                            </div>
                            <div style="height: 2%"></div>
                            <div class="form-group">
                                <label for="addThemeDesc" class="col-sm-2 control-label">课题描述</label>
                                <div class="col-sm-10">
                                    <textarea type="text" class="form-control input-group-lg" id="addThemeDesc" name="addThemeDesc" placeholder="请输入名字"></textarea>
                                </div>
                            </div>
                        </div>
                        <hr/>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button class="btn btn-primary" type="submit" id="addThemeSubmit">查询</button>
                            <button class="btn btn-primary" id="addReset" type="reset">重置</button>
                        </div>
                    </form>
                </div><!-- /.modal-content -->
            </div><!-- /.modal -->
        </div>
    </c:if>
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
<div style="height:60%;">
    <table id="userListTable" ></table>
</div>
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
                title: '课题序号',
                field: 'themeSeq',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '课题名称',
                field: 'themeTitle',
                align: 'center',
                valign: 'middle',
            },
            {
                title: '课题描述',
                field: 'themeIntroduction',
                align: 'center',
            },
            {
                title: '导师',
                field: 'teacherName',
                align: 'center',
            },
            {
                title: '操作',
                field: 'id',
                align: 'center',
                formatter:function(value,row,index){
                    var e = '<button href="#" class="btn btn-primary"  onclick="chose(\''+ row.themeTitle + '\')">编辑</button> ';
                    return e;
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
            pageSize:10,
            pageList:[5,10, 25, 50, 100],
            undefinedText:'--',
            uniqueId: "themeSeq", //每一行的唯一标识，一般为主键列
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

    function chose(rowTitle) {
        $.ajax({
            type: "GET",
            url: "/login/choseTheme",
            data: {themeTitle:rowTitle},
            dataType: "json",
            success: function(data){
                if(data){
                    alert("课题选择成功");
                    $("#userListTable").bootstrapTable('refresh');
                }
            }
        });
    }
</script>