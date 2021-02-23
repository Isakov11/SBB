package org.hino.sbb.controller;

import org.hino.sbb.dto.ScheduleCreateDTO;
import org.hino.sbb.dto.ScheduleNodeDTO;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.service.ArtemisProducer;
import org.hino.sbb.service.SchedulesService;
import org.hino.sbb.service.StationService;
import org.hino.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.LinkedList;
import java.util.List;

@Controller

public class SchedulesController {
    private final String viewName = "/admin/schedules";
    private final String adminPage = "/index";

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private SchedulesService service;

    @Autowired
    private ArtemisProducer artemisProducer;

    public SchedulesController() {
    }

    @GetMapping(value = viewName)
    public ModelAndView allSchedules() {
        List<ScheduleNodeDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        return modelAndView;
    }

    @GetMapping(path = viewName + "/{id}")
    public ModelAndView schedulesById(@PathVariable("id") long id) {
        ScheduleNodeDTO dto = service.findDTObyId(id);
        List<ScheduleNodeDTO> dtoList = new LinkedList<>();
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
        List<TrainDTO> trainsList = trainService.findAllDTO();
        List<StationDTO> stationsList = stationService.findAllDTO();
        modelAndView.addObject("stationsList", stationsList);
        modelAndView.addObject("trainsList", trainsList);
        return modelAndView;
    }

    @PostMapping(path = viewName + "/add")
    public ModelAndView createSchedules(@Valid @ModelAttribute("ScheduleCreateDTO") ScheduleCreateDTO scheduleCreateDTO,
                                        BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        service.create(scheduleCreateDTO);
        artemisProducer.send("create schedule update");
        return modelAndView;
    }

    @GetMapping(value = viewName + "/edit/{id}")
    public ModelAndView getEditSchedules(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        ScheduleNodeDTO dto = service.findDTObyId(id);

        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);

        List<TrainDTO> trainsList = trainService.findAllDTO();
        List<StationDTO> stationsList = stationService.findAllDTO();

        modelAndView.addObject("stationsList", stationsList);
        modelAndView.addObject("trainsList", trainsList);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = viewName + "/edit")
    public ModelAndView editSchedules(@Valid @ModelAttribute("ScheduleCreateDTO") ScheduleCreateDTO scheduleCreateDTO,
                                      BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        service.update(scheduleCreateDTO);
        artemisProducer.send("update schedule update");
        return modelAndView;
    }

    @RequestMapping (value = viewName + "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteSchedulesById(@PathVariable("id") long id) {
        service.delete(id);
        artemisProducer.send("delete schedule update");
        return ResponseEntity.ok().body("ok");
    }
}