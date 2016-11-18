<%-- 
    Document   : show accommodation
    Created on : Oct 29, 2016
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="home"><spring:message code="students.acc.view" arguments="${room.studentId.studentId}" /></span></h3>
		 			<br />
		 				<div align="left" class="form-group">
								<label for="studentId"><spring:message code="students.acc.label.studentId"></spring:message></label>
			 					<label for="student" class="form-control">${room.studentId.studentId}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="name"><spring:message code="students.acc.label.name"></spring:message></label>
			 					<label for="student" class="form-control">${room.name}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="type"><spring:message code="students.acc.label.type"></spring:message></label>
			 					<label for="student" class="form-control">${room.type.name}</label>
							</div>
							
							<sec:authorize access="hasRole('STUDENT')">
								<spring:url value="/students/accommodation" var="backUrl" />
								<a href="${backUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${backUrl}">
								<div class="lsf-icon" title="setting"><spring:message code="students.acc.button.back" /></div></button></a>	
							</sec:authorize>
		 			</div>
		 	</div>
		 </div>
</div>