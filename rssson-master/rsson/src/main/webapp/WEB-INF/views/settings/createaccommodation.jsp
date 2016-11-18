<%-- 
    Document   : create accommodation
    Created on : Oct, 29 2016
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
	    	  $("#createRoomForm").validate({
	    		  rules: {
	    			  name: {
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="home"><spring:message code="settings.createAcc.view" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="room" id="createRoomForm">
			 				<spring:url value="/settings/accommodations" var="listRooms" />
			 				<div align="left" class="form-group">
			 					<form:input path="name" class="form-control input-lg" placeholder="Room Name" />
								<div class="help-block with-errors">
									<form:errors class="error" path="name" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="type.id"><spring:message code="settings.createAcc.label.type"></spring:message></form:label>
										<form:select path="type.id" class="form-control">
											<c:forEach items="${types}" var="type">
												<c:choose>
													<c:when test="${not empty types}">
														<option value="${type.id}">${type.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="type.id" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
			 						<div align="left" class="form-group">
					 					<form:label path="studentId.id"><spring:message code="settings.createAcc.label.studentId"></spring:message></form:label>
										<form:select path="studentId.id" class="form-control">
											<c:forEach items="${studentIds}" var="studentId">
												<c:choose>
													<c:when test="${not empty studentIds}">
														<option value="${studentId.id}">${studentId.studentId}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
			 					<div class="help-block with-errors">
									<form:errors class="error" path="studentId.id" />
								</div>
			 				</div>
							
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="home"><spring:message code="settings.createAcc.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listRooms}">
									    <div class="lsf-icon" title="list"><spring:message code="settings.createAcc.button.list" /></div>
									</button>
								</div>
							</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>