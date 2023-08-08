public class Rooom{
		Rooom(){
			System.out.println("Room...");
		}
		class chamber{
			chamber()
			{
				System.out.println("chamber...");
			}
			void sayHello();{
				System.out.println("Hello..Inner class");
			}
		}
		void sayHi(){
			System.out.println("Hi..Outer class");
		}
}
public class Rooom{
	public static void main(String args[])
	{
		Room chamber obj_inner=new Room().new chamber();
		obj_inner.SayHello();
		obj_inner.SayHi();
		}
}