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
		 		<div align="left" class="col-md-5">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="dashboard"><spring:message code="settings.gradingScales.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="gradingScales">
		 				<c:if test="${not empty gradingScales}">
		 					<table width="75%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${gradingScales}" var="gradingScale">
			 						<spring:url value="/settings/gradingScales/edit/${gradingScale.id}/" var="editScale" />
									<spring:url value="/settings/gradingScales/delete/${gradingScale.id}/" var="deleteScale" />
									<tr>
										<td><label for="name" class="form-control">${gradingScale.name}</label></td>
										<td><a href="${editScale}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editScale}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.gradingScales.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteScale}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteScale}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.gradingScales.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>