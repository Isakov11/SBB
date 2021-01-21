package org.hino.sbb.controller;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.Passenger;
import org.hino.sbb.model.Train;
import org.hino.sbb.service.BusinessService;
import org.hino.sbb.service.PassengerService;
import org.hino.sbb.service.TicketService;
import org.hino.sbb.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private TicketService ticketService;

    //Wizard step 1
    @GetMapping(value = "/wizard/findtrain")
    public ModelAndView findTrainsForRoute(@RequestParam (name = "departStationId") long departStationId,
                                           @RequestParam (name = "arrivalStationId") long arrivalStationId,
                                           @RequestParam (name = "date", required = false) String date
    ){
        List<TrainDTO> trains = businessService.getDirectTrains(departStationId, arrivalStationId,date);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("DirectTrains");
        modelAndView.addObject("DTOList", trains);
        modelAndView.addObject("departStationId", departStationId);
        return modelAndView;
    }

    //Wizard step 2
    @GetMapping (value = "/wizard/selecttrain")
    public ModelAndView checkTrainAvailability(@RequestParam("trainId") long trainId,
                                               @RequestParam("departStationId") long departStationId) {
        ModelAndView modelAndView = new ModelAndView();
        boolean trainCheck = businessService.checkTrainAvailability(trainId, departStationId);

        if (trainCheck){
            TrainDTO trainDTO = trainService.findDTObyId(trainId);
            String firstStation = trainDTO.getTrainRoute().getFirst().getStationName();
            String lastStation = trainDTO.getTrainRoute().getLast().getStationName();

            modelAndView.addObject("trainDTO", trainDTO);
            modelAndView.addObject("firstStation", firstStation);
            modelAndView.addObject("lastStation", lastStation);
            modelAndView.addObject("departStationId", departStationId);
            modelAndView.setViewName("SelectPassenger");
        }else{
            modelAndView.setViewName("redirect:/tickets");
        }
        return modelAndView;
    }

    //Wizard step 3
    @PostMapping(value = "/wizard/selectpassenger")
    public ModelAndView BuyTicket(@RequestParam("trainId") long trainId,
                                  @RequestParam("departStationId") long departStationId,
                                  @RequestParam("name") String name,
                                  @RequestParam("secondName") String secondName,
                                  @RequestParam("birthDate") String birthDate
                                  ) {
        ModelAndView modelAndView = new ModelAndView();
        PassengerDTO passengerDTO = new PassengerDTO(name,secondName,birthDate);
        boolean passengerCheck = businessService.isPassengerRegisteredOnTrain(passengerDTO,trainId);
        boolean trainCheck = businessService.checkTrainAvailability(trainId, departStationId);
        if (!passengerCheck && trainCheck) {
            ticketService.create(passengerDTO, trainId);
            modelAndView.setViewName("redirect:/tickets");
        }
        else{
            modelAndView.setViewName("redirect:/tickets");
        }
        return modelAndView;
    }

}