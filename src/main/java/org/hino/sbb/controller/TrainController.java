package org.hino.sbb.controller;

import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.service.BusinessService;
import org.hino.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TrainController {
    private final String viewName = "/admin/trains";
    private final String adminPage = "/index";

    @Autowired
    private TrainService service;

    @Autowired
    private BusinessService businessService;

        @GetMapping(value = viewName)
    public ModelAndView allTrains() {
        List<TrainDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(path = viewName + "/{id}")
    public ModelAndView trainById(@PathVariable("id") long id) {
        TrainDTO dto = service.findDTObyId(id);
        List<TrainDTO> dtoList = new LinkedList<>();
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
    public ModelAndView createTrain(@ModelAttribute("dto") TrainDTO dto) {
        service.create(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/edit/{id}")
    public ModelAndView getEditTrain(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        TrainDTO dto = service.findDTObyId(id);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("dto", dto);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @PostMapping(value = viewName + "/edit")
    public ModelAndView editTrain(@ModelAttribute("dto") TrainDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        service.update(dto);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/delete/{id}")
    public ModelAndView deleteTrainById(@PathVariable("id") long id) {
        TrainDTO dto = service.deleteRetDTO(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }
}