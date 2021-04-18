package project1;

import java.io.File;
import java.io.IOException;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Library {
    public static void main(String[] args) throws LifecycleException {
        
        // Tomcat server = new Tomcat();

        // server.getConnector();
        // server.setPort(8080);

        // Context context = server.addWebapp("/api", new File("lib/src/main/webapp").getAbsolutePath());
        // WebResourceRoot resources = new StandardRoot(context);
        // resources.addPreResources(new DirResourceSet(
        //     resources,
        //     "/WEB-INF/classes",
        //     new File("lib/build/classes/java").getAbsolutePath(),
        //     "/"
        // ));
        // server.addServlet("/api", "peopleServlet", new HttpServlet(){
        //    @Override
        //    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        //            throws ServletException, IOException {
        //        resp.getWriter().println("hello from peopleServlet!");
        //    } 
        // });
        // context.addServletMappingDecoded("/people", "peopleServlet");
        // server.start();
        // server.getServer().await();

    }
}
