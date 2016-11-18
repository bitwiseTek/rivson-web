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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="delete"><spring:message code="settings.deleteCourseStaff.view" arguments="${courseStaff.courseUser.user.username}" /></span></h3>
		 			<br />
		 			<form:form method="DELETE" modelAttribute="courseStaff">
		 				<input type="hidden" name="_method" value="DELETE" />
							<table width="75%" border="0" cellspacing="5" cellpadding="5">
									<tr>
										<td><label for="username" class="form-control">${courseStaff.courseUser.user.username}</label></td>
										<td><label for="staffId" class="form-control">${courseStaff.staffMember.staffId}</label></td>
										<td><form:input path="courseStaff.courseUser.user.username" class="form-control input-lg" placeholder="Course Username" type="hidden" /></td>
										<td><form:errors path="courseStaff.courseUser.user.username" class="error" /></td>
										
										<td><form:input path="courseStaff.staffMember.id" class="form-control input-lg" placeholder="Course Staff Id" type="hidden" /></td>
										
										<td><button class="btn btn-magnolia_two">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.deleteCourseStaff.button.delete" /></div></button></td>
									</tr>
		 					</table>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>