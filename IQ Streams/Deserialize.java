package com.app;


//File-------->Object State


import java.io.*;

public class Deserialize
			{
				public static void main (String[] args) throws Exception
					{
						
						FileInputStream fis=new FileInputStream("test.ser");
						
						ObjectInputStream ois=new ObjectInputStream(fis);
						
						Object o=ois.readObject();
						
						Room room=(Room)o;//Downcasting
						
						System.out.println ("Length="+room.length);
						System.out.println ("Breadth="+room.breadth);
						
						
						
						ois.close();
						
						fis.close();
					
			    	}
			}