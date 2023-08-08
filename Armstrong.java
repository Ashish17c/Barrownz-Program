package com.app;

class Assigment
			{
				 
				 boolean isArmstrong(int num)
				 {
				 	int temp=num;
				 	
				 	int result=0;
				 	
				 	while(temp>0)
				 	{
				 		int rem =temp%10;
				 		result=result+rem*rem*rem;
				 		
				 		temp=(int)(temp/10);
				 	}
				 	
				 	if(result==num)
				 	{
				 		return true;
				 	}
				 	else
				 	{
				 		return false;
				 	}
				 }
			}
			
public class Armstrong
				{
						public static void main(String[] args){
								Assigment obj=new Assigment();
								
								for(int i=100; i<1000; i++)
								{
									
									if(obj.isArmstrong(i))
									{
										System.out.println(i);
										
									}
								}
						}
				}