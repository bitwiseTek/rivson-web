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
		
		function validateNonEmptyProgrammeName(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Programme Name");
		}
		
		function validateNonEmptyProgrammeCode(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a Programme Code");
		}

		function submitPage(form) {
			if (validateNonEmptySystemId(form['programmeName'], form['programmeName_help']) &&
					validateNonEmptyBirthday(form['programmeCode'], form['programmeCode_help'])) {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="menu"><spring:message code="settings.createStudyProgramme.view" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="programme">
			 				<spring:url value="/settings/studyprogrammes" var="listProgrammes" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Study Programme Name" 
			 					onblur="validateNonEmptyProgrammeName(this, document.getElementById('programmeName_help'))" />
								<div class="help-block with-errors">
									<span id="programmeName_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="code" class="form-control input-lg" placeholder="Study Programme Code" 
			 					onblur="validateNonEmptyProgrammeCode(this, document.getElementById('programmeCode_help'))" />
								<div class="help-block with-errors">
									<span id="programmeCode_help" class="error"></span>
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="category.id"><spring:message code="settings.createStudyProgramme.label.category"></spring:message></form:label>
										<form:select path="category.id" class="form-control">
											<c:forEach items="${categories}" var="category">
												<c:choose>
													<c:when test="${not empty categories}">
														<option value="${category.id}">${category.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="category" />
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="menu"><spring:message code="settings.createStudyProgramme.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listProgrammes}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createStudyProgramme.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>