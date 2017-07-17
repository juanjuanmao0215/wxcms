<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ include file="/include/maincss.jsp"%>
<title></title>
</head>

<body>
	<%@ include file="/include/jslib.jsp" %>
	<div class="form-cd-div">
		<form class="form-horizontal" action="<%=basePath%>user/addUser.do" name="userform" id="userform" method="post">
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label" id="lbusername">用户名：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control required" id="username" name="username" value="${user.username }" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-2 control-label" id="lbpassword">密码：</label>
				<div class="col-sm-2">
					<input type="password" class="form-control required" name="password" id="username" value="${user.password }" placeholder="请输入密码" />
				</div>
			</div>
			<div class="form-group">
				<label for="nickname" class="col-sm-2 control-label">昵称：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="nickname" id="nickname" value="${user.nickname }" />
				</div>
			</div>
			<div class="form-group">
				<label for="address" class="col-sm-2 control-label">地址：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="address" id="address" value="${user.address }" />
				</div>
			</div>
			<div class="form-group">
				<label for="postcode" class="col-sm-2 control-label">邮编：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control" name="postcode" id="postcode" value="${user.postcode }" />
				</div>
			</div>
			<div class="form-group">
				<label for="province" class="col-sm-2 control-label">省：</label>
				<div class="col-sm-1">
					<select class="form-control" name="province" id="province">
						<option>北京市</option>
						<option>浙江省</option>
					</select>
				</div>
				<label for="city" class="col-sm-2 control-label">市：</label>
				<div class="col-sm-1">
					<select class="form-control" name="city" id="city">
						<option>北京市</option>
						<option>台州市</option>
					</select>
				</div>
				<label for="country" class="col-sm-2 control-label">区/县：</label>
				<div class="col-sm-1">
					<select class="form-control" name="country" id="country">
						<option>海淀区</option>
						<option>椒江区</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-1">
					<select class="form-control" name="sex" id="sex">
						<option value="0">男</option>
					<option value="1">女</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-1 col-sm-10">
					<input type="button" class="btn btn-primary" id="savebtn" value="保存" />
					<input type="button" class="btn btn-primary back" value="返回" class="back"/>
				</div>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		var userid = '${user.id}';
	
		$(function(){
			var province = '${user.province}';
			var city = '${user.city}';
			var country = '${user.country}';
			var sex = '${user.sex}';
			if (province != undefined && province !='')
				$("#province option[value='"+province+"']").attr("selected","selected");
			if (city != undefined && city !='')
				$("#city option[value='"+province+"']").attr("selected","selected");
			if (country != undefined && country !='')
				$("#country option[value='"+province+"']").attr("selected","selected");
			if (sex != undefined && sex !='')
				$("#sex option[value='"+province+"']").attr("selected","selected");
		});
		
		$("#savebtn").click(function(e){
			var url = "<%=basePath%>user/addUser.do";
			if (userid !=undefined && userid !=''){
				url = "<%=basePath%>user/updateUser.do";
			}
			var callback = "<%=basePath%>user/findUsers.do";
			dosave(userid, url, callback);
		});
		
	</script>

</body>
</html>