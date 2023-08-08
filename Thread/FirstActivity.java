package com.app;

class MyTask implements Runnable
				{
					public void run()
					{
						for(int i=1;i<=10; i++)
						{
							System.out.println("i="+i+"current Thread::"+Thread.currentThread().getName());
						}
						
					}
					
				}
				
public class FirstActivity
				{
					public static void main(String[]args)
					{
						MyTask task=new MyTask();
						Thread t=new Thread(task);
						t.setName("India");
						
						t.start();
					}
				}
				