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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.editGrade.view" arguments="${grade.name, grade.description}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="grade">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editGrade.label.grade"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Grade" />
								<form:errors class="error" path="name" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="description"><spring:message code="settings.editGrade.label.descr"></spring:message></form:label>
			 					<form:input path="description" class="form-control input-lg" placeholder="Description" />
								<form:errors class="error" path="description" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="qualification"><spring:message code="settings.editGrade.label.qual"></spring:message></form:label>
			 					<form:input path="qualification" class="form-control input-lg" placeholder="Qualification" />
								<form:errors class="error" path="qualification" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="gradingScale.id"><spring:message code="settings.editGrade.label.scale"></spring:message></form:label>
			 					<label for="gradingScale" class="form-control">${grade.gradingScale.name}</label>
			 					<form:hidden path="gradingScale.id" class="form-control input-lg" placeholder="Grading Scale" />
								<form:errors class="error" path="gradingScale.id" />
			 				</div>
			 				
			 				<div align="left" class="checkbox">
								<form:label path="passingGrade"><spring:message code="settings.editGrade.label.passing"></spring:message></form:label>
								<form:checkbox path="passingGrade" />
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="GPA"><spring:message code="settings.editGrade.label.gpa"></spring:message></form:label>
			 					<form:input path="GPA" class="form-control input-lg" placeholder="GPA" />
								<form:errors class="error" path="GPA" />
			 				</div>
		
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editGrade.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>