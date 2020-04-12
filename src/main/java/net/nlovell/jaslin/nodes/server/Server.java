package net.nlovell.jaslin.nodes.server;

import net.nlovell.jaslin.nodes.common.CLI;
import net.nlovell.jaslin.nodes.common.FFMPEG;
import net.nlovell.jaslin.nodes.server.mediaplayer.UDPBroadcaster;
import net.nlovell.jaslin.nodes.server.web.WebServer;
import org.apache.log4j.Logger;

public class Server {

    private UDPBroadcaster player;

    public Server() {
        player = new UDPBroadcaster();
        WebServer ws = new WebServer();

        Logger logger = Logger.getLogger(Server.class);

        logger.debug("Server attempted construction");

        if (!FFMPEG.isFFMPEGAvailable()) FFMPEG.downloadFFMPEG();
        logger.debug(CLI.getDevices());
    }


    public UDPBroadcaster getJplayer(){
        return this.player;
    }

}
