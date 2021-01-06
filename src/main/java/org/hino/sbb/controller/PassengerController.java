package org.hino.sbb.controller;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.mappers.PassengerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.hino.sbb.dao.PassengerDAO;

import java.util.LinkedList;
import java.util.List;

@Controller
public class PassengerController {
//TODO Class not completed
    @Autowired
    private PassengerDAO passengerDAO;
    @Autowired
    private PassengerMapper passengerMapper;

    @GetMapping(value = "/passengers")
    public ModelAndView allPassengers() {
        List<PassengerDTO> passengers = passengerMapper.toDto(passengerDAO.findAll());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passengers");
        modelAndView.addObject("DTOList", passengers);
        return modelAndView;
    }

    @GetMapping(value = "/passengers/{id}")
    public ModelAndView PassengerById(@PathVariable("id") long id) {
        PassengerDTO passenger = passengerMapper.toDto(passengerDAO.findById(id)) ;
        List<PassengerDTO> passengers  = new LinkedList<>();
        passengers.add(passenger);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("passengers");
        modelAndView.addObject("DTOList", passengers);
        return modelAndView;
    }
}