package DataBase;

import java.sql.*;

import Windows.WindowsFrame;

public class SqlConnect {
	private static Connection con = null;
	private static Statement stmt = null;
	private static boolean flag;

	public static Connection SqlCon() {
		String url = "jdbc:mysql://localhost:3306/lottery?noAccessToProcedureBodies=true";//连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
		}
		try {
			con = DriverManager.getConnection(url,WindowsFrame.username,WindowsFrame.password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	//新用户注册
	public static int newUserRegister(String newUsername, String newPassword,String Phone) {
		// TODO Auto-generated method stub
		String sql = "select name from bettor where name ='"+newUsername+"'";
		ResultSet set  = querySQL(sql);
		//String oldUsername;
		try {
			if(set.next())
			{
				return 0;
			}
			//将用户信息插入数据库
			sql = "CALL CREATE_BETTOR("+newUsername+","+newPassword+","+Phone+")";
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 1;
	}
	//用户登陆
	public static void OldUserLogin(String username,String password)
	{
		try {
			stmt = SqlCon().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		}
	}
	public static void createNewTerm() {//创建当前期号
		String sql = "INSERT INTO TERMS(TNO) VALUES(CURDATE())";
		updateSQL(sql);
		sql = "UPDATE CURTERM SET TNO=(SELECT MAX(TNO)FROM TERMS)";
		updateSQL(sql);
	}
	public static ResultSet querySQL(String sql)//执行查询
	{
		ResultSet set=null;
		try {
			stmt = SqlCon().createStatement();
			set = stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}
	
	public static void updateSQL(String sql)//执行更新
	{
		try {
			stmt = SqlCon().createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public static String cheakLucky(){//查看当期开奖 
		
		String sql = "select tno from term where lucky ='blank';";
		ResultSet set = querySQL(sql);
		try {
			while(set.next())
			{
				return set.getString("tno");
					
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
