<%-- 
    Document   : student subjects
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="students.subjects.view" /></span></h3>
		 			<br />
		 			<h4 class="appTitle"><spring:message code="students.subjects.label.semesterone" /></h4>
		 			<form:form method="POST" modelAttribute="oneStudentSubjects">
		 				<c:if test="${not empty oneStudentSubjects}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
		 						<thead>
		 							<tr>
		 								<th><spring:message code="students.subjects.label.code" /></th>
		 								<th><spring:message code="students.subjects.label.course" /></th>
		 							</tr>
		 						</thead>
			 					<c:forEach items="${oneStudentSubjects}" var="oneStudentSubject">
			 						<spring:url value="/students/subjects/register/${oneStudentSubject.id}/" var="registerStudentSubject" />
									<tr>
										<td><label for="Subject Code" class="form-control">${oneStudentSubject.subject.code}</label></td>
										<td><label for="Subject Name" class="form-control">${oneStudentSubject.subject.name}</label></td>
										<td><a href="${registerStudentSubject}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${registerStudentSubject}">
							    		<div class="lsf-icon" title="setting"><spring:message code="students.subjects.button.register" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 			&nbsp;
		 			<h4 class="appTitle"><spring:message code="students.subjects.label.semestertwo" /></h4>
		 			<form:form method="POST" modelAttribute="twoStudentSubjects">
		 				<c:if test="${not empty twoStudentSubjects}">
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
		 						<thead>
		 							<tr>
		 								<th><spring:message code="students.subjects.label.code" /></th>
		 								<th><spring:message code="students.subjects.label.course" /></th>
		 							</tr>
		 						</thead>
			 					<c:forEach items="${twoStudentSubjects}" var="twoStudentSubject">
			 						<spring:url value="/students/subjects/register/${twoStudentSubject.id}/" var="registerStudentSubject" />
									<tr>
										<td><label for="Subject Code" class="form-control">${twoStudentSubject.subject.code}</label></td>
										<td><label for="Subject ID" class="form-control">${twoStudentSubject.subject.name}</label></td>
										<td><a href="${registerStudentSubject}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${registerStudentSubject}">
							    		<div class="lsf-icon" title="setting"><spring:message code="students.subjects.button.register" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>