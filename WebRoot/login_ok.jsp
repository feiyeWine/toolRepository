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
		.view{
			font-size: 20px;
			font-weight: bold;
		}
		.submit{
			font-size: 20px;
			font-weight: bold;
		}
		.p{
			font-size: 25px;
			font-weight: bold;
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
  		
  		<% String str = request.getParameter("user.id") ;%>
  		<%  
  			application.setAttribute("empId",str);
  		 %>
  		<hr/>
  		<s:form action="selectTools" method="get" name="toolForm" namespace="/">
  			
  			<table><s:submit value="查看已借用工具" id="view" class="view" align="right"/></table>	
  			
  			<p align="center" id="p" class="p">廉价工具表</p>
  		<table width="600" border="1" align="center">
  			<tr align="center">
  				<td>工具编号</td>
  				<td>工具名称</td>
  				<td>所属部门</td>
  				<td>数量</td>
  				<!-- <td>价格</td> -->
  				<td>选择</td>
  			</tr>
  			
  			<s:iterator value="#request.tools"  var="tools" status="status">
  				<tr>
  					<td>
  						<s:property value="#request.tools[#status.index].getId()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools[#status.index].getName()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools[#status.index].getToolType()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools[#status.index].getNumber()"/>
  					</td>
  					<%-- <td>
  						<s:property value="#request.tools[#status.index].getPrice()"/>
  					</td> --%>
  					<td>
  						<input type="button" value="借用"
  						onclick="borrow(this,'<s:property value='#request.tools[#status.index].getId()'/>','<s:property value='#request.tools[#status.index].getToolType()'/>');"   
  						/>
  						<s:hidden  name="tools.id" id="id"/>
  						<s:hidden name="tools.department" id="department"/>
  						
  					</td>
  				</tr>
  			</s:iterator>
  		
  		</table>
  		<h2 align="center">贵重工具表</h2>
  		<table width="600" border="1" align="center">
  			<tr align="center">
  				<td>工具编号</td>
  				<td>工具名称</td>
  				<td>所属部门</td>
  				<td>数量</td>
  				<!-- <td>价格</td> -->
  				<td>选择</td>
  			</tr>
  			
  			<s:iterator value="#request.tools2"  var="tools2" status="status">
  				
  				<tr>
  					<td>
  						<s:property value="#request.tools2[#status.index].getId()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools2[#status.index].getName()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools2[#status.index].getToolType()"/>
  					</td>
  					<td>
  						<s:property value="#request.tools2[#status.index].getNumber()"/>
  					</td>
  					<%-- <td>
  						<s:property value="#request.tools2[#status.index].getPrice()"/>
  					</td> --%>
  					<td>
  						<input type="button" value="借用"
  						onclick="borrow(this,'<s:property value='#request.tools2[#status.index].getId()'/>','<s:property value='#request.tools2[#status.index].getToolType()'/>');"   
  						/>
  						<s:hidden  name="tools.id" id="id" />
  						<s:hidden name="tools.department" id="department"/>
  					</td>
  				</tr>
  			</s:iterator>
  		
  		</table>
  			<input type="hidden" value="<%=str %>" name="empId"/>
			<s:submit value="提交" align="center" class="submit" id="submit"></s:submit>
  		</s:form>
  		<s:debug/>
  </body>
</html>
