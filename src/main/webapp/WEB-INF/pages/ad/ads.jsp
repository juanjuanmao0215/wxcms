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
		<form class="form-inline" action="<%=basePath%>ad/findAds.do" name="adform" id="adform" method="post">
			<div class="form-group">
				<label for="showtitle">广告标题：</label>
				<input type="text" class="form-control" id="showtitle" name="showtitle" value="${ad.showtitle }">
			</div>
			<div class="form-group">
				<label for="showcontent">广告描述：</label>
				<input type="text" class="form-control" id="showcontent" name="showcontent" value="${ad.showcontent }">
			</div>
			<div class="form-group">
				<label></label>
				<input class="btn btn-primary searchbtn" type="button" value="查询" />
				<input class="btn btn-primary" id="addUser" type="button" value="新增" onclick="topage('<%=basePath%>ad/toAdinfo.do');" />
				<input class="btn btn-primary" type="button" value="确认调整" onclick="changesortnum();" />
				<input class="btn btn-danger" type="button" onclick="batchdelete('<%=basePath%>ad/batchdeleteAd.do');" value="批量删除" />
			</div>
		</form>
		<hr />
	</div>
	<div class="table-responsive">
		<table class="table table-striped table-bordered table-hover table-condensed">
			<thead>
				<tr>
					<th class="table-tr-td6 td-center"><label><input
							type="checkbox" class="form-checkall" id="checkall" />全选</label>
					<th class="table-tr-td6">序号</th>
					<th class="table-tr-td25">广告标题</th>
					<th class="table-tr-td8 td-center sorting" id="sortnum">显示顺序</th>
					<th class="table-tr-td30">广告描述</th>
					<th class="table-tr-td15 sorting_desc" id="intime">创建时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ads}" var="ad" varStatus="s">
					<tr>
						<td class="td-center">
							<input type="checkbox" name="adcbx" class="form-ckb" value="${ad.id }" />
						</td>
						<td>${s.count }</td>
						<td>${ad.showtitle }</td>
						<td class="td-center">
							<select class="form-select" name="sortnum" id="sortnum${ad.id }">
								<option value="1" <c:if test="${1 == ad.sortnum }">selected="selected"</c:if>>第一张</option>
								<option value="2" <c:if test="${2 == ad.sortnum }">selected="selected"</c:if>>第二张</option>
								<option value="3" <c:if test="${3 == ad.sortnum }">selected="selected"</c:if>>第三张</option>
								<option value="4" <c:if test="${4 == ad.sortnum }">selected="selected"</c:if>>第四张</option>
								<option value="5" <c:if test="${5 == ad.sortnum }">selected="selected"</c:if>>第五张</option>
							</select>
						</td>
						<td>${ad.showcontent }</td>
						<td><fmt:formatDate value="${ad.intime }" type="both" pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td>
							<a id="updatead" onclick="topage('<%=basePath%>ad/toAdinfo.do','${ad.id}');">修改</a>
							<a class="delete" id="deletead" onclick="dodelete('<%=basePath%>ad/deleteAd.do','${ad.id}');">删除</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<%@ include file="/include/sort.jsp"%>
  	<script>
  		function changesortnum(){
  			var id_array = new Array();
  			$("select[name='sortnum']").each(function(){
  				var id = $(this).attr("id");
  	  			var param = {
  	  				"id":id.substring("sortnum".length),
  	  				"sortnum":$(this).val()
  	  			};
  	  			id_array.push(param);
  			});
  			dialogConfirm("您确定要调整显示顺序？", function() {
  				var url = "<%=basePath%>ad/updatesortnum.do";
  				var callback = $("form:first").attr("action");
  				handleAjaxSimple(url, JSON.stringify(id_array), 1, 1, callback);
  			});
  		}
  	</script>
  </body>
</html>
