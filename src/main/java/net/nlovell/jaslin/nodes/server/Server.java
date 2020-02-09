package net.nlovell.jaslin.nodes.server;

import net.nlovell.jaslin.nodes.common.FFMPEG;
import net.nlovell.jaslin.nodes.server.mediaplayer.Jplayer;
import net.nlovell.jaslin.nodes.server.web.WebServer;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class Server {

    public Server() {
        Jplayer jp = new Jplayer();
        WebServer ws = new WebServer(jp);

        Logger logger = Logger.getLogger(Server.class);

        logger.debug("Server attempted construction");
        FFMPEG ffmpeg = new FFMPEG();

        if (!ffmpeg.isFFMPEGAvailable()) ffmpeg.downloadFFMPEG();
    }
}
