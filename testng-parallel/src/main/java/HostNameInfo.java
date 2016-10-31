import java.net.UnknownHostException;

/**
 * @author zoomout
 */
public class HostNameInfo {
    public String getHostName() throws UnknownHostException {
            return java.net.InetAddress.getLocalHost().getHostName();
    }
}
