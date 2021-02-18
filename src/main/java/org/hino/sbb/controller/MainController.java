package org.hino.sbb.controller;

//import org.hino.sbb.service.SimpleMessageSender;
import org.hino.sbb.service.ArtemisProducer;
import org.hino.sbb.service.JMSSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MainController {

    /*@Autowired
    SimpleMessageSender simpleMessageSender;*/
    @Autowired
    ArtemisProducer artemisProducer;

    @GetMapping(value = "/login")
    public ModelAndView loginPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/login");
        return modelAndView;
    }

    @GetMapping(value = {"/index","/"})
    public ModelAndView indexPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/index");
        return modelAndView;
    }
    @PostMapping(value = {"/send"})
    public void sendJMS() {
        artemisProducer.send("sdfsad");
    }
}