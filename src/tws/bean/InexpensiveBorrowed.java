package tws.bean;

/**
 * 廉价工具借用记录类
 */
public class InexpensiveBorrowed extends Borrowed{
	protected static final String STATUS_NORMAL = "normal";
	protected static final String STATUS_DAMAGE = "damage";
	
	protected String status; //状态——正常（借出） 及 损坏

	/**
	 * 获取当前借用工具的状态
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 设置当前借用工具的状态
	 * @param status
	 */
	public void setStatus(String status) {
		if(STATUS_NORMAL.equals(status)|| STATUS_DAMAGE.equals(status))
			this.status = status;
		else{
			//默认设置为normal
			this.status = STATUS_NORMAL;
		}
	}
		
	@Override
	public String toString() {
		return "[InexpensiveBorrowed : tool_id "+toolId
				+" employee_id "+employeeId
				+" borrow_time "+ borrowTime
				+" status "+ status+"]";
	}
}
