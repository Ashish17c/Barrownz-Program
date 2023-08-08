package com.app;

import java.util.*;


public class Waiter implements Runnable
					{
						Message message;
						
						public Waiter(message _message)
						{
							message= _message;
							
						}
						
						public void run()
						{
							synchronized (message)
							{
								try
								{
									System.out.println("Waiter thread entry time::"+new Date());
									System.out.println ("I will wait after 3 Seconds::"+new Date());
									Thread.sleep(3000);
									
									System.out.println ("Wait......fired::"+new Date());
									message.wait();
									System.out.println ("Wait over at........"+new Date());
									
								}
								catch(Exception e)
								{
									
								}
							}
						}
					}