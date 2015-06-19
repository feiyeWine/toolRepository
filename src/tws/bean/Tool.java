package tws.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 131211班 SA final project 第二组。 组长：蔡石林 Project:TWS(Tool Warehouse
 * System)工具仓库管理系统
 * 
 * 基础工具类,表示某一工具实体类
 * 
 */
public abstract class Tool {

	protected String id; // id
	protected String name; // 工具名
	protected float price; // 工具价格
	protected int number; //库存，当=0时表示不可借
//	protected int typeId; // 工具分类 ：目前分成 4种贵重类+1种廉价类
	
	
	/**
	 * @return 工具id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id 工具id
	 */
	public void setId(String id) {
		this.id = id;
	}
		
	/**
	 * @return 工具的库存
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number 工具的库存
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * @return 工具名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 工具名称
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 工具的价格
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price 工具的价格
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
	 * 抽象方法， 获取tool的种类
	 * @return tool type
	 */
	public abstract String getToolType();

	/**
	 * 根据tool type 将resultSet封装成对应的tool类 
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
