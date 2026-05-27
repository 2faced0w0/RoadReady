package com.cms.controller;

import com.cms.dto.IncidentSuspectReqDto;
import com.cms.service.IncidentSuspectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/incident/suspect")
@AllArgsConstructor
public class IncidentSuspectController {

    private final IncidentSuspectService incidentSuspectService;
    /*
     * Req:
     * suspect should be present in db (suspectId)
     * incident should be present in db (incidentId)
     * */
    @PostMapping("/add/{incidentId}/{suspectId}")
    public void add(@PathVariable int incidentId ,
                    @PathVariable int suspectId,
                    @Valid  @RequestBody IncidentSuspectReqDto dto){
        incidentSuspectService.add(incidentId,suspectId,dto);
    }

    /*
        * Resp:
        * incidentType
        * incidentStatus
        * incidentDetails
        * suspectName
        * suspectContact
        * suspectId
     */
    @GetMapping("/by-incident/{incidentId}")
    public ResponseEntity<Object> getAllSuspectsByIncidents(){

        return incidentSuspectService
    }

    @GetMapping("/by-station/{stationId}")
    public ResponseEntity<Object> getAllSuspectsByIncidents(){

        return incidentSuspectService.getAllSuspectByStation
    }
}