package tws.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 数据库操作帮助类 ， 执行sql语句，获取结果
 */
public class JDBCUtils {

	static Connection conn = null;
	static Statement st = null;
	static ResultSet rs = null;
	/**
	 * 执行查询语句，并返回结果集
	 * 
	 * @param sql
	 * @return
	 */
	public static ResultSet excuteQuery(String sql) {
		try {
			//连接数据库
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
	 * 执行更新语句——update,insert,delete，返回操作是否成功
	 * 
	 * @param sql
	 * @return
	 */
	public static boolean excuteUpdate(String sql) {
		boolean isSuccess = false;
		try {
			// 连接数据库
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
				// 关闭数据库连接
				DBConnection.releaseConnection(rs, st, conn);
			}
		} 
		return isSuccess;
	}

	public static void onDBComplete() {
		// 关闭数据库连接
		DBConnection.releaseConnection(rs, st, conn);
	}
}
