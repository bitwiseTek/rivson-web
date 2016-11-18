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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="geo"><spring:message code="settings.editEduLength.view" arguments="${eduLength.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="eduLength">
		 					<input type="hidden" name="_method" value="PUT" />
		 					<div align="left" class="form-group">
		 						<form:label path="unit"><spring:message code="settings.editEduLength.label.unit"></spring:message></form:label>
			 					<label for="unit" class="form-control">${unit.name}</label>
			 					<form:input path="unit" class="form-control input-lg" placeholder="Credit Unit" type="hidden" />
								<form:errors class="error" path="course" />
							</div>
							
			 				<div align="left" class="form-group">
			 					<form:label path="units"><spring:message code="settings.editEduLength.label.units"></spring:message></form:label>
			 					<form:input path="units" class="form-control input-lg" placeholder="Units" />
								<form:errors class="error" path="units" />
			 				</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editEduLength.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>