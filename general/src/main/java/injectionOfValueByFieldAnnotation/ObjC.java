package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjC {
    public int getIntV1() {
        return intIntV1;
    }

    public ObjC setIntIntV1(int intIntV1) {
        this.intIntV1 = intIntV1;
        return this;
    }

    public int getIntIntV2() {
        return intIntV2;
    }

    public ObjC setIntIntV2(int intIntV2) {
        this.intIntV2 = intIntV2;
        return this;
    }

    private int intIntV1;

    private int intIntV2;

    @SetDefault("intIntV2")
    public void setIntIntV2(){
        intIntV2 = 7;
    }


    @Override
    public String toString() {
        return "ObjC{" + "intIntV1=" + intIntV1 + ", intIntV2=" + intIntV2 + '}';
    }

}
