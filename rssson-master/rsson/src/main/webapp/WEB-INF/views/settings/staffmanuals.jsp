<%-- 
    Document   : staff manuals
    Created on : Nov, 15 2016
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.staffManuals.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="manuals">
		 				<c:if test="${not empty manuals}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${manuals}" var="manual">
			 						<spring:url value="/settings/staff/manuals/show/${manual.id}/" var="showManual" />
									<tr>
										<td><label for="manualName" class="form-control">${manual.manualName}</label></td>
										<td><label for="manualVersion" class="form-control">${manual.manualVersion}</label></td>
										<td><a href="${showManual}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${showManual}">
							    		<div class="lsf-icon" title="list"><spring:message code="settings.staffManuals.button.view" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>