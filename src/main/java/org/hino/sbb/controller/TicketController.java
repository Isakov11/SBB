package org.hino.sbb.controller;

import org.hino.sbb.dto.*;
import org.hino.sbb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TicketController {
    private final String viewName = "/admin/tickets";
    private final String adminPage = "/index";

    //@Autowired
    private TicketService service;


    private TrainService trainService;

    public TicketController(){}

    @Autowired
    public TicketController(TicketService service, TrainService trainService) {
        this.service = service;
        this.trainService = trainService;
    }

    @GetMapping(value = viewName)
    public ModelAndView allTickets() {
        ModelAndView modelAndView = new ModelAndView();
        List<TrainDTO> trainList = trainService.findAllDTO();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("trainList", trainList);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(value = viewName + "/getlist")
    public ModelAndView ticketsByTrain(@RequestParam("trainId") long trainId) {
        List<TicketDTO> dtoList = service.findDTOByTrain(trainId);
        List<TrainDTO> trainList = trainService.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("trainList", trainList);
        modelAndView.addObject("trainSelect", trainId);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @RequestMapping (value = viewName + "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteTicketById(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().body("ok");
    }
}