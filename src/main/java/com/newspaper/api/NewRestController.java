package com.newspaper.api;

import com.newspaper.dto.NewDto;
import com.newspaper.entity.New;
import com.newspaper.entity.User;
import com.newspaper.service.NewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/api_new")
public class NewRestController {

    @Autowired
    private NewService newService;

    //Crud
    @GetMapping("/list_news")
    public List<New> getAllNews() {
        return newService.getAll();
    }

    @GetMapping("/get_new/{id}")
    public ResponseEntity<New> getNewById(@PathVariable("id") Long id){
        New news = newService.getNewById(id);
        if( news != null){
            return new ResponseEntity<>(news, HttpStatus.OK);
        }else{
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create_new")
    public ResponseEntity<New> createUser(@RequestBody New news){
        New createdNew = newService.saveNew(news);
        return  new ResponseEntity<>(createdNew, HttpStatus.CREATED);
    }

    @PutMapping("/update_new/{id}")
    public ResponseEntity<New> updateNew(@PathVariable(name = "id") Long id, @RequestBody New news){
        New updatedNew = newService.updateNew(id, news);
        if (updatedNew != null){
            return new ResponseEntity<>(updatedNew, HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/delete_new/{id}")
    public  ResponseEntity<New> deleteNew(@PathVariable("id") Long id){
        newService.deleteNew(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   /* @GetMapping("/get_new")
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

    @GetMapping("/recent")
    public NewDto mostRecentNew(){
        return newService.getNewMostRecent();
    }*/
}
