<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<%@ include file="/include/maincss.jsp"%>
<title></title>
<style type="text/css">
</style>
</head>

<body>
	<%@ include file="/include/jslib.jsp"%>
	<div class="form-cd-div">
		<form class="form-inline" action="<%=basePath%>user/findUsers.do"
			name="userform" id="userform" method="post">
			<div class="form-group">
				<label for="username">用户名：</label> <input type="text"
					class="form-control" id="username" name="username"
					value="${user.username }" placeholder="请输入用户名">
			</div>
			<div class="form-group">
				<label for="address">地址：</label> <input type="text"
					class="form-control" id="address" name="address"
					value="${user.address }" placeholder="请输入地址">
			</div>
			<br />
			<div class="form-group">
				<label for="loginname">登录账号：</label> <input type="text"
					class="form-control" id="loginname" placeholder="请输入登录账号">
			</div>
			<div class="form-group">
				<label for="nickname">昵称：</label> <input type="text"
					class="form-control" id="nickname" placeholder="请输入昵称">
			</div>
			<br />
			<div class="form-group">
				<label for="startDate">日期：</label> <input type="text" id="startDate"
					name="startDate" class="form-control input-date" readonly
					onclick="WdatePicker({maxDate:'#F{$dp.$D(\'endDate\')||\'%y-%M-%d\'}',dateFmt:'yyyy-MM-dd'})" />
				<input type="text" id="endDate" name="endDate"
					class="form-control input-date" readonly
					onClick="WdatePicker({minDate:'#F{$dp.$D(\'startDate\')}',maxDate:'%y-%M-%d',dateFmt:'yyyy-MM-dd'})" />
			</div>
			<br />
			<div class="form-group">
				<!-- 如果查询条件不是很多，可以和按钮处于同一行，那么label不用加 -->
				<label></label>
				<input class="btn btn-primary searchbtn" type="button" value="查询" />
				<input class="btn btn-primary" id="addUser" onclick="topage('<%=basePath%>user/toSaveUser.do');" type="button" value="新增用户" />
				<input class="btn btn-danger" type="button" onclick="batchdelete('<%=basePath%>user/batchdeleteuser.do');" value="批量删除" />
			</div>
		</form>
		<hr />
	</div>

	<div class="table-responsive">
		<table
			class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th class="table-tr-td6 td-center"><label><input
							type="checkbox" class="form-checkall" id="checkall" />全选</label>
					</th>
					<th class="table-tr-td6">序号</th>
					<th class="table-tr-td8 sorting" id="username">用户名</th>
					<th class="table-tr-td8">昵称</th>
					<th class="table-tr-td30">地址</th>
					<th class="table-tr-td6 td-center sorting" id="postcode">邮编</th>
					<th class="table-tr-td5 td-center sorting" id="sex">性别</th>
					<th class="table-tr-td15 sorting_desc" id="intime">时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pageResult.list}" var="u" varStatus="s">
					<tr>
						<td class="td-center"><input type="checkbox" name="usercbx"
							class="form-ckb" value="${u.id }" /></td>
						<td>${(pageResult.pageNum-1)*pageResult.pageSize+s.count }</td>
						<td>${u.username }</td>
						<td>${u.nickname }</td>
						<td>${u.address }</td>
						<td class="td-center">${u.postcode }</td>
						<td class="td-center"><c:if test="${u.sex ==0 }">男</c:if> <c:if
								test="${u.sex ==1 }">女</c:if></td>
						<td><fmt:formatDate value="${u.intime }" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a id="updateuser"
							onclick="topage('<%=basePath%>user/toSaveUser.do','${u.id}');">修改</a>
							<a class="delete" id="deluser"
							onclick="dodelete('<%=basePath%>user/deleteUser.do','${u.id}');">删除</a>&nbsp;&nbsp;&nbsp;
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<pageset:PageBar pageUrl="findUsers.do" pageAttrKey="pageResult"></pageset:PageBar>
	</div>
	<%@ include file="/include/sort.jsp"%>
</body>
</html>