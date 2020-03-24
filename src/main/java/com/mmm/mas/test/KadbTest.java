package com.mmm.mas.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class KadbTest {
	public static void main(String[] args) throws Exception {
		Connection con;
		String url = "jdbc:kingbase8://192.168.1.222:54321/jdbctest";
		String username = "SYSTEM";
		String password = "kaadmin";
		Class.forName("com.kingbase8.Driver");
//		DriverManager.registerDriver(new com.kingbase8.Driver());

		con = DriverManager.getConnection(url, username, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from t1");
		while (rs.next())
			System.out.println(rs.getObject(1));

		rs.close();
		stmt.close();
	}
}
