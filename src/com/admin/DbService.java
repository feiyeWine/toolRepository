package com.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.user.User;

/**
 * 操作数据库
 * @author YR
 *
 */
public class DbService {
	public void addUser(User user){
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		String sql = "insert into employee"
				+ "(Employee_Id, Employee_Password, Employee_Name, Employee_Authority, Employee_Department) values(?,?,?,?,?)";
		try {
			ps = connection.prepareStatement(sql);

			ps.setString(1, user.getId());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getName());
			ps.setString(4, user.getAuthory());
			ps.setString(5,user.getDepartment());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public User hasUser(String userId, String password) {
		User user = new User();
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from employee where Employee_Id= ? and Employee_Password = ?";

		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				user.setId(rs.getString("Employee_Id"));
				user.setPassword(rs.getString("Employee_Password"));
				user.setName(rs.getString("Employee_Name"));
				user.setAuthory(rs.getString("Employee_Authority"));
				user.setDepartment(rs.getString("Employee_Department"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(rs, ps, connection);
		}

		return user;
	}
	//注册时判断有无同名
	public boolean hasSameName(String userId) {
		String name = null;
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from employee where Employee_Id=?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, userId);
			rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString("Employee_Id");
				if (name.equals(userId)) {
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(rs, ps, connection);
		}
		return false;

	}
	//登录时判断有无同名
	public boolean hasLogSame(String id,String password){
		String name = null;
		String pwd = null;
		Connection connection = DbConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from employee where Employee_Id=? and Employee_Password = ?";
		try {
			ps = connection.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2,password);
			rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString("Employee_Id");
				pwd = rs.getString("Employee_Password");
				if (name.equals(id)&&pwd.equals(password)) {
					return true;
				}else{
					return false;
				}
			}else{
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DbConnection.closeConnection(rs, ps, connection);
		}
		return false;
	}
}
