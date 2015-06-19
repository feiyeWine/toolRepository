package com.admin;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Validateable;
import com.user.User;

public class RegisterAction extends ActionSupport{
	private User user = new User();
	
	
	@Override
	public String execute() throws Exception {
		
		return this.SUCCESS;
	}
	public String reg() throws Exception{
		DbService dbservice = new DbService();
		
		//System.out.println(user.getId()+"   "+user.getPassword()+"  "+user.getPasswordSure());
		if(user.getId().equals("")){
			this.addActionError( "员工号不能为空！");
			return this.INPUT;
		}else if(user.getPassword().equals("")){
			this.addActionError("密码不能为空！");
			return this.INPUT;
		}else if(user.getId().trim().length()<2){
			this.addActionError("员工号长度不小于2！");
			return this.INPUT;
		}else if(user.getPassword().trim().length()<3){
			this.addActionError("密码名长度不少于3个字符！");
			return this.INPUT;
		}else if(!user.getPassword().trim().equals(user.getPasswordSure().trim())){
			this.addActionError("确认密码与输入密码不同！");
			return this.INPUT;
		}
		
		
		if(dbservice.hasSameName(user.getId())){
			this.addActionError("此员工号已存在");
			return this.INPUT;
		}else{
			dbservice.addUser(user);
		}
		return this.SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}