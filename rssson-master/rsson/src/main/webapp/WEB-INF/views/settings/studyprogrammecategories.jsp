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
		 			<h3 align="left" class="appTitle"><span class="lsf-icon" title="menu"><spring:message code="settings.studyProgCats.view" /></span></h3>
		 			<br />
		 			<form:form method="POST" modelAttribute="categories">
		 				<c:if test="${not empty categories}">
		 					<table width="85%" border="0" cellspacing="5" cellpadding="5">
			 					<c:forEach items="${categories}" var="category">
			 						<spring:url value="/settings/programmecategories/edit/${category.id}/" var="editCategory" />
									<spring:url value="/settings/programmecategories/delete/${category.id}/" var="deleteCatgeory" />
									<tr>
										<td><label for="name" class="form-control">${category.name}</label></td>
										<td><a href="${editCategory}"><button class="btn btn-magnolia" type="submit" formmethod="get" formaction="${editCategory}">
							    		<div class="lsf-icon" title="setting"><spring:message code="settings.studyProgCats.button.edit" /></div></button></a></td>
							    		
										<td><a href="${deleteCategory}"><button class="btn btn-magnolia_two" type="submit" formmethod="get" formaction="${deleteCategory}">
							    		<div class="lsf-icon" title="delete"><spring:message code="settings.studyProgCats.button.delete" /></div></button></a></td>
									</tr>
			 					</c:forEach>
		 					</table>
		 				</c:if>
		 			</form:form>
		 		</div>
		 	</div>
		 </div>
</div>