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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="category"><spring:message code="generic.navigation.createSchoolField" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="schoolField">
		 					<spring:url value="/settings/schoolfields" var="listSchoolFields" />
			 					<table width="75%" border="0" cellspacing="5" cellpadding="5">
										<tr>
											<td><form:input path="name" class="form-control input-lg" placeholder="School Field" /></td>
											<td><form:errors path="name" class="error" /></td>
								    		
											<td><button class="btn btn-magnolia" type="submit">
								    		<div class="lsf-icon" title="category"><spring:message code="settings.addSchoolField.button.add" /></div></button></td>
								    		
								    		<td><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listSchoolFields}">
										    <div class="lsf-icon" title="list"><spring:message code="settings.addSchoolField.button.view" /></div>
											</button></td>
										</tr>
			 					</table>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>