<%-- 
    Document   : student info
    Created on : Oct 29, 2016
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
		 		<div align="left" class="col-md-6">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="users"><spring:message code="students.info.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="students">
		 				<c:if test="${not empty students}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${students}" var="student">
			 						<spring:url value="/students/studentinfo/show/${student.id}/" var="viewStudent" />
			 						<c:if test="${student.user.username == pageContext.request.userPrincipal.name}">
										<tr>
											<td><label for="username" class="form-control">${student.user.username}</label></td>
											<td><label for="student" class="form-control">${student.studentId}</label></td>
											<td><a href="${viewStudent}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${viewStudent}">
								    		<div class="lsf-icon" title="setting"><spring:message code="students.button.view" /></div></button></a></td>
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