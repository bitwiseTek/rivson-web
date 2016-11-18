<%-- 
    Document   : users edit
    Created on : Oct 22, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-5">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="users.systemUsers.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="systemUsers">
		 				<c:if test="${not empty systemUsers}">
		 					<table width="75%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${systemUsers}" var="systemUser">
			 						<spring:url value="/users/systemusers/edit/${systemUser.id}/" var="editSystemUser" />
									<spring:url value="/users/systemusers/show/${systemUser.id}/" var="showSystemUser" />
									<c:if test="${systemUser.username == pageContext.request.userPrincipal.name}">
										<tr>
											<td><label for="username" class="form-control">${systemUser.username}</label></td>
											<td><a href="${editSystemUser}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editSystemUser}">
								    		<div class="lsf-icon" title="setting"><spring:message code="users.systemUsers.button.edit" /></div></button></a></td>
								    		
											<td><a href="${showSystemUser}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${showSystemUser}">
								    		<div class="lsf-icon" title="delete"><spring:message code="users.systemUsers.button.view" /></div></button></a></td>
										</tr>
									</c:if>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>