<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="/WEB-INF/tlds/c.tld" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:set var="id" value="${empty param.id ? 1 : param.id}" />

<c:forEach items="${menus }" var="menu" varStatus="st">
	<c:if test="${menu.pId == id}">
		<c:choose>
			<c:when test="${!menu.haschildren }">
				<li>
					<a status="off" treelevel="${menu.treelevel }" href="javascript:;" onclick="loadpage(this,'<%=basePath %>${menu.menuurl }');">${menu.name }</a>
				</li>
			</c:when>
			<c:otherwise>
				<li>
					<a href="javascript:;">
						<i class="${menu.menuimg }"></i> 
						<span class="title">${menu.name }</span>
						<span class="arrow "></span>
					</a>
					<ul class="sub-menu">
						<c:import url="sidebar.jsp">
							<c:param name="id" value="${menu.id}"/>
						</c:import>
					</ul>
				</li>
			</c:otherwise>
		</c:choose>		
	</c:if>
</c:forEach>
