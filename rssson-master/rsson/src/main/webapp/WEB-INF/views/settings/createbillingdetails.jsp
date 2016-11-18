<%-- 
    Document   : create billing details
    Created on : Oct, 27 2016
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="generic.navigation.createBillingDets" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="billingDets">
			 				<spring:url value="/settings/billingdetails" var="listBillingDetails" />
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
			 						<div align="left" class="form-group">
					 					<form:label path="studentId.id"><spring:message code="settings.createBillingDets.label.studentId"></spring:message></form:label>
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
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="personName.id"><spring:message code="settings.createBillingDets.label.personName"></spring:message></form:label>
										<form:select path="personName.id" class="form-control">
											<c:forEach items="${personNames}" var="personName">
												<c:choose>
													<c:when test="${not empty personNames}">
														<option value="${personName.id}">${personName.user.fullName}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="personName.id" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:input path="companyName" class="form-control input-lg" placeholder="Company Name" />
								<form:errors class="error" path="companyName" />
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="streetAddress1.id"><spring:message code="settings.createBillingDets.label.streetAddress"></spring:message></form:label>
										<form:select path="streetAddress1.id" class="form-control">
											<c:forEach items="${streetAddresses}" var="streetAddress">
												<c:choose>
													<c:when test="${not empty streetAddresses}">
														<option value="${streetAddress.id}">${streetAddress.user.streetAddress}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="streetAddress1.id" />
								</div>
							</div>
							
			 				<div align="left" class="form-group">
			 					<form:input path="streetAddress2" class="form-control input-lg" placeholder="Alternate Street Address" />
								<form:errors class="error" path="streetAddress2" />
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="postalCode.id"><spring:message code="settings.createBillingDets.label.postal"></spring:message></form:label>
										<form:select path="postalCode.id" class="form-control">
											<c:forEach items="${postalCodes}" var="postalCode">
												<c:choose>
													<c:when test="${not empty postalCodes}">
														<option value="${postalCode.id}">${postalCode.user.postalCode}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="postalCode.id" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="city.id"><spring:message code="settings.createBillingDets.label.city"></spring:message></form:label>
										<form:select path="city.id" class="form-control">
											<c:forEach items="${cities}" var="city">
												<c:choose>
													<c:when test="${not empty cities}">
														<option value="${city.id}">${city.user.city}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="city.id" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="country.id"><spring:message code="settings.createBillingDets.label.country"></spring:message></form:label>
										<form:select path="country.id" class="form-control">
											<c:forEach items="${countries}" var="country">
												<c:choose>
													<c:when test="${not empty countries}">
														<option value="${country.id}">${country.user.country}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="country.id" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="phoneNumber.id"><spring:message code="settings.createBillingDets.label.phone"></spring:message></form:label>
										<form:select path="phoneNumber.id" class="form-control">
											<c:forEach items="${phoneNumbers}" var="phoneNumber">
												<c:choose>
													<c:when test="${not empty phoneNumbers}">
														<option value="${phoneNumber.id}">${phoneNumber.user.primaryNumber}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="phoneNumber.id" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="emailAddress.id"><spring:message code="settings.createBillingDets.label.email"></spring:message></form:label>
										<form:select path="emailAddress.id" class="form-control">
											<c:forEach items="${emailAddresses}" var="emailAddress">
												<c:choose>
													<c:when test="${not empty emailAddresses}">
														<option value="${emailAddress.id}">${emailAddress.user.primaryAddress}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="emailAddress.id" />
								</div>
							</div>
							
							<div align="left" class="form-group">
								<form:label path="notes"><spring:message code="settings.createBillingDets.label.notes"></spring:message></form:label>
								<form:textarea path="notes" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="notes" />
								</div>
							</div>
							
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="album"><spring:message code="settings.createBillingDets.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listBillingDetails}">
									    <div class="lsf-icon" title="list"><spring:message code="settings.createBillingDets.button.view" /></div>
									</button>
								</div>
							</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>