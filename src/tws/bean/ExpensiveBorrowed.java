package tws.bean;

import java.sql.Date;

/**
 * ���ع��߽��ü�¼��
 */
public class ExpensiveBorrowed extends Borrowed {
	
	protected Date returnTime; // �黹ʱ��

	/**
	 * @return �黹���ߵ�ʱ��
	 */
	public Date getReturnTime() {
		return returnTime;
	}

	/**
	 * @param returnTime
	 *            �黹���ߵ�ʱ��
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
