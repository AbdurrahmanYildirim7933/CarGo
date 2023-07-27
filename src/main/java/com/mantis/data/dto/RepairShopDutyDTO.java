package com.mantis.data.dto;


public class RepairShopDutyDTO {
    private Integer id;
    private double price;
    private RepairShopDTO repairShopDTO;
    private DutyDTO dutyDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public RepairShopDTO getRepairShopDTO() {
        return repairShopDTO;
    }

    public void setRepairShopDTO(RepairShopDTO repairShopDTO) {
        this.repairShopDTO = repairShopDTO;
    }

    public DutyDTO getDutyDTO() {
        return dutyDTO;
    }

    public void setDutyDTO(DutyDTO dutyDTO) {
        this.dutyDTO = dutyDTO;
    }
}
