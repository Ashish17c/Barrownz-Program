package com.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Window5 extends JFrame
					{
						JLabel label_1,label_2,label_3,label_4;
						JButton button_1,button_2,button_3,button_4;
						JTextField txt1,txt2,txt3,txt4;
						DefaultTableModel model;
						JTable table_1;
						
						Connection cn;
						
						public void initComponent(){
							
							label_1=new JLabel("CODE");
							label_1.setHorizontalAlignment(JLabel.CENTER);
							
							label_2=new JLabel("NAME");
							label_2.setHorizontalAlignment(JLabel.CENTER);
							
							label_3=new JLabel("SALARY");
							label_3.setHorizontalAlignment(JLabel.CENTER);
							
							label_4=new JLabel("SEARCH BY NAME");
							label_4.setHorizontalAlignment(JLabel.CENTER);
								
							txt1=new JTextField(20);
							txt2=new JTextField(20);
							txt3=new JTextField(20);
							txt4=new JTextField(20);
							
							button_1=new JButton("CREATE");
							button_2=new JButton("UPDATE");
							button_3=new JButton("DELETE");
							button_4=new JButton("REPORT");
							
							JPanel p1=new JPanel(new GridLayout(3,3,5,5));
							p1.setBorder(BorderFactory.createTitledBorder("Operation Panel"));
							
							p1.add(label_1);
							p1.add(label_2);
							p1.add(label_3);
							
							p1.add(txt1);
							p1.add(txt2);
							p1.add(txt3);
							
							p1.add(button_1);
							p1.add(button_2);
							p1.add(button_3);
							
							model=new DefaultTableModel();
							
							model.addColumn("CODE");
							model.addColumn("NAME");
							model.addColumn("SALARY");
							
							table_1=new JTable(model);
							
							table_1.setPreferredScrollableViewportSize(new Dimension(350,200));
							
							JPanel p2=new JPanel(new GridLayout(1,1,5,5));
							
							p2.setBorder(BorderFactory.createTitledBorder("Show Records"));
							
							p2.add(new JScrollPane(table_1));
							
							JPanel p3=new JPanel(new GridLayout(1,3,5,5));
							p3.setBorder(BorderFactory.createTitledBorder("Report Records"));
							
							p3.add(label_4);
							p3.add(txt4);
							p3.add(button_4);
							
							this.getContentPane().add(BorderLayout.NORTH,p1);
							this.getContentPane().add(BorderLayout.CENTER,p2);
							this.getContentPane().add(BorderLayout.SOUTH,p3);	
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
						closeConnection();
					}
				}
					
					);
			}			
							public Window5()
						{
							this.initComponent();
							
							this.initEvent();
							this.setTitle("MyProject");
							this.setLocation(200,200);
							this.setVisible(true);
							this.setResizable(false);
							this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
							this.pack();
						}
						public static void main (String[] args) {
							
							Window5 obj=new Window5();
								
			}
			
			
			
	}