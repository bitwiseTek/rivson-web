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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="menu"><spring:message code="settings.studyprogrammes.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="programmes">
		 				<c:if test="${not empty programmes}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${programmes}" var="programme">
			 						<spring:url value="/settings/studyprogrammes/edit/${programme.id}/" var="editProgramme" />
									<spring:url value="/settings/studyprogrammes/delete/${programme.id}/" var="deleteProgramme" />
									<tr>
										<td><label for="name" class="form-control">${programme.name}</label></td>
										<td><a href="${editProgramme}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editProgramme}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.studyprogrammes.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteProgramme}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteProgramme}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.studyprogrammes.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>