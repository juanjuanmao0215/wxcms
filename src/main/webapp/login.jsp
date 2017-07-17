<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<head>
	<meta charset="utf-8" />
	<title></title>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta content="width=device-width, initial-scale=1.0" name="viewport" />
	<meta content="" name="description" />
	<meta content="" name="author" />
	<meta name="MobileOptimized" content="320">
	<%@ include file="/include/csslib.jsp" %>
	<link href="<%=basePath %>assets/css/pages/login.css" rel="stylesheet" />
</head>
<!-- BEGIN BODY -->
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<img src="<%=basePath %>assets/img/logo.png" alt="" /> 
	</div>
	<!-- END LOGO -->
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="login-form" action="" method="post">
			<div class="has-error" id="error-tip"></div>
			<div class="form-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">用户名</label>
				<div class="input-icon">
					<i class="icon-user"></i>
					<input class="form-control placeholder-no-fix" type="text" autocomplete="off" placeholder="请输入用户名" name="username" id="username" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label visible-ie8 visible-ie9">密码</label>
				<div class="input-icon">
					<i class="icon-lock"></i>
					<input class="form-control placeholder-no-fix" type="password" autocomplete="off" placeholder="请输入密码" name="password" id="password" />
				</div>
			</div>
			<div class="form-actions">
				<button type="submit" class="btn btn-info pull-right">
				登录
				</button>            
			</div>
		</form>
		<!-- END LOGIN FORM -->        
	</div>
	<%@ include file="/include/jslib.jsp" %>
	<script src="<%=basePath %>assets/scripts/login.js"></script>
	<script src="<%=basePath %>assets/scripts/md5.js"></script>
	<script>
		$(function(){
			Login.init();
		});
	</script>
	<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>