package pkg;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import pkg.app.AppConfig;
import pkg.web.WebConfig;

public class WebServer {
    public static void main(String[] args) throws InterruptedException {
        ServletContextHandler servletContextHandler = new ServletContextHandler(null, "/");

        //old school servlet
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();
        annotationConfigWebApplicationContext.register(WebConfig.class);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(annotationConfigWebApplicationContext);
        servletContextHandler.addServlet(new ServletHolder(dispatcherServlet), "/");

        //app contextloaderlistener
        servletContextHandler.addEventListener(new ContextLoaderListener());
        //if you wanna java configurations, add this in
        servletContextHandler.setInitParameter("contextClass", org.springframework.web.context.support.AnnotationConfigWebApplicationContext.class.getName());
        //separate names with blanks if you have multiple config files
        servletContextHandler.setInitParameter("contextConfigLocation", AppConfig.class.getName());

        Server server = new Server(60000);
        server.setHandler(servletContextHandler);
        server.setStopAtShutdown(true);

        try {
            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

        server.join();
    }
}
