package net.nlovell.jaslin.nodes.server;

import net.nlovell.jaslin.nodes.server.mediaplayer.Jplayer;
import net.nlovell.jaslin.nodes.server.web.WebServer;

public class Server {

    public Server() {
        Jplayer jp = new Jplayer();

        WebServer ws = new WebServer(jp);
    }
}
