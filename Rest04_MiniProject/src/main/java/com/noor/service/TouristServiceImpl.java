package com.noor.service;

import com.noor.entity.Tourist;
import com.noor.repo.ITouristRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service("touristService")
public class TouristServiceImpl implements ITouristMgmtService{
    @Autowired
    private ITouristRepo touristRepo;
    @Override
    public String registerTourist(Tourist tourist) {
        int idValue=touristRepo.save(tourist).getTid();

        return "Tourist generated id value is::"+idValue;
    }

    @Override
    public List<Tourist> GetTouristDetails() {
        List<Tourist> list= (List<Tourist>) touristRepo.findAll();
       // list.sort((t1,t2)->t1.getName().compareTo(t2.getName()));
        return list;
    }

    @Override
    public List<Tourist> getByName(String name) {
        List<Tourist> tourist=touristRepo.findByName(name);
        return tourist;
    }

    @Override
    public String deleteRecordById(Integer tid) {
        Optional<Tourist> t= touristRepo.findById(tid);
        touristRepo.delete(t.get());
        return tid+" this record is deleted";
    }

    @Override
    public String updateTouristDetails(Tourist tourist) {
        Optional<Tourist> t=touristRepo.findById(tourist.getTid());
        if(t.isPresent()) {
            touristRepo.save(tourist);
            return tourist.getTid() + " this record is updated";
        }else{
            return tourist.getTid()+" This ID record is Not Found in Records";
        }
    }

    @Override
    public Tourist getByIdDetails(Integer tid) {
        return touristRepo.findById(tid).orElseThrow(()->new NoSuchElementException(tid+" \tno such records found"));


    }



}
