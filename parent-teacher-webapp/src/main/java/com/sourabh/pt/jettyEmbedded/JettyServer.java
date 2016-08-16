package com.sourabh.pt.jettyEmbedded;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;

/**
 * Created by Sourabh on 7/23/2016.
 */
public class JettyServer {

    public static void main(String[] args) {
        try {
            run();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static void run() throws Exception{
        Configuration configuration = new Configuration();
        Server server = new Server() {
            {
                setHandler(configuration.getWebApplicationContext());
            }
        };

        try(ServerConnector connector = configuration.getServerConnector(server)) {
           server.start();
            server.join();
        }
    }


}
