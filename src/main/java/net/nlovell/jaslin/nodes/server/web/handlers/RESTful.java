package net.nlovell.jaslin.nodes.server.web.handlers;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/web")
public class RESTful {

    @POST
    @Path("/playpause")
    @Produces(MediaType.TEXT_HTML)
    public String playing() {
        return "Is playing? ";// + UDPBroadcaster.toggleState();
    }
}
