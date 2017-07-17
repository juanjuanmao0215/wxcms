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
  			<!-- BEGIN EXAMPLE TABLE PORTLET-->
  			<div class="portlet box light-grey">
  				<div class="portlet-title">
  					<div class="caption"><i class="fa fa-globe"></i>系统用户列表</div>
				</div>
				<div class="portlet-body">
					<div class="dataTables_wrapper form-inline">
						<form class="form-inline" action="<%=basePath%>sys/findSysUsers.do" name="userform" id="userform" method="post">
							<div class="form-group">
								<label for="username" class="control-label">用户名</label>
								<input type="text" class="form-control" id="username" name="username" />
							</div>
							<div class="form-group">
								<label for="roleid" class="control-label">用户角色</label>
								<select class="form-control" name="roleid" id="roleid">
									<option value="">--请选择--</option>
									<c:forEach items="${roles }" var="r">
										<option value="${r.id }">${r.rolename }</option>
									</c:forEach>
								</select>
							</div>
							<div class="form-group">
								<label class="control-label">查询日期</label>
								<div class="input-group input-large date-picker input-daterange" data-date-format="yyyy-mm-dd">
									<input type="text" class="form-control" name="startdate">
									<span class="input-group-addon">至</span>
									<input type="text" class="form-control" name="enddate">
								</div>
							</div>
							<div class="form-group">
								<label></label>
								<input class="btn btn-primary searchbtn" type="button" value="查询" />
								<input class="btn btn-primary" id="addUser" onclick="topage('<%=basePath%>sys/toUserinfo.do');" type="button" value="新增用户" />
								<input class="btn btn-danger" type="button" onclick="batchdelete('<%=basePath%>sys/batchdeleteuser.do');" value="批量删除" />
							</div>
						</form>
						<div class="flip-scroll">
							<table class="table table-bordered table-striped table-condensed flip-content table-hover">
								<thead class="flip-content">
									<tr>
										<th class="table-tr-td6 td-center">
											<label><input type="checkbox" class="form-checkall" id="checkall" />全选</label>
										</th>
										<th class="table-tr-td6">序号</th>
										<th class="table-tr-td8">用户账号</th>
										<th class="table-tr-td10">用户名</th>
										<th class="table-tr-td10">联系电话</th>
										<th class="table-tr-td20">邮箱</th>
										<th class="table-tr-td8">角色</th>
										<th class="table-tr-td5 td-center">性别</th>
										<th class="table-tr-td15 sorting_desc" id="createdate">创建时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="tabledata">
									
								</tbody>
							</table>
						</div>
						<div class="row" id="datatablepaginate">
							
						</div>
					</div>
				</div>
			</div>
			<!-- END EXAMPLE TABLE PORTLET-->
		</div>
	</div>
	<script src="<%=basePath %>assets/scripts/sort.js"></script>
	
	<script type="text/javascript">
		$(function(){
			//初始化表单插件
			FormComponents.init();
		});
		
		/**
		 * 填充表单数据
		 * @param data
		 * @param html
		 */
		function filltable(data,html){
			if (data.pageResult !=undefined){
				for (i=0;i<data.pageResult.list.length;i++){
					var user = data.pageResult.list[i];
					html.push('<tr>');
					html.push('<td class="td-center"><input type="checkbox" name="usercbx" class="form-ckb" value="'+user.id+'" /></td>');
					html.push('<td>'+((data.pageResult.pageNum-1)*data.pageResult.pageSize+(i+1))+'</td>');
					html.push('<td>'+user.loginid+'</td>');
		            html.push('<td>'+formatValue(user.username)+'</td>');
		            html.push('<td>'+formatValue(user.telno)+'</td>');
		            html.push('<td>'+formatValue(user.email)+'</td>');
		            html.push('<td>'+user.rolename+'</td>');
		            html.push('<td class="td-center">'+(user.sex == 0 ? "男" : "女")+'</td>');
		            html.push('<td>'+formatDate(user.createdate, "yyyy-MM-dd HH:mm:ss")+'</td>');
		            html.push('<td><a id="updateuser" onclick="topage(\'<%=basePath%>sys/toUserinfo.do\',\''+user.id+'\');">修改</a>&nbsp;&nbsp;<a id="deluser" onclick="dodelete(\'<%=basePath%>sys/deleteUser.do\',\''+user.id+'\');">删除</a>&nbsp;&nbsp;<span>水电费</span></td>');
		            html.push('</tr>');
				}
		        var tabledata = $('#tabledata');
		        tabledata.empty();
		        tabledata.html(html.join(''));
			}
		}
	</script>
  </body>
</html>