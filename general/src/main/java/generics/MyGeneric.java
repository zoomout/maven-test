package generics;

/**
 * Created by zoomout on 11/23/16.
 */
class MyGeneric<A extends MyGeneric, B, C, D> {

    void setA(A a) {
        this.a = a;
    }

    void setB(B b) {
        this.b = b;
    }

    void setC(C c) {
        this.c = c;
    }

    void setD(D d) {
        this.d = d;
    }

    private A a;
    private B b;
    private C c;
    private D d;

    void print() {
        System.out.println("A: " + a);
        System.out.println("B: " + b);
        System.out.println("C: " + c);
        System.out.println("D: " + d);
    }

}