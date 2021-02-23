package org.hino.sbb.controller;

import org.hino.sbb.dto.UserDTO;
import org.hino.sbb.model.User;
import org.hino.sbb.service.UserService;
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
public class UserController {
    private final String viewName = "/admin/users";
    private final String adminPage = "/index";

    @Autowired
    private UserService service;

    @GetMapping(value = viewName)
    public ModelAndView allUsers() {
        List<UserDTO> dtoList = service.findAllDTO();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(viewName);
        modelAndView.addObject("DTOList", dtoList);
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    @GetMapping(path = viewName + "/{id}")
    public ModelAndView userById(@PathVariable("id") long id) {
        UserDTO dto = service.findDTOById(id);
        List<UserDTO> dtoList = new LinkedList<>();
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
    public ModelAndView createUser(@Valid @ModelAttribute("dto") UserDTO dto,
                                   BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        if (bindingResult.hasErrors()) {
            return modelAndView;
        }
        service.create(dto);
        return modelAndView;
    }

    @RequestMapping(value = viewName + "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity deleteUserById(@PathVariable("id") long id) {
        service.delete(id);
        return ResponseEntity.ok().body("ok");
    }
}