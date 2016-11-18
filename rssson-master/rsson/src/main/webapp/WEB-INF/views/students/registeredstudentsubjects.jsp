<%-- 
    Document   : registered student subjects
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
		 		<div align="left" class="col-md-10">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="students.registeredsubjects.view" /></span></h3>
		 			<br />
		 			<c:if test="${not empty courseStudents}">
		 				<c:forEach items="${courseStudents}" var="courseStudent">
		 					<h4 class="appTitle"><spring:message code="students.registeredsubjects.label.semesterone" arguments="${courseStudent.student.studentId}" /></h4>
		 				</c:forEach>
		 			</c:if>
		 			<form:form method="POST" modelAttribute="oneStudentSubjects">
		 				<c:if test="${not empty oneStudentSubjects}">
		 				<spring:url value="/students/subjects" var="listStudentSubjects" />
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
		 						<thead>
		 							<tr>
		 								<th><spring:message code="students.registeredsubjects.label.code" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.course" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.base" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.unit" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.level" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.lecturer" /></th>
		 							</tr>
		 						</thead>
			 					<c:forEach items="${oneStudentSubjects}" var="oneStudentSubject">
			 						<spring:url value="/students/subjects/register/${oneStudentSubject.id}/" var="registerStudentSubject" />
									<tr>
										<td><label for="Subject Code" class="form-control">${oneStudentSubject.subject.code}</label></td>
										<td><label for="Subject Name" class="form-control">${oneStudentSubject.subject.name}</label></td>
										<td><label for="Course Base" class="form-control">${oneStudentSubject.subject.courseBase.name}</label></td>
										<td><label for="Credit Unit" class="form-control">${oneStudentSubject.subject.creditUnit}</label></td>
										<td><label for="Academic Level" class="form-control">${oneStudentSubject.subject.academicLevel}</label></td>
										<td><label for="Course Lecturer" class="form-control">${oneStudentSubject.subject.subjectLecturer.staffMember.user.fullName}</label></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 			&nbsp;
		 			<c:if test="${not empty courseStudents}">
		 				<c:forEach items="${courseStudents}" var="courseStudent">
		 					<h4 class="appTitle"><spring:message code="students.registeredsubjects.label.semestertwo" arguments="${courseStudent.student.studentId}" /></h4>
		 				</c:forEach>
		 			</c:if>
		 			<form:form method="POST" modelAttribute="twoStudentSubjects">
		 				<c:if test="${not empty twoStudentSubjects}">
		 				<spring:url value="/students/subjects" var="listStudentSubjects" />
		 					<table width="95%" border="0" cellspacing="5" cellpadding="5">
		 						<thead>
		 							<tr>
		 								<th><spring:message code="students.registeredsubjects.label.code" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.course" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.base" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.unit" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.level" /></th>
		 								<th><spring:message code="students.registeredsubjects.label.lecturer" /></th>
		 							</tr>
		 						</thead>
			 					<c:forEach items="${twoStudentSubjects}" var="twoStudentSubject">
			 						<spring:url value="/students/subjects/register/${twoStudentSubject.id}/" var="registerStudentSubject" />
									<tr>
										<td><label for="Subject Code" class="form-control">${twoStudentSubject.subject.code}</label></td>
										<td><label for="Subject Name" class="form-control">${twoStudentSubject.subject.name}</label></td>
										<td><label for="Course Base" class="form-control">${twoStudentSubject.subject.courseBase.name}</label></td>
										<td><label for="Credit Unit" class="form-control">${twoStudentSubject.subject.creditUnit}</label></td>
										<td><label for="Academic Level" class="form-control">${twoStudentSubject.subject.academicLevel}</label></td>
										<td><label for="Course Lecturer" class="form-control">${twoStudentSubject.subject.subjectLecturer.staffMember.user.fullName}</label></td>
									</tr>
			 					</c:forEach>
			 					<tr>
			 						<td><a href="${listStudentSubjects}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${listStudentSubjects}">
							    	<div class="lsf-icon" title="album"><spring:message code="students.registeredsubjects.button.back" /></div></button></a></td>
			 					</tr>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>