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

public class Donor_Search_Console extends JFrame
{

	private static final long serialVersionUID = 1L;
	JPanel p1,p2,p3,p4,p5;
	JLabel dono,na,am,da,da1;
	JComboBox donoc,nac;
	JTextField d1,d2,amf;
	JButton z1,z2,z3,z4,z5;
	 boolean flag;
	PreparedStatement pst;
	Connection con;
	void function()
	{
		//	a.removeAll();
		donoc.addItem("SELECT");
		try{
			pst=con.prepareStatement("select distinct DID from donation");
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			{
				String id=rs.getString("DID");
				donoc.addItem(id+"");
			}
		}
		catch(Exception qq)
		{
			qq.printStackTrace();
		}
	}
	void function1()
	{
		//	a.removeAll();
		nac.addItem("SELECT");
		try{
			pst=con.prepareStatement("select distinct named from donation");
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			{
				String id=rs.getString("named");
				nac.addItem(id+"");
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
			   String sql = "Select * from donation ";
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
			 scrollPane.setBounds(900, 100, 400, 400);
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
			Object y=donoc.getSelectedItem();
				String sql = "Select * from donation where DID=?";
			
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
			 scrollPane.setBounds(900, 100, 400, 400);
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
			Object y=amf.getText();
				String sql = "Select * from donation where amount=?";
			
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
			 scrollPane.setBounds(900, 100, 400, 400);
			   add( scrollPane );
	 }
	catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	 }
	 void fillTable3()
	 {
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
			Object y=nac.getSelectedItem();
				String sql = "Select * from donation where named=?";
			
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
			 scrollPane.setBounds(900, 100, 400, 400);
			   add( scrollPane );
	 }
	catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	 }
	 void fillTable4()
	 {
		   try {
				Class.forName("com.mysql.jdbc.Driver");
				con =DriverManager.getConnection("jdbc:mysql://localhost:3306/hey","root","bce");
Object da=d1.getText();
Object daa=d2.getText();
				String sql = "Select * from donation where date between ? and ?";
			    pst = con.prepareStatement(sql);
			    pst.setObject(1,da);
			    pst.setObject(2,daa);
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
			 scrollPane.setBounds(900, 100, 400, 400);
			   add( scrollPane );
	 }
	catch(Exception nex)
		   {
			   nex.printStackTrace();
		   }
	 }   
	
		
		
	
	Donor_Search_Console()
	{
		con=sqlconn.getConnection();
		setLayout(null);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
        p5=new JPanel();
		p1.setLayout(null);
		p1.setSize(400,300);
		p1.setBackground(Color.white);
		p1.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
		p1.setBounds(4,4,850,100);
		p2.setLayout(null);
		p2.setSize(300,300);
		p2.setBackground(Color.white);
		p2.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
		p2.setBounds(4,150,850,100);
		p3.setLayout(null);
		p3.setSize(300,300);
		p3.setBackground(Color.white);
		p3.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
		p3.setBounds(4,280,850,100);
		p4.setLayout(null);
		p4.setSize(300,300);
		p4.setBackground(Color.white);
		p4.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
		p4.setBounds(4,430,850,100);
		p5.setLayout(null);
		p5.setSize(300,300);
		p5.setBackground(Color.white);
		p5.setBorder(BorderFactory.createBevelBorder(JFrame.ICONIFIED, Color.BLACK, Color.red));
		p5.setBounds(4,560,850,100);
		dono=new JLabel("DONOR_ID");
		na=new JLabel("NAME");
		am=new JLabel("AMOUNT");
		da=new JLabel("DATE  FROM");
		da1=new JLabel("TO");
		da1.setBounds(390,28,20,20 );
		d1=new JTextField();
		d2=new JTextField();
		donoc =new JComboBox();
		nac =new JComboBox();
		amf=new JTextField();
		z1=new JButton("FETCH DONOR IDS");
		z2=new JButton("FETCH DONOR NAMES");
		z3=new JButton("FETCH ACC TO AMOUNT");
		z4=new JButton("FETCH ACC. TO DATE");
		z5=new JButton("SHOW ALL");


		z1.setBounds(550,30,200,40);
	
		dono.setBounds(200,25,100,60);
		donoc.setBounds(300,30,100,40);
		function();
		function1();
	
		na.setBounds(200,25,100,60);
		nac.setBounds(300,30,100,40);
		z2.setBounds(550,30,200,40);
		am.setBounds(200,25,100,60);
		amf.setBounds(300,30,100,40);
		z3.setBounds(550,30,200,40);
		da.setBounds(170,23,100,60);
		d1.setBounds(280,25,100,40);
		d2.setBounds(420,25,100,40);

		z4.setBounds(550,30,200,40);
		z5.setBounds(350,30,200,40);
		z5.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{ 
				fillTable();
			}
		});
		z1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{ 
				fillTable1();
			}
		});
		z3.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{ 
				fillTable2();
			}
		});
		z2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{ 
				fillTable3();
			}
		});
		z4.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{ 
				fillTable4();
			}
		});
		p1.add(dono);
		p1.add(donoc);
		p1.add(z1);
		add(p1);
		p2.add(na);
		p2.add(nac);
		p2.add(z2);
		add(p2);
		p3.add(am);
		p3.add(amf);
		p3.add(z3);
		add(p3);
		p4.add(da);
		p4.add(d1);
		p4.add(da1);
		p4.add(d2);
		p4.add(z4);
		add(p4);
		p5.add(z5);
		add(p5);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setUndecorated(true);
		setSize(1360,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new Donor_Search_Console();
	}

}
