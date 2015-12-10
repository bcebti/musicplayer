package myjavapro;
import java.awt.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class donation extends JFrame
{
	/**
	 * 		setContentPane(new JLabel(new ImageIcon("dc69c1b9611af47a44c8089d14f835bc.jpg")));

	 */boolean flag;
	PreparedStatement pst;
	Connection con;

	private static final long serialVersionUID = 1L;
	JPanel p1,p2,p3,p4;
	JLabel donor,name,mo,date,mode;
	JTextField da,namet,donort,am,co,pe,penc,sh,bo,un,ea,ba,bot,ti,cy,er,st,ot;
	JButton savv,neww,close,fetch;
	JComboBox a,b;
	JLabel amount,copy,pen,pencil,shoes,books,uniform,eatables,bags,cycle,bottle,tiffin,eraser,stationary,others;
	void function()
	{
	//	a.removeAll();
		a.addItem("SELECT");
		try{
			pst=con.prepareStatement("select distinct DID from newtab");
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			{
				int id=rs.getInt("DID");
				a.addItem(id+"");
			}
		}
		catch(Exception qq)
		{
			qq.printStackTrace();
		}
	}
	void fetch()
	{
		String aa="",b="";
		
		try {
		/*	 String l=JOptionPane.showInputDialog(null,"ENTER UR DID");
	    	 JOptionPane.showMessageDialog(null, "ur did is"+l);*/
			Object l= a.getSelectedItem();
			if(l.equals("SELECT"))
			{
				JOptionPane.showMessageDialog(null,"FIRSTLY SELECT ONE OPTION FROM DONOR ID");
			}
			pst=con.prepareStatement("select * from newtab where DID=?");
		//Object l= a.getSelectedItem();
		pst.setObject(1, l);
		
		//pst.setString(2, s);
		ResultSet rs=pst.executeQuery();
		while(rs.next())
		{
			
			 aa=rs.getString("named");
			 b=rs.getString("phonenum");
			 			
		}
		
		namet.setText(aa);
		donort.setText(b);
		
		
		
		}
		catch(SQLException e){e.printStackTrace();}

	}

	void savv()
	{
		try
		{   
			pst=con.prepareStatement("Insert into donation(DID,named,mobilenum,amount,mode,copies,pen,pencil,books,shoes,uniform,eatables,stationary,bottles,eraser,tiffin,date,others,bags,cycles) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setObject(1, a.getSelectedItem());
			pst.setString(2,(String)namet.getText());
			pst.setString(3, (String)donort.getText());
			pst.setString(4,(String)am.getText());
			pst.setString(5,(String)b.getSelectedItem());
			pst.setString(6,(String)co.getText());
			pst.setString(7,(String)pe.getText());
			pst.setString(8, (String)penc.getText());
			pst.setString(9,(String)bo.getText());
		//JOptionPane.showMessageDialog(null, "hvjhxkd");
			pst.setString(10,(String)sh.getText());
			pst.setString(11,(String)un.getText());
			pst.setString(12,(String)ea.getText());
			pst.setString(13,(String)st.getText());
			pst.setString(14,(String)bo.getText());
			pst.setString(15,(String)er.getText());
			pst.setString(16,(String)ti.getText());
			pst.setObject(17,(Object)da.getText());
			pst.setString(18,(String)ot.getText());
			pst.setString(19,(String)ba.getText());
			pst.setString(20,(String)cy.getText());
			JOptionPane.showMessageDialog(null, "Data recorded");
			pst.executeUpdate();
		}
		catch (SQLException e){e.getMessage(); e.printStackTrace();}

	}
	void update()
	{
		try
		{
		
			String p=new String();
			String qq=new String();
			String rr=new String();
			String ss=new String();
			String tt=new String();
			String pp=new String("0");
			String q=new String();
			String r=new String();
			String s=new String();
			String t=new String();
			String u=new String();
			String v=new String();
			String w=new String();
			String x=new String();
			String y=new String();

			pst=con.prepareStatement("Select * from stock");
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				 p=rs.getString("amount"); v=rs.getString("copies");
				 q=rs.getString("pen"); w=rs.getString("pencil");
				 r=rs.getString("shoes"); x=rs.getString("books");
				 s=rs.getString("uniform"); y=rs.getString("stationary");
				 t=rs.getString("eatables");
				 u=rs.getString("bags");
				 qq=rs.getString("cycles"); ss=rs.getString("bottles");
				 rr=rs.getString("tiffin"); tt=rs.getString("eraser");
				pp=rs.getString("others");
			}
			pst=con.prepareStatement("update stock set amount=?,copies=?,pen=?,pencil=?,shoes=?,books=?,uniform=?,eatables=?,tiffin=?,stationary=?,bags=?,cycles=?,bottles=?,eraser=?,others=?");
			int aq=Integer.parseInt(p)+Integer.parseInt(am.getText());   
			pst.setInt(1,aq);   
			int fq=Integer.parseInt(x)+Integer.parseInt(bo.getText());
			pst.setInt(6,fq);
			int bq=Integer.parseInt(v)+Integer.parseInt(co.getText());    
			pst.setInt(2,bq);
			int gq=Integer.parseInt(s)+Integer.parseInt(un.getText());
			pst.setInt(7,gq);
			int cq=Integer.parseInt(q)+Integer.parseInt(pe.getText());
			pst.setInt(3,cq);                                      
			int hq=Integer.parseInt(t)+Integer.parseInt(ea.getText());
			pst.setInt(8,hq);
			int dq=Integer.parseInt(w)+Integer.parseInt(penc.getText());
			pst.setInt(4,dq); 
			int iq=Integer.parseInt(rr)+Integer.parseInt(ti.getText());	
			pst.setInt(9,iq);
			int eq=Integer.parseInt(r)+Integer.parseInt(sh.getText());      
			pst.setInt(5,eq);      
			int jq=Integer.parseInt(y)+Integer.parseInt(st.getText());
			pst.setInt(10,jq);
			int kq=Integer.parseInt(u)+Integer.parseInt(ba.getText());    
			pst.setInt(11,kq);      
			int mq=Integer.parseInt(ss)+Integer.parseInt(bot.getText());
			pst.setInt(13,mq);
			int lq=Integer.parseInt(qq)+Integer.parseInt(cy.getText()); 
			pst.setInt(12,lq);                                        
			int nq=Integer.parseInt(tt)+Integer.parseInt(er.getText());
			pst.setInt(14,nq);
			int oq=Integer.parseInt(pp)+Integer.parseInt(ot.getText());    
			pst.setInt(15,oq);                                     
			pst.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "updated...");
		}
		catch (SQLException exc) {
		
			exc.printStackTrace();
		}
	}
	donation()
	{
		con=sqlconn.getConnection();
		setLayout(null);
		p1=new JPanel();
		p2=new JPanel();
		p3=new JPanel();
		p4=new JPanel();
		mode=new JLabel("MODE OF PAYMENT");
		String []amm={"CASH","DD","CHECK"};
		b=new JComboBox(amm);
		
		 b.insertItemAt("CHOOSE OPTION", 0);
		 b.setSelectedIndex(0);
		 b.setEditable(false);
		donor=new JLabel();
		name=new JLabel();
		mo=new JLabel();
		date=new JLabel("DATE...(YY/MM//DD)");
		da=new JTextField();
		namet=new JTextField();
		donort=new JTextField();
		a=new JComboBox();
		savv=new JButton();
		neww =new JButton();
		close=new JButton();
		   savv.setIcon(new ImageIcon("RenderedImage.png"));
		   neww.setIcon(new ImageIcon("aqa.png"));
		   close.setIcon(new ImageIcon("aqq.png"));
		amount=new JLabel("AMOUNT");
		am=new JTextField("0");
		co=new JTextField("0");
		pe=new JTextField("0");
		penc=new JTextField("0");
		bo=new JTextField("0");
		bot=new JTextField("0");
		sh=new JTextField("0");
		un=new JTextField("0");
		ea=new JTextField("0");
		ba=new JTextField("0");
		ti=new JTextField("0");
		er=new JTextField("0");
		st=new JTextField("0");
		bot=new JTextField("0");
		cy=new JTextField("0");
		ot=new JTextField("0");

		copy=new JLabel("COPIES");
		pen=new JLabel("PEN");
		pencil=new JLabel("PENCIL");
		shoes=new JLabel("SHOES");
		books=new JLabel("BOOKS");
		uniform=new JLabel("UNIFORM");
		eatables=new JLabel("EATABLES");
		bags=new JLabel("BAGS");
		cycle=new JLabel("CYCLE");
		bottle=new JLabel("BOTTLE");
		tiffin=new JLabel("TIFFIN");
		eraser=new JLabel("ERASER");
		stationary=new JLabel("STATIONARY");
		others=new JLabel("OTHERS");
		fetch=new JButton();
	fetch.setIcon(new ImageIcon("as.jpg"));

		p1.setLayout(null);
		p1.setSize(980,200);
		p1.setLocation(2,2);
		p1.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.cyan));
		p1.setBackground(Color.LIGHT_GRAY);

		p2.setLayout(null);
		p2.setSize(980,280);
		p2.setLocation(2,202);
		p2.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.cyan));
		p2.setBackground(Color.LIGHT_GRAY);
		p3.setLayout(null);
		p3.setSize(980,130);
		p3.setLocation(2,460);
		p3.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.cyan));
		p3.setBackground(Color.LIGHT_GRAY);
		p4.setLayout(null);
		p4.setSize(980,200);
		p4.setLocation(2,590);
		p4.setBorder(BorderFactory.createMatteBorder(3,3,3, 3, Color.cyan));
		p4.setBackground(Color.DARK_GRAY);
		fetch.setBounds(100,40,140,120);
		fetch.setForeground(Color.BLUE);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setUndecorated(true);
		donor.setBounds(310,2,200,100);
		donor.setForeground(Color.pink);
		a.setBounds(550,30,200,40);
		function();
		a.setEditable(false);
		name.setBounds(310,50,200,100);
		name.setForeground(Color.pink);
		namet.setBounds(550,80,200,40);
		mo.setBounds(310,47,250,200);
		mo.setForeground(Color.pink);
		donort.setBounds(550,130,200,40);
		amount.setBounds(20,20,100,40);
		am.setBounds(80,30,150,30);
		amount.setBackground(Color.CYAN);
		b.setBounds(30,100,150,30);
	   
		mode.setBounds(50,50,200,40);
		mode.setBackground(Color.CYAN);

		copy.setBounds(190,200,60,40);
		copy.setBackground(Color.CYAN);
		co.setBounds(250,200,60,30);
		pen.setBounds(280,20,60,40);
		pen.setBackground(Color.CYAN);
		pe.setBounds(345,24,60,30);
		pencil.setBounds(370,80,70,40);
		pencil.setBackground(Color.CYAN);
		penc.setBounds(450,80,60,30);
		shoes.setBounds(470,20,70,40);
		shoes.setBackground(Color.CYAN);
		sh.setBounds(530,24,60,30);

		books.setBounds(570,80,70,40);
		books.setBackground(Color.CYAN);
		bo.setBounds(650,80,60,30);
		uniform.setBounds(670,20,80,40);
		uniform.setBackground(Color.CYAN);
		un.setBounds(743,24,60,30);
		eatables.setBounds(770,80,90,40);
		eatables.setBackground(Color.CYAN);
		ea.setBounds(850,80,60,30);

		bags.setBounds(190,80,60,40);
		bags.setBackground(Color.CYAN);
		ba.setBounds(260,80,60,30);

		cycle.setBounds(280,140,70,40);
		cycle.setBackground(Color.CYAN);
		cy.setBounds(360,140,60,30);
		bottle.setBounds(370,200,80,40);
		bottle.setBackground(Color.CYAN);
		bot.setBounds(460,200,60,30);
		tiffin.setBounds(570,200,70,40);
		tiffin.setBackground(Color.CYAN);
		ti.setBounds(660,200,60,30);
		eraser.setBounds(470,140,90,40);
		eraser.setBackground(Color.CYAN);
		er.setBounds(570,140,60,30);
		stationary.setBounds(670,140,100,40);
		stationary.setBackground(Color.CYAN);
		st.setBounds(780,140,60,30);
		others.setBounds(770,200,80,40);
		others.setBackground(Color.CYAN);
		ot.setBounds(860,200,60,30);
		date.setBounds(300,40,200,10);
		date.setForeground(Color.BLUE);
		da.setBounds(440,30,200,40);
		savv.setBounds(20,10,300,100);
		savv.setForeground(Color.BLUE);
		neww.setBounds(340,10,300,100);
		neww.setForeground(Color.BLUE);
		close.setBounds(670,10,300,100);
		close.setForeground(Color.BLUE);
		donor.setIcon(new ImageIcon("dnm.png"));
		name.setIcon(new ImageIcon("did.png"));
		mo.setIcon(new ImageIcon("phn.png"));

				close.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				JOptionPane.showMessageDialog(null,"CLOSING...... " );
				doClose();

			}
			void doClose()
			{
				System.exit(0);
			}
		});
		neww.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{   
				b.setSelectedIndex(0);
				a.setSelectedIndex(0);
				da.setText("");
				namet.setText("");
				donort.setText("");
				am.setText("");
				co.setText("");
				pe.setText("");
				penc.setText("");
				sh.setText("");
				bo.setText("");
				un.setText("");
				ea.setText("");
				ba.setText("");
				bot.setText("");
				ti.setText("");
				cy.setText("");
				er.setText("");
				st.setText(null);
				ot.setText(null);

				JOptionPane.showMessageDialog(null,"U CAN CONTINUE");
			}
		});

		   fetch.addActionListener(new ActionListener(){
			   public void actionPerformed(ActionEvent arg0)
			   {
				   try {
	
					fetch();
				} catch (Exception ar) {
					// TODO Auto-generated catch block
					ar.printStackTrace();
				}

			   }
		   });
		savv.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{   
				String s2=(String)a.getSelectedItem();

				if(s2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "donor id should be filled");
				}
				
				savv();
				update();
				JOptionPane.showMessageDialog(null, "data saved:"+s2 );
			}
		});
			p1.add(a);
		p1.add(donor);
		p1.add(name);
		p1.add(donort);
		p1.add(namet);
		p1.add(mo);
		p1.add(fetch);
		p2.add(am);
		p2.add(pe);
		p2.add(sh);
		p2.add(b);
		p2.add(un);
		p2.add(co);
		p2.add(cy);
		p2.add(penc);
		p2.add(ea);
		p2.add(ba);
		p2.add(bo);
		p2.add(er);
		p2.add(st);
		p2.add(bot);
		p2.add(ti);
		p2.add(ot);
		p2.add(mode);

		p2.add(amount);
		p2.add(bags);
		p2.add(copy);
		p2.add(pen);
		p2.add(pencil);
		p2.add(shoes);
		p2.add(books);
		p2.add(uniform);
		p2.add(eatables);
		p2.add(cycle);
		p2.add(bottle);
		p2.add(tiffin);
		p2.add(eraser);
		p2.add(stationary);
		p2.add(others);
		p3.add(date);
		p3.add(da);
		p4.add(savv);
		p4.add(neww);
		p4.add(close);
		add(p1);
		add(p2);
		add(p3);
		add(p4);

		setSize(1000,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args)
	{ 		new donation();
	}

}
