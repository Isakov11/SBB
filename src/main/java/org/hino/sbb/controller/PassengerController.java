package org.hino.sbb.controller;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.model.Passenger;
import org.hino.sbb.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class PassengerController {
    private final String viewName = "/admin/passengers";
    private final String adminPage = "/index";
    @Autowired
    private PassengerService service;

    @GetMapping(value = viewName)
    public ModelAndView allPassengers() {
        List<PassengerDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(path = viewName + "/{id}")
    public ModelAndView passengerById(@PathVariable("id") long id) {
        PassengerDTO dto = service.findDTOById(id);
        List<PassengerDTO> dtoList = new LinkedList<>();
        dtoList.add(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(value =  viewName + "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @PostMapping(path = viewName + "/add")
    public ModelAndView createPassenger(@ModelAttribute("dto") PassengerDTO dto) {
        service.create(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/edit/{id}")
    public ModelAndView getEditPassenger(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        PassengerDTO dto = service.findDTOById(id);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = viewName + "/edit")
    public ModelAndView editPassenger(@ModelAttribute("dto") PassengerDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        service.update(dto);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/delete/{id}")
    public ModelAndView deletePassengerById(@PathVariable("id") long id) {
        Passenger entity = service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        if (entity == null){
            modelAndView.setViewName("500");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }
}