// Checkbox 

package com.app;

//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;

public class Checkbox2 extends JFrame
{
	JCheckBox rdb1, rdb2;
	JLabel label_1,label_2,label_3,label_4;
	
	public void initComponents()
	{
		label_1 = new JLabel("Select Your Laguage");
		label_2 = new JLabel("");
		label_3 = new JLabel("");
		label_4 = new JLabel("");
		rdb1=new JCheckBox("JAVA");
		rdb2=new JCheckBox("HTML");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdb1);
		bg.add(rdb2);
		bg.add(rdb1);
		bg.add(rdb2);
		
		JPanel p1=new JPanel(new GridLayout(1,4,5,5));
		
		p1.setBorder(BorderFactory.createTitledBorder("Selection Your Answers"));
		
		p1.add(label_1);
		p1.add(rdb1);
		p1.add(rdb2);
		p1.add(label_2);
		
		this.getContentPane().add(p1);
	}
	public void initEvent()
	{
		rdb1.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
			if(rdb1.isSelected())
					label_2.setText("Girl Selected");
			}
				
		}
		);
	rdb2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				if(rdb2.isSelected())
					label_2.setText("Boy_Selected");
			}
		}
		);
	}
	public Checkbox2()
	{
		this.initComponents();
		this.initEvent();
		this.setTitle("Radio Demo");
		this.setLocation(200, 200);
		this.setVisible(true);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	public static void main(String[]args){
		Checkbox1 obj=new Checkbox1();
	}
}