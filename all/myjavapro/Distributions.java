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
public class Distributions extends JFrame
{
	boolean flag;
	PreparedStatement pst;
	Connection con;
	JLabel heading,school,date,amount,copy,pen,pencil,shoes,books,uniform,eatables,bags,cycle,bottle,tiffin,eraser,stationary,others;
	JComboBox sch,dd,mm,yy;
	JTextField am,co,pe,penc,sh,bo,un,ea,ba,bot,ti,cy,er,st,ot;
	JButton save;
	JPanel p1,p2;
	void function()
	{
		//	a.removeAll();
		sch.addItem("SELECT");
		try{
			pst=con.prepareStatement("select distinct names from tab");
			ResultSet rs=pst.executeQuery();
			while(rs.next()==true)
			{
				String id=rs.getString("names");
				sch.addItem(id+"");
			}
		}
		catch(Exception qq)
		{
			qq.printStackTrace();
		}
	}
	void savv()
	{
		try
		{   
			pst=con.prepareStatement("Insert into distributions(schoolname,amount,copies,pen,pencil,books,shoes,uniform,eatables,stationary,bottles,eraser,tiffin,others,bags,cycles) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pst.setObject(1, sch.getSelectedItem());
			//pst.setString(2,(String)namet.getText());
			//pst.setString(3, (String)donort.getText());
			pst.setString(2,(String)am.getText());
			//	pst.setString(5,(String)b.getSelectedItem());
			pst.setString(3,(String)co.getText());
			pst.setString(4,(String)pe.getText());
			pst.setString(5, (String)penc.getText());
			pst.setString(6,(String)bo.getText());
			//JOptionPane.showMessageDialog(null, "hvjhxkd");
			pst.setString(7,(String)sh.getText());
			pst.setString(8,(String)un.getText());
			pst.setString(9,(String)ea.getText());
			pst.setString(10,(String)st.getText());
			pst.setString(11,(String)bo.getText());
			pst.setString(12,(String)er.getText());
			pst.setString(13,(String)ti.getText());
			//	pst.setObject(17,(Object)da.getText());
			pst.setString(14,(String)ot.getText());
			pst.setString(15,(String)ba.getText());
			pst.setString(16,(String)cy.getText());
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
			int aq=Integer.parseInt(p)-Integer.parseInt(am.getText());   
			pst.setInt(1,aq);   
			int fq=Integer.parseInt(x)-Integer.parseInt(bo.getText());
			pst.setInt(6,fq);
			int bq=Integer.parseInt(v)-Integer.parseInt(co.getText());    
			pst.setInt(2,bq);
			int gq=Integer.parseInt(s)-Integer.parseInt(un.getText());
			pst.setInt(7,gq);
			int cq=Integer.parseInt(q)-Integer.parseInt(pe.getText());
			pst.setInt(3,cq);                                      
			int hq=Integer.parseInt(t)-Integer.parseInt(ea.getText());
			pst.setInt(8,hq);
			int dq=Integer.parseInt(w)-Integer.parseInt(penc.getText());
			pst.setInt(4,dq); 
			int iq=Integer.parseInt(rr)-Integer.parseInt(ti.getText());	
			pst.setInt(9,iq);
			int eq=Integer.parseInt(r)-Integer.parseInt(sh.getText());      
			pst.setInt(5,eq);      
			int jq=Integer.parseInt(y)-Integer.parseInt(st.getText());
			pst.setInt(10,jq);
			int kq=Integer.parseInt(u)-Integer.parseInt(ba.getText());    
			pst.setInt(11,kq);      
			int mq=Integer.parseInt(ss)-Integer.parseInt(bot.getText());
			pst.setInt(13,mq);
			int lq=Integer.parseInt(qq)-Integer.parseInt(cy.getText()); 
			pst.setInt(12,lq);                                        
			int nq=Integer.parseInt(tt)-Integer.parseInt(er.getText());
			pst.setInt(14,nq);
			int oq=Integer.parseInt(pp)-Integer.parseInt(ot.getText());    
			pst.setInt(15,oq);                                     
			pst.executeUpdate();

			JOptionPane.showMessageDialog(null, "updated...");
		}
		catch (SQLException exc) {

			exc.printStackTrace();
		}
	}
	Distributions()
	{
		con=sqlconn.getConnection();
		setLayout(null);
		p1=new JPanel();
		p2=new JPanel();
		p1.setLayout(null);
		p1.setSize(948,380);
		p1.setLocation(2,2);
		p1.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.cyan));
		p1.setBackground(Color.LIGHT_GRAY);

		p2.setLayout(null);
		p2.setSize(948,350);
		p2.setLocation(2,385);
		p2.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.RED));
		p2.setBackground(Color.LIGHT_GRAY);
		save=new JButton("SAVE");
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
		amount=new JLabel("AMOUNT");
		heading=new JLabel();
		heading.setIcon(new ImageIcon("dondis.png"));
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
		school=new JLabel();
		school.setIcon(new ImageIcon("schoolnm.png"));
		date=new JLabel();
		date.setIcon(new ImageIcon("date.png"));
		String[] as={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		String[] has={"JAN","FEB","MAR","APR","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		String[] sad={"2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
		sch=new JComboBox();
		dd=new JComboBox(as);
		mm=new JComboBox(has);
		yy=new JComboBox(sad);

		heading.setBounds(150,30,700,100);
		school.setBounds(170,135,300,100);
		sch.setBounds(440,176,200,40);
		function();
		date.setBounds(250,230,300,100);
		dd.setBounds(440,260,60,40);

		mm.setBounds(520,260,60,40);
		yy.setBounds(600,260,60,40);
		am.setBounds(80,30,150,30);
		amount.setBounds(20,20,100,40);
		amount.setBackground(Color.CYAN);
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
		save.setBounds(60,150,100,50);
		save.setForeground(Color.BLUE);
		save.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0)
			{   
				String s2=(String)sch.getSelectedItem();

				if(s2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "school id should be filled");
				}

				savv();
				update();
				JOptionPane.showMessageDialog(null, "data saved:"+s2 );
			}
		});
		p1.add(school);
		p1.add(sch);
		p1.add(date);
		p1.add(dd);
		p1.add(mm);
		p1.add(yy);
		p1.add(heading);

		p2.add(am);
		p2.add(pe);
		p2.add(sh);
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
		p2.add(save);
		add(p1);
		add(p2);
	 getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		    setUndecorated(true);
		setSize(960,900);
		setVisible(true);
  
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);


	}
	public static void main(String[] args) {
		new Distributions();
		new Current_stock();
	}

}
