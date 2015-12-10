package myjavapro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public  class sqlconn {
public static Connection getConnection()
{
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return con;
}
}
