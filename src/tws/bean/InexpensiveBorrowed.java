package tws.bean;

/**
 * ���۹��߽��ü�¼��
 */
public class InexpensiveBorrowed extends Borrowed{
	protected static final String STATUS_NORMAL = "normal";
	protected static final String STATUS_DAMAGE = "damage";
	
	protected String status; //״̬��������������� �� ��

	/**
	 * ��ȡ��ǰ���ù��ߵ�״̬
	 * @return
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ���õ�ǰ���ù��ߵ�״̬
	 * @param status
	 */
	public void setStatus(String status) {
		if(STATUS_NORMAL.equals(status)|| STATUS_DAMAGE.equals(status))
			this.status = status;
		else{
			//Ĭ������Ϊnormal
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
