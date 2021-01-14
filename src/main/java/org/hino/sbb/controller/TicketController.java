package org.hino.sbb.controller;

import org.hino.sbb.dto.*;
import org.hino.sbb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
public class TicketController {
    private final String viewName = "tickets";

    @Autowired
    private TicketService service;

    @Autowired
    private TrainService trainService;

    @Autowired
    private PassengerService stationService;

    public TicketController(){}

    @GetMapping(value = "/" + viewName)
    public ModelAndView allTickets() {
        //TODO  change to list
        List<TicketDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(path = "/" + viewName + "/{id}")
    public ModelAndView TicketsById(@PathVariable("id") long id) {
        TicketDTO dto = service.findDTObyId(id);
        List<TicketDTO> dtoList = new LinkedList<>();
        dtoList.add(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(value = "/" + viewName + "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);

        List<TrainDTO> trainsList = trainService.findAllDTO();
        List<PassengerDTO> passengerList = stationService.findAllDTO();
        modelAndView.addObject("passengersList", passengerList);
        modelAndView.addObject("trainsList", trainsList);
        return modelAndView;
    }

    @PostMapping(path = "/" + viewName + "/add")
    public ModelAndView CreateTicket(@ModelAttribute("TicketCreateDTO") TicketCreateDTO ticketCreateDTO){

        service.create(ticketCreateDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/edit/{id}")
    public ModelAndView GetEditTicket(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        TicketDTO dto = service.findDTObyId(id);

        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);

        List<TrainDTO> trainsList = trainService.findAllDTO();
        List<PassengerDTO> passengerList = stationService.findAllDTO();

        modelAndView.addObject("passengersList", passengerList);
        modelAndView.addObject("trainsList", trainsList);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = "/" + viewName + "/edit")
    public ModelAndView EditTicket(@ModelAttribute("TicketCreateDTO") TicketCreateDTO ticketCreateDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        service.update(ticketCreateDTO);
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/delete/{id}")
    public ModelAndView DeleteTicketById(@PathVariable("id") long id) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }
}