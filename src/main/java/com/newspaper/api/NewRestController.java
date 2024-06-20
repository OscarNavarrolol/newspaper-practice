package com.newspaper.api;

import com.newspaper.dto.NewDto;
import com.newspaper.entity.New;
import com.newspaper.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api_new")
public class NewRestController {

    @Autowired
    private NewService newService;

    @GetMapping("/get_new")
    public List<NewDto> getAllUser(){
        return newService.getAllNew();
    }

    @GetMapping("/get_new/{id}")
    public NewDto getUserById(@PathVariable("id") Long id){
        return newService.getNewById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") Long id){
        newService.deleteById(id);
    }

//    @PutMapping("/update/{id}")
//    public void takeAttendance(@PathVariable("id") Long id) {
//        newService.saveEventArrivalTime(id);
//    }

}
