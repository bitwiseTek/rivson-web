<%-- 
    Document   : coursebases
    Created on : Jul, 12 2016
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.courseBases.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="courseBases">
		 				<c:if test="${not empty courseBases}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${courseBases}" var="courseBase">
			 						<spring:url value="/settings/coursebases/edit/${courseBase.id}/" var="editCourseBase" />
									<spring:url value="/settings/coursebases/delete/${courseBase.id}/" var="deleteCourseBase" />
									<tr>
										<td><label for="courseCode" class="form-control">${courseBase.courseCode}</label></td>
										<td><label for="name" class="form-control">${courseBase.name}</label></td>
										<td><a href="${editCourseBase}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editCourseBase}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.courseBases.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteCourseBase}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteCourseBase}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.courseBases.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>