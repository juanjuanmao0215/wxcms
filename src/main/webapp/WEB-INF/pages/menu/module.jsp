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
					<div class="caption"><i class="icon-cogs"></i>模块管理</div>
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
				<form class="form-horizontal" id="saveform" action="<%=basePath %>module/addModule.do" method="post">
					<input type="hidden" name="modulelevel" id="modulelevel" />
					<input type="hidden" name="id" id="moduleid" />
					<input type="hidden" name="parentid" id="parentid" />
					<input type="hidden" name="modulelevel" id="modulelevel" />
					<div class="form-group">
		 				<label for="parentmodule" class="col-md-3 control-label" id="lbparentmodule">父级模块</label>
						<div class="col-md-9">
							<input type="text" class="form-control required" id="moduleSel" name="parentmodule" readonly onclick="showMenu();" />
						</div>
					</div>
					<div class="form-group">
		 				<label for="modulename" class="col-md-3 control-label" id="lbmodulename">模块名称</label>
						<div class="col-md-9">
							<input type="text" class="form-control required" id="modulename" name="modulename" />
						</div>
					</div>
					<div class="form-group">
		 				<label for="moduleurl" class="col-md-3 control-label">模块地址</label>
						<div class="col-md-9">
							<input type="text" class="form-control" id="moduleurl" name="moduleurl" />
						</div>
					</div>
					<div class="form-group">
		 				<label for="moduleurl" class="col-md-3 control-label">模块图片</label>
						<div class="col-md-9">
							<select class="form-control" name="moduleimg" id="moduleimg">
								<option value="">--请选择--</option>
								<c:forEach items="${moduleimgs }" var="mi">
									<option value="${mi.codeimg }">${mi.codename }</option>							
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="ordernum" class="col-md-3 control-label">排序编号</label>
						<div class="col-md-9">
							<select class="form-control" name="ordernum" id="ordernum">
								<c:forEach begin="1" end="30" var="sortnum">
									<option value="${sortnum }">${sortnum }</option>							
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-md-3 control-label">是否禁用</label>
						<div class="col-md-9">
							<div class="radio-list">
								<label class="radio-inline">
									<input type="radio" name="isused" checked="checked" value="0" />否
								</label>
								<label class="radio-inline">
									<input type="radio" name="isused" value="1" />是
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
		<div id="moduleContent" class="menuContent" style="display:none; position: absolute;background: #D7E4F2;border:1px solid #DDDDDD;">
 			<ul id="selztree" class="ztree" style="margin-top:0; width:300px; min-height: 350px;"></ul>
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
					handleAjaxSimple(url,form.serialize(),2,1,callback);
				}
			});

			$("#updatebtn").click(function(){
				if (checksubmit()){
					var url = "<%=basePath %>module/updateModule.do";
					var callback = window.location.href;
					handleAjaxSimple(url,form.serialize(),2,1,callback);
				}
			});
			
			$("#deletebtn").click(function(){
				var modulelevel = $("#modulelevel").val();
				if (modulelevel == ''){
					showDialog("请选择要删除的项！");
					return;
				}
				var data = {"modulelevel":modulelevel};
				dialogConfirm("删除后数据无法恢复，您确定要删除？",function(){
					var url = "<%=basePath %>module/deleteModule.do";
					var callback = window.location.href;
					var data = {"modulelevel":modulelevel};
					handleAjaxSimple(url,data,2,1,callback);
				});
			});
			
		})
		
		function selclick(event, treeId, treeNode){
			$("#modulelevel").val(treeNode.treelevel);
			$("#moduleSel").val(treeNode.name);
			$("#parentid").val(treeNode.id);
		}
		
		function showMenu() {
			var cityObj = $("#moduleSel");
			var cityOffset = $("#moduleSel").offset();
			$("#moduleContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");
			$("body").bind("mousedown", onBodyDown);
		}
		
		function hideMenu() {
			$("#moduleContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		
		function onBodyDown(event) {
			if (!(event.target.id == "moduleSel" || event.target.id == "moduleContent" || $(event.target).parents("#moduleContent").length>0)) {
				hideMenu();
			}
		}
		
		function checksubmit(){
			if ($("#parentid").val() == ''){
				showDialog("请先点击左侧的模块树选择对应的父节点！");
				return false;
			}
			if (!$.checkFormSubmit(form)) {
				return false;
			}
			return true;
		}

		function onClick(event, treeId, treeNode) {
			$("#modulelevel").val(treeNode.treelevel);
			$("#modulelevel").val(treeNode.getParentNode()!=null?treeNode.getParentNode().treelevel:1);
			$("#moduleid").val(treeNode.id);
			$("#parentid").val(treeNode.pId==null?0:treeNode.pId);
			$("#modulename").val(treeNode.name);
			$("#moduleurl").val(treeNode.moduleurl);
			$("[name='isused'][value="+treeNode.isused+"]").attr("checked","checked");
			$("#ordernum").val(treeNode.ordernum);
			$("#moduleSel").val(treeNode.getParentNode()!=null?treeNode.getParentNode().name:treeNode.name);
		}
		$(function() {
			App.init(); // initlayout and core plugins
		});
	</script>
  </body>
</html>
