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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="category"><spring:message code="settings.editSchool.view" arguments="${school.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="school">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editSchool.nameTitle"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="School Name" />
								<form:errors class="error" path="name" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="code"><spring:message code="settings.editSchool.codeTitle"></spring:message></form:label>
			 					<form:input path="code" class="form-control input-lg" placeholder="School Code" />
								<form:errors class="error" path="code" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="field.id"><spring:message code="settings.editSchool.fieldTitle"></spring:message></form:label>
								<form:select path="field.id" class="form-control">
									<c:forEach items="${schoolFields}" var="schoolField">
										<c:choose>
											<c:when test="${not empty schoolFields}">
												<option value="${schoolField.id}">${schoolField.name}</option>
											</c:when>
										</c:choose>
									</c:forEach>
								</form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="field.id" />
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editSchool.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>