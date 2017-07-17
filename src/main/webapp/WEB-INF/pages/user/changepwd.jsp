<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@ include file="/include/maincss.jsp"%>
  </head>
  
  <body>
  	<%@ include file="/include/jslib.jsp" %>
  	<div class="form-cd-div">
		<form class="form-horizontal" action="<%=basePath%>sys/addUser.do" name="userform" id="userform" method="post">
			<div class="form-group">
				<label for="oldpwd" class="col-sm-2 control-label" id="lboldpwd">原密码：</label>
				<div class="col-sm-2">
					<input type="password" class="form-control required" id="oldpwd" name="oldpwd" maxlength="32" placeholder="请输入原密码">
				</div>
			</div>
			<div class="form-group">
				<label for="pwd" class="col-sm-2 control-label" id="lbpwd">新密码：</label>
				<div class="col-sm-2">
					<input type="password" class="form-control required" name="pwd" id="pwd" maxlength="32" placeholder="请输入新密码" />
				</div>
			</div>
			<div class="form-group">
				<label for="repwd" class="col-sm-2 control-label" id="lbrepwd">确认新密码：</label>
				<div class="col-sm-2">
					<input type="password" class="form-control required" name="repwd" id="repwd" maxlength="32" placeholder="请确认新密码" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div>
					<input type="button" class="btn btn-primary" id="savebtn" value="保存" />
				</div>
			</div>
		</form>
	</div>
	<script>
		$(function(){
			$("#savebtn").click(function(){
				var form = $("form:first");
				if ($.checkFormSubmit(form)) {
					var pwd = $("#pwd").val();
					var repwd = $("#repwd").val();
					if (pwd !=repwd){
						showDialog("新密码与确认新密码不一致，请重新输入！");
						return;
					}
					var data = {
						"oldpwd":hex_md5($("#oldpwd").val()),
						"pwd":hex_md5($("#pwd").val())
					};
					var url = "<%=basePath%>sys/changePwd.do";
					handleAjaxSimple(url, JSON.stringify(data), 1, 0, null);
				}
			});
		});
	</script>
  </body>
</html>
