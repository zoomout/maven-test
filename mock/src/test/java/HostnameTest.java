import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

/**
 * Test for {@link HostNameInfo}.
 *
 * @author zoomout
 */
public class HostnameTest {

    private HostNameInfo mockHostNameInfo;

    @BeforeMethod
    public void setUp() {
        mockHostNameInfo = Mockito.mock(HostNameInfo.class);
    }

    @Test
    public void getHostNameMock() throws UnknownHostException {
        Mockito.when(mockHostNameInfo.getHostName()).thenReturn("123");
        Assert.assertEquals(mockHostNameInfo.getHostName(), "123");
    }

    @Test
    public void getHostNameReal() throws UnknownHostException {
        HostNameInfo hostNameInfo = new HostNameInfo();
        Assert.assertEquals(hostNameInfo.getHostName(), "MD760.local");
    }
}
