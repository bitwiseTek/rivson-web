<%-- 
    Document   : billing info
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="students.billingInfo.view.info" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="billingInfos">
		 				<c:if test="${not empty billingInfos}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${billingInfos}" var="billingInfo">
			 						<spring:url value="/students/billinginfo/show/${billingInfo.id}/" var="showBillingDet" />
			 						<c:if test="${billingInfo.studentId.user.username == pageContext.request.userPrincipal.name}">
										<tr>
											<td><label for="studentId" class="form-control">${billingInfo.studentId.studentId}</label></td>
											<td><label for="name" class="form-control">${billingInfo.personName.user.fullName}</label></td>
											<td><a href="${showBillingDet}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${showBillingDet}">
								    		<div class="lsf-icon" title="list"><spring:message code="students.billingInfo.button.view" /></div></button></a></td>
										</tr>
									</c:if>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>