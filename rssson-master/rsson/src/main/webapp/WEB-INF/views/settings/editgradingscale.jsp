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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="dashboard"><spring:message code="settings.editGradingScale.view" arguments="${gradingScale.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="gradingScale">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editGradingScale.label.scale"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Grading Scale" />
								<form:errors class="error" path="name" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="description"><spring:message code="settings.editGradingScale.label.descr"></spring:message></form:label>
			 					<form:input path="description" class="form-control input-lg" placeholder="Description" />
								<form:errors class="error" path="description" />
			 				</div>
		
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editGradingScale.button.save" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>