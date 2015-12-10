package myjavapro;
import java.awt.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Distribution_Search_Cosole extends JFrame 
 {
   JPanel p1,p2,p3;
   JLabel school,amount;
   JComboBox schc;
   JTextField am;
   JButton fe,s1,a1;
   PreparedStatement pst;
	Connection con;
	void function()
	{
		//	a.removeAll();
		schc.addItem("SELECT");
		try{
			pst=con.prepareStatement("select distinct schoolname from distributions");
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			{
				String id=rs.getString("schoolname");
				schc.addItem(id+"");
			}
		}
		catch(Exception qq)
		{
			qq.printStackTrace();
		}
	}
	 void fillTable()
	 {
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
			Object y=schc.getSelectedItem();
				String sql = "Select * from distributions where schoolname=?";
			
			    pst = con.prepareStatement(sql);
				pst.setObject(1,y);
			    ResultSet rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			 	
			   JScrollPane scrollPane = new JScrollPane( table );
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(200, 300, 900, 380);
			   add( scrollPane );
	 }
	catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	 }
	 void fillTable1()
	 {
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
			Object y=am.getText();
				String sql = "Select * from distributions where amount >=?";
			
			    pst = con.prepareStatement(sql);
				pst.setObject(1,y);
			    ResultSet rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			 	
			   JScrollPane scrollPane = new JScrollPane( table );
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(200, 300, 900, 380);
			   add( scrollPane );
	 }
	catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	 }
	 void fillTable2()
	 {
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
		
				String sql = "Select * from distributions";
			
			    pst = con.prepareStatement(sql);
				
			    ResultSet rs = pst.executeQuery();
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
			   pst.close();
			   JTable table = new JTable(data,columnNames);
			 	
			   JScrollPane scrollPane = new JScrollPane( table );
			   table.setBackground(Color.YELLOW);
			   table.setSelectionBackground(Color.red);
			   
			   //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			 table.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );//to get horizontal scroll bar 
			 scrollPane.setBounds(200, 300, 900, 380);
			   add( scrollPane );
	 }
	catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	 }
   		Distribution_Search_Cosole()
   		{
   			con=sqlconn.getConnection();

   			setLayout(null);
   			p1=new JPanel();
   			p2=new JPanel();
   			p3=new JPanel();
   		  school=new JLabel("SCHOOLS");
   		  s1=new JButton("FETCH");
   		  a1=new JButton("FETCH");
          amount=new JLabel("AMOUNT>=");
   			schc=new JComboBox();
   			am=new JTextField();
   			fe=new JButton("SHOW ALL");
   			p1.setLayout(null);
   			p1.setBackground(Color.white);
   			p1.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
             p1.setBounds(40,10,350,250);   
         	p2.setLayout(null);
   			p2.setBackground(Color.white);
   			p2.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
             p2.setBounds(440,10,350,250);  
            	p3.setLayout(null);
       			p3.setBackground(Color.white);
       			p3.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
             p3.setBounds(840,10,350,250);
             school.setBounds(60,20,100,100);
             amount.setBounds(60,20,100,100);
             schc.setBounds(40,90,300,50);
             am.setBounds(40,90,300,50);
             fe.setBounds(75,80,200,100);
s1.setBounds(80,170,200,40);
a1.setBounds(80,170,200,40);

function();
s1.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0)
	{ 
		fillTable();
	}
});
a1.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0)
	{ 
		fillTable1();
	}
});
fe.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent arg0)
	{ 
		fillTable2();
	}
});

             p1.add(school);
             p1.add(schc);p1.add(s1);
             p2.add(amount);
             p2.add(am);p2.add(a1);
             p3.add(fe);
             add(p1);
             add(p2);
             add(p3);
             getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
             setUndecorated(true);
             setSize(1360,750);
           setVisible(true);
         	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            
   		}
   		public static void main(String[] args) {
		new Distribution_Search_Cosole();
	}

}
