<%-- 
    Document   : create system user
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
	    			  streetAddress: {
	    				  required: true,
	    				  maxlength: 40
	    			  }, 
	    			  primaryNumber: {
	    				  required: true,
	    				  minlength: 11
	    			  }, 
	    			  primaryAddress: {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="users.addSystemUser.add" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="systemUser" id="createUserForm">
		 				<spring:url value="/users/systemusers" var="listSystemUsers" />
		 				<fieldset class="well">
		 					<legend class="well-legend"><spring:message code="users.addSystemUser.generalInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<form:input path="systemId" class="form-control input-lg" placeholder="System ID" />
								<div class="help-block with-errors">
									<form:errors class="error" path="systemId" />
								</div>
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
								<form:select path="sex"  items="${sexes}" class="form-control input-lg" placeholder="Sex"></form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="sex" />
								</div>
							</div>
		 				</fieldset>
		 				
		 				<fieldset class=" well">
		 					<legend class="well-legend"><spring:message code="users.addSystemUser.addressInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<form:input path="streetAddress" class="form-control input-lg" placeholder="Street Address" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="streetAddress" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="postalCode" class="form-control input-lg" placeholder="Postal Code" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:select path="city" items="${cities}" class="form-control input-lg" placeholder="City" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="city" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:select path="country" items="${countries}" class="form-control input-lg" placeholder="Country" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="country" />
								</div>
			 				</div>
		 				</fieldset>
		 				
		 				<fieldset class="well">
		 					<legend class="well-legend"><spring:message code="users.addSystemUser.contactInfo" /></legend>
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
		 					<legend class="well-legend"><spring:message code="users.addSystemUser.loginInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<form:input path="username" class="form-control input-lg" placeholder="Username" />
								<div class="help-block with-errors">
									<form:errors class="error" path="username" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input id="password" name="password" path="password" type="password" class="form-control input-lg" placeholder="Password" />
								<div class="help-block with-errors">
									<form:errors class="error" path="password" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input id="confirmPassword" name="confirmPassword" path="confirmPassword" type="password" class="form-control input-lg" placeholder="Confirm Password" />
								<div class="help-block with-errors">
									<form:errors class="error" path="confirmPassword" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="checkbox">
								<form:label path="secureInfo"><spring:message code="users.addSystemUser.secureInfo"></spring:message></form:label>
								<form:checkbox path="secureInfo" />
							</div>
							
							<div align="left" class="checkbox">
								<form:label path="isActive"><spring:message code="users.addSystemUser.active"></spring:message></form:label>
								<form:checkbox path="isActive" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:select path="secretQuestion" items="${questions}" class="form-control input-lg" placeholder="Secret Question" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="secretQuestion" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:input path="secretAnswer" class="form-control input-lg" placeholder="Secret Answer" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="secretAnswer" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:select path="roles" items="${roles}" multiple="true" itemValue="id" itemLabel="roleType" class="form-control input-lg" placeholder="Role" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="roles" />
								</div>
			 				</div>
							
							<div align="left" class="form-group">
								<form:label path="basicInfo"><spring:message code="users.addSystemUser.basicInfo"></spring:message></form:label>
								<form:textarea path="basicInfo" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="basicInfo" />
								</div>
							</div>
							<form:hidden path="lastLogin" />
							
							<form:hidden path="lastLogout" />
		 				</fieldset>
						
						<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="key"><spring:message code="users.addSystemUser.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listSystemUsers}">
								    <div class="lsf-icon" title="list"><spring:message code="users.addSystemUser.button.view" /></div>
								</button>
							</div>
						</div>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>