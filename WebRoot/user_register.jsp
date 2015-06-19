<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=utf-8"%> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>仓库管理系统注册页面</title>
    <style>
    	div{
    		margin: 60px;
    	}
    </style>
</head>
  <body>
  		<%-- <s:fielderror/> --%>
  		<s:actionerror/>
  		<div align="center" >
  		<s:form action="register!reg" method="post"  namespace="/">
  			<s:textfield type="text" name="user.id" label="员工号"/>
  			<s:password name="user.password" label="密码"/>
  			<s:password name="user.passwordSure" label="确认密码"/>
  			<s:textfield type="text" name="user.name" label="姓名"/>
  			<s:radio name="user.authory" label="权限" list="{'normal','advance'}"/>
  			<s:select name="user.department" label="部门" list="{'Construction','Automobile','Appliance','Computer'}"/>
  			<s:submit value="注册" />
  		</s:form>
  		</div>
  </body>
</html>
