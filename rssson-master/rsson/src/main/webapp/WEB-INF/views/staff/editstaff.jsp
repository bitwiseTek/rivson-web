<%-- 
    Document   : edit staff
    Created on : Sep 27, 2016
    Author     : Sika Kay
--%>

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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="staff.editStaff.view" arguments="${staff.staffId}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="staff">
		 					<input type="hidden" name="_method" value="PUT" />
		 					<div align="left" class="form-group">
			 					<form:label path="title"><spring:message code="staff.editStaff.label.title"></spring:message></form:label>
								<form:select path="title" class="form-control input-lg">
									<form:option value="${currentTitle}"></form:option>
									<form:options items="${titles}" />
								</form:select>
								<form:errors class="error" path="title" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="staffId"><spring:message code="staff.editStaff.label.staffId"></spring:message></form:label>
			 					<label for="staff" class="form-control">${staff.staffId}</label>
			 					<form:input path="staffId" class="form-control input-lg" placeholder="Staff Id" type="hidden" />
								<form:errors class="error" path="staffId" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="nationality"><spring:message code="staff.editStaff.label.nation"></spring:message></form:label>
								<form:select path="nationality" class="form-control input-lg">
									<form:option value="${currentNationality}"></form:option>
									<form:options items="${nationalities}" />
								</form:select>
								<form:errors class="error" path="nationality" />
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="stateOfOrigin"><spring:message code="staff.editStaff.label.state"></spring:message></form:label>
										<form:select path="stateOfOrigin" class="form-control input-lg">
											<form:option value="${currentState}"></form:option>
											<form:options items="${states}" />
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="stateOfOrigin" />
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="lga.id"><spring:message code="staff.editStaff.label.lga"></spring:message></form:label>
										<form:select path="lga.id" class="form-control">
											<c:forEach items="${lgas}" var="lga">
												<c:choose>
													<c:when test="${not empty lgas}">
														<option value="${lga.id}">${lga.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="lga" />
								</div>
							</div>
							
							<div align="left" class="checkbox">
			 					<form:label path="isAcademic"><spring:message code="staff.editStaff.label.academic"></spring:message></form:label>
			 					<form:checkbox path="isAcademic" />
			 				</div>
			 				
			 				<div align="left" class="checkbox">
			 					<form:label path="isTemporary"><spring:message code="staff.editStaff.label.temporary"></spring:message></form:label>
			 					<form:checkbox path="isTemporary" />
			 				</div>
							
							<div align="left" class="form-group">
								<form:label path="additionalInfo"><spring:message code="staff.editStaff.label.addinfo"></spring:message></form:label>
								<form:textarea path="additionalInfo" class="form-control input-lg" />
								<form:errors class="error" path="additionalInfo" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="user.id"><spring:message code="staff.editStaff.label.edited"></spring:message></form:label>
			 					<label for="user" class="form-control">${staff.user.username}</label>
			 					<form:input path="user.id" class="form-control input-lg" placeholder="Username" type="hidden" />
								<form:errors class="error" path="user.id" />
							</div>
							
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
								    	<div class="lsf-icon" title="setting"><spring:message code="students.editStudent.button.edit" /></div>
									</button>
								</div>
							</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>