class A{
    void move() {
        System.out.println("The animal moves");
    }
   }
   class Cheetah extends A {
    void move() {
        System.out.println("The cheetah runs swiftly");
    }
   }
   public class Main5 {
    public static void main(String[] args) {
        A a = new A();
         a.move();  
   
        Cheetah speedy = new Cheetah();
        speedy.move();         
    }
   }