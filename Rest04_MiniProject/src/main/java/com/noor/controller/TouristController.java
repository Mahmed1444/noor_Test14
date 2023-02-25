package com.noor.controller;

import com.noor.entity.Tourist;
import com.noor.service.ITouristMgmtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TouristController {
    @Autowired
    private ITouristMgmtService service;
    @PostMapping("/register")
    public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist){
        String result= service.registerTourist(tourist);
        return new ResponseEntity<String>(result, HttpStatus.CREATED);

    }
    /*@GetMapping("/show")
    public ResponseEntity<?> showTouristById() {
        try {
            Iterable<Tourist> value = service.GetTouristDetails();
            return new ResponseEntity<List<Tourist>>( value, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("problem in fetching deatils", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/
        @GetMapping("/find/{tid}")
        public ResponseEntity<?> getRecordById(@PathVariable("tid") Integer tid){
            try {
                Tourist tourist = service.getByIdDetails(tid);
                return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
            }catch (Exception e){
                e.printStackTrace();
                return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
            }

    }
    @GetMapping("/search/{name}")
    public ResponseEntity<?> getRecordByName(@PathVariable("name")String name){
        try {
            List<Tourist> touristName = service.getByName(name);
            return new ResponseEntity<>(touristName, HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>("No such type of names found",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/remove/{tid}")
    public ResponseEntity<String> deleteByIdRecords(@PathVariable("tid")Integer tid){
        try{
            String tourist= service.deleteRecordById(tid);
            return new ResponseEntity<String>(tourist,HttpStatus.OK);

        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(" such record is no found ",HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/modify")
    public ResponseEntity<String> modifyTourist(@RequestBody Tourist tourist){
        try{
            String tourist1=service.updateTouristDetails(tourist);
            return new ResponseEntity<String>(tourist1,HttpStatus.ACCEPTED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<String>(" No such records found and not Upadated",HttpStatus.NOT_FOUND);
        }
    }
}
