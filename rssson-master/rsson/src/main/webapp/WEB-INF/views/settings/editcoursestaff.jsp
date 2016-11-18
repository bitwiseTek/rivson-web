<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<spring:message code="created.date.pattern" var="createdDatePattern" />

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="settings.editCourseStaff.view" arguments="${courseStaff.courseUser.user.username}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="courseStaff">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="courseUser.user.username"><spring:message code="settings.editCourseStaff.label.courseUsername"></spring:message></form:label>
			 					<label for="courseUser" class="form-control">${courseStaff.courseUser.user.username}</label>
			 					<form:input path="courseUser.user.username" class="form-control input-lg" placeholder="Course Username" type="hidden" />
								<form:errors class="error" path="courseUser.user.username" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="staffMember.id"><spring:message code="settings.editCourseStaff.label.staffId"></spring:message></form:label>
			 					<label for="staffMember.id" class="form-control">${courseStaff.staffMember.staffId}</label>
			 					<form:input path="staffMember.id" class="form-control input-lg" placeholder="Staff ID" type="hidden" />
								<form:errors class="error" path="staffMember.id" />
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editCourseStaff.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>