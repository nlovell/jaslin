package net.nlovell.jaslin.nodes.server.web;

import net.nlovell.jaslin.nodes.server.mediaplayer.Jplayer;
import net.nlovell.jaslin.tools.ConfigReader;
import org.eclipse.jetty.server.Server;

/**
 * For serving web-pages upon request
 */
public class WebServer {

    private Server server;

    public WebServer() {
        try {
            getServer().start();
            getServer().join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Server getServer(){
        if(server==null){
            server = new Server(Integer.parseInt(ConfigReader.getConfigReader().getConfigOrDefault("PORT")));
        }
        return this.server;
    }

}
