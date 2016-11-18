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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="users"><spring:message code="settings.courseUsers.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="courseUsers">
		 				<c:if test="${not empty courseUsers}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${courseUsers}" var="courseUser">
			 						<spring:url value="/settings/courseusers/edit/${courseUser.id}/" var="editCourseUser" />
									<spring:url value="/settings/courseusers/delete/${courseUser.id}/" var="deleteCourseUser" />
									<tr>
										<td><label for="courseUserName" class="form-control">${courseUser.user.username}</label></td>
										<td><label for="course" class="form-control">${courseUser.course.name}</label></td>
										<td><a href="${editCourseUser}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editCourseUser}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.courseUsers.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteCourseUser}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteCourseUser}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.courseUsers.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>