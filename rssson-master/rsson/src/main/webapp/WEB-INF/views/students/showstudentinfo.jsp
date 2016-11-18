<%-- 
    Document   : show student info
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
<%@ taglib prefix="joda" uri="http://www.joda.org/joda/time/tags" %>

<spring:message code="created.date.pattern" var="createdDatePattern" />

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="students.showStudent.view" arguments="${student.studentId}" /></span></h3>
		 			<br />
		 				<div align="left" class="form-group">
								<label for="studentId"><spring:message code="students.showStudent.label.studentId"></spring:message></label>
			 					<label for="student" class="form-control">${student.studentId}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="nickname"><spring:message code="students.showStudent.label.nickname"></spring:message></label>
								<label for="nickname" class="form-control">${student.nickname}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="nationality"><spring:message code="students.showStudent.label.nation"></spring:message></label>
								<label for="nationality" class="form-control">${student.nationality}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="stateOfOrigin"><spring:message code="students.showStudent.label.state"></spring:message></label>
								<label for="stateOfOrigin" class="form-control">${student.stateOfOrigin}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="lga"><spring:message code="students.showStudent.label.lga"></spring:message></label>
								<label for="lga" class="form-control">${student.lga.name}</label>
								<form:errors class="error" path="lga" />
							</div>
							
							<div align="left" class="form-group">
								<label for="activityType"><spring:message code="students.showStudent.label.activity"></spring:message></label>
			 					<label for="activityType" class="form-control">${student.activityType.name}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="examinationType"><spring:message code="students.showStudent.label.exam"></spring:message></label>
								<label for="examinationType" class="form-control">${student.examinationType.name}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="educationalLevel"><spring:message code="students.showStudent.label.education"></spring:message></label>
			 					<label for="educationalLevel" class="form-control">${student.educationalLevel.name}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="studyTimeEnd"><spring:message code="students.showStudent.label.studyend"></spring:message></label>
			 					<label for="studyTimeEnd" class="form-control">${student.studyTimeEnd}</label>
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="studyProgramme"><spring:message code="students.showStudent.label.programme"></spring:message></label>
			 					<label for="studyProgramme" class="form-control">${student.studyProgramme.name}</label>
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<label for="previousStudies"><spring:message code="students.showStudent.label.previous"></spring:message></label>
			 					<label for="previousStudies" class="form-control">${student.previousStudies}</label>
			 				</div>
							
							<div align="left" class="form-group">
			 					<label for="studyStartDate" class="control-label"><spring:message code="students.showStudent.label.start"></spring:message></label>
			 					<label for="studyStartDate" class="form-control"><joda:format value="${student.studyStartDate}" pattern="${createdDatePattern}"/></label>
							</div>
							
							<div align="left" class="form-group">
			 					<label for="studyEndDate" class="control-label"><spring:message code="students.showStudent.label.end"></spring:message></label>
			 					<label for="studyEndDate" class="form-control"><joda:format value="${student.studyEndDate}" pattern="${createdDatePattern}"/></label>
							</div>
							
							<div align="left" class="form-group">
								<label for="studyEndReason"><spring:message code="students.showStudent.label.endreason"></spring:message></label>
			 					<label for="studyEndReason" class="form-control">${student.studyEndReason.name}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="studyEndText"><spring:message code="students.showStudent.label.endtext"></spring:message></label>
								<label for="studyEndText" class="form-control">${student.studyEndText}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="additionalInfo"><spring:message code="students.showStudent.label.addinfo"></spring:message></label>
								<label for="additionalInfo" class="form-control">${student.additionalInfo}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="images"><spring:message code="students.showStudent.label.image" /></label>
								<c:if test="${not empty student.images}">
									<c:forEach items="${student.images}" var="image">
										<a href="/rssson//students/show/filedownload/student/${image.id}" target="_blank"><img src="/rssson/students/show/filedownload/student/${image.id}" alt="Student Image" class="img-thumbnail" width="304" height="236" /></a><br />
									</c:forEach>
								</c:if>
							</div>
							
							<div align="left" class="form-group">
			 					<label for="user"><spring:message code="students.showStudent.label.username"></spring:message></label>
			 					<label for="user" class="form-control">${student.user.username}</label>
							</div>
							
							<sec:authorize access="hasRole('STUDENT')">
								<spring:url value="/students/studentinfo" var="backUrl" />
								<a href="${backUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${backUrl}">
								<div class="lsf-icon" title="setting"><spring:message code="students.showStudent.button.back" /></div></button></a>			
							</sec:authorize>
		 			</div>
		 	</div>
		 </div>
</div>