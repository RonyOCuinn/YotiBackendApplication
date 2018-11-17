package com.ronan.yotibackendtest.service;

import com.ronan.yotibackendtest.model.Input;
import com.ronan.yotibackendtest.model.Output;
import com.ronan.yotibackendtest.repository.InputRepository;
import com.ronan.yotibackendtest.repository.OutputRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersistService {

    @Autowired
    InputRepository inputRepository;

    @Autowired
    OutputRepository outputRepository;

    public void persist(Input input, Output output){
        inputRepository.save(input);
        outputRepository.save(output);
    }

    public void persist(Input input){
        inputRepository.save(input);
    }

    public void persist(Output output){
        outputRepository.save(output);
    }

}
