package net.nlovell.jaslin.nodes.server.web;

import com.sun.jersey.spi.container.servlet.ServletContainer;
import net.nlovell.jaslin.nodes.server.web.handlers.HelloWorld;
import net.nlovell.jaslin.nodes.server.web.handlers.playpause;
import net.nlovell.jaslin.tools.ConfigReader;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * For serving web-pages upon request
 */
public class WebServer extends Server {

    private Server localserver;
    Logger log;

    public WebServer() {
        log = Logger.getLogger(WebServer.class);

        try {
            ServletHolder sh = new ServletHolder(ServletContainer.class);
            sh.setInitParameter("com.sun.jersey.config.property.resourceConfigClass", "com.sun.jersey.api.core.PackagesResourceConfig");
            sh.setInitParameter("com.sun.jersey.config.property.packages", "net.nlovell.jaslin.nodes.server.web.handlers");
            sh.setInitParameter("com.sun.jersey.api.json.POJOMappingFeature", "true");

            Server server = new Server(4571);
            ServletContextHandler context = new ServletContextHandler(server, "/", ServletContextHandler.SESSIONS);
            context.addServlet(sh, "/*");
            server.start();
            server.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void endpoint_log(String ep){
        log.info("Endpoint accessed: " + ep);
    }

}
