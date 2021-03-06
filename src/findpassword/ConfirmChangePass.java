package findpassword;

import java.sql.Connection;
import java.sql.PreparedStatement;

import data.DbConnect;

public class ConfirmChangePass {
	/*
	 * 张松磊  201226010427    2015/05/01
	 */
	
	//更新数据库用户密码的方法
	public void confirmPass(String userName,String userPassword) {
		
		Connection conn = null;
		
		try {
			new DbConnect();
			//取得数据库的连接
			conn = DbConnect.getConnection();
			//定义数据库更新语句
			String updateSql = null;
			
			//用户数据库更新语句
			updateSql = "Update user set password = ? Where userName = ?";
			
			PreparedStatement pst = conn.prepareStatement(updateSql);
			pst.setString(1,userPassword);
			pst.setString(2,userName);
			pst.executeUpdate();
					
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			}catch(Exception e) {}
		}
	}

}
