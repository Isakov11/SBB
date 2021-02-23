package org.hino.sbb.service;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TrainDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@Transactional
public class BusinessService {
    private long timeOffsetCloseTicketSelling = 10; //minutes

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TrainService trainService;

    public List<TrainDTO> getDirectTrains(long departStationId, long arrivalStationId, String departDate){
        List<TrainDTO> crossTrains;
        if (departDate == null || departDate.equals("")) {
            crossTrains = trainService.getTrainsByDepartAndArrivalStationIds(departStationId, arrivalStationId);
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate lDepartDate = LocalDate.parse(departDate,formatter);
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
