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
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="dashboard"><spring:message code="settings.editAcademicSemester.view" arguments="${semester.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="semester">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editAcademicSemester.label.semester"></spring:message></form:label>
			 					<label for="name" class="form-control">${semester.name}</label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Academic Semester" type="hidden" />
								<form:errors class="error" path="name" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="session"><spring:message code="settings.editAcademicSemester.label.session"></spring:message></form:label>
			 					<form:input path="session" class="form-control input-lg" placeholder="Academic Session" />
								<form:errors class="error" path="session" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="startDate"><spring:message code="settings.editAcademicSemester.label.start"></spring:message></form:label>
			 					<form:input id="birthday" path="startDate" class="form-control input-lg" placeholder="Start Date" />
								<form:errors class="error" path="startDate" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="endDate"><spring:message code="settings.editAcademicSemester.label.end"></spring:message></form:label>
			 					<form:input id="birthday" path="endDate" class="form-control input-lg" placeholder="End Date" />
								<form:errors class="error" path="endDate" />
			 				</div>
		
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editAcademicSemester.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>