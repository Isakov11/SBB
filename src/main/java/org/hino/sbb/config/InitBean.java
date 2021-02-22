package org.hino.sbb.config;

import org.apache.log4j.Logger;
import org.hino.sbb.service.ArtemisProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class InitBean implements
        ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = Logger.getLogger(InitBean.class);

    private static boolean startUpFlag = false;

    @Autowired
    ArtemisProducer artemisProducer;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        if (startUpFlag == false ){
            logger.info(" onApplicationEvent running");
            artemisProducer.send("init update");
        }
        startUpFlag = true;
    }
}
