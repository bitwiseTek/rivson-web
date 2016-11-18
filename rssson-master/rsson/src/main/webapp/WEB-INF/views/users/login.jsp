<%-- 
    Document   : login
    Created on : Jul 09, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

    
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
		
		function validateNonEmptyUsername(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a username");
		}
		
		function validateNonEmptyPassword(inputField, helpText) {
			return validateRegEx(/.+/, inputField.value, helpText, "Please enter a password");
		}
		
		function submitPage(form) {
			if (validateNonEmptyUsername(form['username'], form['username_help']) &&
			validateNonEmptyPassword(form['password'], form['password_help'])) {
				form.submit();
			} else {
				alert("Sorry but the information provided in your form is insufficient");
			}
		}
</script>

 <div class="well-lg2">
 	<div align="center" class="container main_content">
	 	<div class="row">
			<spring:url value="/j_spring_security_check" var="logIn"></spring:url>
			<spring:url value="/forgotPassword" var="forgotPass"></spring:url>
	 		<div class="col-md-5 hidden-sm hidden-xs"></div>
	 		<div align="center" class="col-md-5">
	 			<h3 align="left"><span class="lsf-icon" title="user"><spring:message code="users.login.pageTitle" /></span></h3>
	 			<br />
	 			<form name="logInForm" method="POST" action="${logIn}">
	 				<div align="left" class="form-group">
	 					<label for="username" class="control-label"><spring:message code="users.login.usernameTitle" /></label>
						<input type="text" id="username" name="username" class="form-control input-lg" placeholder="Username"
						onblur="validateNonEmptyUsername(this, document.getElementById('username_help'))" />
						<div class="help-block with-errors">
							<span id="username_help" class="error"></span>
						</div>
	 				</div>
	 				
	 				<div align="left" class="form-group">
	 					<label for="password" class="control-label"><spring:message code="users.login.passwordTitle" /></label>
						<input type="password" id="password" name="password" class="form-control input-lg" placeholder="Password"
						onblur="validateNonEmptyPassword(this, document.getElementById('password_help'))" />
						<div class="help-block with-errors">
							<span id="password_help" class="error"></span>
						</div>
	 				</div>
					
					<div class="row">
						<div align="left" class="col-md-5">
							<button class="btn btn-magnolia">
							    <div class="lsf-icon" title="key"><spring:message code="users.login.loginButton" /></div>
							</button>
						</div>
						<div class="col-md-9">
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<spring:message code="users.login.loginFailed" />
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-success">
									<spring:message code="users.login.loggedOut" />
								</div>
							</c:if>
						</div>
					</div>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	 			</form>
	 		</div>
	 		<div class="col-md-5 hidden-sm hidden-xs"></div>
	 	</div>
	 </div>
 </div>