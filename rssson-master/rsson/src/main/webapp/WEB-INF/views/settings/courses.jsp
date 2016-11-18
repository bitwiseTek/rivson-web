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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.courses.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="courses">
		 				<c:if test="${not empty courses}">
		 					<table width="75%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${courses}" var="course">
			 						<spring:url value="/settings/courses/edit/${course.id}/" var="editCourse" />
									<spring:url value="/settings/courses/delete/${course.id}/" var="deleteCourse" />
									<tr>
										<td><label for="name" class="form-control">${course.name}</label></td>
										<td><a href="${editCourse}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editCourse}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.courses.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteCourse}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteCourse}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.courses.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>