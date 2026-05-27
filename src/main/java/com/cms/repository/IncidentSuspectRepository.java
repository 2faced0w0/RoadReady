package com.cms.repository;

import com.cms.dto.SuspectDtoV2;
import com.cms.model.IncidentSuspect;
import com.cms.model.Suspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IncidentSuspectRepository extends JpaRepository<IncidentSuspect, Integer> {

    @Query("""
            select isObj.suspect
            from IncidentSuspect isObj
            where isObj.incident.id = ?1
            """)
    List<Suspect> getAllSuspectByIncident(int incidentId);

    @Query("""
            select new com.cms.dto.SuspectDtoV2(s.name, s.contact, s.city, i.incidentType, i.incidentStatus, o.name, stn.stationTitle)
            from IncidentSuspect ins join ins.suspect s join ins.Incident i join i.officer o join o.station stn
            where s.id=?1
            """)
    List<SuspectDtoV2>  getAllSuspectByStation(int stationId);
}