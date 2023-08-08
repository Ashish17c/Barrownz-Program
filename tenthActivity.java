public class Room{
	int length;
	int breadth;
	
	Room(){
		this(10,20); // Room(10,20)
	}
	Room(int l, int b){
		length = 1;
		breadth = b;
		{
			return length*breadth;
		}
	}
	public class tenthActivity{
		public static void main(String args[]){
			Room obj = new Room(11,12);
			System.out.println("Area="+obj.calculateArea());
		}
	}
}