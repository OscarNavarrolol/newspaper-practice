package com.newspaper.api;

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

    @GetMapping("/get_user")
    public List<New> getAllUser(){
        return newService.getAllNew();
    }

}
