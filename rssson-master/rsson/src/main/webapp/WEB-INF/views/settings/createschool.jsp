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
		
		function validateNonEmptySchoolName(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a School Name");
		}
		
		function validateNonEmptySchoolCode(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a School Code");
		}
		
		function submitPage(form) {
			if (validateNonEmptySystemId(form['schoolName'], form['schoolName_help']) &&
			validateNonEmptyBirthday(form['schoolCode'], form['schoolCode_help'])) {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="category"><spring:message code="generic.navigation.createSchool" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="school">
			 				<spring:url value="/settings/schools" var="listSchools" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="School Name" 
			 					onblur="validateNonEmptySchoolName(this, document.getElementById('schoolName_help'))" />
								<div class="help-block with-errors">
									<span id="schoolName_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="code" class="form-control input-lg" placeholder="School Code"
			 					onblur="validateNonEmptySchoolCode(this, document.getElementById('schoolCode_help'))" />
								<div class="help-block with-errors">
									<span id="schoolCode_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="field.id"><spring:message code="settings.createSchool.fieldTitle"></spring:message></form:label>
								<form:select path="field.id" class="form-control">
									<c:forEach items="${schoolFields}" var="schoolField">
										<c:choose>
											<c:when test="${not empty schoolFields}">
												<option value="${schoolField.id}">${schoolField.name}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="field.id" />
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="category"><spring:message code="settings.createSchool.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listSchools}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createSchool.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>