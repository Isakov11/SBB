package org.hino.sbb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;

@Component
public class ArtemisProducer {

    @Autowired
    private JMSContext jMScontext;

    @Autowired
    private Destination destination;

    private JMSProducer jMSProducer;

    @PostConstruct
    private void init(){
        this.jMSProducer = jMScontext.createProducer();
    }

    public void send(String msg){
        jMSProducer.send(destination, msg);
    }
}
