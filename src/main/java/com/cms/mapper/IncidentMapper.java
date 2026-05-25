package com.cms.mapper;

import com.cms.dto.IncidentDto;
import com.cms.dto.IncidentRespDto;
import com.cms.model.Incident;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidentMapper {
    public Incident mapDtoToEntity(IncidentDto incidentDto){
        Incident incident=new Incident();
        incident.setIncidentType(incidentDto.incidentType());
        incident.setIncidentStatus(incidentDto.incidentStatus());
        incident.setProgressDetails(incidentDto.progressDetails());
        return incident;
    }
    public IncidentRespDto mapEntityToDto(Page<Incident> pages){
        long totalElements=pages.getTotalElements();
        int totalPages=pages.getTotalPages();
        List<Incident> list=pages.getContent();
        IncidentRespDto dto=new IncidentRespDto(
                totalElements,
                totalPages,
                list
        );
        return dto;
    }
}
