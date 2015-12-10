package myjavapro;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
	public class About_us extends JFrame
	{
		JLabel a1,a2,a3,a4,a5,a6,a7,a8,a9,a10,a11;
		JPanel p;
	
	About_us()
	{
		setLayout(null);
		p=new JPanel();
		p.setBackground(Color.LIGHT_GRAY);	
		p.setLayout(null);
	//	p.setSize(1200,1200);
		p.setBorder(BorderFactory.createTitledBorder("ABOUT US"));
		p.setBounds(2,2,1100,800);
		a1=new JLabel();
		a2=new JLabel();
		a3=new JLabel();
		a4=new JLabel();
		a5=new JLabel();
		a6=new JLabel();
		a7=new JLabel();
		a8=new JLabel();
		a9=new JLabel();
		a10=new JLabel();
		a11=new JLabel();
		a1.setIcon(new ImageIcon("develop.png"));
		a2.setIcon(new ImageIcon("aboutus (2).png"));
		a3.setIcon(new ImageIcon("rollno (1).png"));
		a4.setIcon(new ImageIcon("underguid.png"));
		a5.setIcon(new ImageIcon("rollno (2).png"));
		a6.setIcon(new ImageIcon("founder.png"));
		a7.setIcon(new ImageIcon("bce.png"));
		a8.setIcon(new ImageIcon("trainig.png"));
		a9.setIcon(new ImageIcon("sst.png"));
		a10.setIcon(new ImageIcon("contact.png"));
		a11.setIcon(new ImageIcon("cooltext127076667132425.png"));

		

		a1.setBounds(50,70,600,100);
		a2.setBounds(400,100,600,100);
		a3.setBounds(400,170,600,100);
		a4.setBounds(50,220,600,100);
		a5.setBounds(400,290,600,100);
		a6.setBounds(50,320,600,100);
		a7.setBounds(400,370,600,100);
		a8.setBounds(50,420,650,100);
		a9.setBounds(400,490,600,100);
		a10.setBounds(50,520,600,100);
		a11.setBounds(400,590,600,100);
		p.add(a1);
		p.add(a2);
		p.add(a3);
		p.add(a4);
		p.add(a5);
		p.add(a6);
		p.add(a7);
		p.add(a8);
		p.add(a9);
		p.add(a10);
	p.add(a11);
	add(p);
getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
setUndecorated(true);
		setSize(1100,1200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
public static void main(String[] args) {
new About_us();
}
}