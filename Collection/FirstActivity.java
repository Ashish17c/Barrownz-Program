package com.app;

import java.util.*;

public class FirstActivity
			{
				public static void main(String[] args){
					List list = new ArrayList();
					list.add("First");
					list.add("Second");
					list.add("Third");
					list.add("Fourth");
					
					System.out.println ("Elements in collection::"+c);
					System.out.println ("Is first exist in collection::"+c.contains("Seventh"));
					
					System.out.println ("Is current Collection empty::"+c.isEmpty());
				
					Iterator itr = c.iterator();
					
					while(itr.hasNext())
					{
						System.out.println (its.next());
					}
					c.remove("Second");
					
					System.out.println ("The Collection c::"+c);
					System.out.println ("No of Elements:: "+c.size());
					
				}
			}
