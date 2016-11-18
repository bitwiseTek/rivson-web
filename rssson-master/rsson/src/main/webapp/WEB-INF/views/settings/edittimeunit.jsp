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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="geo"><spring:message code="settings.editTimeUnit.view" arguments="${timeUnit.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="timeUnit">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editTimeUnit.label.name"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Unit Name" />
								<form:errors class="error" path="name" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="baseUnits"><spring:message code="settings.editTimeUnit.label.units"></spring:message></form:label>
			 					<form:input path="baseUnits" class="form-control input-lg" placeholder="Base Units" />
								<form:errors class="error" path="baseUnits" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="symbol"><spring:message code="settings.editTimeUnit.label.symbol"></spring:message></form:label>
			 					<form:input path="symbol" class="form-control input-lg" placeholder="Symbol" />
								<form:errors class="error" path="symbol" />
			 				</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editTimeUnit.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>