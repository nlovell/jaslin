package net.nlovell.jaslin.tools;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class OSUtils {

    public static String getOS() {
        return "windows";
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

    public static boolean supportedOSContains(String compare){
        for(SupportedOS enom : SupportedOS.values()){
            if(String.valueOf(enom).equals(compare))
                return true;
        }
        return false;
    }
}
