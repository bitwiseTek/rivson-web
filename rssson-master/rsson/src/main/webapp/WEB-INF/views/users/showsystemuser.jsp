<%-- 
    Document   : show system user
    Created on : Sep 14, 2016
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

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-5">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="users.showSystemUser.show" arguments="${systemUser.username}" /></span></h3>
		 			<br />
		 			<fieldset class="well">
		 					<legend class="well-legend"><spring:message code="users.showSystemUser.generalInfo" /></legend>
		 					<div align="left" class="form-group">
		 						<label for="systemId" class="form-control">${systemUser.systemId}</label>
			 				</div>
			 				<div align="left" class="form-group">
			 					<label for="firstName" class="form-control">${systemUser.firstName}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="lastName" class="form-control">${systemUser.lastName}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="middleName" class="form-control">${systemUser.middleName}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="birthday" class="form-control">${systemUser.birthday}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
								<label for="sex" class="form-control">${systemUser.sex}</label>
							</div>
		 				</fieldset>
		 				
		 				<fieldset class=" well">
		 					<legend class="well-legend"><spring:message code="users.showSystemUser.addressInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<label for="streetAddress" class="form-control">${systemUser.streetAddress}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="postalCode" class="form-control">${systemUser.postalCode}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="city" class="form-control">${systemUser.city}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="country" class="form-control">${systemUser.country}</label>
			 				</div>
		 				</fieldset>
		 				
		 				<fieldset class="well">
		 					<legend class="well-legend"><spring:message code="users.showSystemUser.contactInfo" /></legend>
		 					<div align="left" class="form-group">
			 					<label for="phonePrimary" class="form-control">${systemUser.primaryNumber}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="phoneSecondary" class="form-control">${systemUser.secondaryNumber}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="emailPrimary" class="form-control">${systemUser.primaryAddress}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="emailSecondary" class="form-control">${systemUser.secondaryAddress}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="username" class="form-control">${systemUser.username}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="lastLogin" class="form-control"><joda:format value="${systemUser.lastLogin}" pattern="${createdDatePattern}"/></label>
			 				</div>
		 				</fieldset>
						
						<sec:authorize access="hasRole('STUDENT') or hasRole('LECTURER') or hasRole('MANAGER')">
							<spring:url value="/users/profile" var="backUrl" />
							<a href="${backUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${backUrl}">
							<div class="lsf-icon" title="setting"><spring:message code="users.showSystemUser.button.back" /></div></button></a>	
						</sec:authorize>
						
						<sec:authorize access="hasRole('ADMINISTRATOR') or hasRole('SUPER_ADMIN')">
							<spring:url value="/users/systemusers/edit/${user.id}/" var="editUrl" />
							<spring:url value="/users/systemusers/delete/${user.id}/" var="deleteUrl" />
							<a href="${editUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editUrl}">
							<div class="lsf-icon" title="setting"><spring:message code="users.showSystemUser.button.edit" /></div></button></a> |		
							<a href="${deleteUrl}"><button class="btn btn-danger" type="submit" formmethod="get" formaction="${deleteUrl}">
							<div class="lsf-icon" title="trash"><spring:message code="users.showSystemUser.button.delete" /></div></button></a>		
						</sec:authorize>
		 		</div>
		 	</div>
		 </div>
</div>