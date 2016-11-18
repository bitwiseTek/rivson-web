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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.grades.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="grades">
		 				<c:if test="${not empty grades}">
		 					<table width="75%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${grades}" var="grade">
			 						<spring:url value="/settings/grades/edit/${grade.id}/" var="editGrade" />
									<tr>
										<td><label for="name" class="form-control">${grade.name}</label></td>
										<td><label for="description" class="form-control">${grade.description}</label></td>
										<td><a href="${editGrade}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editGrade}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.grades.button.edit" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>