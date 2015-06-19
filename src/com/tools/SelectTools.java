package com.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import tws.bean.Employee;
import tws.bean.ExpensiveBorrowed;
import tws.bean.InexpensiveBorrowed;
import tws.database.GetBeansFromDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class SelectTools extends ActionSupport{
	
	private ToolsInfor tools = new ToolsInfor();
	private static String empId;
	
	ArrayList<ToolsInfor> list = new ArrayList<ToolsInfor>();
	@Override
	public String execute() throws Exception {

		HttpServletRequest request = ServletActionContext.getRequest();
		String ids[] = request.getParameterValues("tools.id");
		String apartments[] = request.getParameterValues("tools.department");
		String empId = request.getParameter("empId");
		
		for(int i=0;i<ids.length;i++){
			if(!ids[i].equals("")&&!apartments[i].equals("")){
						
					//添加选择工具
					GetBeansFromDB.borrowTool(apartments[i],ids[i], empId);
			}
		}
		
		Employee emp = new Employee();
		emp.setId(empId);
		//添加参数
		ActionContext ac = ActionContext.getContext();
		ac.getApplication().put("userId", emp.getId());
		
		
		//获取廉价工具
		List<InexpensiveBorrowed> tools1  = GetBeansFromDB.getInexpensiveBorroweds(emp.getId());
		Map map = (Map) ac.get("request");
		//System.out.println(tools.get(0).getToolType());
		map.put("tools1", tools1);
		//获取贵重工具
		List<ExpensiveBorrowed> tools2 = GetBeansFromDB.getExpensiveBorroweds(emp.getId());
		map.put("tools2", tools2);
		
		return this.SUCCESS;
	}
	public ToolsInfor getTools() {
		return tools;
	}
	public void setTools(ToolsInfor tools) {
		this.tools = tools;
	}
}
