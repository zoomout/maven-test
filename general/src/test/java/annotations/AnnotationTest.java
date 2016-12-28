package annotations;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Created by zoomout on 11/3/16.
 */
public class AnnotationTest {

    @Test
    public void annotationsTest() {
        Method[] methods = ClassWithAnnotations.class.getMethods();
        for (int i = 0; i < methods.length; i++) {
            if (methods[i].getName().equals("annotatedPublicMethod")) {
                Assert.assertTrue(methods[i].isAnnotationPresent(MyAnnotation.class));
                Assert.assertEquals(21, methods[i].getAnnotation(MyAnnotation.class).id());
            }
        }
    }
}
