package org.hino.sbb.controller;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.mappers.PassengerMapper;
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
private final String viewName = "passengers";

    @Autowired
    private PassengerService service;

    @Autowired
    private PassengerMapper mapper;

    @GetMapping(value = "/" + viewName)
    public ModelAndView allPassengers() {
        List<PassengerDTO> dtoList = mapper.toDto(service.findAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(path = "/" + viewName + "/{id}")
    public ModelAndView PassengerById(@PathVariable("id") long id) {
        Passenger entity = service.findById(id);
        if (entity != null){
            PassengerDTO dto = mapper.toDto(service.findById(id));
            List<PassengerDTO> dtoList  = new LinkedList<>();
            dtoList.add(dto);
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName(viewName);
            modelAndView.addObject("DTOList", dtoList);
            modelAndView.addObject("viewName", viewName);
            return modelAndView;
        }else{
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("error");
            return modelAndView;
        }
    }

    @GetMapping(value = "/" + viewName + "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @PostMapping(path = "/" + viewName + "/add")
    public ModelAndView CreatePassenger(@ModelAttribute("dto") PassengerDTO dto) {
        Passenger entity = mapper.toEntity(dto);
        service.create(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/edit/{id}")
    public ModelAndView GetEditPassenger(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Passenger entity = service.findById(id);
        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        PassengerDTO dto = mapper.toDto(entity);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = "/" + viewName + "/edit")
    public ModelAndView EditPassenger(@ModelAttribute("dto") PassengerDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        service.update(mapper.toEntity(dto));
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/delete/{id}")
    public ModelAndView DeletePassengerById(@PathVariable("id") long id) {
        Passenger entity = service.delete(id);
        ModelAndView modelAndView = new ModelAndView();

        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }
}