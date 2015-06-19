package tws.bean;

/**
 * 家电修理工具
 *
 */
public class Appliance extends Tool{ 

	@Override
	public String getToolType() {
		return Appliance.class.getSimpleName();
	}
}
