package YccSenaoOOP.Handler.impl.DB.impl;

import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import YccSenaoOOP.Handler.impl.DBAdapter;
import YccSenaoOOP.Handler.impl.DB.IDBHandler;
import YccSenaoOOP.MyBackupCandidate.Candidate;

public abstract class AbstractDBHandler implements IDBHandler {
	private static Logger logger = Logger.getLogger(AbstractDBHandler.class);
	
	private static String dbPropertiesFilePath = "D:\\Git\\Repository\\Senao\\github.com\\YccSenaoOOP\\src\\db.properties";

	public AbstractDBHandler() {
		this.init();
	}

	private String YccSenaoOOP_DB_Driver;
	private String YccSenaoOOP_DB_Url;	
	private String YccSenaoOOP_DB_Account;
	private String YccSenaoOOP_DB_Password;	
	private void init() {
		logger.debug("");
		try {
			FileInputStream fis = new FileInputStream(dbPropertiesFilePath);
			Properties properties = new Properties();
			properties.load(fis);

			this.YccSenaoOOP_DB_Driver = properties.getProperty("YccSenaoOOP.DB.Driver");
			this.YccSenaoOOP_DB_Url = properties.getProperty("YccSenaoOOP.DB.Url");			
			this.YccSenaoOOP_DB_Account = properties.getProperty("YccSenaoOOP.DB.Account");
			this.YccSenaoOOP_DB_Password = properties.getProperty("YccSenaoOOP.DB.Password");

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 自行建立資料庫連線與執行範例
		// try {
		//   System.out.println("測試資料庫自行連線取得");
		//   Class.forName("com.mysql.jdbc.Driver");
		//	 java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/YccSenaoOOP", "帳號", "密碼");
		//	 java.sql.Statement stmt = con.createStatement();
		//	 java.sql.ResultSet rs = stmt.executeQuery("select * from username");
		//	 while (rs.next()) {
		//	     String s = rs.getString(1);
		//		 logger.debug(s);
		//	 }
		//	 rs.close();
		//	 con.close();
		// }  catch (Exception e) {
		//	 e.printStackTrace();
		// }
	}

	private java.sql.Connection con = null;
	java.sql.Connection getConnect() {
		if(this.con==null) { this.openConnection(); }
		return this.con;
	}
	
	public void openConnection() {
		try {
			if (con == null || con.isClosed()) {
				// 建立資料庫連線
				Class.forName(YccSenaoOOP_DB_Driver);
				con = DriverManager.getConnection(YccSenaoOOP_DB_Url, YccSenaoOOP_DB_Account, YccSenaoOOP_DB_Password);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//取資料源範例
		/*
	    try {
	        Context ctx=null;
	        DataSource dataSource=null;
	        ctx = new javax.naming.InitialContext();
	        javax.naming.Context envCtx = (javax.naming.Context) ctx.lookup("java:comp/env"); //TOMCAT的制式前置字元
	        dataSource = (javax.sql.DataSource) envCtx.lookup("jdbc/YccSenaoOOP"); //設定在context.xml
	        con= dataSource.getConnection();
	    } catch (javax.naming.NamingException ne) {
	      ne.printStackTrace();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		*/
	}

	public void closeConnection() {
		// 關閉資料庫連線
		try {
			if (con != null && !con.isClosed()) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public byte[] perform(Candidate candidate, byte[] target) {

		// 可實作一些共用的部位

		return doPerform(candidate, target);
	}

	public abstract byte[] doPerform(Candidate candidate, byte[] target);

}
