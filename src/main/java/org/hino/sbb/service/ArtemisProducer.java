package org.hino.sbb.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;

@Component
@Scope("singleton")
public class ArtemisProducer {
    private static final Logger logger = Logger.getLogger(ArtemisProducer.class);

    @Autowired
    private JMSContext jMScontext;

    @Autowired
    private Destination destination;

    private JMSProducer jMSProducer;

    @PostConstruct
    private void init() {
        this.jMSProducer = jMScontext.createProducer();
        logger.info("jMSProducer created ");
    }

    public void send(String msg){
        jMSProducer.send(destination, msg);
        logger.info("message \"" + msg + "\" was sent to " + destination.toString());
    }
}
