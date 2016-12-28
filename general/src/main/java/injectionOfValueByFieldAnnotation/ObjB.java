package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjB {
    private int b1;
    private int b2;
    private ObjC objC;

    @SetDefault("b1")
    public void setDefaultB1() {b1 = 6;}

    @SetDefault("objC")
    public void setDefaultObjC() {
        objC = new ObjC();
        Injector.setDefaults(objC);
    }

    public int getB1() {
        return b1;
    }

    public ObjB setB1(int b1) {
        this.b1 = b1;
        return this;
    }

    public int getB2() {
        return b2;
    }

    public ObjB setB2(int b2) {
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
