import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

/**
 * Created by zoomout on 5/24/16.
 */
public class MyTestClass2 extends AbstractTest {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractTest.class.getSimpleName());

    private Map<String, Integer> map = new HashMap<>();

    @BeforeMethod
    public void beforeMethod(Method m) {
        Random random = new Random();
        map.put(m.getName(), random.nextInt(1000));
    }

    @Test
    public void myTestMethod2_1(Method m) {
        LOG.info("myTestMethod2_1; random_num=" + map.get(m.getName()));
        Sleep.sleep(500);
    }

    @Test
    public void myTestMethod2_2(Method m) {
        LOG.info("myTestMethod2_2; random_num=" + map.get(m.getName()));
        Sleep.sleep(500);
    }
}
