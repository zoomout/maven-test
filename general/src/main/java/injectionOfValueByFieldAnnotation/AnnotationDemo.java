package injectionOfValueByFieldAnnotation;

/**
 * Created by zoomout on 12/27/16.
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        ObjA objA = new ObjA().setA1("set_value_a1");

        System.out.println(objA.toString());

        Injector.setDefaults(objA);

        System.out.println(objA.toString());
    }
}
