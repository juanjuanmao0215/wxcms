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
				<form class="form-horizontal" id="saveform" action="<%=basePath %>menu/addMenu.do" method="post">
					<input type="hidden" name="menulevel" id="menulevel" />
					<input type="hidden" name="id" id="menuid" />
					<input type="hidden" name="parentid" id="parentid" />
					<div class="form-group">
		 				<label for="parentmenu" class="col-md-3 control-label" id="lbparentmenu">父级模块</label>
						<div class="col-md-9">
							<input type="text" class="form-control required" id="menuSel" name="parentmenu" readonly onclick="showMenu();" />
						</div>
					</div>
					<div class="form-group">
		 				<label for="menuname" class="col-md-3 control-label" id="lbmenuname">模块名称</label>
						<div class="col-md-9">
							<input type="text" class="form-control required" id="menuname" name="menuname" />
						</div>
					</div>
					<div class="form-group">
		 				<label for="menuurl" class="col-md-3 control-label">模块地址</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="menuurl" name="menuurl" />
						</div>
					</div>
					<div class="form-group">
		 				<label for="menuimg" class="col-md-3 control-label">模块图片</label>
						<div class="col-md-9">
							<select class="form-control" name="menuimg" id="menuimg">
								<option value="">--请选择--</option>
								<c:forEach items="${menuimgs }" var="mi">
									<option value="${mi.codeimg }">${mi.codename }</option>							
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="sortnum" class="col-md-3 control-label" id="lbsortnum">排序编号</label>
						<div class="col-md-9">
							<select class="form-control required" name="sortnum" id="sortnum">
								<c:forEach begin="1" end="30" var="sortnum">
									<option value="${sortnum }">${sortnum }</option>							
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label  class="col-md-3 control-label">是否禁用</label>
						<div class="col-md-9">
							<div class="radio-list">
								<label class="radio-inline">
									<input type="radio" name="isused" value="0" checked>否
								</label>
								<label class="radio-inline">
									<input type="radio" name="isused" value="1">是
								</label>
							</div>
						</div>
					</div>
					<div class="form-actions fluid">
						<div class="col-md-offset-3 col-md-9">
							<input type="button" class="btn btn-primary" id="savebtn" value="添加" />
							<input type="button" class="btn btn-primary" id="updatebtn" value="修改" />
							<input type="button" class="btn btn-danger" id="deletebtn" value="删除" />
							<input type="reset" class="btn btn-primary" value="清空" />
						</div>
					</div>
				</form>
			</div>
		</div>
		<div id="menuContent" style="display:none; position: absolute;background: #EEEEEE;border:1px solid #DDDDDD;min-width:300px;min-height: 350px;">
 			<ul id="selztree" class="ztree"></ul>
		</div>
	</div>
	<script src="<%=basePath %>assets/plugins/zTree/js/jquery.ztree.core-3.5.js"></script>
	<script type="text/javascript">
		var setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: onClick
			}
		};

		var sel_setting = {
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onClick: selclick
			}
		};
		var form = $("#saveform");
		$(function(){
			$.fn.zTree.init($("#ztree"), setting, ${ztreedata });
			$.fn.zTree.init($("#selztree"), sel_setting, ${ztreedata });
			
			$("#savebtn").click(function(e){
				if (checksubmit()){
					if ($("#parentid").val() == 0)
						$("#parentid").val(1);
					var url = $(form).attr("action");
					var callback = window.location.href;
					handleAjaxSimple(url,form.serialize(),2,1,callback,true);
				}
			});

			$("#updatebtn").click(function(){
				if (checksubmit()){
					var url = "<%=basePath %>menu/updateMenu.do";
					var callback = window.location.href;
					handleAjaxSimple(url,form.serialize(),2,1,callback,true);
				}
			});
			
			$("#deletebtn").click(function(){
				var menuid = $("#menuid").val();
				if (menuid == ''){
					showDialog("请选择要删除的菜单！");
					return;
				}
				dialogConfirm("删除后数据无法恢复，您确定要删除？",function(){
					var url = "<%=basePath %>menu/deleteMenu.do";
					var callback = window.location.href;
					var data = {"menuid":menuid};
					handleAjaxSimple(url,data,2,1,callback,true);
				});
			});
			
		})
		
		function selclick(event, treeId, treeNode){
			$("#menulevel").val(treeNode.treelevel);
			$("#menuSel").val(treeNode.name);
			$("#parentid").val(treeNode.id);
		}
		
		function showMenu() {
			var menuObj = $("#menuSel");
			var menuOffset = $("#menuSel").offset();
			$("#menuContent").css({left:menuOffset.left + "px", top:menuOffset.top + menuObj.outerHeight() + "px"}).slideDown("fast");
			$("body").bind("mousedown", onBodyDown);
		}
		
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		
		function onBodyDown(event) {
			if (!(event.target.id == "menuSel" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}
		
		function checksubmit(){
			if ($("#parentid").val() == ''){
				showDialog("请选择父节点！");
				return false;
			}
			if (!$.checkFormSubmit(form)) {
				return false;
			}
			return true;
		}

		function onClick(event, treeId, treeNode) {
			$("#menulevel").val(treeNode.getParentNode()!=null?treeNode.treelevel:1);
			$("#menuid").val(treeNode.id);
			$("#parentid").val(treeNode.pId==null?0:treeNode.pId);
			$("#menuname").val(treeNode.name);
			$("#menuurl").val(treeNode.menuurl);
			$("[name='isused'][value="+treeNode.isused+"]").attr("checked","checked");
			$("#sortnum").val(treeNode.sortnum);
			$("#menuSel").val(treeNode.getParentNode()!=null?treeNode.getParentNode().name:treeNode.name);
		}
		$(function() {
			$(".masklayer").hide();	//hide masklayer
		});
	</script>
  </body>
</html>
