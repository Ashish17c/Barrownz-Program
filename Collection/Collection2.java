package com.app;

import java.util.*;

class Room 
		{
			int length;
			int breadth;
			
			public  Room(int l, int b)
			{
				length =l;
				breadth = b;
			}
			
			public String toString()
			 {	
				return "(Object of room with length ="+length+"and breadth ="+ breadth+")";
			}
	}
class LengthWiseSorting implements Comparator<Room>
		{
			public int compare(Room o1,Room o2)
			{
				int value = o1.length-o2.length;
				return value; 
			}
		}
		
	public  class Collection2
			{
				public static void main (String[] args) throws Exception
					 {
					 	Room obj =new Room(5,8);
					 	Room obj1=new Room(51,18);
					 	Room obj2=new Room(15,81);
					 	Room obj3=new Room(50,3);
					 	
					 //	LengthWiseSorting levise = new LengthWiseSorting();
					 	
					 	BreadthWiseSorting bwise = new BreadthWiseSorting();
					 	
					 	SortedSet<Room>set= new Treeset<Room>(bwise);
					 	
					 	set.add(obj);
					 	set.add(obj1);
					 	set.add(obj2);
					 	set.add(obj3);
					 	
					 	Iterator itr=set.iterator();
					 	
					 	while(itr.hasNext())
					 	{
					 		System.out.println (itr.next());
					 		
					 		Thread.sleep(1000);
					 			
					 	}			
			}
	}


