<%-- 
    Document   : system users
    Created on : Jul 12, 2016
    Author     : Sika Kay
--%>

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<spring:url value="/users/systemusers/usersgrid" var="usersUrl" />

<script type="text/javascript">
		$(function() {
			/* Users */
			$("#grid").jqGrid({
				url: '${usersUrl}',
				height: 'auto',
				datatype: 'json', 
				type: 'GET', 
				colNames:['ID', 'System ID', 'First Name', 'Last Name', 'Middle Name', 'Sex','Active', 'Username'], 
				colModel:[
				    {name:'id', index:'id', width:55, editable:false, editoptions:{readonly:true, size:10}, hidden:true},
				    {name:'systemId', index:'systemId', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'firstName', index:'firstName', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
				    {name:'lastName', index:'lastName', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}}, 
				    {name:'middleName', index:'middleName', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}},
				    {name:'sex', index:'sex', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'isActive', index:'isActive', width:100, editable:false, editoptions:{readonly:true, size:10}},
				    {name:'username', index:'username', width:100, editable:true, editrules:{required:true}, editoptions:{size:10}}
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
				sortname: 'id', 
				sortorder: 'desc', 							
				viewrecords: true,
				loadonce: false,
				loadComplete: function() {},
				gridview: true, 
				height: 450, 
				autowidth: true,
				rownumbers: true,
				caption: "System Users",
				emptyrecords: "Empty Records",
				onSelectRow: function(id){
					document.location.href="/rivson/users/systemusers/show/" + id;
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
							document.location.href="/rivson/users/createsystemuser";
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