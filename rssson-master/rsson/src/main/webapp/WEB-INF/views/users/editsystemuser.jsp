<%-- 
    Document   : edit system user
    Created on : Jul 12, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<spring:message code="created.date.pattern" var="createdDatePattern" />

<script type="text/javascript">
		$(document).ready(function() {
	    	  $("#createUserForm").validate({
	    		  rules: {
	    			  systemId: {
	    				  required: true,
	    				  maxlength: 14
	    			  }, 
	    			  firstName: {
	    				  required: true,
	    				  maxlength: 25
	    			  }, 
	    			  lastName: {
	    				  required: true,
	    				  maxlength: 20
	    			  }, 
	    			  middleName: {
	    				  required: true,
	    				  maxlength: 20
	    			  }, 
	    			  birthday: {
	    				  required: true,
	    				  date: true
	    			  }, 
	    			  phoneNumber: {
	    				  required: true,
	    				  minlength: 11
	    			  }, 
	    			  email: {
	    				  required: true,
	    				  email: true
	    			  }, 
	    			  username: {
	    				  required: true,
	    				  maxlength: 10
	    			  }, 
	    			  password: {
	    				  required: true,
	    				  minlength: 8
	    			  }, 
	    			  confirmPassword: {
	    				  required: true,
	    				  minlength: 8,
	    				  equalTo: "#password"
	    			  }, 
	    			  secretAnswer: {
	    				  required: true,
	    				  maxlength: 20
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="users.editSystemUser.edit" arguments="${systemUser.username}" /></span></h3>
		 			<br />
		 			<form:form method="PUT" modelAttribute="systemUser" id="editSystemUser">
		 				<input type="hidden" name="_method" value="PUT" />
		 				<fieldset class="well">
		 					<legend class="well-legend"><spring:message code="users.editSystemUser.generalInfo" /></legend>
		 					<div align="left" class="form-group">
		 						<label for="systemId" class="form-control">${systemUser.systemId}</label>
			 					<form:input path="systemId" class="form-control input-lg" placeholder="System ID" type="hidden" />
			 				</div>
			 				<div align="left" class="form-group">
			 					<form:input path="firstName" class="form-control input-lg" placeholder="First Name" />
								<div class="help-block with-errors">
									<form:errors class="error" path="firstName" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="lastName" class="form-control input-lg" placeholder="Last Name" />
								<div class="help-block with-errors">
									<form:errors class="error" path="lastName" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="middleName" class="form-control input-lg" placeholder="Middle Name" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="middleName" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input id="birthday" path="birthday" class="form-control input-lg" placeholder="Birthday (YY-MM-DD)" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="birthday" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
								<form:select path="sex" class="form-control input-lg">
									<form:option value="${currentSex}"></form:option>
									<form:options items="${sexes}" />
								</form:select>
								<form:errors class="error" path="sex" />
							</div>
			 				
			 				<div align="left" class="checkbox">
								<form:label path="secureInfo"><spring:message code="users.editSystemUser.secureInfo"></spring:message></form:label>
								<form:checkbox path="secureInfo" />
							</div>
							
							<div align="left" class="checkbox">
								<form:label path="isActive"><spring:message code="users.editSystemUser.active"></spring:message></form:label>
								<form:checkbox path="isActive" />
							</div>
		 				</fieldset>
		 				
		 				<fieldset class=" well">
		 					<legend class="well-legend"><spring:message code="users.editSystemUser.addressInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<form:input path="streetAddress" class="form-control input-lg" placeholder="Street Address" />
			 					<form:errors class="error" path="streetAddress" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="postalCode" class="form-control input-lg" placeholder="Postal Code" />
			 					<form:errors class="error" path="postalCode" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:select path="city" class="form-control input-lg">
									<form:option value="${currentCity}"></form:option>
									<form:options items="${cities}" />
								</form:select>
			 					<form:errors class="error" path="city" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:select path="country" class="form-control input-lg">
									<form:option value="${currentCountry}"></form:option>
									<form:options items="${countries}" />
								</form:select>
			 					<form:errors class="error" path="country" />
			 				</div>
		 				</fieldset>
		 				
		 				<fieldset class="well">
		 					<legend class="well-legend"><spring:message code="users.editSystemUser.contactInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<form:input id="primaryNumber" path="primaryNumber" class="form-control input-lg" placeholder="Primary Phone Number" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="primaryNumber" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="secondaryNumber" class="form-control input-lg" placeholder="Alternative Phone Number" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="secondaryNumber" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="primaryAddress" class="form-control input-lg" placeholder="Primary Email Address" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="primaryAddress" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="secondaryAddress" class="form-control input-lg" placeholder="Alternative Email Address" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="secondaryAddress" />
								</div>
			 				</div>
			 			</fieldset>
			 			
			 			<fieldset class="well">
			 				<legend class="well-legend"><spring:message code="users.editSystemUser.loginInfo" /></legend>
			 				<div align="left" class="form-group">
			 					<label for="username" class="form-control">${systemUser.username}</label>
			 					<form:input path="username" class="form-control input-lg" placeholder="Username" type="hidden" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:password id="password" name="password" path="password" class="form-control input-lg" placeholder="Password" />
								<div class="help-block with-errors">
									<form:errors class="error" path="password" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:password id="confirmPassword" name="confirmPassword" path="confirmPassword" class="form-control input-lg" placeholder="Confirm Password" />
								<div class="help-block with-errors">
									<form:errors class="error" path="confirmPassword" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:select path="secretQuestion" class="form-control input-lg">
									<form:option value="${currentQuestion}"></form:option>
									<form:options items="${questions}" />
								</form:select>
			 					<form:errors class="error" path="secretQuestion" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="secretAnswer" class="form-control input-lg" placeholder="Secret Answer" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="secretAnswer" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="lastLogin" class="control-label"><spring:message code="users.editSystemUser.label.login"></spring:message></label>
			 					<label for="lastLogin" class="form-control"><joda:format value="${user.lastLogin}" pattern="${createdDatePattern}"/></label>
							</div>
			 			</fieldset>
						
						<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="users.editSystemUser.button.edit" /></div>
								</button>
							</div>
						</div>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>