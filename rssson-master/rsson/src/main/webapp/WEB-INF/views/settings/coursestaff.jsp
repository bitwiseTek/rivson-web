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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="users"><spring:message code="settings.courseStaff.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="courseStaff">
		 				<c:if test="${not empty courseStaff}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${courseStaff}" var="staff">
			 						<spring:url value="/settings/coursestaff/edit/${staff.id}/" var="editCourseStaff" />
									<spring:url value="/settings/coursestaff/delete/${staff.id}/" var="deleteCourseStaff" />
									<tr>
										<td><label for="courseUserName" class="form-control">${staff.courseUser.user.username}</label></td>
										<td><label for="staffId" class="form-control">${staff.staffMember.staffId}</label></td>
										<td><a href="${editCourseStaff}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editCourseStaff}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.courseStaff.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteCourseStaff}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteCourseStaff}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.courseStaff.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>