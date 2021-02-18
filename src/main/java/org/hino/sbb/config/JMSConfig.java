package org.hino.sbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

@Configuration

public class JMSConfig {

    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "jms/queue/SBB";
    private static final String DEFAULT_USERNAME = "root";
    private static final String DEFAULT_PASSWORD = "root";
    private static final String INITIAL_CONTEXT_FACTORY = "org.wildfly.naming.client.WildFlyInitialContextFactory";
    private static final String PROVIDER_URL = "http-remoting://127.0.0.1:8085";

    @Bean
    public Context initialContext() {
        Context initialContext = null;
        try {
            String userName = System.getProperty("username", DEFAULT_USERNAME);
            String password = System.getProperty("password", DEFAULT_PASSWORD);

            // Set up the namingContext for the JNDI lookup
            final Properties env = new Properties();
            env.put(Context.INITIAL_CONTEXT_FACTORY, INITIAL_CONTEXT_FACTORY);
            env.put(Context.PROVIDER_URL, PROVIDER_URL);
            env.put(Context.SECURITY_PRINCIPAL, userName);
            env.put(Context.SECURITY_CREDENTIALS, password);
            initialContext = new InitialContext(env);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return initialContext;
    }

    @Bean
    public ConnectionFactory connectionFactory(Context initialContext) {
        String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
        ConnectionFactory connectionFactory = null;
        try {
            connectionFactory = (ConnectionFactory) initialContext.lookup(connectionFactoryString);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return connectionFactory;
    }

    @Bean
    public Destination destination(Context initialContext) {
        String destinationString = System.getProperty("destination", DEFAULT_DESTINATION);
        Destination destination = null;
        try {
            destination = (Destination) initialContext.lookup(destinationString);
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return destination;
    }

    @Bean
    JMSContext jMScontext(ConnectionFactory connectionFactory) {
        JMSContext context = connectionFactory.createContext(DEFAULT_USERNAME, DEFAULT_PASSWORD);
        return context;
    }
}