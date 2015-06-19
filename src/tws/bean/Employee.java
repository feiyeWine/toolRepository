package tws.bean;

/**
 * 131211班 SA final project 第二组。 组长：蔡石林 Project:TWS(Tool Warehouse
 * System)工具仓库管理系统
 * 
 * 雇员bean类 
 */
public class Employee {
	
	private String id; // id
	private String name; // 姓名
	private String password; // 密码
	private String authority; // 权限 --表示其为普通员工/专家
	private String department; // 所在部门，所在部门不同，可获取的工具类不同

	public static final String Authority_Normal = "normal";	  //普通员工权限常量
	public static final String Authority_Advance = "advance"; //高级员工权限常量
	
	/**
	 * @return 雇员id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 雇员的id
	 */
	public void setId(String id) {
		this.id = id;
	}

		
	/**
	 * @return 雇员姓名
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name 雇员姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 雇员登陆TWS系统的密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 雇员登陆TWS系统的密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 雇员的权限
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority 雇员的权限
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	/**
	 * @return 雇员的部门名
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department 雇员的部门名
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	
	@Override
	public String toString() {
		return "[Employee : id "+id
				+" name "+name 
				+" authority "+ authority
				+" department "+ department+"]";
	}
}
