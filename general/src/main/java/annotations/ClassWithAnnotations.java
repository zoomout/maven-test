package annotations;

/**
 * Created by zoomout on 11/3/16.
 */
public class ClassWithAnnotations {

    @MyAnnotation
    Integer myInt;

    @MyAnnotation(id = 21)
    public void annotatedPublicMethod() {

    }

    @MyAnnotation
    private void annotatedPrivateMethod() {

    }
}
