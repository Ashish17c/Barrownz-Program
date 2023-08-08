// Selected box windows program.

package com.app;
import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

public class Windows1 extends JFrame
{
	JLabel label_1, label_2;
	
	JComboBox cmb1;
	
	public void initComponents()
	{
		label_1 = new JLabel("SELECT THE CAPITAL OF INDIA");
		label_2= new JLabel("");
		cmb1=new JComboBox(new String[]{ "-select capital-","Lucknow","Delhi","Mumbai","Maharashtra"} );
		
		JPanel p1=new JPanel(new GridLayout(1,3,5,5));
		p1.setBorder(BorderFactory.createTitledBorder("Combo.Panel"));
		p1.add(label_1);
		p1.add(cmb1);
		p1.add(label_2);
		
		this.getContentPane().add(p1);		
	}
	
	public void initEvent()
	{
			cmb1.addItemListener(new ItemListener()
			{
					public void itemStateChanged(ItemEvent ie)
					{
						if(cmb1.getSelectedIndex()==0)
									label_2.setText("");
							else
								if(cmb1.getSelectedItem().equals(ie.getItem()))
								{
									label_2.setText(cmb1.getSelectedItem()	+"Selcted!");
										
								}
					}
			}
				);
	}
	public Windows1()
	{
		this.initComponents();
		this.initEvent();
		this.setTitle("Combo Demo");
		this.setLocation(300,200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	public static void main (String[] args) {
		
		Windows1 obj=new Windows1();
	}
}