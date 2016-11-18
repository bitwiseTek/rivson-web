<%-- 
    Document   : template
    Created on : Jul 09, 2016
    Author     : Sika Kay
--%>

<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    	<meta name="description" content="RSSSON Web App">
    	<meta name="author" content="Sika Kay">
	    <title><spring:message code="generic.applicationTitle" /></title>
	    <spring:url value="/resources/images/icon.png" var="shortcutIcon"></spring:url>
	    <link rel="shortcut icon" href="${shortcutIcon}" />
	    <spring:url value="/resources/css/app/rssson.css" var="rsssonCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${rsssonCSS}" />
	    <spring:url value="/resources/css/app/rssson_theme.css" var="rsssonThemeCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${rsssonThemeCSS}" />
	    <spring:url value="/resources/css/app/messages.css" var="messagesCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${messagesCSS}" />
	    <spring:url value="/resources/css/app/hovermenu.css" var="hovermenuCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${hovermenuCSS}" />
	    <spring:url value="/resources/css/app/index.css" var="indexCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${indexCSS}" />
	    <spring:url value="/resources/css/app/layout.css" var="layoutCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${layoutCSS}" />
	    <spring:url value="/resources/css/app/tabs.css" var="tabsCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${tabsCSS}" />
	    <spring:url value="/resources/css/app/theme.css" var="themeCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${themeCSS}" />
	    <spring:url value="/resources/css/app/bootstrap-toggle.min.css" var="bootstrapToggleCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${bootstrapToggleCSS}" />
	    <spring:url value="/resources/css/app/pikaday.css" var="pikadayCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${pikadayCSS}" />
	    <spring:url value="/resources/css/app/jumbotron.css" var="jumbotronCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${jumbotronCSS}" />
	    <spring:url value="/resources/css/ligature/ligature.css" var="ligatureCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${ligatureCSS}" />
	   <spring:url value="/resources/jqueryui/jquery-ui-min.css" var="jQueryUiCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${jQueryUiCSS}" />
	    <spring:url value="/resources/jqueryui/jquery-ui.structure.min.css" var="jQueryUiStructureCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${jQueryUiStructureCSS}" />
	    <spring:url value="/resources/jqueryui/jquery-ui.theme.min.css" var="jQueryUiThemeCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${jQueryUiThemeCSS}" />
	    <spring:url value="/resources/jqgrid/css/ui.jqgrid.css" var="jqGridCSS"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${jqGridCSS}" />
	    <spring:url value="http://fonts.googleapis.com/css?family=Open+Sans+Condensed:300|Playfair+Display:400italic" var="googleFont"></spring:url>
	    <link rel="stylesheet" type="text/css" href="${googleFont}" />
	    <spring:url value="/resources/jquery/jquery-1.9.min.js" var="jQuery"></spring:url>
	    <script type="text/javascript" src="${jQuery}" /></script>
	    <spring:url value="/resources/jqueryval/dist/jquery.validate.min.js" var="jQueryVal"></spring:url>
	    <script type="text/javascript" src="${jQueryVal}" /></script>
	    <spring:url value="/resources/jqgrid/js/jquery.jqGrid.min.js" var="jqGrid"></spring:url>
	    <script type="text/javascript" src="${jqGrid}"/></script>
	    <spring:url value="/resources/jqgrid/plugins/grid.addons.js" var="jqGridPlug"></spring:url>
	    <script type="text/javascript" src="${jqGridPlug}"/></script>
	    <spring:url value="/resources/jqgrid/js/i18n/grid.locale-en.js" var="jqGridLoc"></spring:url>
	    <script type="text/javascript" src="${jqGridLoc}"/></script>
	    <spring:url value="/resources/js/bootstrap.min.js" var="bootstrapJS"></spring:url>
	    <script type="text/javascript" src="${bootstrapJS}"/></script>
	    <spring:url value="/resources/js/bootstrap-toggle.min.js" var="bootstrapToggleJS"></spring:url>
	    <script type="text/javascript" src="${bootstrapToggleJS}"/></script>
	    <spring:url value="/resources/jqueryui/jquery-ui.min.js" var="jQueryUI"></spring:url>
	    <script type="text/javascript" src="${jQueryUI}"/></script>
	    <spring:url value="/resources/js/validator.js" var="bootstrapVD"></spring:url>
	    <script type="text/javascript" src="${bootstrapVD}"/></script>
	    <spring:url value="/resources/ckeditor/ckeditor.js" var="ckEditor"></spring:url>
	    <script type="text/javascript" src="${ckEditor}"/></script>
	    <spring:url value="/resources/ckeditor/adapter/jquery.js" var="ckAdap"></spring:url>
	    <script type="text/javascript" src="${ckAdap}"/></script>
	    <spring:url value="/resources/plugins/pikaday.jquery.js" var="pikadayJQ"></spring:url>
	    <script type="text/javascript" src="${pikadayJQ}"></script>
	</head>
	
	<body>
		<div>
			<script type="text/javascript">
				$(function() {
					/* Date Function */
					$("#birthday").datepicker({
						dateFormat: "yy-mm-dd",
						changeYear: true, 
						showOtherMonths: true,
					    selectOtherMonths: true,
					    changeMonth: true,
					    yearRange: "-100:+10"
					});
				});
				
				$(document).ready(function() {
					/* Upload Image */
					$('#uploadImage').click(function() {
						$('#imageAttachmentUpload').show();
					});
					
					/* Upload PDF */
					$('#uploadPDF').click(function() {
						$('#pdfAttachmentUpload').show();
					});
				});
			</script>
  	        <tiles:insertAttribute name="header" />
  	        <spring:url value="/resources/images/LOGG.png" var="topLogo"></spring:url>
  	        <spring:url value="/resources/images/ceo.jpg" var="midLogo"></spring:url>
  	        <spring:url value="/index.htm" var="landing"></spring:url>
  	        &#160;
  	        <div class="container">
  	        	<div class="page-header">
  	        		<a href="${landing}"><img src="${topLogo}" class="img-responsive" width="776" height="65"></a>
  	        	</div>
  	        	<div align="center" class="page-header">
  	        		<a href="${landing}"><img src="${midLogo}" class="img-responsive"></a>
  	        	</div>
  	        </div>
  	        <div class="well-lg2">
  	        	<div class="greybar">&nbsp;</div>
  	        </div>
  	        <div>
  	        	<tiles:insertAttribute name="content" />
  	        </div>
  	       	<tiles:insertAttribute name="footer" />
  	    </div>
	</body>
</html>