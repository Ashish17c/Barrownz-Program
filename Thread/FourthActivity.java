package com.app;


// Default priority of any Thread is 5(NORM_PRIORITY)
// Priority of Any thread exists between 1(MIN_PRIORITY) to 10(MAX_PRIORITY)

class Test implements Runnable
					{
						
						public void run()
						{
							
							for(int i=1; i<=100; i++)
							{
								System.out.println("i="+i+" Current Thread::"+Thread.currentThread());
							}
						}
					}
					
public class FourthActivity
				{
					public static void main (String[] args){
						Test task = new Test();
						
						Thread t1= new Thread(task);  
						t1.setName("India");
						t1.setPriority(1);
						
					Thread t2= new Thread(task);  
						t2.setName("Japan");
						t2.setPriority(10);
						
						t1.start();
						t2.start();
						
					}
				}