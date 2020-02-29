package net.nlovell.jaslin.nodes.server.web;

import net.nlovell.jaslin.nodes.server.web.handlers.HelloWorld;
import net.nlovell.jaslin.nodes.server.web.handlers.playpause;
import net.nlovell.jaslin.tools.ConfigReader;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;

/**
 * For serving web-pages upon request
 */
public class WebServer {

    private Server server;
    Logger log;


    public WebServer() {
        try {
            getServer().start();
            getServer().join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        log = Logger.getLogger(WebServer.class);
    }

    private Server getServer(){
        if(server==null){
            server = new Server(Integer.parseInt(ConfigReader.getConfigReader().getConfigOrDefault("PORT")));
            server.setHandler(new HelloWorld());
            server.setHandler(new playpause());

        }
        return this.server;
    }

    private void endpoint_log(String ep){
        log.info("Endpoint accessed: " + ep);
    }

}
