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
</head>
  
  <body>
  	<%@ include file="../nav.jsp"%>
	<div class="form-cd-div">
		<form class="form-horizontal" action="<%=basePath%>sys/addUser.do" name="userform" id="userform" method="post">
			<div class="form-group">
				<label for="loginid" class="col-sm-2 control-label" id="lbloginid">用户账号：</label>
				<div class="col-sm-2">
					<c:if test="${user.id !=null && user.id!='' }">
						<label class="form-label">${user.loginid }</label>
					</c:if>
					<c:if test="${user.id ==null || user.id=='' }">
						<input type="text" class="form-control required" id="loginid" name="loginid" placeholder="请输入账号">
					</c:if>
				</div>
			</div>
			<div class="form-group">
				<label for="username" class="col-sm-2 control-label" id="lbusername">用户名：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control required" id="username" name="username" value="${user.username }" placeholder="请输入用户名">
				</div>
			</div>
			<div class="form-group">
				<label for="telno" class="col-sm-2 control-label" id="lbtelno">联系电话：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control mobile" name="telno" id="telno" maxlength="16" value="${user.telno }" />
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-2 control-label" id="lbemail">邮箱：</label>
				<div class="col-sm-2">
					<input type="text" class="form-control email" name="email" id="email" value="${user.email }" />
				</div>
			</div>
			<div class="form-group">
				<label for="roleid" class="col-sm-2 control-label">用户角色：</label>
				<div class="col-sm-1">
					<select class="form-select" name="roleid" id="roleid">
						<c:forEach items="${roles }" var="r">
							<option <c:if test="${user.roleid == r.id }">selected="selected"</c:if> value="${r.id }">${r.rolename }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="sex" class="col-sm-2 control-label">性别：</label>
				<div class="col-sm-1">
					<select class="form-select" name="sex" id="sex">
						<option value="0">男</option>
						<option value="1">女</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2"></label>
				<div>
					<input type="button" class="btn btn-primary" id="savebtn" value="保存" />
					<input type="button" class="btn btn-primary back" value="返回" onclick="javascript:history.back();" class="back"/>
				</div>
			</div>
		</form>
	</div>
	
	<script type="text/javascript">
		var userid = '${user.id}';
		$(function(){
			var sex = '${user.sex}';
			if (sex != undefined && sex !='')
				$("#sex option[value='"+sex+"']").attr("selected","selected");
		});
		$("#savebtn").click(function(e){
			var url = "<%=basePath%>sys/saveUser.do";
			var callback = "<%=basePath%>sys/findUsers.do";
			dosave(userid, url, callback);
		});
	</script>

</body>
</html>