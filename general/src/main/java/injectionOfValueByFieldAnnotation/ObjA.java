package injectionOfValueByFieldAnnotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zoomout on 12/27/16.
 */
public class ObjA {

    private String a1;
    private Integer a2;
    private List<ObjB> objBList;

    @SetDefault("a1")
    public void a1(){
        a1 = "default_a1";
    }

    @SetDefault("a2")
    public void a2(){
        a2 = 2;
    }

    @SetDefault("objBList")
    public void objBList(){
        objBList = new ArrayList<>();
        ObjB objB = new ObjB();
        Injector.setDefaults(objB);
        objBList.add(objB);
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

    public List<ObjB> getObjBList() {
        return objBList;
    }

    public ObjA setObjBList(List<ObjB> objBList) {
        this.objBList = objBList;
        return this;
    }

    @Override
    public String toString() {
        return "ObjA{" + "a1=" + a1 + ", a2=" + a2 + ", objBList=" + objBList + '}';
    }
}
