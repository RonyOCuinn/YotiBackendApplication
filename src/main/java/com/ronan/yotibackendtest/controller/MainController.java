package com.ronan.yotibackendtest.controller;

import com.ronan.yotibackendtest.model.Input;
import com.ronan.yotibackendtest.service.CleanerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    CleanerService cleanerService;

    @ResponseBody
    @GetMapping(value = "/hello")
    public String hello(){
        return "Hello!";
    }

    @PostMapping(value = "/clean")
    public String clean(@RequestBody Input input){

        cleanerService.setup(input);
        cleanerService.startCleaning(input);
        //etc.

        return "";
    }

}
