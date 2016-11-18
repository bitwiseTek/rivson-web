<%-- 
    Document   : billing details
    Created on : Oct, 28 2016
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
		 		<div align="left" class="col-md-6">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.billingDets.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="billingDets">
		 				<c:if test="${not empty billingDets}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${billingDets}" var="billingDet">
			 						<spring:url value="/students/billinginfo/show/${billingDet.id}/" var="showBillingDet" />
									<tr>
										<td><label for="studentId" class="form-control">${billingDet.studentId.studentId}</label></td>
										<td><label for="name" class="form-control">${billingDet.personName.user.fullName}</label></td>
										<td><a href="${showBillingDet}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${showBillingDet}">
							    		<div class="lsf-icon" title="list"><spring:message code="settings.billingDets.button.view" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>