package tws;

import java.util.List;
import java.util.Map;

import tws.bean.Employee;
import tws.bean.ExpensiveBorrowed;
import tws.bean.InexpensiveBorrowed;
import tws.bean.Tool;
import tws.database.GetBeansFromDB;

public class Test {
	
	public static void main(String args[]) {
		//�鿴Ա����Ϣ
		Employee employee = GetBeansFromDB.getEmployeeBean("001");
		
		System.out.println(employee);
		
		//�鿴�ɽ����۹���
//		List<Tool> inexpensives = GetBeansFromDB.getInexpensiveBorrowableTools(employee.getId()); 
//		for(Tool tool: inexpensives)
//			System.out.println(tool);
		
		//�鿴�ɽ���ع���
		List<Tool> expensives = GetBeansFromDB.getExpensiveBorrowableTools(employee.getId());
		for(Tool tool: expensives)
			System.out.println(tool);
		boolean isSuccess = GetBeansFromDB.borrowTool(employee.getDepartment(), "001", employee.getId());
		System.out.println(isSuccess);
		expensives = GetBeansFromDB.getExpensiveBorrowableTools(employee.getId());
		for(Tool tool: expensives)
			System.out.println(tool);
		
//		List<InexpensiveBorrowed> tools1  = GetBeansFromDB.getInexpensiveBorroweds(employee.getId());
//		//System.out.println(tools.get(0).getToolType());
//			for(InexpensiveBorrowed tool: tools1){
//				System.out.println(tool);
//			}
//		//获取贵重工具
//		List<ExpensiveBorrowed> tools2 = GetBeansFromDB.getExpensiveBorroweds(employee.getId());
//		for(ExpensiveBorrowed tool: tools2){
//			System.out.println(tool);
//		}
		//���ù���
//		boolean isSuccess = GetBeansFromDB.borrowTool(employee.getDepartment(), "001", employee.getId());
//		System.out.println(isSuccess);
		
		//�黹����
//		boolean isSuccess = GetBeansFromDB.returnTool(employee.getDepartment(), "001", employee.getId(), new Date(System.currentTimeMillis()));
//		System.out.println(isSuccess);
		
		//ע���
//		boolean isSuccess = GetBeansFromDB.deleteTool(employee.getDepartment(),"001", employee.getId(),new Date(System.currentTimeMillis()));
//		System.out.println(isSuccess);
		
//		GetBeansFromDB.getExpensiveBorrowableTools(employee.getId());
	}
}
