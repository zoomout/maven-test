import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by zoomout on 5/24/16.
 */
public class MyTestClass1 extends AbstractTest {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(AbstractTest.class.getSimpleName());

    @Test
    public void myTestMethod1_1() {
        LOG.info("myTestMethod1_1");
        Sleep.sleep(500);
    }

    @Test
    public void myTestMethod1_2() {
        LOG.info("myTestMethod1_2");
        Sleep.sleep(500);
    }
}
