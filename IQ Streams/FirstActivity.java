package com.app;

import java.io.*;

public class  FirstActivity
			{
				public static void main (String[] args) {
			try{
				InputStream ins=new FileInputStream("source.txt");
				
				int ascii=0;
				
				while((ascii=ins.read())!=-1)
				{
					System.out.print((char)ascii);
				}
				
				ins.close();
				}
				catch(Exception ex){
					System.out.println("Reason of Error::"+ex.getMessage());
				}
			}
		}