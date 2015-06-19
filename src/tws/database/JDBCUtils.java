package tws.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * ���ݿ���������� �� ִ��sql��䣬��ȡ���
 */
public class JDBCUtils {

	static Connection conn = null;
	static Statement st = null;
	static ResultSet rs = null;
	/**
	 * ִ�в�ѯ��䣬�����ؽ����
	 * 
	 * @param sql
	 * @return
	 */
	public static ResultSet excuteQuery(String sql) {
		try {
			//�������ݿ�
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			System.out.println("execute query fail");
			return null;
		} 
	}

	/**
	 * ִ�и�����䡪��update,insert,delete�����ز����Ƿ�ɹ�
	 * 
	 * @param sql
	 * @return
	 */
	public static boolean excuteUpdate(String sql) {
		boolean isSuccess = false;
		try {
			// �������ݿ�
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			conn.setAutoCommit(false);
			int result = st.executeUpdate(sql);
			if(result > 0 ){
				isSuccess = true;
				conn.commit();
			}else{
				isSuccess = false;
			}
		} catch (SQLException e) {
			try {
				System.out.println("execute update fail");
				conn.rollback();
				isSuccess = false;
			} catch (SQLException e2) {
			}finally{
				// �ر����ݿ�����
				DBConnection.releaseConnection(rs, st, conn);
			}
		} 
		return isSuccess;
	}

	public static void onDBComplete() {
		// �ر����ݿ�����
		DBConnection.releaseConnection(rs, st, conn);
	}
}
