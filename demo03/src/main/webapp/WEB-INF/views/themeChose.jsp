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
    <meta charset="utf-8" />
    <title>GridView</title>

    <link href="jqgrid/css/ui.jqgrid-bootstrap.min.css" rel="stylesheet" />
    <link href="jqgrid/css/bootstrap.min.css" rel="stylesheet"/>
    <script type="text/javascript" charset="utf-8"src="/js/jquery.min.js"></script>
    <script type="text/javascript" charset="utf-8"src="/js/jquery.jqGrid.min.js"></script>
    <script type="text/javascript" charset="utf-8"src="/js/grid.locale-cn.min.js"></script>
    <script type="text/javascript" charset="utf-8"src="/js/layer/layer.min.js"></script>
    <script type="text/javascript" charset="utf-8"src="/js/layer/extend/layer.ext.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="/js/form.min.js"></script>


    <script>
        $(function() {
            loadGrid();
            //da();
            var str = { "userName": "赵建鹏", "sex": "man" };
            //alert(str.userName);
        });
        //装载表格
        function loadGrid() {
            $("#grid").jqGrid(
                {
                    height : 400,
                    rownumbers : true,
                    colModel : [
                        {
                            label : '姓名',
                            name:  'name',
                            index: 'name',
                            width : 120
                        },
                        {
                            label : '年龄',
                            name : 'age',
                            index : 'age',
                            sortable : false,
                            width : 120
                        },
                        {
                            label : ' ',
                            name : 'id',
                            width : 120,
                            align : 'center',
                            sortable : false,
                            formatter : function(value, options, row) {
                                var btn = "";
                                btn += '&nbsp;<a href="javascript:onDtl('
                                    + value
                                    + ')"class="mesq">查看信息</a>&nbsp;'
                                btn += '&nbsp;<a href="javascript:onDel('
                                    + value
                                    + ')"class="mesd">删除信息</a>&nbsp;'
                                return btn;
                            }
                        } ],
                    rowNum : 5,
                    rowList : [1, 10, 20, 50, 100 ],
                    pager : '#pager',
                    sortname : 'id',
                    sortorder : "desc"
                });

            var rows = [
                {"name":"name1","age":"21","id":"1"},
                {"name":"name2","age":"22","id":"2"},
                {"name":"name3","age":"23","id":"3"},
                {"name":"name4","age":"24","id":"4"},
                {"name":"name5","age":"25","id":"5"},
                {"name":"name6","age":"26","id":"6"},
                {"name":"name7","age":"27","id":"7"},
                {"name":"name8","age":"28","id":"8"},
                {"name":"name9","age":"29","id":"9"},
                {"name":"name10","age":"30","id":"10"},
                {"name":"name11","age":"31","id":"11"},
                {"name":"name12","age":"32","id":"12"},
                {"name":"name13","age":"33","id":"13"},
                {"name":"name14","age":"34","id":"14"},
                {"name":"name15","age":"35","id":"15"},
                {"name":"name16","age":"36","id":"16"},
                {"name":"name17","age":"37","id":"17"},
                {"name":"name18","age":"38","id":"18"},
                {"name":"name19","age":"39","id":"19"},
                {"name":"name20","age":"40","id":"20"},
            ];
            for(var i = 0; i < rows.length; i++) {
                $("#grid").jqGrid('addRowData', i + 1, rows[i]);
            }
        }
        //查看信息
        function onDtl(id){
            layer.alert("姓名：name"+id+"</br>"+"年龄:"+(20+id)+"岁");
        }
        //删除
        function onDel(id) {
            layer.confirm('您确定要删除吗？',
                {btn : [ '确定', '取消' ]},
                function(){layer.alert("此处为删除信息的方法");}
            );
        }
        //查询
        function onQ() {
            layer.alert("此处为携带"+$("#userName").val()+" "+$("#honestName").val()+"参数执行条件查询");
        }
        //显示全部
        function showAll() {
            $("#userName").val("");
            $("#honestName").val("");
            layer.alert("显示全部数据！");
        }
        //窗口变化时自适应宽度
        window.onresize = function() {
            $("#grid").setGridWidth(document.body.clientWidth - 12);
        }
    </script>
</head>

<body>
<style>
    .in{height:30px;border-radius:4px;}
    .getS{background:#69Ea7c;color:#fff;padding:5px;padding-left:20px;padding-right:20px;border-radius:4px;}
    .getS:HOVER{background:#49D44d;cursor:pointer;}
    .mesd{color:#C12E2A}
    .mesq{color:#4CAE4C}
</style>
<div style="padding-Top:5px;background:#ddd;height:40px">
    <form action="/login/queryTheme">
        <label style="margin-left:45px">导师姓名：</label> <input class="in" id="teacherName" name="teacherName" placeholder="  查询信息"/>
        <label>课题名称：</label> <input class="in" id="themeTitle" name="themeTitle" placeholder="  查询信息"/>
        <button class="getS" type="submit"> 查 询 </button>&nbsp;&nbsp;&nbsp;&nbsp;
        <button class="getS" type="reset"> 重置</button>
    </form>


</div>
<div class="row">
    <div class="col-sm-12" style="background:#eee">
        <table id="grid" style="background:#eff"></table>
        <div id="pager" style="height:35px;"></div>
    </div>
</div>
</body>
</html>
