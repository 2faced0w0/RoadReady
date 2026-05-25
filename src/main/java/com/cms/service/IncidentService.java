package com.cms.service;

import com.cms.dto.IncidentDto;
import com.cms.dto.IncidentRespDto;
import com.cms.exception.ResourceNotFoundException;
import com.cms.mapper.IncidentMapper;
import com.cms.model.Incident;
import com.cms.model.Officer;
import com.cms.repository.IncidentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

/*
To create a bean in spring boot we can use following annotations
for services class use @Service
for repositories , use @Repository
for all other classes including util use @Component
* */
@Service
@AllArgsConstructor
public class IncidentService {

    private final IncidentRepository incidentRepository;
    private final IncidentMapper incidentMapper;
    private final OfficerService officerService;

    public List<Incident> getAll() {
        return incidentRepository.findAll();
    }

    public void addIncident(IncidentDto dto) {

        Incident incident= incidentMapper.mapDtoToEntity(dto);
        incidentRepository.save(incident);
    }

    public Incident getById(int id) {
        return incidentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Invalid incident id"));
    }
    public void deleteById(int id){
        getById(id);
        incidentRepository.deleteById(id);
    }

    public void update(int id, Incident updatedIncident){
        Incident existingIncident= getById(id);
        existingIncident.setIncidentStatus(updatedIncident.getIncidentStatus());
        existingIncident.setIncidentType(updatedIncident.getIncidentType());
        existingIncident.setProgressDetails(updatedIncident.getProgressDetails());

        incidentRepository.save(existingIncident);
    }

    public IncidentRespDto getAllWithPagination(int page, int size) {
        // prepare the Pageable object using PageRequest.
        Pageable pageable =  PageRequest.of(page,size);
        Page<Incident> pages =  incidentRepository.findAll(pageable);
        return incidentMapper.mapEntityToDto(pages);
    }

    public void addIncidentWithOfficer(IncidentDto dto, int officerId){

        Officer officer= officerService.getById(officerId);
        Incident incident=incidentMapper.mapDtoToEntity(dto);
        incident.setOfficer(officer);
        incidentRepository.save(incident);
    }
}