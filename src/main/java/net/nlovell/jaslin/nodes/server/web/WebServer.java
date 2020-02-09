package net.nlovell.jaslin.nodes.server.web;

import net.nlovell.jaslin.nodes.server.mediaplayer.Jplayer;

/**
 * For serving web-pages upon request
 */
public class WebServer {
    private final Jplayer player;

    public WebServer(Jplayer jplayer) {
        this.player = jplayer;
    }

}
