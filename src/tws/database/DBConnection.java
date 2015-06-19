package tws.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 131211�� SA final project �ڶ��顣 �鳤����ʯ�� Project:TWS(Tool Warehouse
 * System)���ֿ߲����ϵͳ
 * 
 * ��ݿ�������,������ݿ��������ر�
 */
public class DBConnection {
	
	/**
	 * ��̬����飬���ظ���ʱ�ͼ����������μ���
	 */
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");	//������
		}catch(ClassNotFoundException e){
			System.out.println("driver failure!");	//��û�ҵ�
		}
	}
	
	/**
	 * ������ݿ⣬����Connection����
	 * 
	 * @return ��ݿ����Ӷ���
	 */
	public static Connection getConnection() {
		String conurl = "jdbc:mysql://localhost:3306/tws?useUnicode=true&CharacterEncoding=utf-8";
		String username = "root";
		String userpassword = "19920104yin";
		Connection con = null;// ������ݿ����ӵĳ�Ա����
		try {
			// �Ի�ȡ��������Ӳ���һ����ݿ�����
			con = DriverManager.getConnection(conurl, username, userpassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection failure!");// ����ʧ��
		}
		return con;
	}

	/**
	 * �ر���ݿ�����
	 * @param rs Ҫ�رյ�ResultSet����
	 * @param st Ҫ�رյ�Statement����
	 * @param con Ҫ�رյ�Connection����
	 */
	public static void releaseConnection(ResultSet rs, Statement st,Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
			}
		}
	}
}
