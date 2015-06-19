package tws.bean;

import java.sql.Date;

public abstract class Borrowed {
	
	protected String toolId; // ����id
	protected String employeeId; // ������id
	protected String toolDepartment;
	protected Date borrowTime; // ����ʱ��
	
	/**
	 * @return ���ù��ߵ�id
	 */
		
	public String getToolId() {
		return toolId;
	}

	/**
	 * @param toolId ���ù��ߵ�id
	 */

	public void setToolId(String toolId) {
		this.toolId = toolId;
	}

	/**
	 * @return �����˵�id
	 */
	public String getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId �����˵�id
	 */
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public String getToolDepartment() {
		return toolDepartment;
	}

	public void setToolDepartment(String toolDepartment) {
		this.toolDepartment = toolDepartment;
	}

	/**
	 * @return ���ù��ߵ�ʱ��
	 */
	public Date getBorrowTime() {
		return borrowTime;
	}

	/**
	 * @param borrowTime ���ù��ߵ�ʱ��
	 */
	public void setBorrowTime(Date borrowTime) {
		this.borrowTime = borrowTime;
	}
	

}
