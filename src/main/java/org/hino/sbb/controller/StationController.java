package org.hino.sbb.controller;

import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.mappers.StationMapper;
import org.hino.sbb.model.Station;
import org.hino.sbb.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@ControllerAdvice
public class StationController  {
    private final String viewName = "stations";

    @Autowired
    private StationService service;

    @Autowired
    private StationMapper mapper;

    @GetMapping(value = "/" + viewName)
    public ModelAndView allStations() {
        List<StationDTO> dtoList = mapper.toDto(service.findAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(path = "/" + viewName + "/{id}")
    public ModelAndView StationById(@PathVariable("id") long id) {
        Station entity = service.findById(id);
        if (entity != null){
            StationDTO dto = mapper.toDto(service.findById(id));
            List<StationDTO> dtoList  = new LinkedList<>();
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
    public ModelAndView CreateStation(@ModelAttribute("dto") StationDTO dto) {
        Station entity = mapper.toEntity(dto);
        service.create(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/edit/{id}")
    public ModelAndView GetEditStation(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Station entity = service.findById(id);
        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        StationDTO dto = mapper.toDto(entity);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = "/" + viewName + "/edit")
    public ModelAndView EditStation(@ModelAttribute("dto") StationDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        service.update(mapper.toEntity(dto));
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/delete/{id}")
    public ModelAndView DeleteStationById(@PathVariable("id") long id) {
        Station entity = service.delete(id);
        ModelAndView modelAndView = new ModelAndView();

        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }
}