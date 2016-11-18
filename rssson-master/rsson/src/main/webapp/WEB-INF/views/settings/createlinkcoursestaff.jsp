<%-- 
    Document   : add link course staff
    Created on : Sep 28, 2016
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
		 		<div align="left" class="col-md-6">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="generic.navigation.createLinkCourseStaff" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="staffSubject">
			 				<spring:url value="/settings/staffsubjects" var="listLinkCourseStaff" />
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
			 						<div align="left" class="form-group">
					 					<form:label path="subject.id"><spring:message code="settings.createLinkCourseStaff.label.staffSubject"></spring:message></form:label>
										<form:select path="subject.id" class="form-control">
											<c:forEach items="${subjects}" var="subject">
												<c:choose>
													<c:when test="${not empty subjects}">
														<option value="${subject.id}">${subject.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
			 					<div class="help-block with-errors">
									<form:errors class="error" path="subject.id" />
								</div>
			 				</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="album"><spring:message code="settings.createLinkCourseStaff.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listLinkCourseStaff}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createLinkCourseStaff.button.view" /></div>
								</button>
							</div>
						``</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>