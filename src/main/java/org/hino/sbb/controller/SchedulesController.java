package org.hino.sbb.controller;

import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.mappers.ScheduleNodeMapper;
import org.hino.sbb.mappers.StationMapper;
import org.hino.sbb.mappers.TrainMapper;
import org.hino.sbb.model.ScheduleNode;
import org.hino.sbb.model.Station;
import org.hino.sbb.service.SchedulesService;
import org.hino.sbb.service.StationService;
import org.hino.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Controller
@ControllerAdvice
public class SchedulesController {
    private final String viewName = "schedules";

    @Autowired
    private TrainService trainService;

    @Autowired
    private TrainMapper trainMapper;

    @Autowired
    private StationService stationService;

    @Autowired
    private StationMapper stationMapper;

    @Autowired
    private SchedulesService service;

    @Autowired
    private ScheduleNodeMapper mapper;

    @GetMapping(value = "/" + viewName)
    public ModelAndView allSchedules() {
        Set<ScheduleNodeDTO> dtoList = mapper.toDto(service.findAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(path = "/" + viewName + "/{id}")
    public ModelAndView SchedulesById(@PathVariable("id") long id) {
        ScheduleNode entity = service.findById(id);
        if (entity != null){
            ScheduleNodeDTO dto = mapper.toDto(service.findById(id));
            List<ScheduleNodeDTO> dtoList  = new LinkedList<>();
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

        List<TrainDTO> trainsList = trainMapper.toDto(trainService.findAll());
        List<StationDTO> stationsList = stationMapper.toDto(stationService.findAll());
        modelAndView.addObject("stationsList", stationsList);
        modelAndView.addObject("trainsList", trainsList);
        return modelAndView;
    }

    @PostMapping(path = "/" + viewName + "/add")
    public ModelAndView CreateSchedules(@ModelAttribute("dto") ScheduleNodeDTO dto) {
        ScheduleNode entity = mapper.toEntity(dto);

        service.create(entity);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/edit/{id}")
    public ModelAndView GetEditSchedules(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        ScheduleNode entity = service.findById(id);
        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        ScheduleNodeDTO dto = mapper.toDto(entity);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = "/" + viewName + "/edit")
    public ModelAndView EditSchedules(@ModelAttribute("dto") ScheduleNodeDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/" + viewName);
        service.update(mapper.toEntity(dto));
        return modelAndView;
    }

    @GetMapping (value = "/" + viewName + "/delete/{id}")
    public ModelAndView DeleteSchedulesById(@PathVariable("id") long id) {
        ScheduleNode entity = service.delete(id);
        ModelAndView modelAndView = new ModelAndView();

        if (entity == null){
            modelAndView.setViewName("error");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:/" + viewName);
        return modelAndView;
    }
}