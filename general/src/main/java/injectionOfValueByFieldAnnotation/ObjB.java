package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjB {
    private String b1;
    private String b2;
    private ObjC objC;

    @SetDefault("b1")
    public void b1() {b1 = "default_b1";}

    @SetDefault("objC")
    public void objC() {
        objC = new ObjC();
        Injector.setDefaults(objC);
    }

    public String getB1() {
        return b1;
    }

    public ObjB setB1(String b1) {
        this.b1 = b1;
        return this;
    }

    public String getB2() {
        return b2;
    }

    public ObjB setB2(String b2) {
        this.b2 = b2;
        return this;
    }

    public ObjC getObjC() {
        return objC;
    }

    public ObjB setObjC(ObjC objC) {
        this.objC = objC;
        return this;
    }

    @Override
    public String toString() {
        return "ObjB{" + "b1=" + b1 + ", b2=" + b2 + ", objC=" + objC + '}';
    }
}
