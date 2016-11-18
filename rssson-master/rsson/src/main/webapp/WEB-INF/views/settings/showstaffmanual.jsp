<%-- 
    Document   : show staff manual
    Created on : Nov 15, 2016
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="settings.showStaffManual.view" arguments="${manual.manualVersion}" /></span></h3>
		 			<br />
		 				<div align="left" class="form-group">
								<label for="manualName"><spring:message code="settings.showStaffManual.label.name"></spring:message></label>
			 					<label for="manualName" class="form-control">${manual.manualName}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="manualVersion"><spring:message code="settings.showStaffManual.label.version"></spring:message></label>
								<label for="manualVersion" class="form-control">${manual.manualVersion}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="pdfs"><spring:message code="settings.showStaffManual.label.pdf" /></label>
								<c:if test="${not empty manual.pdfs}">
									<c:forEach items="${maual.pdfs}" var="pdf">
										<a href="/rssson//staff/manual/filedownload/staff/${pdf.id}" target="_blank">
											<button class="btn btn-magnolia" type="submit" formaction="/rssson//staff/manual/filedownload/staff/${pdf.id}" formmethod="get">
										      <div class="lsf-icon" title="download"><spring:message code="settings.showStaffManual.label.download" /></div>
										    </button>
										</a><br />
									</c:forEach>
								</c:if>
							</div>
							
							<sec:authorize access="hasRole('ADMINISTRATOR') or hasRole('SUPER_ADMIN')">
								<spring:url value="javascript:void(0);" var="uploadUrl" />
								<a href="${uploadUrl}" id="uploadPDF"><button class="btn btn-magnolia_two" type="submit" formaction="${uploadUrl}">
								<div class="lsf-icon" title="upload"><spring:message code="settings.showStaffManual.button.upload" /></div></button></a>
							</sec:authorize>
							
							<div id="pdfAttachmentUpload" hidden="true">
								<h3><spring:message code="settings.showStaffManual.label.upload" /></h3>
								<form:form action="fileupload" modelAttribute="uploadItem" method="POST" name="fileuploadForm" enctype="multipart/form-data">
									<input name="staffManualId" type="hidden" value="${manual.id}" />						
									<input name="uploadType" type="hidden" value="staffManual" />
									<label for="file"><spring:message code="settings.showStaffManual.label.file" /></label>
									<input name="file" type="file" /><br />
									<button class="btn btn-magnolia_two" type="submit" formmethod="post" formaction="fileupload">
										<div class="lsf-icon " title="upload"><spring:message code="settings.showStaffManual.button.upload" /></div>
									</button>
									<spring:url value="/settings/staff/manuals" var="backUrl" />
									<a href="${backUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${backUrl}">
									<div class="lsf-icon" title="left"><spring:message code="settings.showStaffManual.button.back" /></div></button></a>					
								</form:form>
							</div>
		 			</div>
		 	</div>
		 </div>
</div>