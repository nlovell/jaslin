package net.nlovell.jaslin.nodes.server.web;

import net.nlovell.jaslin.nodes.server.mediaplayer.Jplayer;
import org.eclipse.jetty.server.Server;

/**
 * For serving web-pages upon request
 */
public class WebServer {

    Server server;

    public WebServer() {

    }

    Server getServer(){
        if(server==null){
            server = new Server();
        }
        return this.server;
    }

}
