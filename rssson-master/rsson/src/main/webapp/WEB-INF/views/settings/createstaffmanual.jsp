<%-- 
    Document   : create staff manual
    Created on : Nov 15, 2016
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
	  $("#createStaffManualForm").validate({
		  rules: {
			  manualName: {
				  required: true,
				  maxlength: 14
			  }, 
			  manualVersion: {
				  required: true, 
				  maxLength: 10
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.addStaffManual.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="manual" id="createStaffManualForm">
		 				<spring:url value="/settings/staff/manuals" var="listStaffManuals" />
		 					<div align="left" class="form-group">
			 					<form:input path="manualName" class="form-control input-lg" placeholder="Name" />
								<div class="help-block with-errors">
									<form:errors class="error" path="manualName" />
								</div>
			 				</div>
			 				<div align="left" class="form-group">
			 					<form:input path="manualVersion" class="form-control input-lg" placeholder="Version" />
								<div class="help-block with-errors">
									<form:errors class="error" path="manualVersion" />
								</div>
			 				</div>
						
							<div class="row">
								<div align="left" class="col-md-6">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="album"><spring:message code="settings.addStaffManual.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listStaffManuals}">
									    <div class="lsf-icon" title="list"><spring:message code="settings.addStaffManual.button.view" /></div>
									</button>
								</div>
						</div>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>