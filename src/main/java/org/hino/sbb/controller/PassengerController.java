package org.hino.sbb.controller;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.model.Passenger;
import org.hino.sbb.service.PassengerService;
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
public class PassengerController {

    private final String viewName = "/admin/passengers";

    private final String adminPage = "/index";

    private PassengerService service;

    public PassengerController() {
    }

    @Autowired
    public PassengerController(PassengerService service) {
        this.service = service;
    }

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
    public ModelAndView createPassenger(@Valid @ModelAttribute("dto") PassengerDTO dto,
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
    public ModelAndView getEditPassenger(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        PassengerDTO dto = service.findDTOById(id);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = viewName + "/edit")
    public ModelAndView editPassenger(@Valid @ModelAttribute("dto") PassengerDTO dto,
                                      BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        service.update(dto);
        return modelAndView;
    }

    @RequestMapping(value = viewName + "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deletePassengerById(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().body("ok");
    }
}