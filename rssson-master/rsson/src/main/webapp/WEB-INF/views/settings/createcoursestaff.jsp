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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="generic.navigation.createCourseStaff" /></span></h3>
		 			<br />
		 				<form:form method="POST" modelAttribute="courseStaff">
			 				<spring:url value="/settings/coursestaff" var="listCourseStaff" />
			 				<div align="left" class="row">
			 					<div align="left" class="col-md-6">
					 				<div align="left" class="form-group">
					 					<form:label path="courseUser.id"><spring:message code="settings.createCourseStaff.label.courseUser"></spring:message></form:label>
										<form:select path="courseUser.id" class="form-control">
											<c:forEach items="${courseUsers}" var="courseUser">
												<c:choose>
													<c:when test="${not empty courseUsers}">
														<option value="${courseUser.id}">${courseUser.user.username}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
										<div class="help-block with-errors">
											<form:errors class="error" path="courseUser" />
										</div>
									</div>
								</div>
							</div>
							
							<div align="left" class="row">
			 					<div align="left" class="col-md-6">
									<div align="left" class="form-group">
										<form:label path="staffMember.id"><spring:message code="settings.createCourseStaff.label.staffId"></spring:message></form:label>
										<form:select path="staffMember.id" class="form-control">
											<c:forEach items="${staffMembers}" var="staffMember">
												<c:choose>
													<c:when test="${not empty staffMembers}">
														<option value="${staffMember.id}">${staffMember.staffId}</option>
													</c:when>
												</c:choose>
											</c:forEach>
										</form:select>
										<div class="help-block with-errors">
											<form:errors class="error" path="staffMember" />
										</div>
									</div>
								</div>
							</div>
							
							<div class="row">
								<div align="left" class="col-md-5">
									<button class="btn btn-magnolia">
									    <div class="lsf-icon" title="user"><spring:message code="settings.createCourseStaff.button.save" /></div>
									</button>
									&#160;
									&#160;
									<button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${listCourseStaff}">
									    <div class="lsf-icon" title="list"><spring:message code="settings.createCourseStaff.button.view" /></div>
									</button>
								</div>
							</div>
		 				</form:form>
		 		</div>
		 	</div>
		 </div>
</div>