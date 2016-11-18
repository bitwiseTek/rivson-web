<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
$(document).ready(function() {
	  $("#editSubjectForm").validate({
		  rules: {
			  name: {
				  required: true,
				  maxlength: 45
			  }, 
			  code: {
				  required: true, 
				  maxLength: 5
			  }
		  }, 
		  highlight: function(element) {
			  $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
		  }, 
		  unhighlight: function(element) {
			  $(element).closest('.form-group').removeClass('has-error').addClass('has-success');
		  }
	  });
});
</script>

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.editSubject.view" arguments="${subject.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="subject" id="editSubjectForm">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editSubject.label.subject"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Subject Name" />
								<div class="help-block with-errors">
									<form:errors class="error" path="name" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="code"><spring:message code="settings.editSubject.label.code"></spring:message></form:label>
			 					<form:input path="code" class="form-control input-lg" placeholder="Subject Code" />
								<div class="help-block with-errors">
									<form:errors class="error" path="code" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="courseBase.id"><spring:message code="settings.editSubject.label.base"></spring:message></form:label>
			 					<label for="courseBase" class="form-control">${subject.courseBase.name}</label>
			 					<form:input path="courseBase.id" class="form-control input-lg" placeholder="Course Base" type="hidden" />
								<form:errors class="error" path="courseBase.id" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="academicLevel"><spring:message code="settings.editSubject.label.level"></spring:message></form:label>
								<form:select path="academicLevel" class="form-control input-lg">
									<form:options items="${levels}" />
								</form:select>
								<form:errors class="error" path="academicLevel" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="creditUnit"><spring:message code="settings.editSubject.label.unit"></spring:message></form:label>
								<form:select path="creditUnit" class="form-control input-lg">
									<form:options items="${units}" />
								</form:select>
								<form:errors class="error" path="creditUnit" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="course.id"><spring:message code="settings.editSubject.label.course"></spring:message></form:label>
								<form:select path="course.id" class="form-control">
									<c:forEach items="${courses}" var="course">
										<c:choose>
											<c:when test="${not empty courses}">
												<option value="${course.id}">${course.name}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="course.id" />
								</div>
							</div>
							
							<div align="left" class="form-group">
								<form:label path="educationType.id"><spring:message code="settings.editSubject.label.type"></spring:message></form:label>
			 					<label for="educationType" class="form-control">${subject.educationType.name}</label>
			 					<form:input path="educationType.id" class="form-control input-lg" placeholder="Education Type" type="hidden" />
								<form:errors class="error" path="educationType.id" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="subjectLecturer.id"><spring:message code="settings.editSubject.label.lecturer"></spring:message></form:label>
								<form:select path="subjectLecturer.id" class="form-control">
									<c:forEach items="${lecturers}" var="lecturer">
										<c:choose>
											<c:when test="${not empty lecturers}">
												<option value="${lecturer.id}">${lecturer.staffMember.user.fullName}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="subjectLecturer.id" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="semester.id"><spring:message code="settings.editSubject.label.semester"></spring:message></form:label>
								<form:select path="semester.id" class="form-control">
									<c:forEach items="${semesters}" var="semester">
										<c:choose>
											<c:when test="${not empty semesters}">
												<option value="${semester.id}">${semester.name}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="semester.id" />
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editSubject.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>