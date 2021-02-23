package org.hino.sbb.controller;

import org.apache.log4j.Logger;
import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.Ticket;
import org.hino.sbb.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.Validator;
import java.util.List;

@Controller
public class BusinessController {
    private static final Logger logger = Logger.getLogger(BusinessController.class);
    private final String adminPage = "/admin/index";

    @Autowired
    private BusinessService businessService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private StationService stationService;

    @Autowired
    Validator validator;

    //Wizard step 1
    @GetMapping(value = "/wizard/step1")
    public ModelAndView selectTravelStationsAndDate() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/wizard/step1");

        List<StationDTO> stationList = stationService.findAllDTO();
        modelAndView.addObject("stationList", stationList);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    //Wizard step 2
    @GetMapping(value = "/wizard/trainfinder")
    public ModelAndView findTrainsForRoute(@RequestParam(name = "departStationId") long departStationId,
                                           @RequestParam(name = "arrivalStationId") long arrivalStationId,
                                           @RequestParam(name = "DepartDate", required = false) String departDate
    ) {
        List<TrainDTO> trains = businessService.getDirectTrains(departStationId, arrivalStationId, departDate);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/wizard/step2");
        modelAndView.addObject("DTOList", trains);
        modelAndView.addObject("departStationId", departStationId);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }

    //Wizard step 3
    @GetMapping(value = "/wizard/trainselecter")
    public ModelAndView checkTrainAvailability(@RequestParam("trainId") long trainId,
                                               @RequestParam("departStationId") long departStationId) {
        ModelAndView modelAndView = new ModelAndView();
        boolean trainCheck = businessService.checkTrainAvailability(trainId, departStationId);
        if (trainCheck) {
            TrainDTO trainDTO = trainService.findDTObyId(trainId);
            String firstStation = trainDTO.getTrainRoute().getFirst().getStationName();
            String lastStation = trainDTO.getTrainRoute().getLast().getStationName();

            modelAndView.addObject("trainDTO", trainDTO);
            modelAndView.addObject("firstStation", firstStation);
            modelAndView.addObject("lastStation", lastStation);
            modelAndView.addObject("departStationId", departStationId);
            modelAndView.addObject("adminPage", adminPage);
            modelAndView.setViewName("wizard/step3");
        } else {
            modelAndView.setViewName("redirect:" + adminPage);
        }
        return modelAndView;
    }

    //Wizard step 4
    @PostMapping(value = "/wizard/passengerselecter")
    public ModelAndView BuyTicket(@RequestParam("trainId") long trainId,
                                  @RequestParam("departStationId") long departStationId,
                                  @Valid @ModelAttribute("passengerDTO") PassengerDTO passengerDTO,
                                  BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        String resultMessage;
        TrainDTO trainDTO = trainService.findDTObyId(trainId);
        String firstStation = trainDTO.getTrainRoute().getFirst().getStationName();
        String lastStation = trainDTO.getTrainRoute().getLast().getStationName();

        if (bindingResult.hasErrors()) {
            resultMessage = "";
        } else {
            boolean isPassengerRegistered = businessService.isPassengerRegisteredOnTrain(passengerDTO, trainId);
            boolean isTrainAvailable = businessService.checkTrainAvailability(trainId, departStationId);
            if (!isPassengerRegistered && isTrainAvailable) {
                Ticket ticket = ticketService.create(passengerDTO, trainId);
                resultMessage = "Ticket № " + ticket.getId() + " successfully registered";
            } else {
                resultMessage = "Something goes wrong";
                if (isPassengerRegistered) {
                    resultMessage = "Passenger already registered";
                }
                if (!isTrainAvailable) {
                    resultMessage = "Train left or less 10 minutes left before departure";
                }
            }
        }
        modelAndView.setViewName("wizard/step3");
        modelAndView.addObject("trainDTO", trainDTO);
        modelAndView.addObject("firstStation", firstStation);
        modelAndView.addObject("lastStation", lastStation);
        modelAndView.addObject("trainId", trainId);
        modelAndView.addObject("departStationId", departStationId);
        modelAndView.addObject("resultMessage", resultMessage);
        modelAndView.addObject("adminPage", adminPage);
        return modelAndView;
    }
}