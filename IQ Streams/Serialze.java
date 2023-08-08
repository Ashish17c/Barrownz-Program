package com.app;
import java.io.*;
public class Serialze
					{
						public static void main (String[] args) throws Exception
							 {
							 	Room obj = new Room(10,20);
							 	FileOutputStream fos= new FileOutputStream("test.ser");
							 	ObjectOutputStream ous = new ObjectOutputStream(fos);
							 	ous.writeObject(obj);
							 	fos.close();
							 	ous.close();
							 	System.out.println("Data Serialized");
							 	
}
					}