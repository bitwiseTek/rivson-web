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
		
		function validateNonEmptyUnits(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter Units");
		}
		
		function submitPage(form) {
			if (validateNonEmptyUnits(form['unitsName'], form['unitsName_help'])) {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="geo"><spring:message code="generic.navigation.createEducationLength" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="eduLength">
			 				<spring:url value="/settings/eductionlengths" var="listEduLengths" />
			 				<div align="left" class="form-group">
			 					<form:input path="units" class="form-control input-lg" placeholder="Units" 
			 					onblur="validateNonEmptyUnits(this, document.getElementById('unitsName_help'))" />
								<div class="help-block with-errors">
									<span id="unitsName_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
								<div align="left" class="col-md-5">
					 				<div align="left" class="form-group">
					 					<form:label path="unit.id"><spring:message code="settings.createEduLength.label.units"></spring:message></form:label>
					 					<form:select path="unit.id" class="form-control">
											<c:forEach items="${units}" var="unit">
												<c:choose>
													<c:when test="${not empty units}">
														<option value="${unit.id}">${unit.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
										<form:errors class="error" path="unit" />
									</div>
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="geo"><spring:message code="settings.createEduLength.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listEduLengths}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createEduLength.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>