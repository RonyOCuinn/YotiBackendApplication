package com.ronan.yotibackendtest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ronan.yotibackendtest.model.Input;
import com.ronan.yotibackendtest.model.Output;
import com.ronan.yotibackendtest.repository.InputRepository;
import com.ronan.yotibackendtest.repository.OutputRepository;
import com.ronan.yotibackendtest.service.CleanerService;
import com.ronan.yotibackendtest.service.PersistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    @Autowired
    CleanerService cleanerService;

    @Autowired
    InputRepository inputRepository;

    @Autowired
    OutputRepository outputRepository;

    @Autowired
    PersistService persistService;

    @ResponseBody
    @PostMapping(value = "/clean")
    public String clean(@RequestBody Input input){
        ObjectMapper objectMapper = new ObjectMapper();
        Output output = cleanerService.start(input);

        try {
            return objectMapper.writeValueAsString(output);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "{}";
    }

}
