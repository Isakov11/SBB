package org.hino.sbb.Test;

import org.hino.sbb.dto.PassengerDTO;
import org.hino.sbb.dto.TrainDTO;
import org.hino.sbb.service.BusinessService;
import org.hino.sbb.service.PassengerService;
import org.hino.sbb.service.TrainService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

public class BusinessServiceTest  extends Assert {

    @Test
    public void getDirectTrainsTestWithNullDate(){
        long departStationId = 0 ;
        long arrivalStationId = 0;
        String departDate = null;

        TrainDTO trainDTOMock = Mockito.mock(TrainDTO.class);
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainDTOMock.getName()).thenReturn("0");
        List mockList = new LinkedList<TrainDTO>();
        mockList.add(trainDTOMock);

        Mockito.when(trainServiceMock.
                getTrainsByDepartAndArrivalStationIds(departStationId, arrivalStationId)).
                thenReturn(mockList);

        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        List<TrainDTO> result =  businessService.getDirectTrains(departStationId,arrivalStationId,departDate);
        assertEquals("0", result.get(0).getName());
    }

    @Test
    public void getDirectTrainsTestWithEmptyDateTest(){

        long departStationId = 0 ;
        long arrivalStationId = 0;
        String departDate = "";

        TrainDTO trainDTOMock = Mockito.mock(TrainDTO.class);
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);
        Mockito.when(trainDTOMock.getName()).thenReturn("0");

        List mockList = new LinkedList<TrainDTO>();
        mockList.add(trainDTOMock);

        Mockito.when(trainServiceMock.
                getTrainsByDepartAndArrivalStationIds(departStationId, arrivalStationId)).
                thenReturn(mockList);
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        List<TrainDTO> result =  businessService.getDirectTrains(departStationId,arrivalStationId,departDate);

        assertEquals("0", result.get(0).getName());
    }

    @Test
    public void getDirectTrainsTestWithFilledDate(){

        long departStationId = 0 ;
        long arrivalStationId = 0;
        String departDate = "4025-02-01";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
        LocalDate lDepartDate = LocalDate.parse(departDate,formatter);

        TrainDTO trainDTOMock = Mockito.mock(TrainDTO.class);
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);
        Mockito.when(trainDTOMock.getName()).thenReturn("0");

        List mockList = new LinkedList<TrainDTO>();
        mockList.add(trainDTOMock);

        Mockito.when(trainServiceMock.
                getTrainsByDepartAndArrivalStationIdsAndDate(departStationId, arrivalStationId,lDepartDate)).
                thenReturn(mockList);
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        List<TrainDTO> result =  businessService.getDirectTrains(departStationId,arrivalStationId,departDate);

        assertEquals("0", result.get(0).getName());
    }

    @Test
    public void getDirectTrainsTestWithWrongDate(){

        long departStationId = 0 ;
        long arrivalStationId = 0;
        String departDate = "sdvsdv";
        LocalDate lDepartDate = LocalDate.of(1752,01,01);
        TrainDTO trainDTOMock = Mockito.mock(TrainDTO.class);
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainDTOMock.getName()).thenReturn("0");

        List mockList = new LinkedList<TrainDTO>();
        mockList.add(trainDTOMock);

        Mockito.when(trainServiceMock.
                getTrainsByDepartAndArrivalStationIdsAndDate(departStationId, arrivalStationId,lDepartDate)).
                thenReturn(mockList);
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        List<TrainDTO> result =  businessService.getDirectTrains(departStationId,arrivalStationId,departDate);

        assertEquals("0", result.get(0).getName());
    }

    @Test
    public void checkTrainAvailabilityTest(){
        long trainId = 0;
        long stationId=0;
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainServiceMock.isTrainHasFreeSeats(trainId)).
                thenReturn(true);

        Mockito.when(trainServiceMock.getTrainDepartureTimeFromStation(trainId, stationId))
                .thenReturn(LocalDateTime.of(9999,01,01,0,01));
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        boolean result =  businessService.checkTrainAvailability(trainId,stationId);

        assertEquals(true, result);
    }
    @Test
    public void checkTrainAvailabilityTest2(){
        long trainId = 0;
        long stationId=0;
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainServiceMock.isTrainHasFreeSeats(trainId)).
                thenReturn(false);

        Mockito.when(trainServiceMock.getTrainDepartureTimeFromStation(trainId, stationId))
                .thenReturn(LocalDateTime.of(9999,01,01,0,01));
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        boolean result =  businessService.checkTrainAvailability(trainId,stationId);

        assertEquals(false, result);
    }

    @Test
    public void checkTrainAvailabilityTest3(){
        long trainId = 0;
        long stationId=0;
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainServiceMock.isTrainHasFreeSeats(trainId)).
                thenReturn(true);

        Mockito.when(trainServiceMock.getTrainDepartureTimeFromStation(trainId, stationId))
                .thenReturn(LocalDateTime.of(999,01,01,0,01));
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        boolean result =  businessService.checkTrainAvailability(trainId,stationId);

        assertEquals(false, result);
    }

    @Test
    public void checkTrainAvailabilityTest4(){
        long trainId = 0;
        long stationId=0;
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainServiceMock.isTrainHasFreeSeats(trainId)).
                thenReturn(true);

        Mockito.when(trainServiceMock.getTrainDepartureTimeFromStation(trainId, stationId))
                .thenReturn(LocalDateTime.now());
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        boolean result =  businessService.checkTrainAvailability(trainId,stationId);

        assertEquals(false, result);
    }

    @Test
    public void checkTrainAvailabilityTest5(){
        long trainId = 0;
        long stationId=0;
        PassengerService passengerServiceMock = Mockito.mock(PassengerService.class);
        TrainService trainServiceMock = Mockito.mock(TrainService.class);

        Mockito.when(trainServiceMock.isTrainHasFreeSeats(trainId)).
                thenReturn(false);

        Mockito.when(trainServiceMock.getTrainDepartureTimeFromStation(trainId, stationId))
                .thenReturn(LocalDateTime.now());
        //----------------------------------------
        BusinessService businessService = new BusinessService(passengerServiceMock, trainServiceMock);
        boolean result =  businessService.checkTrainAvailability(trainId,stationId);

        assertEquals(false, result);
    }
}
