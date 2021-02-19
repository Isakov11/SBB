package org.hino.sbb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
public class BBRestController {
    @Autowired
    private StationService service;
    private ObjectMapper mapper = new ObjectMapper();

    @GetMapping(path =  "/admin/stations/api/{id}")
    public String stationSchedule(@PathVariable("id") long id) {
        String jsonString = "";
        StationDTO dto = service.findDTObyId(id);
        try {
            jsonString = mapper.writeValueAsString(dto.getStationScheduleTable());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }
}
