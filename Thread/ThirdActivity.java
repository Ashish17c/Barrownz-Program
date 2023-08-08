package com.app;

class test implements  Runnable
					{
						
						public void run()
						{
							
							for(int i=1; i<=5; i++)
							{
								if(i==4)
								{
									System.out.println(Thread.currentThread().getName()+"yielding.......");
									Thread.yield();
								}
								
								System.out.println("i="+i+" Current Thread::"+Thread.currentThread().getName());
							}
							
						}

					}
public class ThirdActivity
					{
						public static void main(String[] args)
						{
							test task=new test();
							
							Thread t1=new Thread(task);
							t1.setName("India");
							Thread t2=new Thread(task);
							t2.setName("America");
							t1.start();
							t2.start();
						}
						
					}