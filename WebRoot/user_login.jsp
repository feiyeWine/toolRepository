<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>仓库管理系统登录页面</title>
    <style>
    	div{
    		margin: 60px;
    	}
    </style>
  </head>
  <body>
  		<%-- <s:fielderror/> --%>
  		<div align="right">
  			<s:a href="user_register.jsp">
  				<font color="blue">
  				 <h5>还未注册？点击注册</h5>
  				</font>
  			</s:a>
  		</div>
  		<s:actionerror/>
  		<div align="center">
  		<s:form  action="login_ok" method="get"  namespace="/">
  			<s:textfield type="text" name="user.id" label="员工号"/>
  			<s:password name="user.password" label="密码"/>
  			<s:submit value="登录" align="center"/>
  		</s:form>
  		</div>
  </body>
</html>
