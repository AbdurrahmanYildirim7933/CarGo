
package com.mantis.api;

import com.mantis.data.dto.DutyDTO;
import com.mantis.service.DutyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/duty")
public class DutyApi {

    @Autowired
    DutyService dutyService;

    @PostMapping("/create-duty")
    public ResponseEntity<DutyDTO> createDuty(@RequestBody DutyDTO dutyDTO)
    {
        DutyDTO createdDutyDto = dutyService.createDuty(dutyDTO);
        return ResponseEntity.ok(createdDutyDto);
    }

}