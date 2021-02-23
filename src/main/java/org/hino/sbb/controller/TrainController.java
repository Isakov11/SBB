package org.hino.sbb.controller;

import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.service.BusinessService;
import org.hino.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.LinkedList;
import java.util.List;

@Controller
public class TrainController {
    private final String viewName = "/admin/trains";

    private final String adminPage = "/index";

    private TrainService service;

    public TrainController() {
    }

    @Autowired
    public TrainController(TrainService service) {
        this.service = service;
    }

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
        if (dto != null){
            dtoList.add(dto);
        }
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
    public ModelAndView createTrain(@Valid @ModelAttribute("dto") TrainDTO dto,
                                    BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        service.create(dto);
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
    public ModelAndView editTrain(@Valid @ModelAttribute("dto") TrainDTO dto,
                                  BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        service.update(dto);
        return modelAndView;
    }

    @RequestMapping (value = viewName + "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteTrainById(@PathVariable("id") long id) {
        service.deleteRetDTO(id);
        return ResponseEntity.ok().body("ok");
    }
}