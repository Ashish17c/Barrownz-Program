public class FourthActivity {
     class A{
        static void sayHello(){
            System.out.println("Hello..A");
        }

    }
    public class FourthActivity {
        public static void main(String argd[])
        {
            A obj = new A(){
                void sayHello(){
                    System.out.println("Overridng method of Anonymons sub class");
                }
            }


            ;
            obj.sayHello();
        }
        
    }
}



