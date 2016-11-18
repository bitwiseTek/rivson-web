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
		
		function validateNonEmptyUnitName(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Unit Name");
		}
		
		function validateNonEmptyBaseUnit(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Base Unit");
		}
		
		function validateNonEmptySymbol(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Symbol");
		}
		
		function submitPage(form) {
			if (validateNonEmptySystemId(form['unitName'], form['unitName_help']) &&
			validateNonEmptyBirthday(form['baseUnit'], form['baseUnit_help'])) {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="geo"><spring:message code="generic.navigation.createTimeUnits" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="timeUnit">
			 				<spring:url value="/settings/timeunits" var="listUnits" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Unit Name" 
			 					onblur="validateNonEmptyUnitName(this, document.getElementById('unitName_help'))" />
								<div class="help-block with-errors">
									<span id="unitName_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="baseUnits" class="form-control input-lg" placeholder="Base Units"
			 					onblur="validateNonEmptyBaseUnit(this, document.getElementById('baseUnit_help'))" />
								<div class="help-block with-errors">
									<span id="baseUnit_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="symbol" class="form-control input-lg" placeholder="Symbol"
			 					onblur="validateNonEmptySymbol(this, document.getElementById('symbol_help'))" />
								<div class="help-block with-errors">
									<span id="symbol_help" class="error"></span>
								</div>
			 				</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="geo"><spring:message code="settings.createTimeUnit.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listUnits}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createTimeUnit.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>