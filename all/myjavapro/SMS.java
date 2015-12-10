package myjavapro;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;





public class SMS implements ActionListener, ListSelectionListener
{
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	JFrame f;
	JLabel title,mob,msg;
	JTextField tmob,tmsg,tadd;
	JButton selectall,send,done;
	JPanel p;
	JList l1;
	String ss,m1;
	JScrollPane scroll;
	String selected="";
	DefaultListModel model;

void filllist()
{
	con=sqlconn.getConnection();
	
	try{
		
		 model = new DefaultListModel();
		
		pst=con.prepareStatement("Select distinct mobilenum from donation");
		rs=pst.executeQuery();
		while(rs.next()==true)
		{
		
			String mb=rs.getString("mobilenum");
			model.addElement(mb);
			//c1.addItem(rs.getString("MobileNo"));
		}
		l1.setModel(model);
		rs.close();
		pst.close();
	
}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
}

	SMS()
	{
		f=new JFrame();
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		p=new JPanel();
		p.setLayout(null);
		p.setVisible(true);
		p.setBounds(0,0,600,600);
		p.setBackground(Color.LIGHT_GRAY);
		
		title=new JLabel();
		title.setIcon(new ImageIcon("sending.png"));
		title.setBounds(1,10,580,100);
		Font f1=new Font("Tahoma",Font.BOLD+Font.ITALIC,30);
		title.setFont(f1);
		l1=new JList();
		scroll = new JScrollPane(l1);
		scroll.setBounds(100, 90, 230, 150);
		filllist();
		
		
		//l1.repaint();
		
		l1.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				/*String aa  = l1.getSelectedValue().toString()+",";
				//tmob.setText("null");
				selected += aa;
				JOptionPane.showMessageDialog(null, selected);*/
				Object[] a=l1.getSelectedValues();
				
				selected="";
				for(Object b:a){
					selected=selected+b.toString()+",";
				}
				//tmob.setText("");
				tmob.setText(selected);
			}
		});
		//l1.setVisible(true);
		
		
		//l1.addListSelectionListener(this);
		
		mob=new JLabel("Selected MobileNo.s :-");
		mob.setBounds(90,290,220,30);
		Font m=new Font("Arial",Font.BOLD,20);
		mob.setFont(m);  
		
		tmob=new JTextField();
		tmob.setBounds(30,340,360,60);
		ss=tmob.getText();
		
		
		msg=new JLabel("Message:");
		msg.setBounds(30,420,200,30);
		msg.setFont(m);
		tmsg=new JTextField();
		tmsg.setBounds(260,420,200,30);
		String m1=tmsg.getText();
		
		
		send=new JButton("Send SMS");
		send.setBounds(170,480,155,60);
		send.setFont(m);
		
		send.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				if(tmob.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Choose Mobile Number");
				}
				else
				{
			String res=smsDone.bceSunSoftSend("sunsoft123","sunsoft1234",ss,tmsg.getText(),"SUNSFT");	
			JOptionPane.showMessageDialog(null, res);
			res=res.toLowerCase();
			if(res.indexOf("successfully")!=-1)
			{
				JOptionPane.showMessageDialog(null, "Send");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Check Internet Connection");
			}
		}}
		});
		
		selectall=new JButton("Select All");
		selectall.setBounds(350,90,130,60);
		selectall.setFont(m);
		
		selectall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				selected="";
				
				for(int i=0;i<model.getSize();++i){
					selected=selected+model.get(i)+",";
				}
				
				tmob.setText(selected);
			}
		});
		
		
		
		
		//done=new JButton("Done");
		//done.setBounds(350,190,130,60);
		//done.setFont(m);
		
		
		f.add(p);
		p.add(title);
		p.add(mob);
		p.add(tmob);
		p.add(msg);
		p.add(tmsg);
		p.add(send);
		p.add(selectall);
		//p.add(done);
		p.add(scroll);
		
		f.setVisible(true);
		f.setBounds(0,0,600,600);
		
	}
	public static void main(String args[])
	{
		new SMS();
	}

	public void actionPerformed(ActionEvent arg0) {
		
	}

	String a="";
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		
		//a= l1.getSelectedValue().toString()+",";
		
		/*String[] selected=new String[9];
		for(int i=0;i<selected.length;i++)
		{
			selected[i] = l1.getSelectedValue().toString();
			
			String	b= selected[i];
			a=a.concat(b+",");
		}*/
			//tmob.setText(a);
			
	}
} 