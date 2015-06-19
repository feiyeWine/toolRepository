package tws.bean;

/**
 * 131211�� SA final project �ڶ��顣 �鳤����ʯ�� Project:TWS(Tool Warehouse
 * System)���ֿ߲����ϵͳ
 * 
 * ��Աbean�� 
 */
public class Employee {
	
	private String id; // id
	private String name; // ����
	private String password; // ����
	private String authority; // Ȩ�� --��ʾ��Ϊ��ͨԱ��/ר��
	private String department; // ���ڲ��ţ����ڲ��Ų�ͬ���ɻ�ȡ�Ĺ����಻ͬ

	public static final String Authority_Normal = "normal";	  //��ͨԱ��Ȩ�޳���
	public static final String Authority_Advance = "advance"; //�߼�Ա��Ȩ�޳���
	
	/**
	 * @return ��Աid
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id ��Ա��id
	 */
	public void setId(String id) {
		this.id = id;
	}

		
	/**
	 * @return ��Ա����
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * @param name ��Ա����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return ��Ա��½TWSϵͳ������
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password ��Ա��½TWSϵͳ������
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return ��Ա��Ȩ��
	 */
	public String getAuthority() {
		return authority;
	}

	/**
	 * @param authority ��Ա��Ȩ��
	 */
	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	/**
	 * @return ��Ա�Ĳ�����
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * @param department ��Ա�Ĳ�����
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
