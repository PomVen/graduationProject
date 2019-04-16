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
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-product-certified">文件操作</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-order">课题选择</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-product">灯谜</div></li>
            <li class="nav-item dl-selected"><div class="nav-item-inner nav-product">汉字</div></li>
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
            id:'1',homePage : "11",menu:[{
                text:'我的课题',items:[
                    {id:'11',text:'导师介绍',href:'/teacher/teacherIntroduce'},
                    {id:'12',text:'课题介绍',href:'/teacher/themeDescription'},
                    {id:'13',text:'课题进度',href:'/teacher/themeProgress'}
            ]}]
        },{
            id:'2',homePage : '21',menu:[{
                text:'文件操作',items:[
                    {id:'21',text:'读取文件',href:'/file/fileHomePage'}
                ]}]
        },{
            id:'3',homePage : '31',menu:[{
                text:'课题选择',items:[
                    {id:'31',text:'课题选择',href:'/login/themeChose'}
            ]}]
        },{
            id:'4',homePage : '41',menu:[{
                text:'灯谜',items:[
                    {id:'41',text:'灯谜查询',href:'/dengmi/showDengmi'},
                    {id:'42',text:'新增灯谜',href:'/dengmi/addDengmiPage'},
                    {id:'43',text:'谜材查询',href:'/dengmi/queryMicai'},
                    {id:'44',text:'论谜赏谜',href:'/dengmi/sayDengmi'},
                    {id:'45',text:'灯谜教材',href:'/dengmi/teachDengmi'}
                ]}]
        },{
            id:'5',homePage : '51',menu:[{
                text:'汉字',items:[
                    {id:'51',text:'汉字基本查询',href:'/hanzi/hanziQueryPage'},
                    {id:'52',text:'汉字笔画查询',href:'/hanzi/bihuaQuery'},
                    {id:'53',text:'汉字义项查询',href:'/hanzi/yixiangQuery'},
                    {id:'54',text:'汉字词组查询',href:'/hanzi/cizuQuery'}
                ]}]
        },{
            id:'6',homePage : '61',menu:[{
                text:'汉字',items:[
                    {id:'61',text:'新华字典',href:'/zidian/queryPage'},
                    {id:'62',text:'汉字笔画查询',href:'/zidian/queryPage'},
                    {id:'63',text:'汉字义项查询',href:'/zidian/queryPage'},
                    {id:'64',text:'汉字词组查询',href:'/zidian/queryPage'}
                ]}]
        }];
        new PageUtil.MainPage({
            modulesConfig : config
        });
    });
</script>
</body>
</html>