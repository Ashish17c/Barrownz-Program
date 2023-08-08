package com.app;

import java.util.*;

class Room implements Comparable<Room>
				{
					int length;
					int breadth;
					public Room(int l, int b)
					{
						length=1;
						breadth=b;
					}
					public String toString()
					{
						return "(Object of length="+length+"Breadth="+breadth+")";
					}
					public int compareTo(Room nextObject)
					{
						int value = this.length-nextObject.length;
						if(value<0)
						{
							return -1;
						} 
						else if (value>0)
								{
									return 1;
								}
							else
								return 0;
						}    
				}
				
public class FourthActivity
{
					public static void main (String[] args) {
						
							Room obj=new Room(10,20);
							Room obj1=new Room(5,15);
							Room obj2=new Room(15,5);
														
							SortedSet <Room>set = new TreeSet<Room>();
														
							set .add(obj);
							set .add(obj1);
							set .add(obj2);
														
							Iterator itr=set.iterator();
							while(itr.hasNext())
								System.out.println (itr.next());
		}
}