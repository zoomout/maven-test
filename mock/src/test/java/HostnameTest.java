import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

/**
 * Test for {@link HostName}.
 *
 * @author zoomout
 */
public class HostnameTest {

    private HostName mockHostName;

    @BeforeMethod
    public void setUp() {
        mockHostName = Mockito.mock(HostName.class);
    }

    @Test
    public void getHostNameMock() throws UnknownHostException {
        Mockito.when(mockHostName.getHostName()).thenReturn("123");
        Assert.assertEquals(mockHostName.getHostName(), "123");
    }

    @Test
    public void getHostNameReal() throws UnknownHostException {
        HostName hostName = new HostName();
        Assert.assertEquals(hostName.getHostName(), "MD760.local");
    }
}
