package com.app;

import java.util.*;

public class Maping
			{
				public static void main (String[] args) {
					
					Map<String, String> map= new HashMap<String, String>();
					
					map.put("Name", "Ashish");
					map.put("Address", "Chinhat Lucknow");
					map.put("Pin", "226028");
					
					System.out.println (map);
					
					map.remove("Name");
				
			 System.out.println (map);
}
			}