package org.hino.sbb.controller;

import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.mappers.TrainMapper;
import org.hino.sbb.model.Train;
import org.hino.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
@ControllerAdvice
public class TrainController {
    private final String viewName = "trains";

    @Autowired
    private TrainService service;

    @Autowired
    private TrainMapper mapper;

    @GetMapping(value = "/" + viewName)
    public ModelAndView allTrains() {
        List<TrainDTO> dtoList = mapper.toDto(service.findAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(path = "/" + viewName + "/{id}")
    public ModelAndView TrainById(@PathVariable("id") long id) {
        Train entity = service.findById(id);
        if (entity != null){
            TrainDTO dto = mapper.toDto(service.findById(id));
            List<TrainDTO> dtoList  = new LinkedList<>();
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
    public ModelAndView CreateTrain(@ModelAttribute("dto") TrainDTO dto) {
        Train entity = mapper.toEntity(dto);
        service.create(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/edit/{id}")
    public ModelAndView GetEditTrain(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        Train entity = service.findById(id);

        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }

        TrainDTO dto = mapper.toDto(entity);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("dto", dto);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @PostMapping(value = "/" + viewName + "/edit")
    public ModelAndView EditTrain(@ModelAttribute("dto") TrainDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        service.update(mapper.toEntity(dto));
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/delete/{id}")
    public ModelAndView DeleteTrainById(@PathVariable("id") long id) {
        Train entity =  service.delete(id);
        ModelAndView modelAndView = new ModelAndView();

        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }
}