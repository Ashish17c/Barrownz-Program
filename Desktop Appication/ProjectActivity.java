package com.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;

import java.io.*;

public class ProjectActivity extends JFrame	
				{
					
						JLabel label_1,label_2,label_3,label_4;
						JButton button_1,button_2,button_3,button_4;
						JTextField txt1,txt2,txt3,txt4;
						DefaultTableModel model;
						JTable table_1;
						
						Connection cn;
						
						public void initComponent()
								{
									
											label_1=new JLabel("CODE");
											label_1.setHorizontalAlignment(JLabel.CENTER);
											
											label_2=new JLabel("NAME");
											label_2.setHorizontalAlignment(JLabel.CENTER);
											
											label_3=new JLabel("SALARY");
											label_3.setHorizontalAlignment(JLabel.CENTER);
											
											label_4=new JLabel("SEARCH BY  NAME");
											label_4.setHorizontalAlignment(JLabel.CENTER);
											
											txt1=new JTextField(20);
											txt1.setEditable(false);
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
										
										
										button_1.addActionListener(new ActionListener()
													{
															public void actionPerformed(ActionEvent ae)
																{
																	
																	insertRecord();
																	
																}
														
													}
											);
											
											
										button_2.addActionListener(new ActionListener()
													{
															public void actionPerformed(ActionEvent ae)
																{
																	
																	updateRecord();
																	
																}
														
													}
											);
											
									button_3.addActionListener(new ActionListener()
													{
															public void actionPerformed(ActionEvent ae)
																{
																	
																	deleteRecord();
																	
																}
														
													}
											);
											
									button_4.addActionListener(new ActionListener()
													{
														
															public void actionPerformed(ActionEvent ae)
																{
																	generateReport("select * from worker");
																	
																}
														
													}
										
										);
											
											
											
										table_1.addMouseListener(new MouseAdapter()
												{
													
													
															public void mouseClicked(MouseEvent e)
																	{
																		
																			int row=table_1.getSelectedRow();
																			
																			String code=""+table_1.getValueAt(row,0);
																			String name=""+table_1.getValueAt(row,1);
																			String salary=""+table_1.getValueAt(row,2);
																			
																			
																			txt1.setText(code);
																			txt2.setText(name);
																			txt3.setText(salary);
																				
																	}
													
												}
											
											
											);
											
										txt4.addKeyListener(new KeyAdapter()
													{
																public void keyReleased(KeyEvent ke)
																	{
																				String name=""+txt4.getText();
																				String sql="select * from worker where name like '%"+name+"%'";
																				populateTableOne(sql);
																	}
													}
											);
								
							}
						
						
						
							
							
							
							public ProjectActivity()
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
											public static void main (String[] args) throws Exception
								
								{
									
										ProjectActivity obj=new ProjectActivity();
									//	UIManager.setLookAndFeel(new com.jtattoo.plaf.noire.NoireLookAndFeel());
									//	SwingUtilities.updateComponentTreeUI(obj);
								
						    }
						    
						    public void openConnection()
						    	{
						    			try
						    				{
						    					
						    					cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/university","root","Boot");
						    					
						    					if(!cn.isClosed())
						    						{
						    							
						    							populateTable();
						    							
						    						}
						    					
						    					
						    					
						    				}
						    			catch(Exception e)
						    			{
						    				
						    					System.out.println ("Reason of Error::"+e.getMessage());
						    						
						    				
						    			}
	
						   		}
						   		
						   		    public void closeConnection()
						    			{
						    			try
						    				{
						    					
						    					if(!cn.isClosed())
						    							cn.close();
						    					
						    				}
						    			catch(Exception e)
						    			{
						    				
						    					System.out.println ("Reason of Error::"+e.getMessage());
						    						
						    				
						    			}
						    		
						   		}
						   		
						   		
						   		 public void populateTable()
						    			{
						    			try
						    				{
						    					
						    						PreparedStatement ps=cn.prepareStatement("select * from worker");
						    						
						    						ResultSet rs=ps.executeQuery();
						    						
						    						
						    						Vector cols=new Vector();
						    						Vector data=new Vector();
						    						
						    						for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
						    								{
						    									
						    											cols.add(rs.getMetaData().getColumnLabel(i));
						    									
						    								}
						    						while(rs.next())
						    								{
						    									
						    										Vector temp=new Vector();
						    										
						    										for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
						    											{
						    												temp.add(rs.getString(i));
						    												
						    											}
						    									
						    										data.add(temp);
						    								}
						    						
						    						
						    						model.setDataVector(data,cols);
						    						
						    						table_1.setModel(model);
						    						
						    					
						    				}
						    			catch(Exception e)
						    			{
						    				
						    					System.out.println ("Reason of Error::"+e.getMessage());
						    						
						    				
						    			}
						    		
						   		}
						   		
						   		
						   public void insertRecord()
						   		{
						   			try {
						   				
						   						if(txt2.getText().length()>0 && txt3.getText().length()>0)
						   						{
						   						
						   				
						   							String name=txt2.getText();
						   							
						   							double salary=Double.parseDouble(txt3.getText());
						   							
						   							PreparedStatement ps=cn.prepareStatement("insert into worker(name,salary) values(?,?)");
						   							ps.setString(1,name);
						   							ps.setDouble(2,salary);
						   							
						   							int a=ps.executeUpdate();
						   							
						   							if(a>0)
						   									{
						   										populateTable();
						   									}
						   						}
						   						else
						   							{
						   								JOptionPane.showMessageDialog(null,"Field Empty!");
						   								
						   							}
													
											}
											catch (Exception ex) {
												
													System.out.println ("Reason of Error::"+ex.getMessage());
														
											}
						   			
						   		}
						   		
						   		
						   	  public void updateRecord()
						   		{
						   			try {
						   				
						   						if(txt2.getText().length()>0 && txt3.getText().length()>0)
						   						{
						   						
						   				
						   							String name=txt2.getText();
						   							
						   							double salary=Double.parseDouble(txt3.getText());
						   							
						   							PreparedStatement ps=cn.prepareStatement("update worker set name=?,salary=? where code=?");
						   							ps.setString(1,name);
						   							ps.setDouble(2,salary);
						   							ps.setInt(3,Integer.parseInt(""+txt1.getText()));
						   							
						   							int a=ps.executeUpdate();
						   							
						   							if(a>0)
						   									{
						   										populateTable();
						   									}
						   						}
						   						else
						   							{
						   								JOptionPane.showMessageDialog(null,"Field Empty!");
						   								
						   							}
													
											}
											catch (Exception ex) {
												
													System.out.println ("Reason of Error::"+ex.getMessage());
														
											}
						   			
						   		}
						   		
						   		
						   		
						   		 public void deleteRecord()
						   		{
						   			try {
						   				
						   						if(txt2.getText().length()>0 && txt3.getText().length()>0)
						   						{
						   						
						   				
						   							
						   							
						   							PreparedStatement ps=cn.prepareStatement("delete from worker where code=?");
						   							ps.setInt(1,Integer.parseInt(""+txt1.getText()));
						   							
						   							int a=ps.executeUpdate();
						   							
						   							if(a>0)
						   									{
						   										populateTable();
						   									}
						   						}
						   						else
						   							{
						   								JOptionPane.showMessageDialog(null,"Field Empty!");
						   								
						   							}
													
											}
											catch (Exception ex) {
												
													System.out.println ("Reason of Error::"+ex.getMessage());
														
											}
						   			
						   		}
						   		
						   		
						   		 public void populateTableOne(String sql)
						    			{
						    			try
						    				{
						    					
						    						PreparedStatement ps=cn.prepareStatement(sql);
						    						
						    						ResultSet rs=ps.executeQuery();
						    						
						    						
						    						Vector cols=new Vector();
						    						Vector data=new Vector();
						    						
						    						for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
						    								{
						    									
						    											cols.add(rs.getMetaData().getColumnLabel(i));
						    									
						    								}
						    						while(rs.next())
						    								{
						    									
						    										Vector temp=new Vector();
						    										
						    										for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
						    											{
						    												temp.add(rs.getString(i));
						    												
						    											}
						    									
						    										data.add(temp);
						    								}
						    						
						    						
						    						model.setDataVector(data,cols);
						    						
						    						table_1.setModel(model);
						    						
						    					
						    				}
						    			catch(Exception e)
						    			{
						    				
						    					System.out.println ("Reason of Error::"+e.getMessage());
						    						
						    				
						    			}
						    		
						   		}
						   		
						   		
						   		
						   		public void generateReport(String sql)
						   				{
						   					
						   						try
						   							{
						   								PreparedStatement ps=cn.prepareStatement(sql);
						   								ResultSet rs=ps.executeQuery();
						   								
						   								String str="";
						   								
						   								str+="<html>";
						   										str+="<head>";
						   												str+="<title> My Report </title>";
						   										str+="</head>";
						   										
						   										str+="<body>";
						   											
						   												str+="<table cellpadding=10 cellspacing=0 border=1 width=70% bgcolor=lightyellow align=center>";
						   												
						   												str+="<tr bgcolor=red>";
						   														for(int  i=1;i<=rs.getMetaData().getColumnCount();i++)
						   																{
						   																	str+="<th align=center><font bgcolor=white>"+rs.getMetaData().getColumnLabel(i);
						   																	str+="</th>";
						   																	
						   																}
						   												str+="</tr>";
						   												
						   												
						   												while(rs.next())
						   														{
						   															str+="<tr>";
						   															
						   																for(int  i=1;i<=rs.getMetaData().getColumnCount();i++)
						   																{
						   																	str+="<td align=center>"+rs.getString(i)+"</td>";
						   																	
						   																}
						   															
						   															
						   															str+="</tr>";
						   														}
						   												
						   												
						   												str+="<table>";
						   										
						   										
						   										str+="</body>";
						   								str+="</html>";
						   								
						   								
						   								File file=new File("Report.html");
						   								file.createNewFile();
						   								
						   								FileOutputStream fos=new FileOutputStream(file);
						   								
						   								fos.write(str.getBytes());
						   								
						   								fos.close();
						   								file.deleteOnExit();
						   								
						   								
						   								Runtime r=Runtime.getRuntime();
						   								
						   								Process p=r.exec("C:\\Program Files\\Internet Explorer\\iexplore.exe "+file.getAbsolutePath());						
						   								
						   							}
						   						catch(Exception e)
						   							{
						   								
						   								System.out.println ("Reason of Error::"+e.getMessage());
						   									
						   								
						   							}
						   					
						   				}
						   		
				}