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

public class Current_stock extends JFrame
{
	PreparedStatement pst;
	Connection con;
	JLabel amount,copy,pen,pencil,shoes,books,uniform,eatables,bags,cycle,bottle,tiffin,eraser,stationary,others;
	JLabel amounts,copys,pens,pencils,shoess,bookss,uniforms,eatabless,bagss,cycles,bottles,tiffins,erasers,stationarys,otherss;
	JLabel amountt,copyt,pent,pencilt,shoest,bookst,uniformt,eatablest,bagst,cyclet,bottlet,tiffint,erasert,stationaryt,otherst;
	JPanel p;
	void search()
	{
		try{
			String a1=new String();
			String a2=new String();
			String a3=new String();
			String a4=new String();
			String a5=new String();
			String a6=new String();
			String a7=new String();
			String a8=new String();
			String a9=new String();
			String a10=new String();
			String a11=new String();
			String a12=new String();
			String a13=new String();
			String a14=new String();
			String a15=new String();
			pst=con.prepareStatement("select * from stock");
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				a1=rs.getString("amount");
				a2=rs.getString("copies");
				a3=rs.getString("pen");
				a4=rs.getString("pencil");
				a5=rs.getString("shoes");
				a6=rs.getString("books");
				a7=rs.getString("uniform");
				a8=rs.getString("eatables");
				a9=rs.getString("bags");
				a10=rs.getString("cycles");
				a11=rs.getString("bottles");
				a12=rs.getString("tiffin");
				a13=rs.getString("eraser");
				a14=rs.getString("stationary");
				a15=rs.getString("others");
			}
			amountt.setText(a1);
			copyt.setText(a2);
			pent.setText(a3);
			pencilt.setText(a4);
			shoest.setText(a5);
			bookst.setText(a6);
			uniformt.setText(a7);
			eatablest.setText(a8);
			bagst.setText(a9);
			cyclet.setText(a10);
			bottlet.setText(a11);
			tiffint.setText(a12);
			erasert.setText(a13);
			stationaryt.setText(a14);
			otherst.setText(a15);
		}catch(Exception es)
		{
			es.printStackTrace();
		}
	}
	Current_stock()
	{
		con=sqlconn.getConnection();
		setLayout(null);
		p=new JPanel();
		p.setLayout(null);
		p.setSize(400,800);
		p.setLocation(2,2);
		p.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.cyan));
		p.setBackground(Color.LIGHT_GRAY);
		amount=new JLabel("AMOUNT");
		amount.setForeground(Color.black);
		//Font ni=new Font("forte",Font.BOLD,18);
		//amount.setFont(ni);
		amount.setBounds(20,30,100,23);
		amounts=new JLabel(":");
		amounts.setBounds(200,30,60,23);
		amountt=new JLabel();
		amountt.setBounds(300,30,100,23);
		copy=new JLabel("COPY");
		//copy.setFont(ni);
		copy.setForeground(Color.black);

		copy.setBounds(20,80,90,23);
		copys=new JLabel(":");
		copys.setBounds(200,75,60,23);
		copyt=new JLabel();
		copyt.setBounds(300,80,60,23);
		pen=new JLabel("PENS");
		pen.setForeground(Color.black);

		//pen.setFont(ni);
		pen.setBounds(20,130,55,23);
		pens=new JLabel(":");
		pens.setBounds(200,130,60,23);
		pent=new JLabel();
		pent.setBounds(300,130,100,23);
		pencil=new JLabel("PENCIL");
		pencil.setForeground(Color.black);

		//pencil.setFont(ni);
		pencil.setBounds(20,180,80,23);
		pencils=new JLabel(":");
		pencils.setBounds(200,180,60,23);
		pencilt=new JLabel();
		pencilt.setBounds(300,180,100,23);
		shoes=new JLabel("SHOES");
		//shoes.setFont(ni);
		shoes.setForeground(Color.black);

		shoes.setBounds(20,230,80,23);
		shoess=new JLabel(":");
		shoess.setBounds(200,230,60,23);
		shoest=new JLabel();
		shoest.setBounds(300,230,60,23);
		books=new JLabel("BOOKS");
		//books.setFont(ni);
		books.setBounds(20,280,90,23);
		amount.setForeground(Color.black);
		books.setForeground(Color.black);

		bookss=new JLabel(":");
		bookss.setBounds(200,280,60,23);
		bookst=new JLabel();
		bookst.setBounds(300,280,100,23);
		uniform=new JLabel("UNIFORMS");
		uniform.setForeground(Color.black);

	//	uniform.setFont(ni);
		uniform.setBounds(20,320,90,23);
		uniforms=new JLabel(":");
		uniforms.setBounds(200,320,60,23);
		uniformt=new JLabel();
		uniformt.setBounds(300,320,100,23);
		eatables=new JLabel("EATABLES");

		eatables.setForeground(Color.black);
//eatables.setFont(ni);
		eatables.setBounds(20,370,90,23);
		eatabless=new JLabel(":");
		eatabless.setBounds(200,370,60,23);
		eatablest=new JLabel();
		eatablest.setBounds(300,370,100,23);
		bags=new JLabel("BAGS");
		//bags.setFont(ni);
		bags.setForeground(Color.black);

		bags.setBounds(20,420,90,23);
		bagss=new JLabel(":");
		bagss.setBounds(200,420,60,23);
		bagst=new JLabel();
		bagst.setBounds(300,420,100,23);
		cycle=new JLabel("CYCLES");
		//cycle.setFont(ni);
		cycle.setForeground(Color.black);

		cycle.setBounds(20,470,90,23);
		cycles=new JLabel(":");
		cycles.setBounds(200,470,60,23);
		cyclet=new JLabel();
		cyclet.setBounds(300,470,100,23);
		bottle=new JLabel("BOTTLES");
		//bottle.setFont(ni);
		bottle.setForeground(Color.black);

		bottle.setBounds(20,520,90,23);
		bottles=new JLabel(":");
		bottles.setBounds(200,520,60,23);
		bottlet=new JLabel();
		bottlet.setBounds(300,520,100,23);
		tiffin=new JLabel("TIFFIN");
		//tiffin.setFont(ni);
		tiffin.setForeground(Color.black);

		tiffin.setBounds(20,570,90,23);
		tiffins=new JLabel(":");
		tiffins.setBounds(200,570,60,23);
		tiffint=new JLabel();
		tiffint.setBounds(300,570,100,23);
		eraser=new JLabel("ERASER");
		//eraser.setFont(ni);
		eraser.setForeground(Color.black);

		eraser.setBounds(20,620,90,23);
		erasers=new JLabel(":");
		erasers.setBounds(200,620,60,23);
		erasert=new JLabel();
		erasert.setBounds(300,620,100,23);
		stationary=new JLabel("STATIONARY");
		//stationary.setFont(ni);
		stationary.setForeground(Color.black);

		stationary.setBounds(20,670,90,23);
		stationarys=new JLabel(":");
		stationarys.setBounds(200,670,60,23);
		stationaryt=new JLabel();
		stationaryt.setBounds(300,670,100,23);
		others=new JLabel("OTHERS");
		//others.setFont(ni);
		others.setForeground(Color.black);

		others.setBounds(20,720,90,23);
		otherss=new JLabel(":");
		otherss.setBounds(200,720,60,23);
		otherst=new JLabel();
		otherst.setBounds(300,720,100,23);
		p.add(amount);p.add(copy);p.add(pen);p.add(pencil);p.add(shoes);p.add(books);p.add(uniform);p.add(eatables);p.add(bags);p.add(cycle);p.add(bottle);p.add(tiffin);p.add(eraser);p.add(stationary);p.add(others);
		p.add(amounts);p.add(copys);p.add(pens);p.add(pencils);p.add(shoess);p.add(bookss);p.add(uniforms);p.add(eatabless);p.add(bagss);p.add(cycles);p.add(bottles);p.add(tiffins);p.add(erasers);p.add(stationarys);p.add(otherss);
		p.add(amountt);p.add(copyt);p.add(pent);p.add(pencilt);p.add(shoest);p.add(bookst);p.add(uniformt);p.add(eatablest);p.add(bagst);p.add(cyclet);p.add(bottlet);p.add(tiffint);p.add(erasert);p.add(stationaryt);p.add(otherst);
		add(p);
		search();
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);

		setUndecorated(true);
		setSize(413,900);
		setLocation(960,1);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
 
	}
		public static void main(String[] args) {
			new Current_stock();
		}

	}
