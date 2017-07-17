<%@ tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pageUrl" required="true" rtexprvalue="true"
	description="分页页面对应的URl"%>
<%@ attribute name="pageAttrKey" required="true" rtexprvalue="true"
	description="Page对象在Request域中的键名称"%>
<c:set var="pageUrl" value="${pageUrl}" />
<%
	jspContext.setAttribute("pageResult", request.getAttribute(pageAttrKey));
	jspContext.setAttribute("pageUrl", pageUrl);
%>

<script type="text/javascript">
	function pageFind(pagenum){
		/*
		if (pageNo == ""){
			alert("请输入页数");
			return;
		}
		*/
		var url = "${pageUrl}";
		var pagedom = '<input type="hidden" name="pagenum" value="'+pagenum+'" />';
		$("form:first").append(pagedom);
		$("form:first").attr("action",url);
		$("form:first").submit();
	}
	
	function checkpagenum(obj){
		var regu = /^\+?[ 1-9 ][ 0-9 ]*$/;
		var re = new RegExp(regu);
		var totalpagecount = ${pageResult.pages};
		if (!(re.test(obj.value))){
			$(obj).val("");
		}else{
			if (obj.value > totalpagecount){
				$(obj).val(totalpagecount);
			}
		}
	}
</script>
<div style="font: 12px;padding-right:10px;">
	共${pageResult.total }条，共${pageResult.pages}页&nbsp;|&nbsp;第${pageResult.pageNum}页&nbsp;&nbsp;
	<c:if test="${pageResult.pageNum <=1}">
	   首页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.pageNum >1 }">
		<a href="javascript:pageFind(1)">首页</a>&nbsp;&nbsp;	   
	</c:if>
	<c:if test="${pageResult.hasPreviousPage}">
		<a href="javascript:pageFind(${pageResult.pageNum -1 })">上一页</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${!pageResult.hasPreviousPage}">
	  上一页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.hasNextPage}">
		<a href="javascript:pageFind(${pageResult.pageNum +1 })">下一页</a>&nbsp;&nbsp;
	</c:if>
	<c:if test="${!pageResult.hasNextPage}">
	  下一页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.pageNum >= pageResult.pages}">
	   末页&nbsp;&nbsp;
	</c:if>
	<c:if test="${pageResult.pageNum < pageResult.pages}">
		<a href="javascript:pageFind(${pageResult.pages })">末页</a>&nbsp;&nbsp;	   
	</c:if>
	跳转至第
	<select onchange="pageFind(this.value);">
		<c:if test="${pageResult.pages > 0 }">
			<c:forEach begin="1" end="${pageResult.pages}" var="pgnum">
				<option value="${pgnum }" <c:if test="${pageResult.pageNum==pgnum }">selected="selected"</c:if>>${pgnum }</option>
			</c:forEach>
		</c:if>
		<c:if test="${pageResult.pages == 0 }">
			<option></option>
		</c:if>
	</select>
	页
	<!--
	 <input type="text" id="pageNum" value="${pageResult.pageNum }" 
	 	onblur="checkpagenum(this);" style="width: 40px;height:24px;"/>
	页
	<input type="button" onclick="pageFind($('#pageNum').val());" style="height: 22px;" value="确定" />
	-->
</div>