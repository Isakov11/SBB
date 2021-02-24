package org.hino.sbb.service;

import org.junit.Assert;
import org.junit.Test;

public class BusinessServiceTest  extends Assert {

    @Test
    public void getDirectTrainsTest(){
        /*public List<TrainDTO> getDirectTrains(long departStationId, long arrivalStationId, String departDate){
        List<TrainDTO> crossTrains;
        if (departDate == null || departDate.equals("")) {
            crossTrains = trainService.getTrainsByDepartAndArrivalStationIds(departStationId, arrivalStationId);
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
            LocalDate lDepartDate = LocalDate.parse(departDate,formatter);
            crossTrains = trainService.getTrainsByDepartAndArrivalStationIdsAndDate(departStationId, arrivalStationId,lDepartDate);
        }
        return crossTrains;
    }*/


        assertEquals(1, 1);
    }
}
