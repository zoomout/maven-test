package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjA {

    private int a1;
    private int a2;
    private ObjB objB;

    @SetDefault("a1")
    public void setDefaultA1(){
        a1 = 5;
    }

    @SetDefault("a2")
    public void setDefaultA2(){
        a2 = 5;
    }

    @SetDefault("objB")
    public void setDefaultObjB(){
        objB = new ObjB();
        Injector.setDefaults(objB);
    }

    public int getA1() {
        return a1;
    }

    public ObjA setA1(int a1) {
        this.a1 = a1;
        return this;
    }

    public int getA2() {
        return a2;
    }

    public ObjA setA2(int a2) {
        this.a2 = a2;
        return this;
    }

    public ObjB getObjB() {
        return objB;
    }

    public ObjA setObjB(ObjB objB) {
        this.objB = objB;
        return this;
    }

    @Override
    public String toString() {
        return "ObjA{" + "a1=" + a1 + ", a2=" + a2 + ", objB=" + objB + '}';
    }
}
