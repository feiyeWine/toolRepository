<%@ page language="java" import="java.util.*,com.admin.*,com.tools.*,tws.bean.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>仓库管理系统主页</title>
    
    <style type="text/css">
    	td {
			text-align: center;
		}
    </style>
    <script>
    	function borrow(obj,id,department){
          
          obj.innerHTML = "<input type='text' name='tools.id' value='"+ id +"'/>"+"<input type='text' name='tools.department' value='"+ department +"'/>";
           var toolId = document.getElementById("id");
           var toolDep = document.getElementById("department");
           toolId.value = id;
           toolDep.value = department;
           alert(toolId.value+"  "+toolDep.value);
           
    	}
    	function emp(str){
    		alert(str);
    	}
    </script>
</head>
  <body>
  		用户ID：<s:property value="#application.userId"/>
  		
  		<hr/>
  		<h2 align="center">廉价工具表</h2>
  		
  		<s:form action="return" method="post" name="toolForm" namespace="/">
  		<table width="600" border="1" align="center">
  			<tr align="center">
  				<td>工具编号</td>
  				<td>部门编号</td>
  				<td>借出日期</td>
  			</tr>
  			
  			<s:iterator value="#request.tools1"  var="tools1" status="status">
  				<tr>
  					<td>
  						<s:property value="#request.tools1[#status.index].getToolId()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools1[#status.index].getToolDepartment()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools1[#status.index].getBorrowTime()"/>
  					</td>
  					
  				</tr>
  			</s:iterator>
  		
  		</table>
  		<h2 align="center">贵重工具表</h2>
  		<table width="600" border="1" align="center">
  			<tr align="center">
  				<td>工具编号</td>
  				<td>部门编号</td>
  				<td>借出日期</td>
  				<td>应归还日期</td>
  				<td>归还</td>
  			</tr>
  			
  			<s:iterator value="#request.tools2"  var="tools1" status="status">
  				<tr>
  					<td>
  						<s:property value="#request.tools2[#status.index].getToolId()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools2[#status.index].getToolDepartment()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools2[#status.index].getBorrowTime()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools2[#status.index].getReturnTime()"/>
  					</td>
  					<td>
  						<input type="button" value="归还"
  						onclick="borrow(this,'<s:property value='#request.tools2[#status.index].getToolId()'/>','<s:property value='#request.tools2[#status.index].getToolDepartment()'/>');"   
  						/>
  						<s:hidden  name="tools.id" id="id"/>
  						<s:hidden name="tools.department" id="department"/>
  						
  					</td>
  				</tr>
  			</s:iterator>
  		
  		</table>
  		<% String str = request.getParameter("empId") ;%>
  		<%  
  			application.setAttribute("empId",str);
  		 %>
  		<input type="hidden" value="<%=str %>" name="empId"/>
			<s:submit value="提交" align="center" class="submit" id="submit"></s:submit>
  		</s:form>
  		<s:debug/>
  </body>
</html>
