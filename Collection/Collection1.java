package com.app;

import java.util.*;

public class Collection1{
	
	public static void main (String[] args) {
		
		List<Integer> c=new ArrayList<Integer>();
		
		c.add(1);
		c.add(2);
		c.add(3);
		
		System.out.println ("Data in Callection c::"+c);
		
		int i = c.get(0);
		
		System.out.println ("First Integer::"+i);
	}
}