package myjavapro;


//package swings.code;
import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

//import javax.swing.table.*;
class showInTable extends JFrame
{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	JButton loadAll=new JButton("PRESS HERE");

	
	
 public showInTable() 
    {
	   
	     setLayout(null);
	  
	   loadAll.setBounds(100, 10, 200, 50);
	   add( loadAll);
	   loadAll.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
		fillTable();
			
		}
	});
	   
	   setSize(650,700);
	   setLocation(700,1);
	   setVisible(true);
	  /* }
		catch(Exception ex){ex.printStackTrace();}*/
    }
 
 void fillTable()
 {
	   try {
			Class.forName("com.mysql.jdbc.Driver");
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
		   String sql = "Select * from donation ";
		    pstmt = con.prepareStatement(sql);
		    rs = pstmt.executeQuery();
		   ResultSetMetaData md = rs.getMetaData();
		   Vector<String> columnNames = new Vector<String>();
		   int columns = md.getColumnCount();
		   for (int i = 1; i <= columns; i++) {
		   columnNames.addElement( md.getColumnName(i) );
		   }
		  //--------------------------------------------------
		   Vector<Object> data = new Vector<Object>();
		   while (rs.next())
		   {
		   Vector<Object> row = new Vector<Object>(columns);
		   for (int i = 1; i <= columns; i++)
		       {
		          row.addElement( rs.getObject(i) );
		       }
		   data.addElement(row);
		   }
		   rs.close();
		   pstmt.close();
		   JTable table = new JTable(data,columnNames);
		 	
		   JScrollPane scrollPane = new JScrollPane( table );
		   table.setBackground(Color.YELLOW);
		   table.setSelectionBackground(Color.red);
		   
		   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
		 scrollPane.setBounds(100, 100, 400, 200);
		   add( scrollPane );
 }
catch(Exception nex)
	   {
		   nex.printStackTrace();
	   }
 }
	   
}

public class jTableShow extends showInTable
{
	public static void main(String args[])
{
	new showInTable();
	
}
}




