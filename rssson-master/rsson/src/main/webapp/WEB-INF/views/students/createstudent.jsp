<%-- 
    Document   : create student
    Created on : Jul 13, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
$(document).ready(function() {
	  $("#createStudentForm").validate({
		  rules: {
			  studentId: {
				  required: true,
				  maxlength: 14
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
		 		<div align="left" class="col-md-5">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="students.addStudent.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="student" id="createStudentForm">
		 				<spring:url value="/students" var="listStudents" />
		 					<div align="left" class="form-group">
			 					<form:input path="studentId" class="form-control input-lg" placeholder="Student ID" />
								<div class="help-block with-errors">
									<form:errors class="error" path="studentId" />
								</div>
			 				</div>
			 				<div align="left" class="form-group">
			 					<form:input path="nickname" class="form-control input-lg" placeholder="Nickname" />
								<form:errors class="error" path="nickname" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="nationality"><spring:message code="students.addStudent.label.nation"></spring:message></form:label>
								<form:select path="nationality"  items="${nationalities}" class="form-control input-lg" placeholder="Nationality"></form:select>
								<form:errors class="error" path="nationality" />
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="stateOfOrigin"><spring:message code="students.addStudent.label.state"></spring:message></form:label>
										<form:select path="stateOfOrigin" items="${states}" class="form-control input-lg" placeholder="State of Origin"/>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="stateOfOrigin" />
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="lga.id"><spring:message code="students.addStudent.label.lga"></spring:message></form:label>
										<form:select path="lga.id" class="form-control">
											<c:forEach items="${lgas}" var="lga">
												<c:choose>
													<c:when test="${not empty lgas}">
														<option value="${lga.id}">${lga.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="lga" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="activityType.id"><spring:message code="students.addStudent.label.activity"></spring:message></form:label>
										<form:select path="activityType.id" class="form-control">
											<c:forEach items="${activities}" var="activity">
												<c:choose>
													<c:when test="${not empty activities}">
														<option value="${activity.id}">${activity.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="activityType" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="examinationType.id"><spring:message code="students.addStudent.label.exam"></spring:message></form:label>
										<form:select path="examinationType.id" class="form-control">
											<c:forEach items="${examTypes}" var="examType">
												<c:choose>
													<c:when test="${not empty examTypes}">
														<option value="${examType.id}">${examType.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="examinationType" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="educationalLevel.id"><spring:message code="students.addStudent.label.education"></spring:message></form:label>
										<form:select path="educationalLevel.id" class="form-control">
											<c:forEach items="${eduLevels}" var="eduLevel">
												<c:choose>
													<c:when test="${not empty eduLevels}">
														<option value="${eduLevel.id}">${eduLevel.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="educationalLevel" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:input id="birthday" path="studyTimeEnd" class="form-control input-lg" placeholder="Actual End of Study" />
								<form:errors class="error" path="studyTimeEnd" />
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-7">
					 				<div align="left" class="form-group">
					 					<form:label path="studyProgramme.id"><spring:message code="students.addStudent.label.programme"></spring:message></form:label>
										<form:select path="studyProgramme.id" class="form-control">
											<c:forEach items="${programmes}" var="programme">
												<c:choose>
													<c:when test="${not empty programmes}">
														<option value="${programme.id}">${programme.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="studyProgramme" />
								</div>
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="previousStudies"><spring:message code="students.addStudent.label.previous"></spring:message></form:label>
			 					<form:input path="previousStudies" class="form-control input-lg" placeholder="Previous Studies" />
								<form:errors class="error" path="previousStudies" />
			 				</div>
			 				
			 				<div align="left" class="checkbox">
			 					<form:label path="lodging"><spring:message code="students.addStudent.label.accommodation"></spring:message></form:label>
			 					<form:checkbox path="lodging" />
			 				</div>
			 				
							<form:hidden path="studyStartDate" />
							
							<form:hidden path="studyEndDate" />
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-7">
					 				<div align="left" class="form-group">
					 					<form:label path="studyEndReason.id"><spring:message code="students.addStudent.label.endreason"></spring:message></form:label>
										<form:select path="studyEndReason.id" class="form-control">
											<c:forEach items="${endReasons}" var="endReason">
												<c:choose>
													<c:when test="${not empty endReasons}">
														<option value="${endReason.id}">${endReason.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="studyEndReason" />
								</div>
							</div>
							
							<div align="left" class="form-group">
								<form:label path="studyEndText"><spring:message code="students.addStudent.label.endtext"></spring:message></form:label>
								<form:textarea path="studyEndText" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="studyEndText" />
								</div>
							</div>
							
							<div align="left" class="form-group">
								<form:label path="additionalInfo"><spring:message code="students.addStudent.label.addinfo"></spring:message></form:label>
								<form:textarea path="additionalInfo" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="additionalInfo" />
								</div>
							</div>
		 				
		 					<div align="left" class="row">
			 					<div align="left" class="col-md-7">
					 				<div align="left" class="form-group">
					 					<form:label path="user.id"><spring:message code="students.addStudent.label.username"></spring:message></form:label>
										<form:select path="user.id" class="form-control">
											<c:forEach items="${users}" var="user">
												<c:choose>
													<c:when test="${not empty users}">
														<option value="${user.id}">${user.username}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="user" />
								</div>
							</div>
		 				
						
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="key"><spring:message code="students.addStudent.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listStudents}">
									    <div class="lsf-icon" title="list"><spring:message code="students.addStudent.button.view" /></div>
									</button>
								</div>
						</div>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>