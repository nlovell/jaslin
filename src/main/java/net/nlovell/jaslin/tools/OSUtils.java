package net.nlovell.jaslin.tools;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class OSUtils {

    private static String osName = null;
    private static String osType = null;

    public static String getOSName() {
        if (osName == null) {
            osName = System.getProperty("os.name").toLowerCase();
        }
        return osName;
    }
    public static String getIP() {
        //Attempt to ping Google, and log the outbound result
        String ip = null;
        try (final DatagramSocket socket = new DatagramSocket()) {
            socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
            ip = socket.getLocalAddress().getHostAddress();
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
        return ip;
    }

    public static boolean supportedOSContains(final String compare) {
        String osString = compare.replaceAll(" ", "_").toUpperCase();
        for (SupportedOS enom : SupportedOS.values()) {
            if (String.valueOf(enom).equals(osString))
                return true;
        }
        return false;
    }

    public static String getOsType() {
        if (osType == null) {
            if (isWindows()) {
                osType = "windows";
            } else if (isUnix()) {
                osType = "unix";
            } else if (isMac()) {
                osType = "mac";
            } else {
                osType = "unknown";
            }

        }
        return osType;
    }

    public static boolean isWindows() {
        return getOSName().startsWith("windows");
    }

    public static boolean isUnix() {
        return getOSName().startsWith("nix") || getOSName().startsWith("nux") || getOSName().startsWith("aix");
    }

    public static boolean isMac() {
        return getOSName().startsWith("mac");
    }
}
