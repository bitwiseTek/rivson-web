<%-- 
    Document   : download staff manual
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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="album"><spring:message code="staff.downloadStaffManual.view" arguments="${manual.manualVersion}" /></span></h3>
		 			<br />
		 				<div align="left" class="form-group">
								<label for="manualName"><spring:message code="staff.downloadStaffManual.label.name"></spring:message></label>
			 					<label for="manualName" class="form-control">${manual.manualName}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="manualVersion"><spring:message code="staff.downloadStaffManual.label.version"></spring:message></label>
								<label for="manualVersion" class="form-control">${manual.manualVersion}</label>
							</div>
							
							<div align="left" class="form-group">
								<label for="pdfs"><spring:message code="staff.downloadStaffManual.label.pdf" /></label>
								<c:if test="${not empty manual.pdfs}">
									<c:forEach items="${maual.pdfs}" var="pdf">
										<a href="/rssson//staff/manual/filedownload/staff/${pdf.id}" target="_blank">
											<button class="btn btn-magnolia" type="submit" formaction="/rssson//staff/manual/filedownload/staff/${pdf.id}" formmethod="get">
										      <div class="lsf-icon" title="download"><spring:message code="staff.downloadStaffManual.label.download" /></div>
										    </button>
										</a><br />
									</c:forEach>
								</c:if>
							</div>
							
							<sec:authorize access="hasRole('STAFF') or hasRole('LECTURER')">
								<spring:url value="/staff/manuals" var="backUrl" />
								<a href="${backUrl}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${backUrl}">
								<div class="lsf-icon" title="left"><spring:message code="staff.downloadStaffManual.button.back" /></div></button></a>	
							</sec:authorize>
		 			</div>
		 	</div>
		 </div>
</div>