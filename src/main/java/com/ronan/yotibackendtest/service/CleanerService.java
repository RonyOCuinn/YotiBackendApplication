package com.ronan.yotibackendtest.service;

import com.ronan.yotibackendtest.model.Input;
import com.ronan.yotibackendtest.model.RoboHoover;
import com.ronan.yotibackendtest.model.Room;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CleanerService {

    RoboHoover roboHoover;

    public void startCleaning(Input input){
        System.out.println("Room size: " + Arrays.toString(input.getRoomSize()));
        System.out.println("Co-ordinates: " + Arrays.toString(input.getCoords()));
        System.out.println("Patches: " + Arrays.toString(input.getPatches()));
        System.out.println("Instructions: " + input.getInstructions());
    }

    public void setup(Input input) {
        Room room = new Room(input.getRoomSize()[0], input.getRoomSize()[1], input.getPatches());
        roboHoover = new RoboHoover(input.getCoords()[0], input.getCoords()[1], input.getInstructions(), room);
    }

    public String start(Input input) {
        setup(input);
        roboHoover.move();
        return roboHoover.report();
    }
}
