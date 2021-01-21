package org.hino.sbb.service;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.model.Passenger;
import org.hino.sbb.model.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class BusinessService {
    private long timeOffsetCloseTicketSelling = 10; //minutes

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private TrainService trainService;

    @Autowired
    private StationService stationService;

    @Autowired
    private TicketService ticketService;



    public List<TrainDTO> getDirectTrains(long departStationId, long arrivalStationId, String date){
        List<TrainDTO> crossTrains = trainService.getTrainsByDepartAndArrivalStationIds(departStationId,arrivalStationId);
        return crossTrains;
    }

    public boolean isPassengerRegisteredOnTrain(PassengerDTO passenger, long trainId){
        return passengerService.isPassengerRegisteredOnTrain(passenger, trainId);
    }

    public boolean isTrainHasFreeSeats(long trainId){
        return trainService.isTrainHasFreeSeats(trainId);
    }

    public boolean checkTrainAvailability(long trainId, long stationId){
        boolean timeCheck = false;
        boolean seatsCheck = trainService.isTrainHasFreeSeats(trainId);
        LocalDateTime departureTime = trainService.getTrainDepartureTimeFromStation(trainId, stationId);

        if  (LocalDateTime.now().isBefore(departureTime.minusMinutes(timeOffsetCloseTicketSelling))){timeCheck = true;}
        return (timeCheck && seatsCheck);
    }


}
