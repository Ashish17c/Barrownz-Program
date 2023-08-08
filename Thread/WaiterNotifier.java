package com.app;

public class WaiterNotifier
			{
				public static void main (String[] args) {
					Message resource = new Message ();
					
					Waiter wtask = new Waiter(resource);
					Notifier ntask = new Notifier(resource);
					
					 Thread tw = new Thread(wtask);
					 Thread tn = new Thread(wtask);
					 
					 tw.start();
					 tn.start();
					 	
		}
		
	}