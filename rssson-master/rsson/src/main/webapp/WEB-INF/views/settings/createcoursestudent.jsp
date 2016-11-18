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
		 		<div align="left" class="col-md-5">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="generic.navigation.createCourseStudent" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="courseStudent">
			 				<spring:url value="/settings/coursestudents" var="listCourseStudents" />
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
			 						<div align="left" class="form-group">
					 					<form:label path="courseUser.id"><spring:message code="settings.createCourseStudent.label.courseUser"></spring:message></form:label>
										<form:select path="courseUser.id" class="form-control">
											<c:forEach items="${courseUsers}" var="courseUser">
												<c:choose>
													<c:when test="${not empty courseUsers}">
														<option value="${courseUser.id}">${courseUser.user.username}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
			 					<div class="help-block with-errors">
									<form:errors class="error" path="courseUser" />
								</div>
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="student.id"><spring:message code="settings.createCourseStudent.label.studentId"></spring:message></form:label>
										<form:select path="student.id" class="form-control">
											<c:forEach items="${students}" var="student">
												<c:choose>
													<c:when test="${not empty student}">
														<option value="${student.id}">${student.studentId}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="student" />
								</div>
							</div>
			 				
			 				<form:hidden path="enrolmentTime" />
							
							<div align="left" class="form-group">
								<form:label path="participationType"><spring:message code="settings.createCourseStudent.label.partType"></spring:message></form:label>
								<form:select path="participationType"  items="${partTypes}" class="form-control input-lg" placeholder="Participation Types"></form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="participationType" />
								</div>
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="courseEnrolmentType"><spring:message code="settings.createCourseStudent.label.enrolType"></spring:message></form:label>
								<form:select path="courseEnrolmentType"  items="${enrolmentTypes}" class="form-control input-lg" placeholder="Enrolment Types"></form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="courseEnrolmentType" />
								</div>
							</div>
							
							<div align="left" class="checkbox">
								<form:label path="lodging"><spring:message code="settings.createCourseStudent.label.lodging"></spring:message></form:label>
								<form:checkbox path="lodging" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="courseOptionality"><spring:message code="settings.createCourseStudent.label.options"></spring:message></form:label>
								<form:select path="courseOptionality"  items="${optionalities}" class="form-control input-lg" placeholder="Optionalities"></form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="courseOptionality" />
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="billingDetails.id"><spring:message code="settings.createCourseStudent.label.billing"></spring:message></form:label>
										<form:select path="billingDetails.id" class="form-control">
											<c:forEach items="${billingDetails}" var="billingDetail">
												<c:choose>
													<c:when test="${not empty billingDetails}">
														<option value="${billingDetail.id}">${billingDetail.personName.user.fullName}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<div class="help-block with-errors">
									<form:errors class="error" path="billingDetails" />
								</div>
							</div>
							
							<div align="left" class="form-group">
			 					<form:input path="lodgingFee" class="form-control input-lg" placeholder="Lodging Fee" />
								<form:errors class="error" path="lodgingFee" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="lodgingFeeCurrency"><spring:message code="settings.createCourseStudent.label.lodgingcurrency"></spring:message></form:label>
								<form:select path="lodgingFeeCurrency"  items="${currencies}" class="form-control input-lg" placeholder="Currencies"></form:select>
								<div class="help-block with-errors">
									<form:errors class="error" path="lodgingFeeCurrency" />
								</div>
							</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="room.id"><spring:message code="settings.createCourseStudent.label.room"></spring:message></form:label>
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
								<div class="help-block with-errors">
									<form:errors class="error" path="room" />
								</div>
							</div>
							
			 				<div align="left" class="form-group">
								<form:label path="additionalInfo"><spring:message code="settings.createCourseStudent.label.info"></spring:message></form:label>
								<form:textarea path="additionalInfo" class="form-control input-lg" />
								<div class="help-block with-errors">
									<form:errors class="error" path="additionalInfo" />
								</div>
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="album"><spring:message code="settings.createCourseStudent.button.save" /></div>
								</button>
								&#160;
								&#160;
								<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listCourseStudents}">
								    <div class="lsf-icon" title="list"><spring:message code="settings.createCourseStudent.button.view" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>