<%--
  Created by IntelliJ IDEA.
  User: 霍仰帅
  Date: 2018/9/27
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>毕业设计选课系统 - 首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <link href="/assets/css/dpl-min.css" rel="stylesheet" type="text/css" />
    <link href="/assets/css/bui-min.css" rel="stylesheet" type="text/css" />
    <link href="/assets/css/main-min.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="header">

    <div class="dl-title">
        <!--<img src="/chinapost/Public/assets/img/top.png">-->
    </div>

    <div class="dl-log">欢迎您，<span class="dl-log-user">${loginUser}</span><a href="/login/logout" title="退出系统" class="dl-log-quit">[退出]</a>
    </div>
</div>
<div class="content">
    <div class="dl-main-nav">
        <div class="dl-inform"><div class="dl-inform-title"><s class="dl-inform-icon dl-up"></s></div></div>
        <ul id="J_Nav"  class="nav-list ks-clear">
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-home">我的课题</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">课题选择</div></li>
        </ul>
    </div>
    <ul id="J_NavContent" class="dl-tab-conten">

    </ul>
</div>
<script type="text/javascript" src="/assets/js/jquery-1.8.1.min.js"></script>
<script type="text/javascript" src="/assets/js/bui-min.js"></script>
<script type="text/javascript" src="/assets/js/common/main-min.js"></script>
<script type="text/javascript" src="/assets/js/config-min.js"></script>
<script>
    BUI.use('common/main',function(){
        var config = [{
            id:'1',menu:[{
                text:'我的课题',items:[
                    {id:'2',text:'导师介绍',href:'/login/teacherIntroduce'},
                    {id:'3',text:'课题介绍',href:'/login/themeDescription'},
                    {id:'4',text:'课题进度',href:'/login/themeProgress'},
                    {id:'5',text:'上传文件',href:'/login/fileUpload'},
                    {id:'6',text:'添加灯谜',href:'/dengmi/showDengmi'}

                    // {id:'6',text:'课题成果',href:'/login/themeResults'}
        ]}]},{
                id:'7',homePage : '9',menu:[{
                    text:'课题选择',items:[
                        {id:'9',text:'课题选择',href:'/login/themeChose'}
                ]}]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>