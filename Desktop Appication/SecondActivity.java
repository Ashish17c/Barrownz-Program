package com.app;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SecondActivity extends JFrame
	{
		JLabel label_1, label_2, label_3;
		
		JButton button_1, button_2;
		
		JTextField txt1, txt2;
		Connection cn;
		
		public void initComponents()
		{
			label_1=new JLabel("ENTER NAME");
			label_2=new JLabel("ENTER SALARY");
			label_3=new JLabel("_Output-");
			label_3.setHorizontalAlignment(JLabel.CENTER);
			
			txt1=new JTextField(20);
			txt2=new JTextField(20);
			
			button_1=new JButton("Insert");
			button_2=new JButton("reset");
			
			JPanel p1=new JPanel(new GridLayout(3,2,5,5));
			
			p1.setBorder(BorderFactory.createTitledBorder("Insertion Panel"));
			
			p1.add(label_1);
			p1.add(txt1);
			
			p1.add(label_2);
			p1.add(txt2);
			
			p1.add(button_1);
			p1.add(button_2);
			
			JPanel p2 = new JPanel(new GridLayout(1,1,5,5));
			
			p2.setBorder(BorderFactory.createTitledBorder("Output Panel"));
			p2.add(label_3);
			
			this.getContentPane().add(BorderLayout.NORTH,p1);
			this.getContentPane().add(BorderLayout.SOUTH,p2	);
			
		}
		
		 public void initEvent()
 {
 	this.addWindowListener(new WindowAdapter()
 	{
 		public void windowOpened(WindowEvent we)
 		{
 			openConnection();
 		}
 		public void windowClosing(WindowEvent we)
 		{
 			JOptionPane.showMessageDialog(null,"Window Close");
 		}
 	}
 	);
 }
 
		
		public SecondActivity()
		{
			
			this.initComponents();
			this.initEvent();
			this.setTitle("InsertEnployee window");
			this.setLocation(200, 200);
			this.setVisible(true);
			this.setResizable(false);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.pack();
		}
		
		public static void main (String[] args) {
			SecondActivity obj = new SecondActivity();
	}

 public void openConnection()
 {
 	try{
 		cn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/university?autoReconnect=true&useSSL=false","root", " Boot");
 		
 		
 		if(!cn.isClosed())
 			label_3.setText("Database Connected");
 		}
 	catch(Exception ex)
 		
		 	{
		 		javax.swing.JOptionPane.showMessageDialog(null,"Reason of error::"+ex.getMessage());
		 	}
 }
 public void closeConnection()
 {
 	try 
 		{
    		if(!cn.isClosed())
    			cn.close();
		}
		catch (Exception ex) 
			{
			}
 }
 
 }