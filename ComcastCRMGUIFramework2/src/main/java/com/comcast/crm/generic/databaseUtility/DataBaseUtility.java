package com.comcast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;



public class DataBaseUtility {
	Connection con;
	
	public void getDbConnection(String url,String username,String password) throws Throwable
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection(url,username,password);
	}
	catch(Exception e)
	{
	}
	}
	public void getDbConnection() throws Throwable
	{
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 con = DriverManager.getConnection("jdbc:mysql://106.51.90.215:3333/projects","root@%","root");
	}
	catch(Exception e)
	{
	}
	}
	public void closeDbConnetion() throws SQLException
	{
		con.close();
	}
	public ResultSet executeConSelectQurery(String query)
	{
		
		ResultSet result=null;
		try {
			Statement stat=con.createStatement();
			result=stat.executeQuery(query);
		}catch(Exception e)
		{
		}
		return result;
		}
	public int executeNonSelectQuery(String qurey)
	{
		int result=0;
		try {
			Statement stat=con.createStatement();
			stat.executeUpdate(qurey);
		}catch(Exception e)
		{
		}
		return result;
		}
		
	}

