package com.app;

import java.util.*;

public class Notifier implements Runnable
			{
				Message message;
				
				public  Notifier(Message _message)
				{
					message = _message;
				}
				
				public void run()
				{
					synchronized (message)
					{
						try
						{
							
						 System.out.println ("Notifier Thread entry time.........."+new Date());
						 System.out.println ("I will notify after 5 Seconds....."+new Date());
						 Thread.sleep(5000);
						 
						 System.out.println ("Notification fired......"+new Date());
						 message.notify();
						 	
						}
						catch(Exception e)
						{
						}
					}
				}
			}