import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
class home implements ActionListener
{
	JFrame f;
	JPanel p;
	JLabel lb;
	JButton b1,b2,b3,b4;
	home()
	{
		f=new JFrame("HOME PAGE");
		p=new ImagePanel(new ImageIcon("coins.jpg").getImage());
		f.getContentPane().add(p);
		f.setVisible(true);
		f.setSize(600,600);
		p.setLayout(null);
		f.getContentPane().setBackground(Color.blue);
		lb=new JLabel("BANKING SYSTEM");
		Font f2=new Font("Bookman Old Style",Font.BOLD,40);
		lb.setFont(f2);

		Font f3=new Font("Bookman Old Style",Font.BOLD,20);
		b1=new JButton("NEW CUSTOMER");
		b1.addActionListener(this);
		b1.setFont(f3);
		b2=new JButton("WITHDRAWAL");
		b2.addActionListener(this);
		b2.setFont(f3);
		b3=new JButton("DEPOSIT");
		b3.addActionListener(this);
		b3.setFont(f3);
		b4=new JButton("REPORT");
		b4.addActionListener(this);
		b4.setFont(f3);

		lb.setBounds(730,200,450,30);
		b1.setBounds(780,310,250,35);
		b2.setBounds(780,410,250,35);
		b3.setBounds(780,510,250,35);
		b4.setBounds(740,580,250,35);

		p.add(lb);
		p.add(b1);
		p.add(b2);
		p.add(b3);
		//p.add(b4);
	}

public void actionPerformed(ActionEvent ae)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			Statement s=c.createStatement();
			ResultSet rs;

		if(ae.getSource()==b1) 
		{
	
			new customer();
			f.setVisible(false);
		}
		if(ae.getSource()==b2) 
		{
	
			new withdraw();
			f.setVisible(false);
		}
		if(ae.getSource()==b3) 
		{
	
			new deposit();
			f.setVisible(false);
		}		


		if(ae.getSource()==b4) 
		{
	
			//new TableFromDatabase();
			f.setVisible(false);
		}
		}
		catch(Exception e)	
		{
			JOptionPane.showMessageDialog(f,e);
		}
        	  }




	public static void main(String ar[])
	{
		new home();
	}
}
	
