package com.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 连接数据库
 * @author YR
 *
 */
public class DbConnection {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		Connection con = null;
		/*String url = "jdbc:mysql://127.0.0.1:3306/test";
		String userName ="root";
		String pwd = "19920104yin";*/
		try {
//			con = DriverManager.getConnection(url,userName,pwd);
			con =  (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/tws?useUnicode=true&characterEncoding=utf8&user=root&password=19920104yin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;		
	}
	//关闭数据库
	public static void closeConnection(ResultSet rs,Statement st,Connection conn){
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}if(conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
