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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.editCourseBase.view" arguments="${courseBase.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="courseBase">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editCourseBase.label.coursebase"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Course Base Name" />
								<form:errors class="error" path="name" />
			 				</div>
							
							<div align="left" class="form-group">
			 					<form:label path="courseCode"><spring:message code="settings.editCourse.label.coursecode"></spring:message></form:label>
			 					<form:input path="courseCode" class="form-control input-lg" placeholder="Course Base Code" />
								<form:errors class="error" path="courseCode" />
			 				</div>
			 				
							<div align="left" class="form-group">
			 					<form:label path="created"><spring:message code="settings.editCourseBase.label.createdon" /></form:label>
			 					<label for="created" class="form-control"><joda:format value="${courseBase.created}" pattern="${createdDatePattern}"/></label>
			 					<form:hidden path="created" class="form-control input-lg" placeholder="Course Base Code" />
								<form:errors class="error" path="created" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="lastModified"><spring:message code="settings.editCourseBase.label.modifiedon" /></form:label>
			 					<label for="lastModified" class="form-control"><joda:format value="${courseBase.lastModified}" pattern="${createdDatePattern}"/></label>
			 					<form:hidden path="lastModified" class="form-control input-lg" placeholder="Course Base Code" />
								<form:errors class="error" path="lastModified" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="description"><spring:message code="settings.editCourseBase.label.description"></spring:message></form:label>
								<form:textarea path="description" class="form-control input-lg" />
								<form:errors class="error" path="description" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="maxParticipationCount"><spring:message code="settings.editCourseBase.label.max"></spring:message></form:label>
			 					<form:input path="maxParticipationCount" class="form-control input-lg" placeholder="Maximumn Participants" />
								<form:errors class="error" path="maxParticipationCount" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="lastModifier.id"><spring:message code="settings.editCourseBase.label.modifiedby" /></form:label>
			 					<label for="lastModifier" class="form-control">${courseBase.lastModifier.username}</label>
			 					<form:hidden path="lastModifier.id" class="form-control input-lg" placeholder="Course Base Code" />
								<form:errors class="error" path="lastModifier.id" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="creator.id"><spring:message code="settings.editCourseBase.label.createdby" /></form:label>
			 					<label for="creator" class="form-control">${courseBase.creator.username}</label>
			 					<form:hidden path="creator.id" class="form-control input-lg" placeholder="Course Base Code" />
								<form:errors class="error" path="creator.id" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="courseLength.id"><spring:message code="settings.editCourseBase.label.createdby" /></form:label>
			 					<label for="courseLength" class="form-control">${courseBase.courseLength.unit.name}</label>
			 					<form:hidden path="courseLength.id" class="form-control input-lg" placeholder="Course Length" />
								<form:errors class="error" path="courseLength.id" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="courseLengthUnits.id"><spring:message code="settings.editCourseBase.label.createdby" /></form:label>
			 					<label for="courseLengthUnits" class="form-control">${courseBase.courseLengthUnits.units}</label>
			 					<form:hidden path="courseLengthUnits.id" class="form-control input-lg" placeholder="Course Length" />
								<form:errors class="error" path="courseLengthUnits.id" />
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editCourseBase.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>