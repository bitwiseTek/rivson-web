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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.editCourse.view" arguments="${course.name}" /></span></h3>
		 			<br />
		 				<form:form method="PUT" modelAttribute="course">
		 					<input type="hidden" name="_method" value="PUT" />
			 				<div align="left" class="form-group">
			 					<form:label path="name"><spring:message code="settings.editCourse.label.course"></spring:message></form:label>
			 					<form:input path="name" class="form-control input-lg" placeholder="Course Name" />
								<form:errors path="name" class="error" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="module.id"><spring:message code="settings.editCourse.label.module"></spring:message></form:label>
			 					<label for="module.id" class="form-control">${course.module.name}</label>
			 					<form:input path="module.id" class="form-control input-lg" placeholder="Module" type="hidden" />
								<form:errors class="error" path="module.id" />
							</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="state.id"><spring:message code="settings.editCourse.label.state"></spring:message></form:label>
										<form:select path="state.id" class="form-control">
											<c:forEach items="${states}" var="module">
												<c:choose>
													<c:when test="${not empty states}">
														<option value="${state.id}">${state.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
									</div>
								</div>
								<form:errors class="error" path="state" />
			 				</div>
			 				
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="courseBase.id"><spring:message code="settings.editCourse.label.base"></spring:message></form:label>
											<form:select path="courseBase.id" class="form-control">
												<c:forEach items="${courseBases}" var="courseBase">
													<c:choose>
														<c:when test="${not empty courseBases}">
															<option value="${courseBase.id}">${courseBase.name}</option>
														</c:when>
													</c:choose>
												</c:forEach>
											</form:select>
										</div>
									</div>
								<form:errors class="error" path="courseBase" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="type.id"><spring:message code="settings.editCourse.label.type"></spring:message></form:label>
			 					<label for="type.id" class="form-control">${course.type.name}</label>
			 					<form:input path="type.id" class="form-control input-lg" placeholder="Course Type" type="hidden" />
								<form:errors class="error" path="type.id" />
							</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="beginDate"><spring:message code="settings.editCourse.label.begin"></spring:message></form:label>
								<form:input id="birthday" path="beginDate" class="form-control input-lg" placeholder="Begin Date" />
								<form:errors class="error" path="beginDate" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="endDate"><spring:message code="settings.editCourse.label.end"></spring:message></form:label>
								<form:input id="birthday" path="endDate" class="form-control input-lg" placeholder="End Date" />
								<form:errors class="error" path="endDate" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="distanceTeachingDays"><spring:message code="settings.editCourse.label.distdays"></spring:message></form:label>
			 					<form:input path="distanceTeachingDays" class="form-control input-lg" placeholder="Distance Teaching Days" />
								<form:errors class="error" path="distanceTeachingDays" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="distanceTeachingHours"><spring:message code="settings.editCourse.label.disthours"></spring:message></form:label>
			 					<form:input path="distanceTeachingHours" class="form-control input-lg" placeholder="Distance Teaching Hours" />
								<form:errors class="error" path="distanceTeachingHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="planningHours"><spring:message code="settings.editCourse.label.planhours"></spring:message></form:label>
			 					<form:input path="planningHours" class="form-control input-lg" placeholder="Planning Hours" />
								<form:errors class="error" path="planningHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="localTeachingDays"><spring:message code="settings.editCourse.label.localdays"></spring:message></form:label>
			 					<form:input path="localTeachingDays" class="form-control input-lg" placeholder="Local Teaching Days" />
								<form:errors class="error" path="localTeachingDays" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="localTeachingHours"><spring:message code="settings.editCourse.label.localhours"></spring:message></form:label>
			 					<form:input path="localTeachingHours" class="form-control input-lg" placeholder="Local Teaching Hours" />
								<form:errors class="error" path="localTeachingHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="assessingHours"><spring:message code="settings.editCourse.label.assesshours"></spring:message></form:label>
			 					<form:input path="assessingHours" class="form-control input-lg" placeholder="Assessing Hours" />
								<form:errors class="error" path="assessingHours" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="enrolmentTimeEnd"><spring:message code="settings.editCourse.label.enrolend"></spring:message></form:label>
								<form:input id="birthday" path="enrolmentTimeEnd" class="form-control input-lg" placeholder="Enrolment Time End" />
								<form:errors class="error" path="enrolmentTimeEnd" />
							</div>
							
							<div align="left" class="form-group">
								<form:label path="courseFee"><spring:message code="settings.editCourse.label.coursefee"></spring:message></form:label>
			 					<form:input path="courseFee" class="form-control input-lg" placeholder="Course Fee" />
								<form:errors class="error" path="courseFee" />
			 				</div>
			 				
			 				<div align="left" class="form-group">
			 					<form:label path="courseFeeCurrency"><spring:message code="settings.editCourse.label.coursecurrency"></spring:message></form:label>
								<form:select path="courseFeeCurrency"  items="${currencies}" class="form-control input-lg" placeholder="Currencies"></form:select>
								<form:errors class="error" path="CourseFeeCurrency" />
							</div>
							
							<div class="row">
							<div align="left" class="col-md-5">
								<button class="btn btn-magnolia">
								    <div class="lsf-icon" title="album"><spring:message code="settings.editCourse.button.edit" /></div>
								</button>
							</div>
						</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>