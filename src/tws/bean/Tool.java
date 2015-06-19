package tws.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 131211�� SA final project �ڶ��顣 �鳤����ʯ�� Project:TWS(Tool Warehouse
 * System)���ֿ߲����ϵͳ
 * 
 * ����������,��ʾĳһ����ʵ����
 * 
 */
public abstract class Tool {

	protected String id; // id
	protected String name; // ������
	protected float price; // ���߼۸�
	protected int number; //��棬��=0ʱ��ʾ���ɽ�
//	protected int typeId; // ���߷��� ��Ŀǰ�ֳ� 4�ֹ�����+1��������
	
	
	/**
	 * @return ����id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id ����id
	 */
	public void setId(String id) {
		this.id = id;
	}
		
	/**
	 * @return ���ߵĿ��
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number ���ߵĿ��
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * @return ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return ���ߵļ۸�
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price ���ߵļ۸�
	 */
	public void setPrice(float price) {
		this.price = price;
	}

//	public int getTypeId() {
//		return typeId;
//	}
//
//	public void setTypeId(int typeId) {
//		this.typeId = typeId;
//	}
//	
	
	@Override
	public String toString() {
		return "["+ getClass().getSimpleName()+" : id "+id
				+" name "+name 
				+" price "+ price
				+" number "+ number+"]";
	}
	
	/**
	 * ���󷽷��� ��ȡtool������
	 * @return tool type
	 */
	public abstract String getToolType();

	/**
	 * ����tool type ��resultSet��װ�ɶ�Ӧ��tool�� 
	 * @param rs
	 */
	public void mappingResultSet(ResultSet rs){
		String type = getToolType();
		try {
			this.id = rs.getString(type+"_id");
			this.name = rs.getString(type+"_name");
			this.price = rs.getFloat(type+"_price");
			this.number = rs.getInt(type+"_num");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
