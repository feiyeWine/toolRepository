package com.tools;



import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import tws.database.GetBeansFromDB;

import com.opensymphony.xwork2.ActionSupport;

public class ReturnTools extends ActionSupport{
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ids[] = request.getParameterValues("tools.id");
		String apartments[] = request.getParameterValues("tools.department");
		String empId = request.getParameter("empId");
		
		for(int i = 0;i<ids.length;i++){
			if(ids[i].equals(""))
			System.out.println(ids);
		}
		System.out.println("______________");
		
		Date date = new Date(System.currentTimeMillis());
		for(int i=0;i<ids.length;i++){
			if(!ids[i].equals("")&&!apartments[i].equals("")){
				System.out.println(ids[i]+apartments[i]);
				
				//归还选择工具
				if(GetBeansFromDB.returnTool(apartments[i],ids[i],empId,date)){
					System.out.println("归还成功");
				}
			}
		}
		
		return this.SUCCESS;
	}
}
