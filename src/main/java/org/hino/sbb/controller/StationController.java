package org.hino.sbb.controller;

import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class StationController  {
    private final String viewName = "/admin/stations";
    private final String adminPage = "/index";

    @Autowired
    private StationService service;


    @GetMapping(value = viewName)
    public ModelAndView allStations() {
        List<StationDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(path = viewName + "/{id}")
    public ModelAndView stationById(@PathVariable("id") long id) {
        StationDTO dto = service.findDTObyId(id);
        List<StationDTO> dtoList = new LinkedList<>();
        dtoList.add(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(value = viewName + "/add")
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @PostMapping(path = viewName + "/add")
    public ModelAndView createStation(@ModelAttribute("dto") StationDTO dto) {

        service.create(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/edit/{id}")
    public ModelAndView getEditStation(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        StationDTO dto = service.findDTObyId(id);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = viewName + "/edit")
    public ModelAndView editStation(@ModelAttribute("dto") StationDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        service.update(dto);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/delete/{id}")
    public ModelAndView deleteStationById(@PathVariable("id") long id) {
        StationDTO dto = service.deleteRetDTO(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }
}