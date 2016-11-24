package generics;

/**
 * Created by zoomout on 11/23/16.
 */
public class MyGenericCreator {
    public static void main(String[] args) {
        MyGeneric<MyGeneric, String, Boolean, Long> myGeneric1 = new MyGeneric<>();

        myGeneric1.setA(new MyGeneric());
        myGeneric1.setB("Hi");
        myGeneric1.setC(false);
        myGeneric1.setD(10L);

        myGeneric1.print();

        System.out.println("______");
        System.out.println("");

        MyGeneric<MyGeneric, Thread, Exception, Character> myGeneric2 = new MyGeneric<>();

        myGeneric2.setA(new MyGeneric());
        myGeneric2.setB(new Thread());
        myGeneric2.setC(new Exception());
        myGeneric2.setD('@');

        myGeneric2.print();

    }
}