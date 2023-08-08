package com.app;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

import java.util.*;

public class Window4 extends JFrame
				{
					JTable table_1;
					defaultTableModel model;
					Connection cn;
					
					public void initComponet()
					{
						model=new DefaultTableModel();
						model.addColumn("CODE");
						model.addColumn("NAME");
						model.addColumn("SALARY");
						
						table_1=new JTable(mdel);
						table_1.setPreferredScrollableViewportSize(new Dimension(400,200));
						
						JPanel p1 = new JPanel(new GridLayout(1,1,5,5));
						p1.setBorder(BorderFactory.createTitleBorder("Records"));
						
						p1.add(new JScrollPane(table_1));
						
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
					
				}
				public Window4()
				{
					this.initComponet();
					JOptionPane.showMessageDialog(null,"Reason of Error::"+ex.getMessage());
				}	
			}
				public void populateTable()
			{
				try{
								PreparedStatement ps=cn.prepareStatement("select* from employee");
								ResultSet rs=ps.executeQuery();
								
								Vector col=new Vector();
								Vector rows=new Vector();
								
								
								for(int i=1;i<=rs.getMetaData().getColumnCount();i++)
					{
						col.add(rs.getMetaData().getColumnLabel(i).toUpperCase());
					}
					
			while(rs.next())
			{
				Vector temp=new Vector();
				
					for(int i=1; i<=rs.getMetaData().getColumnCount();i++)
					{
						temp.add(rs.getString(i));
					}
					row.add(temp);
			}
			
			model.setDataVector(rows,col);
			
			table_1.setModel(model);
		}
		catch(Exception ex){
			
			JOptionPane.showMessageDialog(null,"Reason of Error::"+ex.getMessage());
			
		}
				
			}
			
	}