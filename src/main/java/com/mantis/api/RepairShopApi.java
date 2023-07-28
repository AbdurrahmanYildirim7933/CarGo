package com.mantis.api;

import com.mantis.data.dto.RepairShopDTO;
import com.mantis.data.dto.RepairShopDutyDTO;
import com.mantis.data.dto.RepairShopWorkersDTO;
import com.mantis.mapper.RepairShopMapper;
import com.mantis.repositories.RepairShopRepository;
import com.mantis.service.RepairShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/repair_shop")
public class RepairShopApi {

    @Autowired
    private RepairShopService repairShopService;


    @PostMapping("/create-repair_shop")
    public ResponseEntity<RepairShopDTO> createService(@RequestBody RepairShopDTO repairShopDTO) {
        RepairShopDTO createdRrepairShopDTO = repairShopService.createService(repairShopDTO);
        return ResponseEntity.ok(createdRrepairShopDTO);
    }

    @PostMapping("/create-repair_duty_relation")
    public ResponseEntity<RepairShopDutyDTO> createRepairShopDuty(@RequestBody RepairShopDutyDTO repairShopDutyDTO) {
        RepairShopDutyDTO createdRepairShopDutyDTO = repairShopService.createRepairShopDuty(repairShopDutyDTO);
        return ResponseEntity.ok(createdRepairShopDutyDTO);
    }

    @PostMapping("/create-repair_shop_workers")
    public ResponseEntity<RepairShopWorkersDTO> createRepairShopWorkers(@RequestBody RepairShopWorkersDTO repairShopWorkersDTO) {
        RepairShopWorkersDTO createdRepairShopWorkersDTO = repairShopService.createRepairShopWorkers(repairShopWorkersDTO);
        return ResponseEntity.ok(createdRepairShopWorkersDTO);
    }

}