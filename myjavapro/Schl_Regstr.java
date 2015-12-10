package myjavapro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;

public class Schl_Regstr extends JFrame
    {
	/**
	   
	 */   Connection con;
		PreparedStatement pstmt;
	   private static final long serialVersionUID = 1L;
	   JLabel nmes,addrs,nums,phn,h1,city,head,Rqmt,aa;
	   JPanel p2,p3;
	   Boolean flag;
	   JTextField nmest,numst,phnt,cityt,headt;
	   JButton neu,sav,close;
	   JTextArea addrsfill=new JTextArea("",8,8);
       JTextArea Rqmtfill=new JTextArea("",8,8);
    	void savve()
   		{
   				try
   				{
   					
   					pstmt=con.prepareStatement("insert into tab(names,address,num_student,phone_num,cityname,headnam,requirem) values(?,?,?,?,?,?,?)");
   					pstmt.setString(1,nmest.getText());
   					pstmt.setString(3,numst.getText());
   					pstmt.setString(2,addrsfill.getText());
   					pstmt.setString(4,phnt.getText());
   					pstmt.setString(5,cityt.getText());
   					pstmt.setString(6,headt.getText());
   					pstmt.setString(7,Rqmtfill.getText());
   					pstmt.executeUpdate();
   					JOptionPane.showMessageDialog(null,"SAVED");
   				}
   		
   				catch (Exception e) 
   					{
   					e.printStackTrace();
   					}
   			
   		}
	   Schl_Regstr() 
	   {
		   con=sqlconn.getConnection();
		   setLayout(null);
	    p2=new JPanel();
	    p2.setSize(883,570);
	    p2.setLocation(3,3);
		p2.setLayout(null);
		p2.setBorder(BorderFactory.createMatteBorder(3,3, 3, 3, Color.cyan));
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
	    setUndecorated(true);
	    p2.setBackground(Color.LIGHT_GRAY);
	    //declarations
	    aa=new JLabel();
	    Rqmt=new JLabel();
		nmes=new JLabel();
		addrs=new JLabel();
		nums=new JLabel();
		phn=new JLabel();
		h1=new JLabel();
		h1.setIcon(new ImageIcon("schoolreg.png"));
		nmes.setIcon(new ImageIcon("cooltext126749412198494.png"));
		phn.setIcon(new ImageIcon("cooltext126749712845050.png"));
		addrs.setIcon(new ImageIcon("cooltext126749741585606.png"));
aa.setIcon(new ImageIcon("a1.jpg"));
aa.setBounds(600,70,500,550);
		nmest=new JTextField();
		numst=new JTextField();
		phnt=new JTextField();
		city=new JLabel();
		cityt=new JTextField();
		head=new JLabel();
		headt=new JTextField();
		city.setIcon(new ImageIcon("cooltext126749842171270.png"));

		//setting first panel
	    h1.setBounds(250,1,600,200);
	    nmes.setBounds(90,120,200,100);
		   nmes.setForeground(Color.pink);
		   nmest.setBounds(350,150,200,40);
	   //  phone num and text field
		   phn.setBounds(90,170,200,100);
		   phn.setForeground(Color.pink);
		   phnt.setBounds(350,200,200,40);
       //address and txt area
		   addrs.setBounds(90,230,200,100);
		   addrs.setForeground(Color.pink);
		   JScrollPane scroll=new JScrollPane(addrsfill);
	       scroll.setBounds(350,260,200,40);
	       scroll.setVisible(true);
	    //   addrs.setBorder(BorderFactory.createLineBorder(Color.GREEN));
	       //number of students and text field
		   nums.setBounds(90,390,300,100);
		   nums.setForeground(Color.pink);
		   numst.setBounds(350,430,200,40);	    
		   city.setBounds(90,280,200,100);
		   city.setForeground(Color.pink);
           cityt.setBounds(350,320,200,40);
           head.setBounds(90,330,200,100);
		   head.setForeground(Color.pink);
		   head.setIcon(new ImageIcon("cooltext126751402850679.png"));
		   nums.setIcon(new ImageIcon("cooltext126749768247292.png"));

           headt.setBounds(350,380,200,40);
           Rqmt.setBounds(90,450,200,100);
		   Rqmt.setForeground(Color.pink);
		   Rqmt.setIcon(new ImageIcon("cooltext126749798719396.png"));

		   JScrollPane scrolls=new JScrollPane(Rqmtfill);
	       scrolls.setBounds(350,480,200,70);
	       scrolls.setVisible(true);
	       p3=new JPanel();
	       p3.setSize(870,120);
		  p3.setLocation(10,582);
			p3.setLayout(null);
			p3.setBackground(Color.DARK_GRAY);
			p3.setBorder(BorderFactory.createMatteBorder(5,5, 5, 5, Color.cyan));
	       neu=new JButton();
	       sav=new JButton();
	       close=new JButton();
	       neu.setBounds(10,20,250,70);
	       sav.setBounds(320,20,250,70);
	       close.setBounds(610,20,250,70);
		   sav.setIcon(new ImageIcon("RenderedImage.png"));
		   neu.setIcon(new ImageIcon("aqa.png"));
		   close.setIcon(new ImageIcon("aqq.png"));
	       neu.addActionListener(new ActionListener(){
	    	   public void actionPerformed(ActionEvent arg0)
	    	   {
	    		   nmest.setText(null);
	    		   numst.setText(null);
	    		   phnt.setText(null);
	    		   cityt.setText(null);
	    		   headt.setText(null);
	    		   addrsfill.setText(null);
	    		   Rqmtfill.setText(null);
	    		   JOptionPane.showMessageDialog(null,"CREATE A NEW SCHOOL ACCOUNT");
	    	   }
	       });
	       sav.addActionListener(new ActionListener(){
	    	   public void actionPerformed(ActionEvent arg0)
	    	   {
	    		   String s1=(String)nmest.getText();
	    		   String s2=(String)addrsfill.getText();
	    		   String s3=(String)numst.getText();
	    		   String s4=(String)phnt.getText();
	    		   String s5=(String)cityt.getText();
	    		   String s6=(String)headt.getText();
	    		   String s7=(String)Rqmtfill.getText();
	    		   if((s1.equals(""))||(s2.equals(""))||(s3.equals(""))||(s4.equals(""))||(s5.equals(""))||(s6.equals(""))||(s7.equals("")))
	   			{
	   				JOptionPane.showMessageDialog(null, "NO FIELD SHOULD BE EMPTY PLEASE");
	   			}
	   			else 
	   			{
	   				if(s4.length()==10)
	   				{
	   					char v;
	   					for(int i=0;i<s3.length();i++)
	   					{
	   						v=s3.charAt(i);
	   						if(Character.isDigit(v))
	   							flag=true;
	   						else 
	   							flag=false;

	   					}
	   					if(flag==true)
	   					{
	   						JOptionPane.showMessageDialog(null, "SUCCESS");
	   						savve();
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
	  
	       p3.add(neu);
	       p3.add(sav);
	       p3.add(close);
	       add(p3);	       
	    	p2.add(nmes);
	    	p2.add(aa);
	    	p2.add(addrs);
	    	p2.add(nmest);
	    	p2.add(numst);
	    	p2.add(nums);
	    	p2.add(phn);
	    	p2.add(phnt);
	    	p2.add(h1);
	    	p2.add(scroll);
	    	p2.add(city);
	    	p2.add(cityt);
	    	p2.add(head);
	    	p2.add(headt);
	    	p2.add(Rqmt);
	    	p2.add(scrolls);
	         add(p2);
			setSize(900,750);
			setVisible(true);
			   setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		}
   	 
public static void main(String[] args) {
		new Schl_Regstr();
	}

}
