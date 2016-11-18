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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="generic.navigation.createCourseUser" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="courseUser">
			 				<spring:url value="/settings/courseusers" var="listCourseUsers" />
			 				<div align="left" class="row">
								<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="course.id"><spring:message code="settings.createCourseUser.label.course"></spring:message></form:label>
										<form:select path="course.id" class="form-control">
											<c:forEach items="${courses}" var="course">
												<c:choose>
													<c:when test="${not empty courses}">
														<option value="${course.id}">${course.name}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
										<div class="help-block with-errors">
											<form:errors class="error" path="course" />
										</div>
									</div>
								</div>
							</div>
							
							<div align="left" class="row">
								<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="user.id"><spring:message code="settings.createCourseUser.label.user"></spring:message></form:label>
										<form:select path="user.id" class="form-control">
											<c:forEach items="${users}" var="user">
												<c:choose>
													<c:when test="${not empty users}">
														<option value="${user.id}">${user.username}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
										<div class="help-block with-errors">
											<form:errors class="error" path="user.id" />
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="user"><spring:message code="settings.createCourseUser.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listCourseUsers}">
									    <div class="lsf-icon" title="list"><spring:message code="settings.createCourseUser.button.view" /></div>
									</button>
								</div>
							</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>