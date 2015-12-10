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


class ahaha extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	Connection con;
	PreparedStatement pstmt;
	JPanel p;
	JLabel l,m,n,o;
	JTextField s;
	JButton save;
	JPasswordField r=new JPasswordField();
	JComboBox q;
	void save()
	{
		try
		{

			pstmt=con.prepareStatement("insert into adduser(USER_ID,PASSWORD,MOBILE_NUM,STATUS) values(?,?,?,?)");
			Object s1= q.getSelectedItem();
			pstmt.setObject(1, s1);
			char[]  aa = r.getPassword();
			String ss1=new String(aa);

			pstmt.setString(2, ss1);
			char []ch=s.getText().toCharArray();
			int flag = 0;
			String ss=new String(s.getText());
			if(ss.length()==(10))
			{
				JOptionPane.showMessageDialog(null,"Successfully registered!!");

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid entry");
				JOptionPane.showMessageDialog(null, "ENTER CORRECT MOBILE NUM PLEASE");
			}

			for(int i=0;i<=9;i++)
			{
				int val=Character.getNumericValue(ch[i]);
				if(val>=0&& val<=9)
				{
					flag=1;
				}
				else
				{
					flag=0; 
					break;
				}
			}
			if(flag==1)
			{
				JOptionPane.showMessageDialog(null, "correct");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"enter correct number");
			}
			//int b=Integer.parseInt(s.getText());
			pstmt.setString(3, s.getText());
			//pst.setString(2, "23455");
			pstmt.setInt(4, 1);
			int x=pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "saved"+x);
			pstmt.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	void update()
	{
		try 
		{
			pstmt=con.prepareStatement("update adduser set PASSWORD=?,MOBILE_NUM=?,STATUS=? where USER_ID=?");
			Object s1= q.getSelectedItem();
			pstmt.setObject(4, s1);
			char[]  aa = r.getPassword();
			String ss1=new String(aa);
			pstmt.setString(1, ss1);
			char []ch=s.getText().toCharArray();
			int flag = 0;

			String ss=new String(s.getText());
			if(ss.length()==(10))
			{
				JOptionPane.showMessageDialog(null,"Successfully registered!!");

			}
			else
			{
				JOptionPane.showMessageDialog(null, "Invalid entry !!Kindly enter correct mobile number");
			}

			for(int i=0;i<=9;i++)
			{
				int val=Character.getNumericValue(ch[i]);
				if(val>=0&& val<=9)
				{
					flag=1;
				}
				else
				{
					flag=0; 
					break;
				}
			}
			if(flag==1)
			{
				JOptionPane.showMessageDialog(null, "correct");
			}
			else
			{
				JOptionPane.showMessageDialog(null,"enter correct number");
			}

			//int b=Integer.parseInt(s.getText());
			pstmt.setString(2, s.getText());
			pstmt.setInt(3, 1);
			int x=pstmt.executeUpdate();
			JOptionPane.showMessageDialog(null, "Updated:"+x);
			pstmt.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	void delete() throws SQLException
	{

		pstmt=con.prepareStatement("delete from adduser where USER_ID=?");
		Object s1= q.getSelectedItem();
		pstmt.setObject(1, s1);
		int x=pstmt.executeUpdate();
		JOptionPane.showMessageDialog(null, "deleted:"+x);
		pstmt.close();
	}
	ahaha()
	{

		con=sqlconn.getConnection();
		JButton   fetch=new JButton();
		JButton   neww=new JButton();
		JButton	 add=new JButton();
		JButton	 uppdate=new JButton();
		JButton	 remove=new JButton();
		JButton	 close=new JButton();
		l=new JLabel();
		o=new JLabel();
		m =new JLabel();
		//-----------------------------------------

		o.setIcon(new ImageIcon("cooltext124804509773640.png"));
		l.setIcon(new ImageIcon("RenderedImage (1).png"));
		m.setIcon(new ImageIcon("RenderedImage (2).png"));
		neww.setIcon(new ImageIcon("cooltext125277643951148.png"));
		add.setIcon(new ImageIcon("RenderedImage (4).png"));
		fetch.setIcon(new ImageIcon("RenderedImage (10).png"));
		uppdate.setIcon(new ImageIcon("RenderedImage (5).png"));
		remove.setIcon(new ImageIcon("RenderedImage (6).png"));
		close.setIcon(new ImageIcon("RenderedImage (7).png")); 


		o.setBounds(110,10,400,200);
		o.setForeground(Color.GREEN);

		n=new JLabel();
		n.setIcon(new ImageIcon("RenderedImage (3).png"));
		//------------------------------------------------------------		   
		p=new JPanel();
		p.setBackground(Color.lightGray);	
		p.setLayout(null);
		p.setSize(300,300);
		p.setBorder(BorderFactory.createTitledBorder("WELCOME"));
		p.setBounds(200,200,500,500);
		save=new JButton();
		save.setBounds(130,475,120,40);
		save.setBackground(Color.white);
		save.setBorder(BorderFactory.createBevelBorder(ICONIFIED));
		save.setIcon(new ImageIcon("RenderedImage (8).png"));
		//---------------------------------------------------------

		String []ah={"ANKITA","KANIKA","HARMEET","ALISHA"};
		q=new JComboBox(ah);
		q.setBounds(258,190,150,30);

		q.insertItemAt("Akankshanayer@gmail.com",1);
		q.setEditable(true);
		q.setSelectedIndex(0);

		s=new JTextField();
		r=new JPasswordField();

		//Dimension dw=o.getPreferredSize();

		l.setBounds(20,160,250,100);
		m.setBounds(2,203,200,100);
		n.setBounds(2,244,500,100);
		//-------------------------------------------------------------------
		r.setBounds(258,235,150,30);
		s.setBounds(258,280,150,30);

		fetch.setBounds(313,475,120,40);
		fetch.setBackground(Color.white);
		fetch.setBorder(BorderFactory.createBevelBorder(ICONIFIED));

		neww.setBounds(48,330,120,40);
		neww.setBackground(Color.white);
		neww.setBorder(BorderFactory.createBevelBorder(ICONIFIED));

		add.setBounds(130,375,120,40);
		add.setBackground(Color.white);
		add.setBorder(BorderFactory.createBevelBorder(ICONIFIED));

		uppdate.setBounds(212,420,120,40);
		uppdate.setBackground(Color.white);
		uppdate.setBorder(BorderFactory.createBevelBorder(ICONIFIED));    	

		remove.setBounds(313,375,120,40);
		remove.setBackground(Color.white);
		remove.setBorder(BorderFactory.createBevelBorder(ICONIFIED));
		setUndecorated(true);
		Font brdr=new Font("arial",Font.BOLD+Font.ITALIC,20);
		Border compound=BorderFactory.createTitledBorder(null,"WELCOME",TitledBorder.CENTER,TitledBorder.TOP,brdr,Color.BLUE);
		p.setBorder(compound);

		close.setBounds(400,330,120,40);
		close.setBackground(Color.white);
		close.setBorder(BorderFactory.createBevelBorder(ICONIFIED));
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		//-------------------------------------------------------
		neww.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{

				q.setSelectedIndex(0);
				s.setText(null);
				r.setText(null);

				JOptionPane.showMessageDialog(null,"FEEL FREE TO CREATE A NEW ACCOUNT" );

			}
		});
		uppdate.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{      
				update();
				JOptionPane.showMessageDialog(null,"YOUR ACCOUNT IS UPDATED SUCCESFULLY" );

			}
		});
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {

				save();
			}

		});

		remove.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try {
					delete();
				} catch (SQLException e) {
					e.printStackTrace();
				}

				JOptionPane.showMessageDialog(null,"YOUR ACCOUNT HAS BEEN REMOVED " );
				JOptionPane.showMessageDialog(null,"THANK U " );
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
		fetch.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try{

					System.out.println((String) q.getSelectedItem());
					pstmt=con.prepareStatement("Select * from adduser where USER_ID=?");
					pstmt.setString(1, (String) q.getSelectedItem());
					ResultSet rs=pstmt.executeQuery();

					while(rs.next())
					{
						String	p=rs.getString("PASSWORD");
						String mob=rs.getString("MOBILE_NUM");
						System.out.println("Password="+p);
						System.out.println("Mobile number="+mob);

					}
					JOptionPane.showMessageDialog(null,"****KEEP CALM FETCHING INFORMATION...... " );
				}catch(Exception e)
				{
					e.printStackTrace();
				}

			}
		});
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				{
					JOptionPane.showMessageDialog(null,"GOTO SAVE BUTTON");

				}

			}});   
		p.add(fetch);
		p.add(neww);
		p.add(add);
		p.add(uppdate);
		p.add(remove);
		p.add(close);
		p.add(l);
		p.add(o);
		p.add(o);
		p.add(m);
		p.add(n);
		p.add(q);
		p.add(r);
		p.add(s);
		p.add(save);
		add(p);

		setSize(800,700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
public   class adduser
{

	public static void main(String[] args)
	{ 
		//JOptionPane.showMessageDialog(null, "aaa");
		ahaha n=new ahaha();
	//	JOptionPane.showMessageDialog(null, "aaa");
	}

}