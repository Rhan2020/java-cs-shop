package com.Jie.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Jie.Entity.Entity;

/**
 * Created by Jie on 2016/1/15.
 */
public class UserDao {

	/**
	 * ʵ�ֵ�¼����
	 */

	public int doLogin(User lu) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		String sql = "";
		sql = "select * from user where username=?";
		
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.err.println("获取连接失败");
				return 0;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, lu.getUsername());
			rs = ps.executeQuery();//���ܽ����
			if (rs.next()) {
				u = new User();
				//��ȡ�����������ԣ���ʼ�����¶�����
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setFlag(rs.getInt("flag"));
				
				if(u.getUsername().equals(lu.getUsername())&&u.getPassword().equals(lu.getPassword())){
					return u.flag;
				}
				
				if(u.getUsername().equals(lu.getUsername())&&!u.getPassword().equals(lu.getPassword())){
					return 9;// 返回9表示用户已存在但密码错误
				}
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return 0;
	}
	public boolean add(Entity ad) {
		UserDao ud =new UserDao();
		User u =new User();
		u.setUsername(ad.getUsername());
		u.setPassword(ad.getPassword());
		u.setFlag(ad.getRole());
		if(ud.doLogin(u)==0){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "";
			sql = "insert into user (username,password,flag) values(?,?,?)";
			
			try {
				conn = DBUtils.getConnection();
				if (conn == null) {
					System.err.println("获取连接失败");
					return false;
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, ad.getUsername());
				ps.setString(2, ad.getPassword());
				ps.setInt(3, ad.getRole());
				int num = ps.executeUpdate();
				if (num > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				DBUtils.close(rs, ps, conn);
			}
		}else{
			System.out.println("用户已存在！");
			return false;
		}
	}
	public boolean del(Entity e) {
		// 检查用户是否存在（只需要用户名）
		Entity userExists = findUser(e.getUsername());
		if(userExists != null){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "";
			sql = "delete from user where username= ?";
			
			try {
				conn = DBUtils.getConnection();
				if (conn == null) {
					System.err.println("获取连接失败");
					e.setResult(false);
					return false;
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, e.getUsername());
				int num = ps.executeUpdate();
				if (num > 0) {
					e.setResult(true);
					return true;
				} else {
					e.setResult(false);
					return false;
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
				e.setResult(false);
				return false;
			} finally {
				DBUtils.close(rs, ps, conn);
			}
		}else{
			System.out.println("用户不存在！");
			e.setResult(false);
			return false;
		}
	}
	public boolean updateUser(Entity e) {
		// 检查用户是否存在
		Entity userExists = findUser(e.getUsername());
		if(userExists != null){
			Connection conn = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "";
			sql = "update user set password=?,flag=? where username=?";
			try {
				conn = DBUtils.getConnection();
				if (conn == null) {
					System.err.println("获取连接失败");
					return false;
				}
				ps = conn.prepareStatement(sql);
				ps.setString(1, e.getPassword());
				ps.setInt(2, e.getRole());
				ps.setString(3, e.getUsername());
				int num = ps.executeUpdate();
				if (num > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e3) {
				e3.printStackTrace();
				return false;
			} finally {
				DBUtils.close(rs, ps, conn);
			}
		}else{
			System.out.println("用户不存在，修改失败！");
			return false;
		}
	}
	public Entity findUser(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Entity e = null;
		String sql = "";
		sql = "select * from user where username=?";
		
		try {
			conn = DBUtils.getConnection();
			if (conn == null) {
				System.err.println("获取连接失败");
				return null;
			}
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();//���ܽ����
			if (rs.next()) {
				e=new Entity();
				//��ȡ�����������ԣ���ʼ�����¶�����
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
				e.setRole(rs.getInt("flag"));
			}
		} catch (SQLException e4) {
			e4.printStackTrace();
		} finally {
			DBUtils.close(rs, ps, conn);
		}
		return e;
	}
	
}