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
		
		function validateNonEmptyCourseBaseName(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Course Base Name");
		}
		
		function validateNonEmptyCourseBaseCode(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Course Base Code");
		}
		
		function submitPage(form) {
			if (validateNonEmptySystemId(form['courseBaseName'], form['courseBaseName_help']) &&
			validateNonEmptyBirthday(form['courseBaseCode'], form['courseBaseCode_help'])) {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="generic.navigation.createCourseBase" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="courseBase">
			 				<spring:url value="/settings/coursebases" var="listCourseBases" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Course Base Name" 
			 					onblur="validateNonEmptyCourseBaseName(this, document.getElementById('courseBaseName_help'))" />
								<div class="help-block with-errors">
									<span id="courseBaseName_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="courseCode" class="form-control input-lg" placeholder="Course Base Code"
			 					onblur="validateNonEmptyCourseBaseCode(this, document.getElementById('courseBaseCode_help'))" />
								<div class="help-block with-errors">
									<span id="courseBaseCode_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<form:hidden path="created" />
							
							<form:hidden path="lastModified" />
							
							<form:hidden path="creator.id" value="${pageContext.request.userPrincipal.name}" />
							
							<form:hidden path="lastModifier.id" value="${pageContext.request.userPrincipal.name}" />
			 				
			 				<div align="left" class="form-group">
								<form:label path="description"><spring:message code="settings.createCourseBase.label.description"></spring:message></form:label>
								<form:textarea path="description" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="description" />
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="courseLength.id"><spring:message code="settings.createCourseBase.label.courseLengthUnit"></spring:message></form:label>
										<form:select path="courseLength.id" class="form-control">
											<c:forEach items="${educationLengths}" var="educationLength">
												<c:choose>
													<c:when test="${not empty educationLengths}">
														<option value="${educationLength.id}">${educationLength.units}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="courseLength.id" />
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="courseLengthUnits.id"><spring:message code="settings.createCourseBase.label.courseLengthUnitName"></spring:message></form:label>
										<form:select path="courseLengthUnits.id" class="form-control">
											<c:forEach items="${educationLengths}" var="educationLength">
												<c:choose>
													<c:when test="${not empty educationLengths}">
														<option value="${educationLength.id}">${educationLength.unit.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="courseLengthUnits.id" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:input path="maxParticipationCount" class="form-control input-lg" placeholder="Maximumn Participants" />
								<form:errors class="error" path="maxParticipationCount" />
			 				</div>
							
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="album"><spring:message code="settings.createCourseBase.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listCourseBases}">
									    <div class="lsf-icon" title="list"><spring:message code="settings.createCourseBase.button.view" /></div>
									</button>
								</div>
							</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>