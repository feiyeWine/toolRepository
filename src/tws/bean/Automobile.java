package tws.bean;

/**
 * ������������
 */
public class Automobile extends Tool{

	@Override
	public String getToolType() {
		return Automobile.class.getSimpleName();
	}
}
