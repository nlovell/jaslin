package net.nlovell.jaslin.nodes.common;

import net.nlovell.jaslin.tools.OSUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public class CLI {
    private static Logger log = Logger.getLogger(CLI.class);

    public static String execCmd(String cmd) throws java.io.IOException {
        java.util.Scanner s = new java.util.Scanner(Runtime.getRuntime().exec(cmd).getInputStream()).useDelimiter("\\A");
        return s.hasNext() ? s.next() : "";
    }

    public static String getDevices() {
        String getDevices = null;
        if (OSUtils.isWindows()) {
            getDevices = "ffmpeg -list_devices true -f dshow -i dummy";
            Runtime rt = Runtime.getRuntime();
            try {
                Process proc = rt.exec(getDevices);
                CommandRunner error = new CommandRunner(proc.getErrorStream(), "ERROR");
                CommandRunner output = new CommandRunner(proc.getInputStream(), "OUTPUT");
                int exitVal = 0;

                error.start();
                output.start();
                error.join(3000);
                output.join(3000);
                exitVal = proc.waitFor();
                return "[::Output::] " + output.message + "[::Error::] " + error.message;
            } catch (IOException | InterruptedException e) {
                log.error("Error encountered while trying to fetch device list: " + e);
            }
        }


        return null;
    }


}
