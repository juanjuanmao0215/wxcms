<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<div class="row">
	<div class="col-md-12" id="navdiv">
		<!-- BEGIN PAGE TITLE & BREADCRUMB-->

		<!-- END PAGE TITLE & BREADCRUMB-->
	</div>
</div>
<script>
	$(function() {
		var title = $("ul[class='page-sidebar-menu']").children().find("a[status='on']").html();
		var navdom = '<h3 class="page-title">'+title+'</h3><ul class="page-breadcrumb breadcrumb">';
		navdom += '<li><i class="icon-home"></i><a href="javascript:;">首页</a><i class="icon-angle-right"></i></li>';
		var treelevelarray = $("ul[class='page-sidebar-menu']").children().find("a[status='on']").attr("treelevel").split(".");
		var menujson = ${menumap};
		for (i=0;i<treelevelarray.length;i++){
			var menuname = menujson[treelevelarray[i]];
			if (menuname !=undefined){
				navdom += '<li><a href="javascript:;">'+menuname+'</a>';
				if (i != treelevelarray.length-1)
					navdom += '<i class="icon-angle-right"></i></li>';
			}
		}
		navdom += '</ul>';
		$("#navdiv").append(navdom);
	});
</script>
