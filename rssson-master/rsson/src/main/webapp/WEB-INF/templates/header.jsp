<%-- 
    Document   : header
    Created on : Jul 09, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tilesx" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<tilesx:useAttribute name="current" />

<div class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/rssson/index.htm"><spring:message code="generic.applicationTitle" /></a>
        </div>
      	<div class="navbar-collapse collapse">
      	  <spring:url value="/index.htm" var="homeUrl"></spring:url>
      	  <spring:url value="/users/profile" var="editProfileUrl"></spring:url>
          <spring:url value="/users/profile" var="viewProfileUrl"></spring:url>
          <spring:url value="/students" var="viewStudentsUrl"></spring:url>
      	  <spring:url value="/students/createstudent" var="createStudentUrl"></spring:url>
          <spring:url value="/students/searchstudents.htm" var="searchStudentsUrl"></spring:url>
          <spring:url value="/students/createstudentgroup.htm" var="createStudentGroupUrl"></spring:url>
          <spring:url value="/students/searchstudentgroup.htm" var="searchStudentGroupsUrl"></spring:url>
          <spring:url value="/courses/createcoursewizard.htm" var="createCourseUrl"></spring:url>
          <spring:url value="/students/subjects" var="searchCoursesUrl"></spring:url>
          <spring:url value="/students/timetable" var="timeTableUrl"></spring:url>
          <spring:url value="/students/registered/subjects" var="coursePlannerUrl"></spring:url>
          <spring:url value="/students/studentinfo" var="studentInfoUrl"></spring:url>
          <spring:url value="/students/billinginfo" var="billingInfoUrl"></spring:url>
          <spring:url value="/students/accommodation" var="accUrl"></spring:url>
          <spring:url value="/projects/createproject.htm" var="createProjectUrl"></spring:url>
          <spring:url value="/projects/searchprojects.htm" var="searchProjectsUrl"></spring:url>
          <spring:url value="/projects/createstudentproject.htm" var="createStudentProjectUrl"></spring:url>
          <spring:url value="/projects/searchstudentprojects.htm" var="searchStudentProjectsUrl"></spring:url>
          <spring:url value="/staff/createstaff" var="createStaffUrl"></spring:url>
          <spring:url value="/staff" var="viewStaffUrl"></spring:url>
          <spring:url value="/resources/resourcecategories.htm" var="resourceCategoriesUrl"></spring:url>
          <spring:url value="/resources/creatematerialresource.htm" var="createMaterialResourceUrl"></spring:url>
          <spring:url value="/resources/createworkresource.htm" var="createWorkResourceUrl"></spring:url>
          <spring:url value="/resources/searchresources.htm" var="searchResourcesUrl"></spring:url>
          <spring:url value="/reports/listreports.htm" var="listReportsUrl"></spring:url>
          <spring:url value="/users/createsystemuser" var="createSystemUserUrl"></spring:url>
          <spring:url value="/users/systemusers" var="listSystemUsersUrl"></spring:url>
          <spring:url value="/users/searchusers.htm" var="searchUsersUrl"></spring:url>
          <spring:url value="/settings/creategradingscale" var="createGradingScaleUrl"></spring:url>
          <spring:url value="/settings/creategrade" var="createGradeUrl"></spring:url>
          <spring:url value="/settings/gradingscales" var="listGradingScalesUrl"></spring:url>
          <spring:url value="/settings/createeducationlength" var="eduLengthUrl"></spring:url>
          <spring:url value="/settings/createsubject" var="subjectUrl"></spring:url>
          <spring:url value="/settings/academicsemesters" var="semestersUrl"></spring:url>
          <spring:url value="/settings/createstudyprogramme" var="studyProgUrl"></spring:url>
          <spring:url value="/settings/createprogrammecategory" var="studyProgCatUrl"></spring:url>
          <spring:url value="/settings/reportcategories.htm" var="reportCategoriesUrl"></spring:url>
          <spring:url value="/settings/createtimeunit" var="timeUnitsUrl"></spring:url>
          <spring:url value="/settings/createcourse" var="courseUrl"></spring:url>
          <spring:url value="/settings/createcoursebase" var="courseBaseUrl"></spring:url>
          <spring:url value="/settings/createcourseuser" var="courseUserUrl"></spring:url>
          <spring:url value="/settings/createbillingdetails" var="billingDetsUrl"></spring:url>
          <spring:url value="/settings/createstudentsubject" var="linkCourseStudentUrl"></spring:url>
          <spring:url value="/settings/createstaffsubject" var="linkCourseStaffUrl"></spring:url>
          <spring:url value="/settings/createcoursestudent" var="courseStudentUrl"></spring:url>
          <spring:url value="/settings/createcoursestaff" var="courseStaffUrl"></spring:url>
          <spring:url value="/settings/managetransfercredittemplates.htm" var="manageCreditUrl"></spring:url>
          <spring:url value="/settings/managechangelog.htm" var="manageChangeLogUrl"></spring:url>
          <spring:url value="/settings/createaccommodation" var="manageAccUrl"></spring:url>
          <spring:url value="/settings/managetimetable" var="manageTimeUrl"></spring:url>
          <spring:url value="/settings/coursedescriptioncategories.htm" var="courseDescrCatUrl"></spring:url>
          <spring:url value="/settings/managefiletypes.htm" var="manageFileTypesUrl"></spring:url>
          <spring:url value="/settings/studyendreasons.htm" var="studyEndUrl"></spring:url>
          <spring:url value="/system/systemsettings.htm" var="systemSettingsUrl"></spring:url>
          <spring:url value="/system/initialdata.htm" var="initialDataUrl"></spring:url>
          <spring:url value="/system/importcsv.htm" var="impCsvUrl"></spring:url>
          <spring:url value="/system/importdata.htm" var="impDataUrl"></spring:url>
          <spring:url value="/system/importscripteddata.htm" var="impScrDataUrl"></spring:url>
          <spring:url value="/system/importreport.htm" var="impReportUrl"></spring:url>
          <spring:url value="/system/elementcheatsheet.htm" var="cheatSheetUrl"></spring:url>
          <spring:url value="/system/managepermissions.htm" var="managePermissionsUrl"></spring:url>
          <spring:url value="/system/importexportpermissions.htm" var="impExpPermissionsUrl"></spring:url>
          <spring:url value="/staff/manuals" var="staffHelpUrl"></spring:url>
          <spring:url value="/students/manuals" var="studentHelpUrl"></spring:url>
          <spring:url value="/settings/staff/manuals/createmanual" var="staffManualUrl"></spring:url>
          <spring:url value="/settings/students/manuals/createmanual" var="studentManualUrl"></spring:url>
          <spring:url value="/users/login" var="loginUrl"></spring:url>
          <spring:url value="/users/logout" var="logoutUrl"></spring:url>
          <ul class="nav navbar-nav">
          	<li class="${current == 'home' ? 'active' : '' }"><a href="${homeUrl}"><spring:message code="generic.navigation.index" /></a></li>
          	
          	<sec:authorize access="fullyAuthenticated">
			  	<li class="dropdown ${current == 'profile' ? 'active' : '' }">
			    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.profile"/><b class="caret"></b></a>
			    	<ul class="dropdown-menu">
	          		  <li><a href="${editProfileUrl}"><spring:message code="generic.navigation.manageProfile"/></a></li>
	          		</ul>
			    </li>
		    </sec:authorize>
		    
		    <sec:authorize access="hasRole('ROLE_STUDENT')">
				 <li class="dropdown ${current == 'courses' ? 'active' : '' }">
				   	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.courses"/><b class="caret"></b></a>
			    		<ul class="dropdown-menu">
				          <li><a href="${searchCoursesUrl}"><spring:message code="generic.navigation.searchCourses"/></a></li>
				          <li><a href="${coursePlannerUrl}"><spring:message code="generic.navigation.coursePlanner"/></a></li>
				          <li><a href="${timeTableUrl}"><spring:message code="generic.navigation.timetable"/></a></li>
		          		</ul>
				 </li>
			</sec:authorize>
			
			<sec:authorize access="fullyAuthenticated">
		  		<sec:authorize access="hasRole('ROLE_STUDENT')">
			  		<li class="dropdown ${current == 'student' ? 'active' : '' }">
					    <a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.student"/><b class="caret"></b></a>
					    <ul class="dropdown-menu">
			          	   <li><a href="${studentInfoUrl}"><spring:message code="generic.navigation.studentInfo"/></a></li>
					       <li><a href="${billingInfoUrl}"><spring:message code="generic.navigation.billingInfo"/></a></li>
				           <li><a href="${accUrl}"><spring:message code="generic.navigation.accInfo"/></a></li>
			          	</ul>
					</li>
		  		</sec:authorize>
		  	</sec:authorize>
			
			<sec:authorize access="hasRole('ROLE_LECTURER')">
				 <li class="dropdown ${current == 'courses' ? 'active' : '' }">
				   	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.courses"/><b class="caret"></b></a>
			    		<ul class="dropdown-menu">
				          <li><a href="${searchCoursesUrl}"><spring:message code="generic.navigation.searchCourses"/></a></li>
				          <li><a href="${coursePlannerUrl}"><spring:message code="generic.navigation.coursePlanner"/></a></li>
		          		</ul>
				 </li>
			</sec:authorize>
		    
		     <sec:authorize access="fullyAuthenticated">
		  		<sec:authorize access="hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_SUPER_ADMIN')">
			  		<li class="dropdown ${current == 'staff' ? 'active' : '' }">
					    <a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.staff"/><b class="caret"></b></a>
					    <ul class="dropdown-menu">
			          	   <li><a href="${createStaffUrl}"><spring:message code="generic.navigation.createStaff"/></a></li>
		          		   <li><a href="${viewStaffUrl}"><spring:message code="generic.navigation.viewStaff"/></a></li>
				           <li><a href="${courseStaffUrl}"><spring:message code="generic.navigation.createCourseStaff"/></a></li>
				           <li><a href="${linkCourseStaffUrl}"><spring:message code="generic.navigation.createLinkCourseStaff"/></a></li>
			          	</ul>
					</li>
		  		</sec:authorize>
		  	</sec:authorize>
		    
		    <sec:authorize access="fullyAuthenticated">
		    	<sec:authorize access="hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_SUPER_ADMIN')">
				    <li class="dropdown ${current == 'reports' ? 'active' : '' }">
				    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.reports"/><b class="caret"></b></a>
				    	<ul class="dropdown-menu">
				          <li><a href="${listReportsUrl}"><spring:message code="generic.navigation.listReports"/></a></li>
		          		</ul>
				    </li>
			    </sec:authorize>
		    </sec:authorize>
		    
		    <sec:authorize access="fullyAuthenticated">
		  		<sec:authorize access="hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_SUPER_ADMIN')">
			  		<li class="dropdown ${current == 'students' ? 'active' : '' }">
					    <a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.students"/><b class="caret"></b></a>
					    <ul class="dropdown-menu">
			          	   <li><a href="${createStudentUrl}"><spring:message code="generic.navigation.createStudent"/></a></li>
					       <li><a href="${viewStudentsUrl}"><spring:message code="generic.navigation.viewStudents"/></a></li>
				           <li><a href="${courseStudentUrl}"><spring:message code="generic.navigation.createCourseStudent"/></a></li>
					       <li><a href="${linkCourseStudentUrl}"><spring:message code="generic.navigation.createLinkCourseStudent"/></a></li>
			          	</ul>
					</li>
		  		</sec:authorize>
		  	</sec:authorize>
		  </ul>
          
          <ul class="nav navbar-nav navbar-right">
          	<sec:authorize access="fullyAuthenticated">
          		<sec:authorize access="hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_SUPER_ADMIN')">
	          	 	<li class="dropdown ${current == 'settings' ? 'active' : '' }">
			    		<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.settings"/><b class="caret"></b></a>
				    	<ul class="dropdown-menu">
				          <li><a href="${createSystemUserUrl}"><spring:message code="generic.navigation.createSystemUser"/></a></li>
				          <li><a href="${listSystemUsersUrl}"><spring:message code="generic.navigation.listSystemUsers"/></a></li>
				          <li><a href="${createGradingScaleUrl}"><spring:message code="generic.navigation.createGradingScale"/></a></li>
				          <li><a href="${createGradeUrl}"><spring:message code="generic.navigation.createGrade"/></a></li>
				          <li><a href="${eduLengthUrl}"><spring:message code="generic.navigation.createEducationLength"/></a></li>
				          <li><a href="${subjectUrl}"><spring:message code="generic.navigation.createSubject"/></a></li>
				          <li><a href="${semestersUrl}"><spring:message code="generic.navigation.manageAcademicSemesters"/></a></li>
				          <li><a href="${studyProgUrl}"><spring:message code="generic.navigation.createStudyProgrammes"/></a></li>
				          <li><a href="${studyProgCatUrl}"><spring:message code="generic.navigation.createStudyProgrammeCategories"/></a></li>
				          <li><a href="${reportCategoriesUrl}"><spring:message code="generic.navigation.manageReportCategories"/></a></li>
				          <li><a href="${timeUnitsUrl}"><spring:message code="generic.navigation.createTimeUnits"/></a></li>
				          <li><a href="${courseBaseUrl}"><spring:message code="generic.navigation.createCourseBase"/></a></li>
				          <li><a href="${courseUrl}"><spring:message code="generic.navigation.createCourse"/></a></li>
				          <li><a href="${manageAccUrl}"><spring:message code="generic.navigation.manageAccommodation"/></a></li>
				          <li><a href="${manageTimeUrl}"><spring:message code="generic.navigation.manageTimeTable"/></a></li>
				          <li><a href="${courseUserUrl}"><spring:message code="generic.navigation.createCourseUser"/></a></li>
				          <li><a href="${billingDetsUrl}"><spring:message code="generic.navigation.createBillingDets"/></a></li>
				          <li><a href="${staffManualUrl}"><spring:message code="generic.navigation.staffManual"/></a></li>
				          <li><a href="${studentManualUrl}"><spring:message code="generic.navigation.studentManual"/></a></li>
				       </ul>
			    	</li>
			    	
	          	 	<li class="dropdown ${current == 'system' ? 'active' : '' }">
				    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.system"/><b class="caret"></b></a>
				    	<ul class="dropdown-menu">
				            <li><a href="${systemSettingsUrl}"><spring:message code="generic.navigation.manageSystemSettings"/></a></li>
				            <li><a href="${initialDataUrl}"><spring:message code="generic.navigation.importInitialData"/></a></li>
				            <li><a href="${impCsvUrl}"><spring:message code="generic.navigation.importCSV"/></a></li>
				            <li><a href="${impDataUrl}"><spring:message code="generic.navigation.importData"/></a></li>
				            <li><a href="${impScrDataUrl}"><spring:message code="generic.navigation.importScriptedData"/></a></li>
				            <li><a href="${impReportUrl}"><spring:message code="generic.navigation.importReport"/></a></li>
				            <li><a href="${cheatSheetUrl}"><spring:message code="generic.navigation.layoutElementsCheatSheet"/></a></li>
				            <li><a href="${managePermissionsUrl}"><spring:message code="generic.navigation.managePermissions"/></a></li>
				            <li><a href="${impExpPermissionsUrl}"><spring:message code="generic.navigation.importexportPermissions"/></a></li>
				       </ul>
			    	</li>
          	 </sec:authorize>
          	 	<div id="GUI_headerLoginInformationContainer"> 
				    <a href="${viewProfileUrl}" class="GUI_headerEditUserLink">${pageContext.request.userPrincipal.name}</a>           
				    <a href="${logoutUrl}" class="GUI_headerLogoutLoginLink"><spring:message code="generic.logoutLink"/></a>
				</div>
          	</sec:authorize>
          	 
          	 <sec:authorize access="fullyAuthenticated">
          		<sec:authorize access="hasRole('ROLE_STAFF') or hasRole('ROLE_LECTURER')">
		          	 <li class="dropdown ${current == 'help' ? 'active' : '' }">
				    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.help"/><b class="caret"></b></a>
				    	<ul class="dropdown-menu">
				          <li><a href="${staffHelpUrl}"><spring:message code="generic.navigation.staff.help"/></a></li>
		          		</ul>
				    </li>
				</sec:authorize>
				
				<sec:authorize access="hasRole('ROLE_STUDENT')">
		          	 <li class="dropdown ${current == 'help' ? 'active' : '' }">
				    	<a href="#" data-toggle="dropdown" class="dropdown-toggle"><spring:message code="generic.navigation.help"/><b class="caret"></b></a>
				    	<ul class="dropdown-menu">
				          <li><a href="${studentHelpUrl}"><spring:message code="generic.navigation.student.help"/></a></li>
		          		</ul>
				    </li>
				</sec:authorize>
			</sec:authorize>
		    
		    <sec:authorize access="!authenticated">
          		<div id="GUI_headerLoginInformationContainer">   
				   <span class="loginLinkContainer"><a href="${loginUrl}" class="GUI_headerLogoutLoginLink"><spring:message code="generic.loginLink"/></a></span>
				</div>
          	</sec:authorize>
          </ul>
		</div>
 	</div>
 </div>