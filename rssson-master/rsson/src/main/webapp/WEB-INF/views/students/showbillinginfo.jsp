<%-- 
    Document   : show billing info
    Created on : Oct 28, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="students.billingInfo.view" arguments="${billingInfo.studentId.studentId}" /></span></h3>
		 			<br />
		 				<div align="left" class="form-group">
								<label for="studentId"><spring:message code="students.billingInfo.label.studentId"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.studentId.studentId}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="name"><spring:message code="students.billingInfo.label.personName"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.personName.user.fullName}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="postal"><spring:message code="students.billingInfo.label.postal"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.postalCode.user.postalCode}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="streetAddress"><spring:message code="students.billingInfo.label.streetAddress"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.streetAddress1.user.streetAddress}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="city"><spring:message code="students.billingInfo.label.city"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.city.user.city}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="country"><spring:message code="students.billingInfo.label.country"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.country.user.country}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="phone"><spring:message code="students.billingInfo.label.phone"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.phoneNumber.user.primaryNumber}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="email"><spring:message code="students.billingInfo.label.email"></spring:message></label>
			 					<label for="student" class="form-control">${billingInfo.emailAddress.user.primaryAddress}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="notes"><spring:message code="settings.createBillingDets.label.notes"></spring:message></label>
								<label for="student" class="form-control">${billingInfo.notes}</label>
							</div>
							
							<sec:authorize access="hasRole('STUDENT')">
								<spring:url value="/students/billinginfo" var="backUrl" />
								<a href="${backUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${backUrl}">
								<div class="lsf-icon" title="setting"><spring:message code="students.billingInfo.button.back" /></div></button></a>	
							</sec:authorize>
		 			</div>
		 	</div>
		 </div>
</div>