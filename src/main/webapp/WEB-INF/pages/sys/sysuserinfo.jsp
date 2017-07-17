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
  	<div class="row">
  		<div class="col-md-12">
  			<div class="portlet">
  				<div class="portlet-title">
  					<div class="caption"><i class="icon-reorder"></i>新增用户</div>
  				</div>
  				<div class="portlet-body form">
  					<form action="#" class="form-horizontal">
  						<div class="form-body">
  							<div class="form-group">
  								<label class="col-md-3 control-label" id="lbloginid">用户账号</label>
  								<div class="col-md-4">
  									<c:if test="${user.id !=null && user.id!='' }">
		  								<p class="form-control-static">${user.loginid }</p>
									</c:if>
									<c:if test="${user.id ==null || user.id=='' }">
										<input type="text" class="form-control required" id="loginid" name="loginid" placeholder="请输入账号">
									</c:if>
	  							</div>
	  						</div>
	  						<div class="form-group">
	  							<label  class="col-md-3 control-label" id="lbusername">用户名</label>
	  							<div class="col-md-4">
		  							<input type="text" class="form-control required" id="username" name="username" value="${user.username }" placeholder="请输入用户名">
	  							</div>
	  						</div>
	  						<div class="form-group">
	  							<label  class="col-md-3 control-label">联系电话</label>
	  							<div class="col-md-4">
		  							<input type="text" class="form-control" name="telno" id="telno" maxlength="16" value="${user.telno }" />
	  							</div>
	  						</div>
	  						<div class="form-group">
	  							<label  class="col-md-3 control-label">邮箱</label>
	  							<div class="col-md-4">
		  							<div class="input-group">
		  								<span class="input-group-addon"><i class="icon-envelope"></i></span>
		  								<input type="text" class="form-control" name="email" id="email" value="${user.email }" />
		  							</div>
	  							</div>
                           	</div>
                           	<div class="form-group">
                           		<label  class="col-md-3 control-label">用户角色</label>
                           		<div class="col-md-2">
                           			<select class="form-control" name="roleid" id="roleid">
										<c:forEach items="${roles }" var="r">
											<option <c:if test="${user.roleid == r.id }">selected="selected"</c:if> value="${r.id }">${r.rolename }</option>
										</c:forEach>
									</select>
                           		</div>
                           	</div>
                           	<div class="form-group">
                           		<label  class="col-md-3 control-label">性别</label>
                           		<div class="col-md-2">
                           			<select class="form-control" name="sex" id="sex">
										<option value="0">男</option>
										<option value="1">女</option>
									</select>
                           		</div>
                           	</div>
                        </div>
                        <div class="form-actions fluid">
                        	<div class="col-md-offset-3 col-md-9">
                        		<button type="button" class="btn btn-info" id="savebtn">保存</button>
                        		<button type="button" class="btn btn-default" onclick="javascript:history.go(-1)">返回</button>                              
                        	</div>
                        </div>
  					</form>
  				</div>
  			</div>
  		</div>
  	</div>
	<script type="text/javascript">
		var userid = '${user.id}';
		$(function(){
			var sex = '${user.sex}';
			if (sex != undefined && sex !='')
				$("#sex option[value='"+sex+"']").attr("selected","selected");
			
			$("#savebtn").click(function(e){
				var url = "<%=basePath%>sys/saveUser.do";
				var callback = "<%=basePath%>sys/toSysUsers.do";
				dosave(userid, url, callback);
			});
		});
	</script>
  </body>
  
</html>