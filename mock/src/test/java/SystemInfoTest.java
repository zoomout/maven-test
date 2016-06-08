import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.UnknownHostException;


/**
 * Test for {@link SystemInfo}.
 *
 * @author zoomout
 */
public class SystemInfoTest {
    private SystemInfo mockSystemInfo;
    private HostNameInfo mockHostNameInfo;

    @BeforeMethod
    public void setUp() {
        mockSystemInfo = Mockito.mock(SystemInfo.class);
        mockHostNameInfo = Mockito.mock(HostNameInfo.class);
    }

    @Test
    public void allMock() throws UnknownHostException {
        Mockito.when(mockHostNameInfo.getHostName()).thenReturn("123");
        Mockito.when(mockSystemInfo.getHostNameInfo()).thenReturn(mockHostNameInfo);
        Assert.assertEquals(mockSystemInfo.getHostNameInfo().getHostName(), "123");
    }

    @Test
    public void hostNameInfoMock() throws UnknownHostException {
        Mockito.when(mockHostNameInfo.getHostName()).thenReturn("124");
        SystemInfo systemInfo = new SystemInfo(mockHostNameInfo);
        Assert.assertEquals(systemInfo.getHostNameInfo().getHostName(), "124");
    }

    @Test
    public void systemInfoMock() throws UnknownHostException {
        HostNameInfo hostNameInfo = new HostNameInfo();
        Mockito.when(mockSystemInfo.getHostNameInfo()).thenReturn(hostNameInfo);
        Assert.assertEquals(mockSystemInfo.getHostNameInfo().getHostName(), "MD760.local");
    }

    @Test
    public void noMock() throws UnknownHostException {
        HostNameInfo hostNameInfo = new HostNameInfo();
        SystemInfo systemInfo = new SystemInfo(hostNameInfo);
        Assert.assertEquals(systemInfo.getHostNameInfo().getHostName(), "MD760.local");
    }

    @Test(expectedExceptions = UnknownHostException.class)
    public void unknownHostExceptionException() throws UnknownHostException {
        Mockito.when(mockSystemInfo.getHostNameInfo()).thenReturn(mockHostNameInfo);
        Mockito.when(mockHostNameInfo.getHostName()).thenThrow(new UnknownHostException());
        mockSystemInfo.getHostNameInfo().getHostName();
    }
}