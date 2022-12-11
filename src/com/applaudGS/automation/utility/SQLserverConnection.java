package com.applaudGS.automation.utility;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class SQLserverConnection {
 /**
  * @param args
  */
  public SQLserverConnection() throws ClassNotFoundException, SQLException {
	  
	  
//   String query = "select * from vs_context"; 
//  String query = "SELECT count(*) as status FROM INFORMATION_SCHEMA.COLUMNS where Table_Name='vs_context'"; 
  // String ss=GlobalFunctions.launchProperties(browser);
   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
      //   Connection connection = DriverManager.getConnection("jdbc:sqlserver://167.114.119.195;database=VS_Dev;integratedSecurity=true;");
   //String DBName=
   
   
  // Connection connection = DriverManager.getConnection("jdbc:sqlserver://167.114.119.195;database=VS_QA;","Sa", "Applaud@2016");
   
   Connection connection = DriverManager.getConnection("jdbc:sqlserver://abc.Net;database=ABC_QA;","applaudgs", "abc@2017");
         
         
       
    Statement stmt = connection.createStatement();
         
         
 //     ResultSet rs = stmt.executeQuery(query);
       
      ResultSet tables = connection.getMetaData().getTables(null, null, "ransgcfvsseezzyv", null);
      if (tables.next()) {
    	  System.out.println("Table Created & It Exists");
    	}
    	else {
    		System.out.println("Table Not Created");
    	}
    
      
      /*if(rs.getFetchSize()<=0){
    	  System.out.println("Table Created");
      }
      else{
    	  System.out.println("Table Not Created");
      }
      System.out.println("Resultant Value Is : "+   rs.getFetchSize());*/
  //    System.out.println("nnnnnnnnnnnn"+ rs.getInt(query));
      
      
       /*while(rs.next()){
    	  String C_ID=rs.getString("C_ID"); 
          String C_Name=rs.getString("C_Name");
          String C_Address=rs.getString("C_Address");
          
          System.out.println(C_ID+" "+C_Name+" "+C_Address);
        
          
         }*/
      connection.close();
     }
     public static void main(String[] args) throws ClassNotFoundException, SQLException {
     new SQLserverConnection();
     }
  }
