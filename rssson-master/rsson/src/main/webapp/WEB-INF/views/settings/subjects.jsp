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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.subjects.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="subjects">
		 				<c:if test="${not empty subjects}">
		 					<table width="255%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${subjects}" var="subject">
			 						<spring:url value="/settings/subjects/edit/${subject.id}/" var="editSubject" />
									<spring:url value="/settings/subjects/delete/${subject.id}/" var="deleteSubject" />
									<tr>
										<td><label for="code" class="form-control">${subject.code}</label></td>
										<td><label for="subject" class="form-control">${subject.name}</label></td>
										<td><a href="${editSubject}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editSubject}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.subjects.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteSubject}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteSubject}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.subjects.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>