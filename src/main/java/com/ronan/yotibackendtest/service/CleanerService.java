package com.ronan.yotibackendtest.service;

import com.ronan.yotibackendtest.model.Input;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CleanerService {

    private String test;

    public void startCleaning(Input input){
        System.out.println("Room size: " + Arrays.toString(input.getRoomSize()));
        System.out.println("Co-ordinates: " + Arrays.toString(input.getCoords()));
        System.out.println("Patches: " + Arrays.toString(input.getPatches()));
        System.out.println("Instructions: " + input.getInstructions());
    }

    public void setup(Input input) {
        test = input.getInstructions();
    }
}
