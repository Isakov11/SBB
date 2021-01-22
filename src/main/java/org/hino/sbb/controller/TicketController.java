package org.hino.sbb.controller;

import org.hino.sbb.dto.*;
import org.hino.sbb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TicketController {
    private final String viewName = "tickets";

    @Autowired
    private TicketService service;

    @Autowired
    private TrainService trainService;

    public TicketController(){}

    @GetMapping(value = "/" + viewName)
    public ModelAndView allTickets() {
        ModelAndView modelAndView = new ModelAndView();
        List<TrainDTO> trainList = trainService.findAllDTO();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("trainList", trainList);
        return modelAndView;
    }

    /*@GetMapping(value = "/" + viewName)
    public ModelAndView allTickets() {
        //TODO  change to list
        List<TicketDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }*/

    @GetMapping(value = "/" + viewName + "/getlist")
    public ModelAndView ticketsByTrain(@RequestParam("trainId") long trainId) {
        List<TicketDTO> dtoList = service.findDTOByTrain(trainId);
        List<TrainDTO> trainList = trainService.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/tickets");
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("trainList", trainList);
        modelAndView.addObject("trainSelect", trainId);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    /*@GetMapping(path = "/" + viewName + "/{id}")
    public ModelAndView ticketsById(@PathVariable("id") long id) {
        TicketDTO dto = service.findDTObyId(id);
        List<TicketDTO> dtoList = new LinkedList<>();
        dtoList.add(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }*/

    /*@GetMapping(value = "/" + viewName + "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);

        List<TrainDTO> trainsList = trainService.findAllDTO();
        List<StationDTO> stationList = stationService.findAllDTO();
        List<PassengerDTO> passengerList = passengerService.findAllDTO();
        modelAndView.addObject("passengersList", passengerList);
        modelAndView.addObject("trainsList", trainsList);
        modelAndView.addObject("stationList", stationList);
        return modelAndView;
    }*/

    /*@PostMapping(path = "/" + viewName + "/add")
    public ModelAndView createTicket(@ModelAttribute("TicketCreateDTO") TicketCreateDTO ticketCreateDTO){

        service.create(ticketCreateDTO);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }*/

    /*@GetMapping (value = "/" + viewName + "/edit/{id}")
    public ModelAndView getEditTicket(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        TicketDTO dto = service.findDTObyId(id);

        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);

        List<TrainDTO> trainsList = trainService.findAllDTO();
        List<PassengerDTO> passengerList = passengerService.findAllDTO();

        modelAndView.addObject("passengersList", passengerList);
        modelAndView.addObject("trainsList", trainsList);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = "/" + viewName + "/edit")
    public ModelAndView editTicket(@ModelAttribute("TicketCreateDTO") TicketCreateDTO ticketCreateDTO) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        service.update(ticketCreateDTO);
        return modelAndView;
    }*/

    @GetMapping (value = "/" + viewName + "/delete/{id}")
    public ModelAndView deleteTicketById(@PathVariable("id") long id) {
        service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }


}