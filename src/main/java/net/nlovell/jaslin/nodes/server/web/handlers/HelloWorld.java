package net.nlovell.jaslin.nodes.server.web.handlers;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorld extends AbstractHandler {

    String body;
    @Override
    public void handle(String target,
                       Request baseRequest,
                       HttpServletRequest request,
                       HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text.html; charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);

        PrintWriter out = response.getWriter();
        out.println("<h1> test </h1>");
        if(body!=null){
            out.println(body);
        }
        baseRequest.setHandled(true);
    }
}
