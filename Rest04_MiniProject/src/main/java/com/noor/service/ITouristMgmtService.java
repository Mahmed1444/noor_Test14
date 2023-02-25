package com.noor.service;

import com.noor.entity.Tourist;

import java.util.List;

public interface ITouristMgmtService {
    public String registerTourist(Tourist tourist);
    public List<Tourist> GetTouristDetails();
    public Tourist getByIdDetails(Integer tid);
    public List<Tourist> getByName(String name);
    public String deleteRecordById(Integer tid);
    public String updateTouristDetails(Tourist tourist);


}
