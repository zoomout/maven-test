package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjC {
    private Integer c1;

    private String c2;

    @SetDefault("c2")
    public void c2() {
        c2 = "default_c2";
    }

    public Integer getC1() {
        return c1;
    }

    public ObjC setC1(int c1) {
        this.c1 = c1;
        return this;
    }

    public String getC2() {
        return c2;
    }

    public ObjC setC2(String c2) {
        this.c2 = c2;
        return this;
    }

    @Override
    public String toString() {
        return "ObjC{" + "c1=" + c1 + ", c2=" + c2 + '}';
    }

}
