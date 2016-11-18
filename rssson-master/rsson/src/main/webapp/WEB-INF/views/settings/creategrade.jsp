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
		
		function validateNonEmptyGradeName(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Grade");
		}
		
		function validateNonEmptyDescr(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Description");
		}
		
		function validateNonEmptyQual(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Qualification");
		}
		
		function validateNonEmptyGPA(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a GPA");
		}
		
		function submitPage(form) {
			if (validateNonEmptySystemId(form['grade'], form['grade_help']) &&
			validateNonEmptyBirthday(form['descr'], form['descr_help'])) {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="generic.navigation.createGrade" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="grade">
			 				<spring:url value="/settings/grades" var="listGrades" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Grade" 
			 					onblur="validateNonEmptyGradeName(this, document.getElementById('grade_help'))" />
								<div class="help-block with-errors">
									<span id="grade_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="description" class="form-control input-lg" placeholder="Description"
			 					onblur="validateNonEmptyDescr(this, document.getElementById('descr_help'))" />
								<div class="help-block with-errors">
									<span id="descr_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="gradingScale.id"><spring:message code="settings.createGrade.label.scale"></spring:message></form:label>
								<form:select path="gradingScale.id" class="form-control">
									<c:forEach items="${gradingScales}" var="gradingScale">
										<c:choose>
											<c:when test="${not empty gradingScales}">
												<option value="${gradingScale.id}">${gradingScale.name}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="gradingScale.id" />
								</div>
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="qualification" class="form-control input-lg" placeholder="Qualification"
			 					onblur="validateNonEmptyQual(this, document.getElementById('qual_help'))" />
								<div class="help-block with-errors">
									<span id="qual_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="checkbox">
								<form:label path="passingGrade"><spring:message code="settings.addGrade.passing"></spring:message></form:label>
								<form:checkbox path="passingGrade" />
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="GPA" class="form-control input-lg" placeholder="GPA"
			 					onblur="validateNonEmptyGPA(this, document.getElementById('gpa_help'))" />
								<div class="help-block with-errors">
									<span id="gpa_help" class="error"></span>
								</div>
			 				</div>
		
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="album"><spring:message code="settings.addGrade.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listGrades}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.addGrade.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>