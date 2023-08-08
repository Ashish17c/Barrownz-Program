class A{
    int lentgth=10;
    void sayHello()
    {
        System.out.println("Hello...A");
    }

}

class B extends A {
}
    public class ThirdActivity{
        public static void main(String[] args) {
            B obj = new B();
            System.out.println("Length="+obj.lentgth);
            obj.sayHello();
        }

    }
