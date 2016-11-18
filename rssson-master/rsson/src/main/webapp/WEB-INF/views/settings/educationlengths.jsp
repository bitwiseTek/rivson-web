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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="geo"><spring:message code="settings.eduLengths.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="eduLengths">
		 				<c:if test="${not empty eduLengths}">
		 					<table width="75%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${eduLengths}" var="eduLength">
			 						<spring:url value="/settings/educationlengths/edit/${eduLength.id}/" var="editLength" />
									<tr>
										<td><label for="units" class="form-control">${eduLength.units}</label></td>
										<td><a href="${editLength}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editLength}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.eduLengths.button.edit" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>