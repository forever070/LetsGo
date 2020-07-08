<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script id="allmobilize" charset="utf-8" src="style/js/allmobilize.min.js"></script>
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate" media="handheld"  />
<!-- end 云适配 -->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录-拉勾网-最专业的互联网招聘平台</title>
<meta property="qc:admins" content="23635710066417756375" />
<meta content="拉勾网是3W旗下的互联网领域垂直招聘网站,互联网职业机会尽在拉勾网" name="description">
<meta content="拉勾,拉勾网,拉勾招聘,拉钩, 拉钩网 ,互联网招聘,拉勾互联网招聘, 移动互联网招聘, 垂直互联网招聘, 微信招聘, 微博招聘, 拉勾官网, 拉勾百科,跳槽, 高薪职位, 互联网圈子, IT招聘, 职场招聘, 猎头招聘,O2O招聘, LBS招聘, 社交招聘, 校园招聘, 校招,社会招聘,社招" name="keywords">

<meta name="baidu-site-verification" content="QIQ6KC1oZ6" />

<!-- <div class="web_root"  style="display:none">h</div> -->
<script type="text/javascript">
var ctx = "h";
console.log(1);
</script>
<link rel="Shortcut Icon" href="h/images/favicon.ico">
<link rel="stylesheet" type="text/css" href="style/css/style.css"/>
<script type="text/javascript" src="style/js/core.min.js"></script>
<script src="style/js/jquery.1.10.1.min.js" type="text/javascript"></script>
<script type="text/javascript" src="style/js/jquery.lib.min.js"></script>
<script type="text/javascript">
 $(function(){
	 $("#password").blur(function(){
			$.ajax({
			type : "POST",
				url : "register?op=logincheck",
				data : {
					account : $("#email").val(),
					password : $("#password").val()
				},
				dataType : "json",
				success : function(data) {
					if (!data) {
						alert("用户名或密码输入错误！！");
					} else{
						//alert("用户名或者密码正确！！");
								//window.location.href="jianli.jsp";
					}
				},
				error : function() {
					alert("服务器繁忙！！！");
				}})
			
	   });	
})
</script>

<script type="text/javascript">
var youdao_conv_id = 271546; 
</script> 
<script type="text/javascript" src="style/js/conv.js"></script>
</head>

<body id="login_bg">
	<div class="login_wrapper">
		<div class="login_header">
        	<a href="h/"><img src="style/images/logo_white.png" width="285" height="62" alt="拉勾招聘" /></a>
            <div id="cloud_s"><img src="style/images/cloud_s.png" width="81" height="52" alt="cloud" /></div>
            <div id="cloud_m"><img src="style/images/cloud_m.png" width="136" height="95"  alt="cloud" /></div>
        </div>
        
    	<input type="hidden" id="resubmitToken" value="registe" />		
		 <div class="login_box">
        	<form id="loginForm" method="post" action="register?op=login" >
				<input type="text" id="email" name="email" value="" tabindex="1" placeholder="请输入登录邮箱地址" />
			  	<input type="password" id="password" name="password" tabindex="2" placeholder="请输入密码" />
				
			    <label class="fl" for="remember">
			 <input type="checkbox" id="remember" value="" checked="checked" name="autoLogin" /> 记住密码</label>
			    <a href="reset.html" class="fr" target="_blank">忘记密码？</a>
			<input type="submit" id="submitLogin" value="登 &nbsp; &nbsp; 录" />
		<%-- <input type="button" id="submitLogin" value="登 &nbsp; &nbsp; 录" /> --%>
			</form>
			
			<div class="login_right">
				<div>还没有拉勾帐号？</div>
				<a  href="register.jsp"  class="registor_now">立即注册</a>
			    <div class="login_others">使用以下帐号直接登录: </div>
			    <a  href="h/ologin/auth/sina.html"  target="_blank" class="icon_wb" title="使用新浪微博帐号登录"></a>
			    <a  href="h/ologin/auth/qq.html"  class="icon_qq" target="_blank" title="使用腾讯QQ帐号登录"></a>
			</div>
        </div>
        <div class="login_box_btm"></div>
    </div>
    
    

<script type="text/javascript">

$(function(){
	$('.register_radio li input').click(function(e){
		$(this).parent('li').addClass('current').append('<em></em>').siblings().removeClass('current').find('em').remove();
	});
	
	$('#email').focus(function(){
		$('#beError').hide();
	});
	//验证表单
	 $("#loginForm").validate({
	        rules: {
	        	
	    	   	email: {
	    	    	required: true,
	    	    	email: true
	    	   	},
	    	   	password: {
	    	    	required: true,
	    	    	rangelength: [6,16]
	    	   	}
	    	   
	    	},
	    	messages: {
	    		
	    	 	email: {
	    	    	required: "请输入邮箱",
	    	    	email: "请输入有效的邮箱地址，如：xxxx@xxx.com"
	    	   	},
	    	   	password: {
	    	    	required: "请输入密码",
	    	    	rangelength: "请输入6-16位密码，字母区分大小写"
	    	   	},
	    	   
	    	}
	});
	
});

</script>
</body>
</html>
