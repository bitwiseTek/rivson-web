<%-- 
    Document   : add staff
    Created on : Sep 27, 2016
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
	  $("#createStaffForm").validate({
		  rules: {
			  staffId: {
				  required: true,
				  maxlength: 14
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="staff.addStaff.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="staff" id="createStaffForm">
		 				<spring:url value="/staff" var="listStaff" />
		 					<div align="left" class="form-group">
			 					<form:label path="title"><spring:message code="staff.addStaff.label.title"></spring:message></form:label>
								<form:select path="title"  items="${titles}" class="form-control input-lg" placeholder="Title"></form:select>
								<form:errors class="error" path="title" />
							</div>
							
		 					<div align="left" class="form-group">
			 					<form:input path="staffId" class="form-control input-lg" placeholder="Staff ID" />
								<div class="help-block with-errors">
									<form:errors class="error" path="staffId" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="nationality"><spring:message code="staff.addStaff.label.nation"></spring:message></form:label>
								<form:select path="nationality"  items="${nationalities}" class="form-control input-lg" placeholder="Nationality"></form:select>
								<form:errors class="error" path="nationality" />
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="stateOfOrigin"><spring:message code="staff.addStaff.label.state"></spring:message></form:label>
										<form:select path="stateOfOrigin" items="${states}" class="form-control input-lg" placeholder="State of Origin" />
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="stateOfOrigin" />
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="lga.id"><spring:message code="staff.addStaff.label.lga"></spring:message></form:label>
										<form:select path="lga.id" class="form-control">
											<c:forEach items="${lgas}" var="lga">
												<c:choose>
													<c:when test="${not empty lgas}">
														<option value="${lga.id}">${lga.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="lga" />
								</div>
							</div>
			 				
			 				<div align="left" class="checkbox">
			 					<form:label path="isAcademic"><spring:message code="staff.addStaff.label.academic"></spring:message></form:label>
			 					<form:checkbox path="isAcademic" />
			 				</div>
			 				
			 				<div align="left" class="checkbox">
			 					<form:label path="isTemporary"><spring:message code="staff.addStaff.label.temporary"></spring:message></form:label>
			 					<form:checkbox path="isTemporary" />
			 				</div>
							
							<div align="left" class="form-group">
								<form:label path="additionalInfo"><spring:message code="staff.addStaff.label.addinfo"></spring:message></form:label>
								<form:textarea path="additionalInfo" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="additionalInfo" />
								</div>
							</div>
		 				
		 					<div align="left" class="row">
			 					<div align="left" class="col-md-7">
					 				<div align="left" class="form-group">
					 					<form:label path="user.id"><spring:message code="staff.addStaff.label.username"></spring:message></form:label>
										<form:select path="user.id" class="form-control">
											<c:forEach items="${users}" var="user">
												<c:choose>
													<c:when test="${not empty users}">
														<option value="${user.id}">${user.username}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="user" />
								</div>
							</div>
		 				
						
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="key"><spring:message code="staff.addStaff.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listStaff}">
									    <div class="lsf-icon" title="list"><spring:message code="staff.addStaff.button.view" /></div>
									</button>
								</div>
						</div>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>