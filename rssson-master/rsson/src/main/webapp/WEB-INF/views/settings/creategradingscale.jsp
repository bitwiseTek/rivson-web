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
		
		function validateNonEmptyGradingScale(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Grading Scale");
		}
		
		function validateNonEmptyDescr(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Description");
		}
		
		function submitPage(form) {
			if (validateNonEmptySystemId(form['gradingScale'], form['gradingScale_help']) &&
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="dashboard"><spring:message code="generic.navigation.createGradingScale" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="gradingScale">
			 				<spring:url value="/settings/gradingscales" var="listGradingScales" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Grading Scale" 
			 					onblur="validateNonEmptyGradingScale(this, document.getElementById('gradingScale_help'))" />
								<div class="help-block with-errors">
									<span id="gradingScale_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="description" class="form-control input-lg" placeholder="Description"
			 					onblur="validateNonEmptyDescr(this, document.getElementById('descr_help'))" />
								<div class="help-block with-errors">
									<span id="descr_help" class="error"></span>
								</div>
			 				</div>
		
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="dashboard"><spring:message code="settings.addGradingScale.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listGradingScales}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.addGradingScale.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>