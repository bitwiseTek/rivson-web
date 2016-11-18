<%-- 
    Document   : students
    Created on : Jul 13, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:url value="/students/studentsgrid" var="studentsUrl" />

<script type="text/javascript">
		$(function() {
			/* Students */
			$("#grid").jqGrid({
				url: '${studentsUrl}',
				height: 'auto',
				datatype: 'json', 
				type: 'GET', 
				colNames:['ID', 'Student ID', 'Nationality', 'State', 'Study Start', 'Study End', 'Lodging', 'Additional Info'], 
				colModel:[
				    {name:'id', index:'id', width:55, editable:false, editoptions:{readonly:true, size:10}, hidden:true},
				    {name:'studentId', index:'studentId', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'nationality', index:'nationality', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
				    {name:'stateOfOrigin', index:'stateOfOrigin', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
				    {name:'studyStartDateString', index:'studyStartDate', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'studyEndDateString', index:'studyEndDate', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'lodging', index:'lodging', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'additionalInfo', index:'additionalInfo', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}}
				],
				jsonReader : {
					root: "rows", 
					page: "page", 
					total: "total", 
					records: "records", 								
					repeatitems: false,
					cell: "cell",
					id: "id"
				},
				postData: {},
				pager: '#pager',
				rowNum: 20, 
				rowList: [20,40,60], 
				sortname: 'studyStartDateString', 
				sortorder: 'desc', 							
				viewrecords: true,
				loadonce: false,
				loadComplete: function() {},
				gridview: true, 
				height: 450, 
				autowidth: true,
				rownumbers: true,
				caption: "Students",
				emptyrecords: "Empty Records",
				onSelectRow: function(id){
					document.location.href="/rivson/students/show/" + id;
				}						
			});
			
			$("#grid").jqGrid('navGrid', "#pager", 
					{edit:false, add:false, del:false, search:true}, 
					{}, {}, {}, 
					{	//Search
						sopt:['cn', 'eq', 'ne', 'lt', 'gt', 'bw', 'ew'], 
						closeOnEscape:	true, 
						multipleSearch:	true, 
						closeAfterSearch: true
					});
			
			$("#grid").navButtonAdd('#pager', 
					{
						caption:"Add", 
						buttonicon:"ui-icon-plus", 					 
						position:"last", 
						title:"", 
						cursor:"pointer",
						onClickButton: function(){
							document.location.href="/rivson/students/createstudent";
						}
					});
			//Toolbar Search
			$("grid").jqGrid('filterToolbar', {stringResult:true, searchOnEnter:true, defaultSearch:"cn"});
		});
</script>

 <div class="well-lg2" align="center">
	<div id="jqgrid">
		<table id="grid">
			<tr><td /></tr>
		</table>
		<div id="pager"></div>
	</div>
	<div id='msgbox' title='' style='display:none'></div>
</div>