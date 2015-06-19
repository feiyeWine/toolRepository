package tws.bean;

/**
 * 汽车修理工具类
 */
public class Automobile extends Tool{

	@Override
	public String getToolType() {
		return Automobile.class.getSimpleName();
	}
}
