<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/include/taglib.jsp"%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="/include/maincss.jsp"%>
	<link rel="stylesheet" href="<%=basePath %>plugin/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">

	<style type="text/css">
		#ztreediv{width: 20%;float: left;overflow-y: auto;min-height: 500px;}
		#ztreediv fieldset{min-height: 500px;}
		#modulediv{width: 70%;float: left;}
		legend{font-size: 14px;}
	</style>
  </head>
  
  <body>
  	<%@ include file="/include/jslib.jsp" %>
 	<div id="ztreediv">
		<fieldset>
 			<legend>模块管理</legend>
	  		<ul id="ztree" class="ztree"></ul>
  		</fieldset>
	</div>
	<div id="modulediv">
		<form class="form-horizontal" id="saveform" action="<%=basePath %>module/findUserRole.do" method="post">
			<div class="form-group">
				<label for="role" class="col-sm-2 control-label">角色：</label>
				<div class="col-sm-3">
					<select class="form-select" name="roleid" id="role">
						<c:forEach items="${roles }" var="role">
							<option value="${role.id }" <c:if test="${roleid==role.id }">selected="selected"</c:if>>${role.rolename }</option>
						</c:forEach>
					</select>
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
	<script src="<%=basePath %>plugin/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script src="<%=basePath %>plugin/zTree/js/jquery.ztree.excheck-3.5.js"></script>
	<script type="text/javascript">
		var menu_setting = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: menuClick
			}
		};
		var menuztree;
		$(function(){
			$.fn.zTree.init($("#ztree"), menu_setting, ${ztreedata });
			menuztree = $.fn.zTree.getZTreeObj("ztree");
		});
		
		function menuClick(event, treeId, treeNode) {
			if (treeNode.checked){	//判断触发的节点的checkbox是否选中
				menuztree.checkNode(treeNode, false, true,true);
			}else{
				menuztree.checkNode(treeNode, true, true,true);
			}
		}
	
		$(function(){
			$("#savebtn").click(function(e){
				if ($(menuztree.getCheckedNodes(true)).size() != 0){
					var roleid = $("#role").val();
					var moduleids = "";
					$(menuztree.getCheckedNodes(true)).each(function(e,obj){
						if (e > 0)
							moduleids += ",";
						if (roleid !=1 && obj.id==1)
							return;
						moduleids += obj.id;
					});
					if (moduleids.startWith(","))
						moduleids = moduleids.substring(1);
					var data = {
						"moduleids":moduleids,
						"roleid":roleid
					};
					var url = "<%=basePath %>module/saveModuleRole.do";
					handleAjaxSimple(url,data,2,0,null);
				}else{
					showDialog("请选择要绑定的模块！");
				}
			});
			
			$("#role").change(function(e){
				$("#saveform").submit();
			});
			
		});
		
	</script>
  </body>
</html>
