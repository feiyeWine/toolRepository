package tws.database;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import tws.bean.Appliance;
import tws.bean.Automobile;
import tws.bean.Borrowed;
import tws.bean.Computer;
import tws.bean.Construction;
import tws.bean.Employee;
import tws.bean.ExpensiveBorrowed;
import tws.bean.InexpensiveBorrowed;
import tws.bean.Tool;

/**
 * �ṩ��ȡbean�ķ����� ������ĸ��ֲ����װ��SQL��䣬����JDBCUtilsִ��SQL��������ȡ�Ľ��ת����Bean��
 */
public class GetBeansFromDB {

	/**
	 * ���� Ա�� :Ա������Ϣ ,�ѽ��ù��� ,�ɽ��ù��� ,�黹 ;����Ա�� ���߽������ ,�����Ϣ
	 */

	private static final int TYPE_EXPENSIVE = 1;
	private static final int TYPE_INEXPENSIVE = 2;

	private static final String[] toolTypes = { "construction", "appliance",
			"automobile", "computer" };
	
	private static final long MillsOfMonth = 86400000*30L;
	/**
	 * ͨ��Ա��id ��ȡԱ������Ϣ�� ���ض�Ӧid��Ա������
	 * 
	 * @param id
	 * @return
	 */
	public static Employee getEmployeeBean(String employeeId) {
		// ��װsql
		String sql = "select * from Employee where employee_id=" + employeeId;
		ResultSet rs = JDBCUtils.excuteQuery(sql);
		if (rs == null) {
			System.out
					.println("There is no employee whose id is " + employeeId);
			return null;
		}
		Employee emp = null;
		try {
			if (rs.next()) {
				emp = new Employee();
				emp.setId(rs.getString("employee_id"));
				emp.setName(rs.getString("employee_name"));
				emp.setPassword(rs.getString("employee_password"));
				emp.setAuthority(rs.getString("employee_authority"));
				emp.setDepartment(rs.getString("employee_department"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.onDBComplete();
		}
		return emp;
	}

	/**
	 * ͨ��Ա��id,�鿴�ѽ��õ����й��ߣ������ѽ��ù����б�
	 * 
	 * @param employeeId
	 * @return
	 */
	public static List<Borrowed> getBorroweds(String employeeId) {
		List<Borrowed> records = new ArrayList<Borrowed>();
		// ��ȡ���õĹ��ع����б�
		records.addAll(getExpensiveBorroweds(employeeId));
		// ��ȡ���õ����۹����б�
		records.addAll(getInexpensiveBorroweds(employeeId));
		return records;
	}

	/**
	 * ͨ��Ա��id,�鿴�ѽ��õĹ��ع��ߣ������ѽ��ù��ع����б�
	 */
	public static List<ExpensiveBorrowed> getExpensiveBorroweds(String employeeId) {
		List<ExpensiveBorrowed> records = null;
		// ��װsql
		String sql = "select * from expensive where employee_id =" + employeeId;
		ResultSet rs = JDBCUtils.excuteQuery(sql);
		if (rs == null) {
			// û�н�����Ϣ
			System.out.println("Employee whose id is " + employeeId
					+ " has no expensive borrowed records");
			return null;
		}
		try {
			records = new ArrayList<ExpensiveBorrowed>();
			ExpensiveBorrowed borrowed = null;
			while (rs.next()) {
				borrowed = new ExpensiveBorrowed();
				borrowed.setToolId(rs.getString("tool_id"));
				borrowed.setEmployeeId(rs.getString("employee_id"));
				borrowed.setToolDepartment(rs.getString("tool_department"));
				borrowed.setBorrowTime(rs.getDate("borrow_time"));
				borrowed.setReturnTime(rs.getDate("return_time"));
				records.add(borrowed);
			}
		} catch (SQLException e) {
		} finally {
			JDBCUtils.onDBComplete();
		}
		return records;
	}

	/**
	 * ͨ��Ա��id,�鿴�ѽ��õ����۹��ߣ������ѽ������۹����б�
	 */
	public static List<InexpensiveBorrowed> getInexpensiveBorroweds(
			String employeeId) {
		List<InexpensiveBorrowed> records = null;
		// ��װsql
		String sql = "select * from inexpensive where employee_id ="
				+ employeeId;
		ResultSet rs = JDBCUtils.excuteQuery(sql);
		if (rs == null) {
			// û�н�����Ϣ
			System.out.println("Employee whose id is " + employeeId
					+ " has no inexpensive borrowed records");
			return null;
		}
		try {
			records = new ArrayList<InexpensiveBorrowed>();
			InexpensiveBorrowed borrowed = null;
			while (rs.next()) {
				borrowed = new InexpensiveBorrowed();
				borrowed.setToolId(rs.getString("tool_id"));
				borrowed.setEmployeeId(rs.getString("employee_id"));
				borrowed.setToolDepartment(rs.getString("tool_department"));
				borrowed.setBorrowTime(rs.getDate("borrow_time"));
				borrowed.setStatus(rs.getString("status"));
				records.add(borrowed);
			}
		} catch (SQLException e) {
		} finally {
			JDBCUtils.onDBComplete();
		}
		return records;
	}

	/**
	 * ͨ��Ա��id,�鿴��Ա���ɽ��õ����й����б�
	 */
	public static List<Tool> getAllBorrowableTools(String employeeId) {
		List<Tool> tools = new ArrayList<Tool>();
		// ��ȡ�ɽ����۹����б�
		tools.addAll(getInexpensiveBorrowableTools(employeeId));
		// ��ȡ�ɽ���ع����б�
		tools.addAll(getExpensiveBorrowableTools(employeeId));
		return tools;
	}

	private static List<Tool> getBorrowableToolsByType(String employeeId,
			int type) {
		String str = "";
		if (type == TYPE_EXPENSIVE)
			str += ">";
		else if (type == TYPE_INEXPENSIVE) {
			str += "<=";
		}
		List<Tool> tools = new ArrayList<Tool>();
		ResultSet rs = null;
		String sql = "";
		for (int i = 0; i < toolTypes.length; i++) {
			// ���Ĵβ�ѯ
			sql = "select * from " + toolTypes[i] + " where " + toolTypes[i]
					+ "_price " + str + " 200";
			rs = JDBCUtils.excuteQuery(sql);
			if (rs == null) {
				// ��ݿ���û�з�������ļ�¼
				System.out
						.println("There is no inexpensive borrowable tools in the "
								+ toolTypes[i]);
				continue;
			}
			try {
				while (rs.next()) {
					// �ж������ֹ���
					Tool tool = null;
					switch (i) {
					case 0:
						tool = new Construction();
						break;
					case 1:
						tool = new Appliance();
						break;
					case 2:
						tool = new Automobile();
						break;
					case 3:
						tool = new Computer();
						break;
					}
					// ��result set��ɶ�Ӧ�Ĺ���
					tool.mappingResultSet(rs);
					tools.add(tool);
				}
			} catch (SQLException e) {
			} finally {
				JDBCUtils.onDBComplete();
			}
		}
		// ��װsql
		// String sql =
		// "select * from construction,appliance,automobile,computer " +
		// "where construction_price "+ str + " 200 " +
		// "or appliance_price "+ str + "200 " +
		// "or automobile_price "+ str + "200 " +
		// "or computer_price "+ str + " 200";

		return tools;
	}

	/**
	 * ͨ��Ա��id,�鿴��Ա���ɽ��õ����۹����б�
	 */
	public static List<Tool> getInexpensiveBorrowableTools(String employeeId) {
		return getBorrowableToolsByType(employeeId, TYPE_INEXPENSIVE);
	}

	/**
	 * ͨ��Ա��id ��ȡ��Ա���ܽ��õ����й��ع���
	 */
	public static List<Tool> getExpensiveBorrowableTools(String employeeId) {
		List<Tool> tools = null;
		// ��ȡԱ���Ļ���Ϣ
		Employee emp = getEmployeeBean(employeeId);
		if (emp.getAuthority().equalsIgnoreCase(Employee.Authority_Advance)) {
			// ��Ա��Ϊ�߼�Ա�� ,�ɽ������й��ع���
			return getBorrowableToolsByType(employeeId, TYPE_EXPENSIVE);
		} else if (emp.getAuthority().equalsIgnoreCase(
				Employee.Authority_Normal)) {
			// Ϊ��ͨԱ��
			String department = emp.getDepartment();
			String sql = "select * from " + department + " where " + department
					+ "_price >200";
			System.out.println(sql);
			ResultSet rs = JDBCUtils.excuteQuery(sql);
			if (rs == null) {
				// ��ݿ���û�з�������ļ�¼
				System.out
						.println("There is no inexpensive borrowable tools in the db");
				return null;
			}
			try {
				tools = new ArrayList<Tool>();
				Tool tool = null;
				while (rs.next()) {
					if (department.equalsIgnoreCase(Construction.class
							.getSimpleName().toLowerCase())) {
						tool = new Construction();
					} else if (department.equalsIgnoreCase(Appliance.class
							.getSimpleName().toLowerCase())) {
						tool = new Appliance();
					} else if (department.equalsIgnoreCase(Automobile.class
							.getSimpleName().toLowerCase())) {
						tool = new Automobile();
					} else if (department.equalsIgnoreCase(Computer.class
							.getSimpleName().toLowerCase())) {
						tool = new Computer();
					}
					tool.mappingResultSet(rs);
					tools.add(tool);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
			} finally {
				JDBCUtils.onDBComplete();
			}
		}
		return tools;
	}

	/**
	 * ���ù���
	 * @param toolId
	 * @param employeeId
	 * @param returnTime
	 * @return �����ɹ���ʧ��
	 */
	public static boolean borrowTool(String department, String toolId,
			String employeeId) {
		// TODO Ӧ���жϿɲ��ɽ�
		// ��borrow������Ӽ�¼
		// ����tool���¼
		Tool tool = getToolBeanByIdAndDept(department, toolId);
		if (tool == null)
			return false;
		String type = tool.getToolType();
		// ����tool��
		String sql = "update " + type + " set " + type + "_num =" + type
				+ "_num -1 where " + type + "_id = " + toolId;
		System.out.println(sql);
		if (!JDBCUtils.excuteUpdate(sql))
			return false;
		float price = tool.getPrice();
		if (price > 200) {
			// ����expensive��
			sql = "insert into tws.expensive(tool_id,employee_id,tool_department,borrow_time,return_time) values("
					+ "\'" + toolId + "\' ," //tool_id
					+ "\'" + employeeId + "\' ,"//employee_id
					+ "\'" + department+ "\' ,"//tool_department
					+ "\'" + new Date(System.currentTimeMillis()) +"\' ,"
					+ "\'" + new Date(System.currentTimeMillis()+MillsOfMonth) + "\' )";
		} else {
			sql = "insert into tws.inexpensive(tool_id,employee_id,tool_department,borrow_time,status) values("
					+ "\'" + toolId + "\' ," //tool_id
					+ "\'" + employeeId + "\' ,"//employee_id
					+ "\'" + department+ "\' ,"//tool_department
					+ "\'" + new Date(System.currentTimeMillis()) +"\' ,"//borrowedTime
					+ "\'normal\'"  + ")"; //status
		}
		System.out.println(sql);
		return JDBCUtils.excuteUpdate(sql);
	}

	/**
	 * �黹tool
	 * 
	 * @param tool
	 * @return
	 */
	public static boolean returnTool(String department, String toolId, String employeeId,
			Date borrowTime) {
		Tool tool = getToolBeanByIdAndDept(department, toolId);
		if (tool == null)
			return false;
		String type = tool.getToolType();
		float price = tool.getPrice();
		// ����tool�� ���
		String sql = "";
		if (price > 200) {
			// ɾ����ر�
			sql = "delete from expensive where tool_id=" 
					+ "\'" + toolId + "\'"
					+ " and employee_id=" 
					+ "\'" + employeeId + "\'" 
					+ " and borrow_time="
					+ "\'" +borrowTime + "\'";
		} else {
			sql = "delete from inexpensive where tool_id=" 
					+ "\'" + toolId + "\'"
					+ " and employee_id=" 
					+ "\'" + employeeId + "\'" 
					+ " and borrow_time="
					+ "\'" +borrowTime + "\'";
		}
		System.out.println(sql);
		if (!JDBCUtils.excuteUpdate(sql))
			return false;
		sql =  "update " + type + " set " + type + "_num =" + type
				+ "_num +1 where " + type + "_id = " + toolId;
		System.out.println(sql);
		return JDBCUtils.excuteUpdate(sql);
	}

	/**
	 * ע���
	 * 
	 */
	public static boolean deleteTool(String department,String toolId, String employeeId,
			Date borrowTime) {
		Tool tool = getToolBeanByIdAndDept(department, toolId);
		if (tool == null)
			return false;
		float price = tool.getPrice();
		String sql = null;
		if (price > 200) {
			// ɾ����ر�
			sql = "delete from expensive where tool_id=" 
					+ "\'" + toolId + "\'"
					+ " and employee_id=" 
					+ "\'" + employeeId + "\'" 
					+ " and borrow_time="
					+ "\'" +borrowTime + "\'";
		} else {
			sql = "delete from inexpensive where tool_id=" + toolId
					+ "\'" + toolId + "\'"
					+ " and employee_id=" 
					+ "\'" + employeeId + "\'" 
					+ " and borrow_time="
					+ "\'" +borrowTime + "\'";
		}
		return JDBCUtils.excuteUpdate(sql);
	}

	/**
	 * ͨ������Ϣ��tool_id��ȡ����bean
	 * @param department
	 * @param toolId
	 * @return
	 */
	private static Tool getToolBeanByIdAndDept(String department, String toolId) {
		String sql = "select * from " + department + " where " + department
				+ "_id = " + toolId;
		ResultSet rs = JDBCUtils.excuteQuery(sql);
		System.out.println(sql);
		if (rs == null) {
			System.out.println("There is no tool whose id is " + toolId);
			return null;
		}
		Tool tool = null;
		try {
			if (rs.next()) {
				if (department.equalsIgnoreCase(Construction.class
						.getSimpleName().toLowerCase())) {
					tool = new Construction();
				} else if (department.equalsIgnoreCase(Appliance.class
						.getSimpleName().toLowerCase())) {
					tool = new Appliance();
				} else if (department.equalsIgnoreCase(Automobile.class
						.getSimpleName().toLowerCase())) {
					tool = new Automobile();
				} else if (department.equalsIgnoreCase(Computer.class
						.getSimpleName().toLowerCase())) {
					tool = new Computer();
				}
				tool.mappingResultSet(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtils.onDBComplete();
		}
		return tool;
	}

//	/**
//	 * ��ݹ���ID ��ȡ���߶���
//	 * 
//	 * @param toolId
//	 * @return
//	 */
//	private static Tool getToolBeanById(String toolId) {
//		String sql = "select * from  construction,appliance,automobile,computer "
//				+ "where construction_id="
//				+ toolId
//				+ " or appliance_id="
//				+ toolId
//				+ " or automobile_id="
//				+ toolId
//				+ " or computer_id="
//				+ toolId;
//		ResultSet rs = JDBCUtils.excuteQuery(sql);
//		if (rs == null) {
//			// ���߲�����
//			System.out.println("There is no tool whose id is " + toolId);
//			return null;
//		}
//		Tool tool = null;
//		ResultSetMetaData rsmd = null;
//		String columnName = null;
//		// ��ȡtool
//		try {
//			while (rs.next()) {
//				// �ж������ֹ���
//				rsmd = rs.getMetaData();
//				columnName = rsmd.getColumnName(1).toLowerCase();
//
//				if (columnName.contains(Construction.class.getSimpleName()
//						.toLowerCase())) {
//					tool = new Construction();
//				} else if (columnName.contains(Appliance.class.getSimpleName()
//						.toLowerCase())) {
//					tool = new Appliance();
//				} else if (columnName.contains(Automobile.class.getSimpleName()
//						.toLowerCase())) {
//					tool = new Automobile();
//				} else if (columnName.contains(Computer.class.getSimpleName()
//						.toLowerCase())) {
//					tool = new Computer();
//				}
//				// ��result set��ɶ�Ӧ�Ĺ���
//				tool.mappingResultSet(rs);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//		} finally {
//			JDBCUtils.onDBComplete();
//		}
//		return tool;
//	}

}
