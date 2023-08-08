package com.app;


class MyThread extends Thread
		{
				public void run()
				{
					for(int i=1; i<=10; i++)
					{
						System.out.println("i="+i+" Current Thread Name::"+Thread.currentThread().getName());
					}
				}
		}
		
public class SecondActivity
			{
				public static void main (String[] args)
				{
					System.out.println("In Main method ::........."+Thread.currentThread().getName());
					MyThread obj=new MyThread();
					obj.start();
				}
			}