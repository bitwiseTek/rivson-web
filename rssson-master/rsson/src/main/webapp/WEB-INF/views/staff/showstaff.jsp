<%-- 
    Document   : show staff
    Created on : Sep 27, 2016
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

<div align="left" class="well-lg2">
	 	<div align="left" class="container">
		 	<div align="left" class="row">
		 		<div align="left" class="col-md-7">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="user"><spring:message code="staff.showStaff.view" arguments="${staff.staffId}" /></span></h3>
		 			<br />
		 					<div align="left" class="form-group">
								<label for="title"><spring:message code="staff.showStaff.label.title"></spring:message></label>
								<label for="title" class="form-control">${staff.title}</label>
							</div>
							
		 					<div align="left" class="form-group">
								<label for="staffId"><spring:message code="staff.showStaff.label.staffId"></spring:message></label>
			 					<label for="staff" class="form-control">${staff.staffId}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="nationality"><spring:message code="staff.showStaff.label.nation"></spring:message></label>
								<label for="nationality" class="form-control">${staff.nationality}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="stateOfOrigin"><spring:message code="staff.showStaff.label.state"></spring:message></label>
								<label for="stateOfOrigin" class="form-control">${staff.stateOfOrigin}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="lga"><spring:message code="staff.showStaff.label.lga"></spring:message></label>
								<label for="lga" class="form-control">${staff.lga.name}</label>
								<form:errors class="error" path="lga" />
							</div>
							
							<div align="left" class="form-group">
								<label for="additionalInfo"><spring:message code="staff.showStaff.label.addinfo"></spring:message></label>
								<label for="additionalInfo" class="form-control">${staff.additionalInfo}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="images"><spring:message code="staff.showStaff.label.image" /></label>
								<c:if test="${not empty staff.images}">
									<c:forEach items="${staff.images}" var="image">
										<a href="/rssson//staff/show/filedownload/staff/${image.id}" target="_blank"><img src="/rssson/staff/show/filedownload/staff/${image.id}" alt="Staff Image" class="img-thumbnail" /></a><br />
									</c:forEach>
								</c:if>
							</div>
							
							<div align="left" class="form-group">
			 					<label for="user"><spring:message code="staff.showStaff.label.username"></spring:message></label>
			 					<label for="user" class="form-control">${staff.user.username}</label>
							</div>
							
							<sec:authorize access="hasRole('SUPER_ADMIN') or hasRole('ADMINISTRATOR')">
								<spring:url value="/staff/edit/${staff.id}/" var="editUrl" />
								<spring:url value="javascript:void(0);" var="uploadUrl" />
								<spring:url value="/staff/delete/${staff.id}/" var="deleteUrl" />
								<a href="${editUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editUrl}">
								<div class="lsf-icon" title="setting"><spring:message code="staff.showStaff.button.edit" /></div></button></a> |
								<a href="${uploadUrl}" id="uploadImage"><button class="btn btn-magnolia_two" type="submit" formaction="${uploadUrl}">
								<div class="lsf-icon" title="upload"><spring:message code="staff.showStaff.button.upload" /></div></button></a> |		
								<a href="${deleteUrl}"><button class="btn btn-danger" type="submit" formmethod="get" formaction="${deleteUrl}">
								<div class="lsf-icon" title="trash"><spring:message code="staff.showStaff.button.delete" /></div></button></a>		
							</sec:authorize>
							
							<div id="imageAttachmentUpload" hidden="true">
								<h3><spring:message code="staff.showStaff.label.upload" /></h3>
								<form:form action="fileupload" modelAttribute="uploadItem" method="POST" name="fileuploadForm" enctype="multipart/form-data">
									<input name="staffId" type="hidden" value="${staff.id}" />						
									<input name="uploadType" type="hidden" value="staff" />
									<label for="file"><spring:message code="staff.showStaff.label.file" /></label>
									<input name="file" type="file" /><br />
									<button class="btn btn-magnolia_two" type="submit" formmethod="post" formaction="fileupload">
										<div class="lsf-icon " title="upload"><spring:message code="staff.showStaff.button.upload" /></div>
									</button>					
								</form:form>
							</div>
		 			</div>
		 	</div>
		 </div>
</div>