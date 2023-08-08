

package com.app;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;

public class Window3 extends JFrame

		{
			
			JLabel label1,label2;
			JComboBox cmb1;
			Connection cn;
			public void initComponenets()
			{
				cmb1=new JComboBox();
				cmb1.addItem("Select Employee Code");
				label1=new JLabel ("Emp Code");
				label1.setHorizontalAlignment(JLabel.CENTER);
				
				label2=new JLabel("Emp Salary");
				
				label2.setHorizontalAlignment(JLabel.CENTER);
				
				JPanel p1=new JPanel(new GridLayout(1,3,5,5));
				
				p1.setBorder(BorderFactory.createTitledBorder("Search Panel"));
				
				p1.add(cmb1);
				p1.add(label1);
				p1.add(label2);
				
				this.getContentPane().add(p1);
				
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
					
					cmb1.addItemListener(new ItemListener()
					{
					
						public void itemStateChanged(ItemEvent ie)
						{
							if(cmb1.getSelectedIndex()!=0)
								if(cmb1.getSelectedItem().equals(""+ie.getItem()))
								{
									searchEmployee(Integer.parseInt(""+cmb1.getSelectedItem()));
								}
						}
						
					}	
						
						);
			}
				
				
				public Window3()
				{
					this.initComponenets();
					this.initEvent();
					this.setTitle("Employee APP");
					this.setLocation(300,250);
					this.setVisible(true);
					this.setResizable(false);
					
					this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
						this.pack();
						
				}
				
			public static void main (String[] args) 
					{
						Window3 obj=new Window3();
					}
					
					public void openConnection()
					{
						try
						{
							 cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/university?autoReconnect=true&useSSL=false","root","Boot");
							if(!cn.isClosed())
								
							{
								label1.setText("Database");
								label2.setText("Connected!");
								PopulateDropdown();
							}
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Reason of error"+ex.getMessage());
						}
					}
					
					public void closeConnection()
					{
						try{
							if(!cn.isClosed())
								cn.close();
						}
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Reason of error::"+ex.getMessage());
						}
					}
					
					public void PopulateDropdown()
					{
						try{
							PreparedStatement ps=cn.prepareStatement("select code from workers");
							ResultSet rs=ps.executeQuery();
							while(rs.next())
							{
								cmb1.addItem(rs.getString(1));
							}
						}
						
						catch(Exception ex)
						{
							JOptionPane.showMessageDialog(null,"Reason of error"+ex.getMessage());
						}
					}
					
					public void searchEmployee(int code)
					{
						try{
							PreparedStatement ps=cn.prepareStatement("select name,salary from workers where code=?");
							
							ps.setInt(1,code);
							ResultSet rs=ps.executeQuery();
							
							if(rs.next())
							{
								label1.setText(rs.getString(1));
								label2.setText(rs.getString(2));
							}
						}
						
						catch(Exception ex)
							
						{
							JOptionPane.showMessageDialog(null,"Reason of error"+ex.getMessage());
						}
					}
		}