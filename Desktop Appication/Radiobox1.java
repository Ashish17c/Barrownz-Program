//  Radio box  program

package com.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Radiobox1 extends JFrame
{
	JRadioButton rdb1, rdb2;
	JLabel label_1,label_2;
	
	public void initComponents()
	{
		label_1 = new JLabel("Select your gender");
		label_2 = new JLabel("");
		rdb1=new JRadioButton("Male");
		rdb2=new JRadioButton("Female");
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdb1);
		bg.add(rdb2);
		
		JPanel p1=new JPanel(new GridLayout(1,4,5,5));
		
		p1.setBorder(BorderFactory.createTitledBorder("Gender Selection"));
		
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
					label_2.setText("male_Selected");
			}
				
		}
		);
		rdb2.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent ie)
			{
				if(rdb2.isSelected())
					label_2.setText("Female_Selected");
			}
		}
		);
	}
	public Radiobox1()
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
		Radiobox1 obj=new Radiobox1();
	}
}