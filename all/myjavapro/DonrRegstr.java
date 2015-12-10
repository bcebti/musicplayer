package myjavapro;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DonrRegstr extends JFrame
{
	Connection con;
	PreparedStatement pstmt;
	private static final long serialVersionUID = 2608971067861839123L;
	JLabel h,nameD,ph,email,address,type,image;
	JComboBox namec,typec;
	JTextField phf,emailf,addressf;
	JButton save,neww,search,update,cancel,close;
	Boolean flag;
	String d;
	void searchh() throws SQLException
	{
		String s="",p="",q="",r="",o="";
		try{
			d=JOptionPane.showInputDialog(null,"ENTER UR DID");
			JOptionPane.showMessageDialog(null, "ur did is"+d);


			pstmt=con.prepareStatement("select * from newtab where DID=?");
			int ii=0;
			//String d=JOptionPane.showInputDialog(null,"Put your did");
			ii=Integer.parseInt(d);
			pstmt.setInt(1, ii);
			ResultSet x=pstmt.executeQuery();
			while(x.next())
			{

				s=x.getString("named");
				p=x.getString("phonenum");
				q=x.getString("emailadd");
				r=x.getString("address");
				o=x.getString("type");

			}
			typec.setSelectedItem(o);
			namec.setSelectedItem(s);
			phf.setText(p);
			emailf.setText(q);
			addressf.setText(r);
		}catch(Exception w)
		{
			w.printStackTrace();

		}
	}

	/*void delete() throws SQLException
	{

		pstmt=con.prepareStatement("delete from newtab where named=?");
		Object s1= namec.getSelectedItem();
		pstmt.setObject(1, s1);
		int x=pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "deleted:"+x);
		pstmt.close();
	}*/
	void delete() throws SQLException
	{

		try{
			String l=JOptionPane.showInputDialog(null,"ENTER UR DID");
			JOptionPane.showMessageDialog(null, "ur did is"+l);


			pstmt=con.prepareStatement("delete from newtab where DID=?");
			pstmt.setObject(1, l);
			int x=pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "REMOVED ACCOUNT"+x);

			pstmt.close();	
		}catch(Exception w)
		{
			w.printStackTrace();

		}
	}

	void savee()
	{
		try
		{
			pstmt=con.prepareStatement("insert into newtab(named,phonenum,emailadd,address,type)values(?,?,?,?,?)");
			pstmt.setString(1, (String)namec.getSelectedItem());
			pstmt.setString(3,emailf.getText());
			pstmt.setString(2, phf.getText());
			pstmt.setString(5, typec.getSelectedItem().toString());
			pstmt.setString(4,addressf.getText());
			int x=pstmt.executeUpdate();
			if(x==1)
			{
				try
				{
					int m=0;
					pstmt=con.prepareStatement("select max(DID) as 'DID' from newtab");
					ResultSet rs=pstmt.executeQuery();
					while(rs.next())
					{
						m=rs.getInt("DID");
					}
					JOptionPane.showMessageDialog(null, "saved account..."+"UR DONOR_ID is "+m);

					pstmt.close();	
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	void update()
	{
		JOptionPane.showMessageDialog(null, "FOR UPDATIONS MAKE SURE U PROCEED WITH SEARCH BUTTON FIRST");

		try{
			pstmt=con.prepareStatement("update newtab set named=?,phonenum=?,emailadd=?,address=?,type=? where DID=?");

			pstmt.setInt(6,(Integer.parseInt(d)));
			pstmt.setString(1, (String)namec.getSelectedItem());
			pstmt.setString(3,emailf.getText());
			pstmt.setString(2, phf.getText());
			pstmt.setString(5,(String) typec.getSelectedItem());
			pstmt.setString(4,addressf.getText());
			pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "updated");
		}

		catch(Exception ae)
		{
			ae.printStackTrace();
		}
	}

	DonrRegstr()
	{
		con=sqlconn.getConnection();
		setLayout(null);
		//panel constructed	
		JPanel p1,p2;

		p1=new JPanel();
		p1.setLayout(null);
		p1.setSize(600,700);
		p1.setLocation(10,10);
		p1.setBorder(BorderFactory.createMatteBorder(5,5, 5, 5, Color.CYAN));
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setUndecorated(true);

		p1.setBackground(Color.LIGHT_GRAY);
		//declarations
		nameD=new JLabel();
		ph=new JLabel();
		email=new JLabel();  
		address=new JLabel();  
		type=new JLabel();
		h=new JLabel();
		image=new JLabel();
		image.setBounds(100,430,500,300);
		h.setIcon(new ImageIcon("cooltext125771418146533.png"));
		nameD.setIcon(new ImageIcon("cooltext125571280592769.png"));
		ph.setIcon(new ImageIcon("cooltext125571308760637.png"));
		email.setIcon(new ImageIcon("cooltext125571331462094.png"));
		address.setIcon(new ImageIcon("cooltext125571347547687.png"));
		type.setIcon(new ImageIcon("cooltext125571360704660.png"));
		String []ah={"ANKITA","ALISHA","HARMEET"};

		namec=new JComboBox(ah);
		String []aha={"INDIVIDUAL","FIRM","CORPORATE","SOCIETY","TRUST","OTHERS"};
		typec = new JComboBox(aha);
		typec.insertItemAt("CHOOSE TYPE",0);
		typec.setSelectedIndex(0);
		phf=new JTextField();
		emailf=new JTextField();
		addressf=new JTextField();
		//Setting all buttons,boxes and fields

		h.setBounds(60,5,900,250);
		//h.setForeground(Color.GREEN);
		//name of donr and combobox
		nameD.setBounds(30,170,500,100);
		nameD.setForeground(Color.pink);
		namec.setBounds(350,200,200,30);	
		namec.insertItemAt("YOUR NAME",0);
		namec.setSelectedIndex(0);
		namec.setEditable(true);
		//  phone num and text field
		ph.setBounds(30,260,500,30);
		ph.setForeground(Color.pink);
		phf.setBounds(350,260,200,30);
		//email id and txt field
		email.setBounds(30,290,500,100);
		email.setForeground(Color.pink);
		emailf.setBounds(350,320,200,30);
		//address and text field
		address.setBounds(30,350,500,100);
		address.setForeground(Color.pink);
		addressf.setBounds(350,375,200,30);
		//type and combobox
		type.setBounds(30,400,100,100);
		type.setForeground(Color.pink);
		typec.setBounds(350,440,200,30);
		typec.setEditable(false);
image.setIcon(new ImageIcon("images.jpg"));
		p1.add(address);
		p1.add(nameD);
		p1.add(namec);
		p1.add(addressf);
		p1.add(ph);
		p1.add(phf);
		p1.add(type);
		p1.add(typec);
		p1.add(email);
		p1.add(emailf);
		p1.add(h);
		p1.add(image);
		add(p1);
		//second panel
		p2=new JPanel();
		save=new JButton();
		save.setIcon(new ImageIcon("cooltext126195434766320.png"));
		neww=new JButton();
		search=new JButton();
		update=new JButton();
		cancel=new JButton();
		close=new JButton();
		neww.setIcon(new ImageIcon("cooltext126195728459069.png"));
		search.setIcon(new ImageIcon("cooltext126195743273992.png"));
		update.setIcon(new ImageIcon("cooltext126195757639538.png"));
		cancel.setIcon(new ImageIcon("cooltext126195774100920.png"));
		close.setIcon(new ImageIcon("cooltext126195794043732.png"));

		save.setBounds(20,20,200,100);
		save.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.cyan));
		save.setBackground(Color.white);
		neww.setBounds(140,120,200,100);
		neww.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.cyan));
		neww.setBackground(Color.white);
		search.setBounds(20,220,200,100);
		search.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.cyan));
		search.setBackground(Color.white);
		update.setBounds(140,320,200,100);
		update.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.cyan));
		update.setBackground(Color.white);
		cancel.setBounds(20,420,200,100);
		cancel.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.cyan));
		cancel.setBackground(Color.white);
		close.setBounds(160,520,200,100);
		close.setBorder(BorderFactory.createBevelBorder(ICONIFIED, Color.red, Color.cyan));
		close.setBackground(Color.white);

		save.addActionListener(new ActionListener()
		{

			public void actionPerformed(ActionEvent arg0)
			{     

				String  s1=(String)namec.getSelectedItem();
				String s2=phf.getText();
				String s3=addressf.getText();
				String s4=(String)typec.getSelectedItem();
				String s5=emailf.getText();

				//String s1=(String)s;
				//String s5=(String)l;

				if((s1.equals(""))||(s2.equals(""))||(s3.equals(""))||(s4.equals(""))||(s5.equals("")))
				{
					JOptionPane.showMessageDialog(null, "NO FIELD SHOULD BE EMPTY PLEASE");
				}
				else 
				{
					if(s2.length()==10)
					{
						char v;
						for(int i=0;i<s2.length();i++)
						{
							v=s2.charAt(i);
							if(Character.isDigit(v))
								flag=true;
							else 
								flag=false;

						}
						if(flag==true)
						{
							JOptionPane.showMessageDialog(null, "SUCCESS");
							savee();
						}
						else 
						{
							JOptionPane.showMessageDialog(null, "CHARACTERS ARE NOT ALLOWED ");
						}
					}
					else
						JOptionPane.showMessageDialog(null, "LENGTH SHOULD BE TEN ");

				}

			}

		});
		search.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					searchh();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		neww.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				phf.setText(null);
				emailf.setText(null);
				addressf.setText(null);
				typec.setSelectedIndex(0);
				namec.setSelectedIndex(0);

				JOptionPane.showMessageDialog(null," YOU CAN CREATE A NEW ACCOUNT" );

			}
		});
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
		update.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				update();

			}

		});

		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					delete();
				} catch (SQLException e) {

					e.printStackTrace();
				}


			}
		});

		p2.setLayout(null);
		p2.setSize(370,700);
		p2.setLocation(615,10);
		p2.setBorder(BorderFactory.createMatteBorder(5,5, 5, 5, Color.CYAN));
		p2.setBackground(Color.gray);
		p2.add(save);
		p2.add(neww);
		p2.add(search);
		p2.add(update);
		p2.add(cancel);
		p2.add(close);

		add(p2);	


		setSize(1000,750);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new DonrRegstr();
	}

}
