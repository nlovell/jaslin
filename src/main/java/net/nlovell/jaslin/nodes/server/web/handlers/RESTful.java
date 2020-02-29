package net.nlovell.jaslin.nodes.server.web.handlers;

import net.nlovell.jaslin.nodes.server.mediaplayer.Jplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/web")
public class RESTful {

    @GET
    @Path("/playpause")
    @Produces(MediaType.TEXT_HTML)
    public String getHTMLData() {
        return "Is playing? " + Jplayer.toggleState();
    }
}
