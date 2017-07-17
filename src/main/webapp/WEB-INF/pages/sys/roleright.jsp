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
	<link rel="stylesheet" href="<%=basePath %>assets/plugins/zTree/css/zTreeStyle/zTreeStyle.css" />
</head>
  
  <body>
  	<%@ include file="../nav.jsp"%>
 	<div class="row">
 		<div class="col-md-3">
			<div class="portlet">
				<div class="portlet-title">
					<div class="caption"><i class="icon-cogs"></i>菜单树</div>
				</div>
				<div class="portlet-body">
					<div class="tree" style="min-height: 350px;">
						<ul id="ztree" class="ztree"></ul>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div class="portlet-body form">
				<form class="form-horizontal" id="saveform" action="<%=basePath %>menu/roleright.do" method="post">
					<div class="form-group">
						<label for="sortnum" class="col-md-3 control-label" id="lbroleid">用户角色</label>
						<div class="col-md-9">
							<select class="form-control required" name="roleid" id="roleid">
								<option>--请选择--</option>
								<c:forEach items="${roles }" var="role">
									<option value="${role.id }" <c:if test="${roleid == role.id }">selected="selected"</c:if>>
										${role.rolename }</option>							
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-actions fluid">
						<div class="col-md-offset-3 col-md-9">
							<input type="button" class="btn btn-primary" id="savebtn" value="保存" />
							<input type="reset" class="btn btn-primary" value="清空" />
						</div>
					</div>
				</form>
			</div>
		</div>
 	</div>
 	<script src="<%=basePath %>assets/plugins/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script src="<%=basePath %>assets/plugins/zTree/js/jquery.ztree.excheck-3.5.js"></script>
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
					var roleid = $("#roleid").val();
					var menuids = "";
					$(menuztree.getCheckedNodes(true)).each(function(e,obj){
						if (e > 0)
							menuids += ",";
						if (roleid !=1 && obj.id==1)
							return;
						menuids += obj.id;
					});
					if (menuids.startWith(","))
						menuids = menuids.substring(1);
					var data = {
						"menuids":menuids,
						"roleid":roleid
					};
					var url = "<%=basePath %>menu/saveRoleright.do";
					handleAjaxSimple(url,data,2,0,null);
				}else{
					showDialog("请选择要绑定的菜单！");
				}
			});
			
			$("#roleid").change(function(e){
				var url = "<%=basePath %>menu/roleright.do";
				$("div[class='page-content']").load(url, {"roleid":$("#roleid").val()});
			});
			
			$(".masklayer").hide();	//hide masklayer
		});
	</script>
  </body>
</html>
