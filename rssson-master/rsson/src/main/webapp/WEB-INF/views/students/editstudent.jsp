<%-- 
    Document   : edit student
    Created on : Jul 13, 2016
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="students.editStudent.view" arguments="${student.studentId}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="student">
		 					<input type="hidden" name="_method" value="PUT" />
							<div align="left" class="form-group">
								<form:label path="studentId"><spring:message code="students.editStudent.label.studentId"></spring:message></form:label>
			 					<label for="student" class="form-control">${student.studentId}</label>
			 					<form:input path="studentId" class="form-control input-lg" placeholder="Student Id" type="hidden" />
								<form:errors class="error" path="studentId" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="nickname"><spring:message code="students.editStudent.label.nickname"></spring:message></form:label>
								<form:input path="nickname" class="form-control input-lg" placeholder="Nickname" />
								<form:errors class="error" path="nickname" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="nationality"><spring:message code="students.editStudent.label.nation"></spring:message></form:label>
								<form:select path="nationality" class="form-control input-lg">
									<form:option value="${currentNationality}"></form:option>
									<form:options items="${nationalities}" />
								</form:select>
								<form:errors class="error" path="nationality" />
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="stateOfOrigin"><spring:message code="students.editStudent.label.state"></spring:message></form:label>
										<form:select path="stateOfOrigin" items="${states}" class="form-control input-lg" placeholder="State of Origin"/>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="stateOfOrigin" />
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="lga.id"><spring:message code="students.editStudent.label.lga"></spring:message></form:label>
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
														
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="activityType.id"><spring:message code="students.editStudent.label.activity"></spring:message></form:label>
										<form:select path="activityType.id" class="form-control">
											<c:forEach items="${activities}" var="activity">
												<c:choose>
													<c:when test="${not empty activities}">
														<option value="${activity.id}">${activity.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="activityType" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="examinationType.id"><spring:message code="students.editStudent.label.exam"></spring:message></form:label>
										<form:select path="examinationType.id" class="form-control">
											<c:forEach items="${examTypes}" var="examType">
												<c:choose>
													<c:when test="${not empty examTypes}">
														<option value="${examType.id}">${examType.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<form:errors class="error" path="examinationType" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="educationalLevel.id"><spring:message code="students.editStudent.label.education"></spring:message></form:label>
			 					<label for="educationalLevel" class="form-control">${student.educationalLevel.name}</label>
			 					<form:input path="educationalLevel.id" class="form-control input-lg" placeholder="Educational Level" type="hidden" />
								<form:errors class="error" path="educationalLevel.id" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="studyTimeEnd"><spring:message code="students.editStudent.label.studyend"></spring:message></form:label>
			 					<form:input id="birthday" path="studyTimeEnd" class="form-control input-lg" placeholder="Actual End of Study" />
								<form:errors class="error" path="studyTimeEnd" />
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="studyProgramme.id"><spring:message code="students.editStudent.label.programme"></spring:message></form:label>
										<form:select path="studyProgramme.id" class="form-control">
											<c:forEach items="${programmes}" var="programme">
												<c:choose>
													<c:when test="${not empty programmes}">
														<option value="${programme.id}">${programme.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<form:errors class="error" path="studyProgramme" />
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="previousStudies"><spring:message code="students.editStudent.label.previous"></spring:message></form:label>
			 					<label for="previousStudies" class="form-control">${student.previousStudies}</label>
			 					<form:input path="previousStudies" class="form-control input-lg" placeholder="Previous Studies" type="hidden"/>
								<form:errors class="error" path="previousStudies" />
			 				</div>
							
							<div align="left" class="checkbox">
								<form:label path="lodging"><spring:message code="students.editStudent.label.accommodation"></spring:message></form:label>
								<form:checkbox path="lodging" />
							</div>
							
							<div align="left" class="form-group">
			 					<label for="studyStartDate" class="control-label"><spring:message code="students.editStudent.label.start"></spring:message></label>
			 					<label for="studyStartDate" class="form-control"><joda:format value="${student.studyStartDate}" pattern="${createdDatePattern}"/></label>
							</div>
							
							<div align="left" class="form-group">
			 					<label for="studyEndDate" class="control-label"><spring:message code="students.editStudent.label.end"></spring:message></label>
			 					<label for="studyEndDate" class="form-control"><joda:format value="${student.studyEndDate}" pattern="${createdDatePattern}"/></label>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="studyEndReason.id"><spring:message code="students.editStudent.label.endreason"></spring:message></form:label>
										<form:select path="studyEndReason.id" class="form-control">
											<c:forEach items="${endReasons}" var="endReason">
												<c:choose>
													<c:when test="${not empty endReasons}">
														<option value="${endReason.id}">${endReason.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<form:errors class="error" path="studyEndReason.id" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="studyEndText"><spring:message code="students.editStudent.label.endtext"></spring:message></form:label>
								<form:textarea path="studyEndText" class="form-control input-lg" />
								<form:errors class="error" path="studyEndText" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="additionalInfo"><spring:message code="students.editStudent.label.addinfo"></spring:message></form:label>
								<form:textarea path="additionalInfo" class="form-control input-lg" />
								<form:errors class="error" path="additionalInfo" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="user.id"><spring:message code="students.editStudent.label.edited"></spring:message></form:label>
			 					<label for="user" class="form-control">${student.user.username}</label>
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