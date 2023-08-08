package com.app;

import java.util.*;

public class SecondActivity

			{
				public static void main (String[] args) {
					List list = new ArrayList();
					
					list.add("First");
					list.add("Second");
					list.add("Third");
					list.add("Fourth");
					list.add("First");
					
					for(int i=0; i<list.size(); i++)
							{
								System.out.println (i+"----------->"+list.get(i));
							}
						
					{
						System.out.println ("First Occurrance Index::"+list.indexOf("First"));
						System.out.println ("Last occurrance Index::"+list.lastIndexOf("First"));
						System.out.println ("Element inlist::"+list);
						ListIterator liter =list.listIterator();
						System.out.println (".......................... Forword Traversing...............");
						
						while(liter.hasNext())
						{
							System.out.println (liter.next());
						}
						System.out.println ("----------------Backward Traversing----------------");
						
						while(liter.hasPrevious())
						{
							System.out.println (liter.previous());
						}
						list.set(0,"One");
						System.out.println ("Final List::"+list);
					}
		}
		
		}