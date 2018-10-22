<%--
  Created by IntelliJ IDEA.
  User: YowYouth
  Date: 2018/10/21
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script src="js/jquery-3.1.1.min.js"></script>
    <script src="js/jquery-ui.min.js"></script>
    <link rel="stylesheet" type="text/css" href="js/jquery-ui.min.css">
    <link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="main">
    <div class="nav">
        <div class="font t_c">C</div>
        <div class="font t_r">R</div>
        <div class="font t_e">E</div>
        <div class="font t_a">A</div>
        <div class="font t_t">T</div>
        <div class="font t_d">D</div>
        <div class="font t_m">M</div>
        <div class="nav_left">
            <a href="index.html">Create Dream</a>
        </div>
        <div class="nav_right">
            <ul>
                <li style="color:white">首页</li>
                <li><a href="#">新闻</a></li>
                <li><a href="#">职业机会</a></li>
                <li><a href="#">资源</a></li>
                <li><a href="#">联系我们</a></li>
                <li style="width:150px"><a href="#">English</a> | <a href="#">日语</a></li>
            </ul>
        </div>
    </div>
    <div class="middle">
        <div class="m_main m1">
            <form class="form1">
                <div class="title">欢迎登录CREATE DREAM</div>
                <input type="text" class="user_message">
                <label class="label l4">用户名不能为空</label>
                <div class="icon user_icon"></div>
                <input type="password" class="user_message">
                <label class="label l5">密码不能为空</label>
                <div class="icon pass_icon"></div>
                <div class="m_font f1">忘记密码？</div>
                <div class="m_font f2">没有账号？点击注册</div>
                <input type="submit" disabled="disabled" value="登&nbsp&nbsp录" class="order submit">
                <input type="reset" class="order zhuce" value="重&nbsp置">
        </div>
        <div class="m_main m2">
            <div class="title">欢迎注册CREATE DREAM</div>
            <input type="text" class="user_message user1">
            <label class="label l1">5-16位数字或字母</label>
            <div class="icon user_icon"></div>
            <input type="password" class="user_message user2">
            <label class="label l2">5-16位数字或字母</label>
            <div class="icon pass_icon"></div>
            <input type="password" class="user_message user3">
            <label class="label l3">与上次输入的密码一致</label>
            <div class="icon pass_icon2"></div>
            <input type="submit" disabled="disabled" value="注&nbsp&nbsp册" class="order submit">
            <input type="reset" class="order zhuce" value="重&nbsp置">
            </form>
        </div>
    </div>
    <div class="footer">
        CREATE DREAM@2016湘</br>
        © 2016 Pactera. All rights reserved. Liaoning ICP 11007858-3. Jing Gongwang Anbei 11010802016198
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    $(function(){
        $(".middle").show("explode",1000);
        $(".f2").click(function(){
            $(".m1").hide("explode",1000);
            $(".m2").show();
        })
        $(".m2> .user_message").focus(function(){
            var a = $(this).index();
            if(a > 2){
                a = Math.floor(a/2);
            }
            $(".m2> .label").eq(a-1).hide("slide",1000);
        })
        $(".m2> .user_message").blur(function(){
            var reg =/^[a-zA-Z0-9][a-zA-Z0-9]{4,16}$/;
            var a = $(this).index();
            if(a > 2){
                a = Math.floor(a/2);
            }
            var b = 0;
            var c = 0;
            if(!reg.test($(this).val())) {
                $(".m2> .label").eq(a-1).html("格式错误，请重新输入").show("slide",1000);
            }else{
                b=1;
            }
            if(a == 3){
                if($(".user3").val() != $(".user2").val()) {
                    $(".l3").html("密码不一致").show("slide",1000);
                }else{
                    console.log($(".user3").val());
                    console.log($(".user2").val());
                    $(".l3").hide("slide",1000);
                    c=1;
                }
            }
            console.log((b + c));
            if((b+c) == 2){
                $(".m2 .submit").removeAttr("disabled","disabled");
            }
        })
        $(".m1 .user_message").blur(function(){
            if($(this).val() == ""){
                var a = $(this).index();
                if(a > 2){
                    a=a/2;
                }
                $(".m1 .submit").attr("disabled","disabled");
                $(".label").eq(a-1).show("bounce",1000)
            }else{
                $(".m1 .submit").removeAttr("disabled","disabled");
                $(".label").eq(a-1).hide("bounce",1000)
            }
        })
        $(".m1 .user_message").focus(function(){
            var a = $(this).index();
            if(a > 2){
                a=a/2;
            }
            $(".label").eq(a-1).hide("bounce",1000)
        })
    })
</script>
