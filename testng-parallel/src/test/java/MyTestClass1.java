import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

/**
 * Created by zoomout on 5/24/16.
 */
@Test
public class MyTestClass1 extends SeleniumAbstractTest {
    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(SeleniumAbstractTest.class.getSimpleName());


    public void myTestMethod1_1() {
        LOG.info("myTestMethod1_1");
        Sleep.sleep(500);
    }

    public void myTestMethod1_2() {
        LOG.info("myTestMethod1_2");
        Sleep.sleep(500);
    }
}
