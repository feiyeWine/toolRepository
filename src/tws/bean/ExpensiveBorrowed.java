package tws.bean;

import java.sql.Date;

/**
 * 贵重工具借用记录类
 */
public class ExpensiveBorrowed extends Borrowed {
	
	protected Date returnTime; // 归还时间

	/**
	 * @return 归还工具的时间
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * @param returnTime
	 *            归还工具的时间
	 */
	public void setReturnTime(Date returnTime) {
		this.returnTime = returnTime;
	}

	@Override
	public String toString() {
		return "[ExpensiveBorrowed : tool_id "+toolId
				+" employee_id "+employeeId
				+" borrow_time "+ borrowTime
				+" return_time "+ returnTime+"]";
	}
}
