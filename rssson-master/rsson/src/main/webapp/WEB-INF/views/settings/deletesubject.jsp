<%-- 
    Document   : delete subject
    Created on : Sep 28, 2016
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
		 		<div align="left" class="col-md-6">
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="delete"><spring:message code="settings.deleteSubject.view" arguments="${subject.name}" /></span></h3>
		 			<br />
		 			<form:form method="DELETE" modelAttribute="subject">
		 				<input type="hidden" name="_method" value="DELETE" />
							<table width="75%" border="0" cellspacing="5" cellpadding="5">
									<tr>
										<td><label for="code" class="form-control">${subject.code}</label></td>
										<td><label for="name" class="form-control">${subject.name}</label></td>
										<td><form:input path="name" class="form-control input-lg" placeholder="Subject Name" type="hidden" /></td>
										<td><form:errors path="name" class="error" /></td>
										
										<td><form:input path="code" class="form-control input-lg" placeholder="Subject Code" type="hidden" /></td>
										
										<td><button class="btn btn-magnolia_two">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.deleteSubject.button.delete" /></div></button></td>
									</tr>
		 					</table>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>