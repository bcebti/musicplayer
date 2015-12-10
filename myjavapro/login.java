package myjavapro;

import java.awt.*;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.*;
//import javax.swing.border.Border;
//import javax.swing.border.TitledBorder;
//import javax.swing.event.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

class ogin extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstmt;
	JLabel a,b,c;
	JTextField d;
	JPasswordField e=new JPasswordField();
	JButton ff,g;
	JPanel p;
	ogin()
	{
		con=sqlconn.getConnection();
		p=new JPanel();

		p.setLayout(null);
		p.setSize(400,400);

		p.setBackground(Color.LIGHT_GRAY);
		p.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		p.setBounds(100,100,500,500);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setUndecorated(true);
		a=new JLabel();
		b=new JLabel();
		d=new JTextField();
		e=new JPasswordField();
		c=new JLabel();
		c.setIcon(new ImageIcon("cooltext125378555243639.png"));
		b.setIcon(new ImageIcon("d.png"));
		a.setIcon(new ImageIcon("c.png"));
		ff=new JButton();
		g=new JButton();
		Font brd=new Font("arial",Font.BOLD+Font.ITALIC,50);
		c.setFont(brd);
		c.setBounds(200,30,300,150);
		c.setForeground(Color.GREEN);
		ff.setIcon(new ImageIcon("a.png"));//login button
		g.setIcon(new ImageIcon("e.png"));//forgot password button
		a.setBounds(37,170,500,100);
		b.setBounds(1,250,500,100);
		d.setBounds(425,210,230,30);
		e.setBounds(425,285,230,30);
		ff.setBounds(30,400,300,75);
		ff.setBackground(Color.lightGray);
		ff.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.BLUE,Color.RED));
		g.setBounds(30,500,500,75);
		g.setBackground(Color.pink);
		g.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.blue));   	



		ff.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				int jasus;
				try
				{
					pstmt=con.prepareStatement("Select * from adduser where USER_ID=? and PASSWORD=?");
					pstmt.setString(1, d.getText());
					char ch1[]=e.getPassword();
					String ss=new String(ch1);
					pstmt.setString(2, ss);
					ResultSet rs= pstmt.executeQuery();
					if(rs.next()==true)
					{
						jasus=1;
					}
					else
					{
						jasus=0;
					}
					if(jasus==1)
					{
						JOptionPane.showMessageDialog(null, "valid");
						JFrame f1=new JFrame();
						JPanel oo=new JPanel();
						f1.setSize(1400,1000);
						f1. setVisible(true);
						f1. setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

						oo=new JPanel();

						oo.setLayout(null);
						oo.setSize(1200,1200);
						Font brdr=new Font("Monotype Corsiva",Font.BOLD+Font.ITALIC,20);
						Border compound=BorderFactory.createTitledBorder(null,"WELCOME TO MOTHER TERESA NGO",TitledBorder.CENTER,TitledBorder.TOP,brdr,Color.red);
						oo.setBorder(compound);
						//    oo.setBorder(BorderFactory.createTitledBorder("WELCOME TO MOTHER TERESA NGO"));
						//oo.setBackground(Color.DARK_GRAY);

						JButton b1,b2,b3,b4,b5,b6,b7,b8;

						b1=new JButton();
						b2=new JButton();
						b3=new JButton();
						b4=new JButton();
						b5=new JButton();
						b6=new JButton();
						b7=new JButton();
						b8=new JButton();
						b1.setIcon(new ImageIcon("schoolregisterations.png"));
						b2.setIcon(new ImageIcon("donorregisteratons.png"));
						b3.setIcon(new ImageIcon("distributions.png"));
						b4.setIcon(new ImageIcon("donations.png"));
						b5.setIcon(new ImageIcon("donorsearch.png"));
						b6.setIcon(new ImageIcon("distributionsearch.png"));
						b7.setIcon(new ImageIcon("aboutus (1).png"));

						b1.setBounds(470,40,400,130);
						b2.setBounds(200,190,400,130);
						b3.setBounds(200,330,400,130);
						b4.setBounds(730,330,400,130);
						b5.setBounds(730,190,400,130);
						b6.setBounds(470,480,450,130);
						b7.setBounds(950,550,400,130);
						b8.setBounds(10,10,400,120);
						b8.setIcon(new ImageIcon("sms.png"));
						b7.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new About_us();
							}
						});
						b1.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new Schl_Regstr();
							}
						});
						b2.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new DonrRegstr();
							}
						});
						b3.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new Distributions();
								new Current_stock();
							}
						});
						b4.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new donation();
							}
						});
						b5.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new Donor_Search_Console();
							}
						});
						b6.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new Distribution_Search_Cosole();
							}
						});
						b8.addActionListener(new ActionListener()
						{
							public void actionPerformed(ActionEvent arg0)
							{
								new SMS();
							}
						});
						oo.add(b1);
						oo.add(b2);
						oo.add(b3);
						oo.add(b4);
						oo.add(b5);
						oo.add(b6);
						oo.add(b7);
						oo.add(b8);
						f1.add(oo);

					}
					else
					{
						JOptionPane.showMessageDialog(null, "sorrrrrrryyyyyy");
						JOptionPane.showMessageDialog(null, "TRY AGAIN");
					}
				}
				catch(Exception fo)
				{
					System.out.println(fo.getMessage());
				}
			}
		});

		g.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				JFrame f=new JFrame();
				f.setSize(700,700);
				f. setVisible(true);
				f. setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				f.setBackground(Color.blue);
				JLabel aa,bb;
				JButton dd;
				JPanel oo;
				final JComboBox qq;
				oo=new JPanel();

				oo.setLayout(null);
				oo.setSize(400,400);

				oo.setBackground(Color.LIGHT_GRAY);
				oo.setBorder(BorderFactory.createTitledBorder("PASSWORD PROBLEM ?????"));
				oo.setBounds(100,100,500,500);
				//-------------------------------------------------------
				aa=new JLabel();//forgot???????????
						aa.setIcon(new ImageIcon("forgot.png"));

				final JTextField fld2p=new JTextField();
				fld2p.setBounds(290,345,350,45);
				;	    	          		   //-----------------------------------------
				Font brd=new Font("arial",Font.BOLD+Font.ITALIC,50);
				aa.setFont(brd);
				aa.setBounds(10,30,700,200);
				aa.setForeground(Color.GREEN);

				bb=new JLabel();
				bb.setBounds(125,150,400,200);
				bb.setIcon(new ImageIcon("b.png"));

				String []ah={"ANKITA","KANIKA","HARMEET","ALISHA"};
				qq=new JComboBox(ah);
				qq.setBounds(290,290,150,45);
				qq.setEditable(true);
				//q.insertItemAt("UID's",0);
				qq.setSelectedIndex(0);
				//---------------------------------------------------------------    	
				dd=new JButton();
				dd.setIcon(new ImageIcon("send sms.png"));
				dd.setBounds(450,450,200,50);
				dd.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.magenta, Color.blue));
				dd.setBackground(Color.pink);
				//	dd.setBorder(BorderFactory.createLineBorder(Color.PINK));
				dd.setContentAreaFilled(true);
				dd.setBorderPainted(true);
				//--------------------------------------
				dd.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0)
					{

						int jasus;
						try
						{
							String pwd="",mob="";
							pstmt=con.prepareStatement("Select PASSWORD,MOBILE_NUM from adduser where USER_ID=?");
							pstmt.setString(1, qq.getSelectedItem().toString());
							ResultSet rs= pstmt.executeQuery();
							if(rs.next()==true)
							{
								jasus=1;
								pwd=rs.getString("PASSWORD");
								mob=rs.getString("MOBILE_NUM");
							}
							else
							{
								jasus=0;
							}
							if(jasus==1)
							{
								fld2p.setText("MOBILE:"+mob);

								JOptionPane.showMessageDialog(null, "found="+pwd+"   "+"phone number="+mob);
							}
							else
							{
								JOptionPane.showMessageDialog(null, "sorrrrrrryyyyyy");
							}
						}
						catch(Exception f)
						{
							System.out.println(f.getMessage());
						}
					}
				}	);


				//-----------------------------------------------------

				oo.add(aa);
				oo.add(bb);
				oo.add(dd);
				oo.add(qq);
				oo.add(fld2p);
				f.add(oo);


			}
		});
		p.add(a);
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		p.add(ff);
		p.add(g);

		add(p);

		setSize(700,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);



	}}
public class login
{

	public static void main(String[] args) {

		ogin n=new ogin();
	}

}
