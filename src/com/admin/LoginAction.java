package com.admin;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import tws.bean.Tool;
import tws.database.GetBeansFromDB;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.user.User;

public class LoginAction extends ActionSupport{
	private User user;
	private List<Tool> tools,tools2;
	
	@Override
	public String execute() throws Exception {
		DbService dbservice = new DbService();
		if(dbservice.hasLogSame(user.getId(),user.getPassword())){
			ActionContext ac = ActionContext.getContext();
			ac.getApplication().put("userId", user.getId());
			
			//获取廉价工具
			tools = GetBeansFromDB.getInexpensiveBorrowableTools(user.getId());
			Map map = (Map) ac.get("request");
			//System.out.println(tools.get(0).getToolType());
			map.put("tools", tools);
			//获取贵重工具
			tools2 = GetBeansFromDB.getExpensiveBorrowableTools(user.getId());
			map.put("tools2", tools2); 
			
			return this.SUCCESS;
		}else{
			this.addActionError("员工号或密码错误");
			return this.INPUT;
		}
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
