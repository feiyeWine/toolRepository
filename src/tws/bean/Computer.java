package tws.bean;

/**
 * 
 * 计算机修理工具类
 */
public class Computer extends Tool{
	
	@Override
	public String getToolType() {
		return Computer.class.getSimpleName();
	}

}
