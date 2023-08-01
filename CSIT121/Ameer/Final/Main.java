class A {
    void m1(String xyz){
        System.out.println("One");
    }
}

class B extends A{

}

public class Main {
    public static void main(String[] args){
        A a = new B();
        a.m1(new A());
    }
}