<%-- 
    Document   : register student subjects
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
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="students.registerSubject.view" arguments="${studentSubject.subject.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="studentSubject">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="subject.id"><spring:message code="students.registerSubject.label.course"></spring:message></form:label>
			 					<label for="subject" class="form-control">${studentSubject.subject.name}</label>
			 					<form:input path="subject.id" class="form-control input-lg" placeholder="Subject Name" type="hidden" />
								<form:errors class="error" path="subject.id" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="courseStudents"><spring:message code="students.registerSubject.label.studentId"></spring:message></form:label>
			 					<form:select path="courseStudents" items="${courseStudents}" multiple="true" itemValue="id" itemLabel="student.studentId" class="form-control input-lg" placeholder="Student Id" />
			 					<div class="help-block with-errors">
									<form:errors class="error" path="courseStudents" />
								</div>
			 				</div>
							
							<div align="left" class="form-group">
								<form:checkbox path="toggleOnOff" data-toggle="toggle" data-on="Registered" data-off="Unregistered" data-onstyle="warning"/>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="album"><spring:message code="students.registerSubject.button.register" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>