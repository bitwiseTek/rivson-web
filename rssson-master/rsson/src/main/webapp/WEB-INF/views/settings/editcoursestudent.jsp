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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="settings.editCourseStudent.view" arguments="${courseStudent.courseUser.user.username}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="courseStudent">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="courseUser.id"><spring:message code="settings.editCourseStudent.label.courseUser"></spring:message></form:label>
			 					<label for="courseUser" class="form-control">${courseStudent.courseUser.user.username}</label>
			 					<form:input path="courseUser.id" class="form-control input-lg" placeholder="Course Username" type="hidden" />
								<form:errors class="error" path="courseUser.id" />
							</div>
							
							<div align="left" class="form-group">
							<form:label path="student.id"><spring:message code="settings.editCourseStudent.label.studentId"></spring:message></form:label>
			 					<label for="student" class="form-control">${courseStudent.student.studentId}</label>
			 					<form:input path="student.id" class="form-control input-lg" placeholder="Student Id" type="hidden" />
								<form:errors class="error" path="student.id" />
							</div>
							
							<div align="left" class="form-group">
			 					<form:label path="enrolmentTime"><spring:message code="settings.editCourseStudent.label.enrolTime"></spring:message></form:label>
			 					<label for="enrolmentTime" class="form-control"><joda:format value="${courseStudent.enrolmentTime}" pattern="${createdDatePattern}"/></label>
								<form:errors class="error" path="enrolmentTime" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="participationType"><spring:message code="settings.editCourseStudent.label.partType"></spring:message></form:label>
								<form:select path="participationType"  items="${partTypes}" class="form-control input-lg" placeholder="Participation Types"></form:select>
								<form:errors class="error" path="participationType" />
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="courseEnrolmentType"><spring:message code="settings.editCourseStudent.label.enrolType"></spring:message></form:label>
								<form:select path="courseEnrolmentType"  items="${enrolmentTypes}" class="form-control input-lg" placeholder="Enrolment Types"></form:select>
								<form:errors class="error" path="courseEnrolmentType" />
							</div>
							
							<div align="left" class="checkbox">
								<form:label path="lodging"><spring:message code="settings.editCourseStudent.label.lodging"></spring:message></form:label>
								<form:checkbox path="lodging" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="courseOptionality"><spring:message code="settings.editCourseStudent.label.options"></spring:message></form:label>
								<form:select path="courseOptionality"  items="${optionalities}" class="form-control input-lg" placeholder="Optionalities"></form:select>
								<form:errors class="error" path="courseOptionality" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="billingDetails.id"><spring:message code="settings.editCourseStudent.label.billing"></spring:message></form:label>
			 					<label for="billing" class="form-control">${courseStudent.billingDetails.personName}</label>
			 					<form:input path="billingDetails.id" class="form-control input-lg" placeholder="Biiling" type="hidden" />
								<form:errors class="error" path="billingDetails.id" />
							</div>
							
							<div align="left" class="form-group">
							<form:label path="lodgingFee"><spring:message code="settings.editCourseStudent.label.lodging"></spring:message></form:label>
			 					<label for="lodgingFee" class="form-control">${courseStudent.lodgingFee}</label>
			 					<form:input path="lodgingFee" class="form-control input-lg" placeholder="Lodging Fee" type="hidden" />
								<form:errors class="error" path="lodgingFee" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="lodgingFeeCurrency"><spring:message code="settings.editCourseStudent.label.lodgingcurrency"></spring:message></form:label>
			 					<label for="lodgingFeeCurrency" class="form-control">${courseStudent.lodgingFeeCurrency}</label>
			 					<form:input path="lodgingFeeCurrency" class="form-control input-lg" placeholder="Lodging Fee" type="hidden" />
								<form:errors class="error" path="lodgingFeeCurrency" />
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="room.id"><spring:message code="settings.editCourseStudent.label.room"></spring:message></form:label>
										<form:select path="room.id" class="form-control">
											<c:forEach items="${rooms}" var="room">
												<c:choose>
													<c:when test="${not empty rooms}">
														<option value="${room.id}">${room.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<form:errors class="error" path="room.id" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="additionalInfo"><spring:message code="settings.editCourseStudent.label.info"></spring:message></form:label>
								<form:textarea path="additionalInfo" class="form-control input-lg" />
								<form:errors class="error" path="additionalInfo" />
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="setting"><spring:message code="settings.editCourseUser.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>