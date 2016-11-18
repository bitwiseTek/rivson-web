<%-- 
    Document   : index-1
    Created on : Jul 09, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="well-lg2">
	<div class="container">
			<div align="center" class="index_row">
				<div class="index_cell">
			      <spring:url value="/resources/gfx/index/users.png" var="usersImg"></spring:url>
			      <img src="${usersImg}" class="index_cell_image"/>
			      <spring:url value="/users/profile" var="editProfileUrl"></spring:url>
          		  <spring:url value="/users/profile" var="viewProfileUrl"></spring:url>
			      <div class="index_cell_title"><spring:message code="generic.index.profileTitle"/></div>
			      <div><a class="index_cell_link" href="${editProfileUrl}"><spring:message code="generic.index.editProfile"/></a></div>
			      <div><a class="index_cell_link" href="${viewProfileUrl}"><spring:message code="generic.index.viewProfile"/></a></div>			    
			     </div>
			    
			    <div class="index_cell">
			      <spring:url value="/resources/gfx/index/courses.png" var="coursesImg"></spring:url>
			      <img src="${coursesImg}" class="index_cell_image"/>
			      <spring:url value="/students/registered/subjects" var="registerCoursesUrl"></spring:url>
			      <spring:url value="/students/subjects" var="searchCoursesUrl"></spring:url>
			      <div class="index_cell_title"><spring:message code="generic.index.coursesTitle"/></div>
			      <div><a class="index_cell_link" href="${registerCoursesUrl}"><spring:message code="generic.index.registerCourses"/></a></div>
			      <div><a class="index_cell_link" href="${searchCoursesUrl}"><spring:message code="generic.index.searchCourses"/></a></div>
			    </div>
			 </div>
			 
			 <div align="center" class="index_row">
			    <sec:authorize access="hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_SUPER_ADMIN')">
				    <div class="index_cell">
				      <spring:url value="/resources/gfx/index/modules.png" var="modulesImg"></spring:url>
				      <img src="${modulesImg}" class="index_cell_image"/>
				      <spring:url value="/modules/modules.htm" var="searchModulesUrl"></spring:url>
	          		  <spring:url value="/modules/createmodule.htm" var="createModuleUrl"></spring:url>
				      <div class="index_cell_title"><spring:message code="generic.index.modulesTitle"/></div>
					  <div><a class="index_cell_link" href="${createModuleUrl}"><spring:message code="generic.index.createModule"/></a></div>
					  <div><a class="index_cell_link" href="${searchModulesUrl}"><spring:message code="generic.index.searchModules"/></a></div>
				    </div>
				    
				    <div class="index_cell">
				      <spring:url value="/resources/gfx/index/projects.png" var="projectsImg"></spring:url>
				      <img src="${projectsImg}" class="index_cell_image"/>
				      <spring:url value="/projects/searchprojects.htm" var="searchProjectsUrl"></spring:url>
	          		  <spring:url value="/projects/createproject.htm" var="createProjectUrl"></spring:url>
				      <div class="index_cell_title"><spring:message code="generic.index.projectsTitle"/></div>
				      <div><a class="index_cell_link" href="${searchProjectsUrl}"><spring:message code="generic.index.searchProjects"/></a></div>
				      <div><a class="index_cell_link" href="${createProjectUrl}"><spring:message code="generic.index.createProject"/></a></div>
				    </div>
			    </sec:authorize>
			</div>
	</div>
</div>