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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="users"><spring:message code="settings.courseStudents.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="courseStudents">
		 				<c:if test="${not empty courseStudents}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${courseStudents}" var="courseStudent">
			 						<spring:url value="/settings/coursestudents/edit/${courseStudent.id}/" var="editCourseStudent" />
									<spring:url value="/settings/coursestudents/delete/${courseStudent.id}/" var="deleteCourseStudent" />
									<tr>
										<td><label for="courseUserName" class="form-control">${courseStudent.courseUser.user.username}</label></td>
										<td><label for="student" class="form-control">${courseStudent.student.studentId}</label></td>
										<td><a href="${editCourseStudent}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editCourseStudent}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.courseStudents.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteCourseStudent}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteCourseStudent}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.courseStudents.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>