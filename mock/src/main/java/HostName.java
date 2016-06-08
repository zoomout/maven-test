import java.net.UnknownHostException;

/**
 * Created by zoomout on 6/8/16.
 */
public class HostName {
    public String getHostName() throws UnknownHostException {
            return java.net.InetAddress.getLocalHost().getHostName();
    }
}
