package org.hino.sbb.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;
import org.hino.sbb.dto.StationDTO;
import org.hino.sbb.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BBRestController {
    private static final Logger logger = Logger.getLogger(BBRestController.class);

    private StationService service;

    private ObjectMapper mapper = new ObjectMapper();

    public BBRestController() {
    }

    @Autowired
    public BBRestController(StationService service) {
        this.service = service;
    }

    @GetMapping(path =  "/admin/stations/api/{id}")
    public String stationSchedule(@PathVariable("id") long id) {
        String jsonString = "";
        StationDTO dto = service.findDTObyId(id);
        try {
            jsonString = mapper.writeValueAsString(dto.getStationScheduleTable());
            logger.info("Sent by REST:\n" + jsonString);
        } catch (JsonProcessingException e) {
            logger.error(e.getMessage());
        }
        return jsonString;
    }
}
