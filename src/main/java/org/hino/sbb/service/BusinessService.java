package org.hino.sbb.service;

import org.apache.log4j.Logger;
import org.hino.sbb.controller.BusinessController;
import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TrainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@Service
@Transactional
public class BusinessService {
    private static final Logger logger = Logger.getLogger(BusinessService.class);
    private long timeOffsetCloseTicketSelling = 10; //minutes

    private PassengerService passengerService;

    private TrainService trainService;

    public BusinessService() {
    }

    @Autowired
    public BusinessService(PassengerService passengerService, TrainService trainService) {
        this.passengerService = passengerService;
        this.trainService = trainService;
    }

    public List<TrainDTO> getDirectTrains(long departStationId, long arrivalStationId, String departDate){
        List<TrainDTO> crossTrains;
        LocalDate lDepartDate;
        if (departDate == null || departDate.equals("")) {
            crossTrains = trainService.getTrainsByDepartAndArrivalStationIds(departStationId, arrivalStationId);
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
            try{
                lDepartDate = LocalDate.parse(departDate,formatter);
            }
            catch(DateTimeParseException e){
                logger.error(e.getMessage());
                lDepartDate = LocalDate.of(1752,01,01);
            }
            crossTrains = trainService.getTrainsByDepartAndArrivalStationIdsAndDate(departStationId, arrivalStationId,lDepartDate);
        }
        return crossTrains;
    }

    public boolean isPassengerRegisteredOnTrain(PassengerDTO passenger, long trainId){
        return passengerService.isPassengerRegisteredOnTrain(passenger, trainId);
    }

    public boolean checkTrainAvailability(long trainId, long stationId){
        boolean timeCheck = false;
        boolean seatsCheck = trainService.isTrainHasFreeSeats(trainId);
        LocalDateTime departureTime = trainService.getTrainDepartureTimeFromStation(trainId, stationId);

        if  (LocalDateTime.now().isBefore(departureTime.minusMinutes(timeOffsetCloseTicketSelling))){timeCheck = true;}
        return (timeCheck && seatsCheck);
    }
}
