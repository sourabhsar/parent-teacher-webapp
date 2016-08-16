package com.sourabh.pt.jettyEmbedded;

import com.sourabh.pt.configuration.PTInitializer;
import org.eclipse.jetty.annotations.AnnotationConfiguration;
import org.eclipse.jetty.server.*;
import org.eclipse.jetty.webapp.WebAppContext;

import static java.lang.Integer.parseInt;

/**
 * Created by Sourabh on 7/23/2016.
 */
public final class Configuration {

    private final String CONNECTOR_HOST = "0.0.0.0";
    private final String SYSTEM_PROPERTY_SERVER_PORT = "8080";

    public Handler getWebApplicationContext() {
        return new WebAppContext() {
            {
                setContextPath("/smartcar/");
                setConfigurations(new org.eclipse.jetty.webapp.Configuration[] {
                        new AnnotationConfiguration() {
                            @Override
                            public void configure(WebAppContext context) throws Exception {
                                super.configure(context);
                                new PTInitializer().onStartup(context.getServletContext());
                            }
                        }
                });
            }
        };
    }

    /**
     * Configure a server connector
     *
     * @param server the jetty server object
     * @return ServerConnector the server connector
     */
    public ServerConnector getServerConnector(Server server) {
        return new ServerConnector(
                server, new HttpConnectionFactory(
                new HttpConfiguration() {{
                    setSendServerVersion(false);
                }}
        )
        ) {{
            setHost(CONNECTOR_HOST);
            setPort(parseInt(SYSTEM_PROPERTY_SERVER_PORT));
            server.setConnectors(new Connector[] { this });
        }};
    }
}
