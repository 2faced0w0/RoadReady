package com.cms.controller;

import com.cms.dto.OfficerReqDto;
import com.cms.dto.OfficerResponseDto;
import com.cms.service.OfficerService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/officer")
@AllArgsConstructor
public class OfficerController {

    private final OfficerService officerService;
    /*
     * name, username, password
     * */
    @PostMapping("/add")
    public void postOfficer(@RequestBody OfficerReqDto officerReqDto){
        officerService.postOfficer(officerReqDto);
    }
}