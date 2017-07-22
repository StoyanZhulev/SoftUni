package Lab10_AsynchronousProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Pr06_DeadLock {
    public static void main(String[] args) throws InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        MyClass first = new MyClass();
        first.id =  "First";

        MyClass second = new MyClass();
        second.id = "Second";

        Thread t1 = new Thread(() -> first.methodA(second));
        Thread t2 = new Thread(() -> second.methodA(first));

        t1.start();
        t2.start();



        t1.join();
        t2.join();
    }
}

class MyClass {

    String id;

   synchronized void  methodA(MyClass other){
       System.out.printf("%s called methodA on %s%n", this.id, other.id);
       other.methodB(this);
   }

   synchronized void methodB(MyClass other){
       System.out.printf("%s called methodB on %s%n",other.id , this.id);
       other.methodC();
   }

   void methodC(){
       System.out.println("All done");
   }

}

