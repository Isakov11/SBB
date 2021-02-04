package org.hino.sbb.controller;

import org.hino.sbb.dto.UserDTO;
import org.hino.sbb.model.User;
import org.hino.sbb.service.UserService;
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
    public ModelAndView createUser(@ModelAttribute("dto") UserDTO dto) {
        service.create(dto);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/edit/{id}")
    public ModelAndView getEditUser(@PathVariable("id") long id) {
        ModelAndView modelAndView = new ModelAndView();
        UserDTO dto = service.findDTOById(id);
        modelAndView.setViewName(viewName + "Edit");
        modelAndView.addObject("viewName", viewName);
        modelAndView.addObject("dto", dto);
        return modelAndView;
    }

    @PostMapping(value = viewName + "/edit")
    public ModelAndView editUser(@ModelAttribute("dto") UserDTO dto) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:" + viewName);
        service.update(dto);
        return modelAndView;
    }

    @GetMapping (value = viewName + "/delete/{id}")
    public ModelAndView deleteUserById(@PathVariable("id") long id) {
        User entity = service.delete(id);
        ModelAndView modelAndView = new ModelAndView();
        if (entity == null){
            modelAndView.setViewName("500");
            return modelAndView;
        }
        modelAndView.setViewName("redirect:" + viewName);
        return modelAndView;
    }
}