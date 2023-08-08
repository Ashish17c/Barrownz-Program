package com.app;

import javax.swing.*;

import java.awt.*;   //Abstract Window toolkit

import java.awt.event.*;



public class FirstActivity extends JFrame
		{
			JLabel label_1, label_2;																																											
			JTextField txt1;
			JButton button_1;
			
			public void initComponents()
			{
				label_1 = new JLabel("Enter your name::");
				label_2 = new JLabel("");
				
				txt1 = new JTextField(20);
				button_1 = new JButton("Say Hello");
				
				button_1.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent ae)
					{
						String name = txt1.getText();
						label_2.setText("Hello......"+name);
						
						txt1.setText(" ");
					}
				}
					);
					
					JPanel p1=new JPanel(new GridLayout(1,4,5,5));
					p1.setBorder(BorderFactory.createTitledBorder("PanelBorder"));
					
					p1.add(label_1);
					p1.add(txt1);
					p1.add(button_1);
					p1.add(label_2);
					
					this.getContentPane().add(p1);
				}
				public FirstActivity()
				{
					this.initComponents();
					this.setTitle("HelloApp");
					this.setLocation(200,200);
					this.setVisible(true);
					this.setResizable(false);
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					this.pack();
				}
				public static void main (String[] args) {
					FirstActivity obj=new FirstActivity();
					
				}
			}