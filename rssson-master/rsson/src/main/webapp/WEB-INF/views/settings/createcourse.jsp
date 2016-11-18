<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<script type="text/javascript">
      function validateRegEx(regex, input, helpText, helpMessage) {
			if (!regex.test(input)) {
				if (helpText != null) {
					helpText.innerHTML = helpMessage;
					return false;
				}
			} else {
				if (helpText != null) {
					helpText.innerHTML = "";
					return true;
				}
			}
		}
		
		function validateNonEmptyCourseName(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Course Name");
		}
		
		function submitPage(form) {
			if (validateNonEmptySystemId(form['courseName'], form['courseName_help'])) {
				form.submit();
			} else {
				alert("Sorry but the information provided in your form is insufficient");
			}
		}
</script>

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-5">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="generic.navigation.createCourse" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="course">
			 				<spring:url value="/settings/courses" var="listCourses" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Course Name" 
			 					onblur="validateNonEmptyCourseName(this, document.getElementById('courseName_help'))" />
								<div class="help-block with-errors">
									<span id="courseName_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="state.id"><spring:message code="settings.createCourse.label.state"></spring:message></form:label>
										<form:select path="state.id" class="form-control">
											<c:forEach items="${states}" var="state">
												<c:choose>
													<c:when test="${not empty states}">
														<option value="${state.id}">${state.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="state" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="courseBase.id"><spring:message code="settings.createCourse.label.base"></spring:message></form:label>
											<form:select path="courseBase.id" class="form-control">
												<c:forEach items="${courseBases}" var="courseBase">
													<c:choose>
														<c:when test="${not empty courseBases}">
															<option value="${courseBase.id}">${courseBase.name}</option>
														</c:when>
													</c:choose>
												</c:forEach>
											</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="courseBase" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="type.id"><spring:message code="settings.createCourse.label.type"></spring:message></form:label>
										<form:select path="type.id" class="form-control">
											<c:forEach items="${types}" var="type">
												<c:choose>
													<c:when test="${not empty types}">
														<option value="${type.id}">${type.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="type" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
								<form:input id="birthday" path="beginDate" class="form-control input-lg" placeholder="Begin Date" />
								<div class="help-block with-errors">
									<form:errors class="error" path="beginDate" />
								</div>
							</div>
							
							<div align="left" class="form-group">
								<form:input id="birthday" path="endDate" class="form-control input-lg" placeholder="End Date" />
								<div class="help-block with-errors">
									<form:errors class="error" path="endDate" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:input path="distanceTeachingDays" class="form-control input-lg" placeholder="Distance Teaching Days" />
								<form:errors class="error" path="distanceTeachingDays" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="distanceTeachingHours" class="form-control input-lg" placeholder="Distance Teaching Hours" />
								<form:errors class="error" path="distanceTeachingHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="planningHours" class="form-control input-lg" placeholder="Planning Hours" />
								<form:errors class="error" path="planningHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="localTeachingDays" class="form-control input-lg" placeholder="Local Teaching Days" />
								<form:errors class="error" path="localTeachingDays" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="localTeachingHours" class="form-control input-lg" placeholder="Local Teaching Hours" />
								<form:errors class="error" path="localTeachingHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="assessingHours" class="form-control input-lg" placeholder="Assessing Hours" />
								<form:errors class="error" path="assessingHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
								<form:input id="birthday" path="enrolmentTimeEnd" class="form-control input-lg" placeholder="Enrolment Time End" />
								<div class="help-block with-errors">
									<form:errors class="error" path="enrolmentTimeEnd" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:input path="courseFee" class="form-control input-lg" placeholder="Course Fee" />
								<form:errors class="error" path="courseFee" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="courseFeeCurrency"><spring:message code="settings.createCourse.label.coursecurrency"></spring:message></form:label>
								<form:select path="courseFeeCurrency"  items="${currencies}" class="form-control input-lg" placeholder="Currencies"></form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="CourseFeeCurrency" />
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="album"><spring:message code="settings.createCourse.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listCourses}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createCourse.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>