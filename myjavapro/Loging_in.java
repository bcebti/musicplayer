package myjavapro;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.*;
public class Loging_in extends JFrame
{
	
	private static final long serialVersionUID = 1L;
	JPanel p;
	JLabel l;
	JButton b1,b2;
	Loging_in()
	{
		p=new JPanel();
		l=new JLabel();
		l.setIcon(new ImageIcon("homelogin.png"));
		

		b1=new JButton();
		b2=new JButton();
		b1.setIcon(new ImageIcon("adminlogin.png"));
		b2.setIcon(new ImageIcon("userlogin.png"));
		p.setLayout(null);
		p.setSize(600,600);

		p.setBackground(Color.LIGHT_GRAY);
		p.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		p.setBounds(100,100,500,500);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setUndecorated(true);
		
		l.setBounds(50,50,700,100);
		b1.setBounds(30,200,700,100);
		b2.setBounds(30,370,700,100);
		
		
		
		
		b1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{
				String y="ENTER ADMIN PASSWORD PLEASE";
				String a="ANKITA";

			String b= JOptionPane.showInputDialog(null,y);
			 int val=b.compareTo(a);
			 if(val==0)
			 {
				
				 new ahaha();
				 
			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null, "ENTER CORRECT PASSWORD");
			 }
			 }
			
		});
		b2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0)
			{
				new ogin();
			}
			
		});
		  p.add(l);
		  p.add(b1);
		  p.add(b2);
		  add(p);
           getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
           setUndecorated(true);
           setSize(800,700);
         setVisible(true);
       	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		
	}
	
	public static void main(String[] args) {
	new Loging_in();
	}

}
