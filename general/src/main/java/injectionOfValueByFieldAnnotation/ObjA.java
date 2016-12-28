package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjA {

    private String a1;
    private Integer a2;
    private ObjB objB;

    @SetDefault("a1")
    public void a1(){
        a1 = "default_a1";
    }

    @SetDefault("a2")
    public void a2(){
        a2 = 2;
    }

    @SetDefault("objB")
    public void objB(){
        objB = new ObjB();
        Injector.setDefaults(objB);
    }

    public String getA1() {
        return a1;
    }

    public ObjA setA1(String  a1) {
        this.a1 = a1;
        return this;
    }

    public Integer getA2() {
        return a2;
    }

    public ObjA setA2(Integer a2) {
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
