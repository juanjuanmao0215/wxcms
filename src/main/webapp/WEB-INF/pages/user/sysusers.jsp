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
  	<%@ include file="/include/jslib.jsp"%>
	<div class="form-cd-div">
		<form class="form-inline" action="<%=basePath%>sys/findUsers.do" name="userform" id="userform" method="post">
			<div class="form-group">
				<label for="username">用户名：</label>
				<input type="text" class="form-control" id="username" name="username" value="${user.username }" />
			</div>
			<div class="form-group">
				<label for="roleid">用户角色：</label>
				<select class="form-control form-select" name="roleid" id="roleid">
					<option value="">--请选择--</option>
					<c:forEach items="${roles }" var="r">
						<option <c:if test="${user.roleid == r.id }">selected="selected"</c:if> value="${r.id }">${r.rolename }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label for="startDate">查询日期：</label>
				<input type="text" id="startDate" name="startDate" class="form-input-date" readonly
					onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}',dateFmt:'yyyy-MM-dd'})" value="${user.startDate }" />
				<input type="text" id="endDate" name="endDate" class="form-input-date" readonly 
					onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd'})" value="${user.endDate }" />
			</div>
			<div class="form-group">
				<label></label>
				<input class="btn btn-primary searchbtn" type="button" value="查询" />
				<input class="btn btn-primary" id="addUser" onclick="topage('<%=basePath%>sys/toUserinfo.do');" type="button" value="新增用户" />
				<input class="btn btn-danger" type="button" onclick="batchdelete('<%=basePath%>sys/batchdeleteuser.do');" value="批量删除" />
			</div>
		</form>
		<hr />
	</div>

	<div class="table-responsive">
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th class="table-tr-td6 td-center">
						<label><input type="checkbox" class="form-checkall" id="checkall" />全选</label>
					</th>
					<th class="table-tr-td6">序号</th>
					<th class="table-tr-td8">用户账号</th>
					<th class="table-tr-td10">用户名</th>
					<th class="table-tr-td10">联系电话</th>
					<th class="table-tr-td20">邮箱</th>
					<th class="table-tr-td8 sorting" id="roleid">角色</th>
					<th class="table-tr-td5 td-center">性别</th>
					<th class="table-tr-td15 sorting_desc" id="intime">创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageResult.list}" var="u" varStatus="s">
					<tr>
						<td class="td-center">
							<input type="checkbox" name="usercbx" class="form-ckb" value="${u.id }" />
						</td>
						<td>${(pageResult.pageNum-1)*pageResult.pageSize+s.count }</td>
						<td>${u.loginid }</td>
						<td>${u.username }</td>
						<td>${u.telno }</td>
						<td>${u.email }</td>
						<td>${u.rolename }</td>
						<td class="td-center">
							<c:if test="${u.sex ==0 }">男</c:if>
							<c:if test="${u.sex ==1 }">女</c:if>
						</td>
						<td>
							<fmt:formatDate value="${u.intime }" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td>
							<a id="updateuser" onclick="topage('<%=basePath%>sys/toUserinfo.do','${u.id}');">修改</a>
							<a class="delete" id="deluser" onclick="dodelete('<%=basePath%>sys/deleteUser.do','${u.id}');">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<pageset:PageBar pageUrl="sys/findUsers.do" pageAttrKey="pageResult"></pageset:PageBar>
	</div>
	<%@ include file="/include/sort.jsp"%>
  </body>
</html>