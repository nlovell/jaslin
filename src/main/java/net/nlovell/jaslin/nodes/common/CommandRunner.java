package net.nlovell.jaslin.nodes.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CommandRunner extends Thread {

    InputStream is = null;
    String type = null;
    String message = null;

    public String getMessage() {
        return message;
    }

    CommandRunner(InputStream is, String type) {
        this.is = is;
        this.type = type;
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            StringBuffer buffer = new StringBuffer();
            String line = null;
            while ((line = br.readLine()) != null) {
                buffer.append(line);//.append("\n");
            }
            message = buffer.toString();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
