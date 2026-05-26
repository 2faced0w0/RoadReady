package com.cms.controller;

import com.cms.dto.IncidentDto;
import com.cms.dto.IncidentOfficerDto;
import com.cms.dto.IncidentRespDto;
import com.cms.model.Incident;
import com.cms.service.IncidentService;
import com.cms.service.OfficerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * In controller if you are creating REST APIs
 * then add
 * @RestController annotation which is a combo of
 * @Controller & @ResponseBody
 * But if you are using this controller to load java UI(jsp or Thymeleaf)
 * then use only @Controller
 * */
@RestController
@AllArgsConstructor
public class IncidentController {

    private final IncidentService incidentService;
    private final OfficerService officerService;

    @GetMapping("/all")
    public List<Incident> getAll( ){
        return incidentService.getAll( );
    }

    @GetMapping("/all/v2")
    public IncidentRespDto getAllV2(@RequestParam int page,
                                    @RequestParam int size){
        return incidentService.getAllWithPagination( page,size);
    }

    @PostMapping("/add")
    public void addIncident(@Valid @RequestBody IncidentDto dto){
        incidentService.addIncident(dto);
    }

    @PostMapping("/add/v2/{officerId}")
    public void addIncident(@Valid @RequestBody IncidentDto dto,
                            @PathVariable int officerId){

        incidentService.addIncidentWithOfficer(dto, officerId);
    }

    @GetMapping("/get-one/{id}")
    public ResponseEntity<Incident> getById(@PathVariable int id) { //<-- path variable
        return ResponseEntity
                .ok(incidentService.getById(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        incidentService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public void update(@PathVariable int id,
                       @RequestBody Incident updatedIncident){
        incidentService.update(id, updatedIncident);
    }

    @GetMapping("/get/officer/{officerId}")
    public List<IncidentOfficerDto> getIncidentByOfficerId(@PathVariable int officerId){
        return incidentService.getIncidentByOfficerId(officerId);
    }

    @GetMapping("/get/officer")
    public List<IncidentOfficerDto> getIncidentByOfficerUsername(@RequestParam String officerUsername){
        return incidentService.getIncidentByOfficerUsername(officerUsername);
    }
}