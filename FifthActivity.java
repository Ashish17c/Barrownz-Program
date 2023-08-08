class Room{
    int length;
    int breadth;
    Room(){
        this(10,20);
    }
    Room(int l, int b)
    {
        length=1;
        breadth=b;    
    }
    int calculateArea(){
        return length*breadth;
    }
}

public class FifthActivity{
    public static void main(String args[]){
        Room obj =new Room ();
        System.out.println("Area="+obj.calculateArea());
    }
}
