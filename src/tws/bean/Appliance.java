package tws.bean;

/**
 * �ҵ�������
 *
 */
public class Appliance extends Tool{ 

	@Override
	public String getToolType() {
		return Appliance.class.getSimpleName();
	}
}
