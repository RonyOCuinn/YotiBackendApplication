package com.ronan.yotibackendtest.service;

import com.ronan.yotibackendtest.model.Input;
import com.ronan.yotibackendtest.model.Output;
import com.ronan.yotibackendtest.model.RoboHoover;
import com.ronan.yotibackendtest.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class CleanerService {

    private RoboHoover roboHoover;

    @Autowired
    private PersistService persistService;

    public void startCleaning(Input input){
        System.out.println("Room size: " + Arrays.toString(input.getRoomSize()));
        System.out.println("Co-ordinates: " + Arrays.toString(input.getCoords()));
        System.out.println("Patches: " + Arrays.toString(input.getPatches()));
        System.out.println("Instructions: " + input.getInstructions());
    }

    private void setup(Input input) {
        Room room = new Room(input.getRoomSize()[0], input.getRoomSize()[1], input.getPatches());
        roboHoover = new RoboHoover(input.getCoords()[0], input.getCoords()[1], input.getInstructions(), room);
    }

    public Output start(Input input) {
        if(input == null){
            throw new NullPointerException("Invalid input");
        }
        persistService.persist(input);
        setup(input);
        roboHoover.move();
        Output output = roboHoover.report();
        persistService.persist(output);
        return output;
    }
}
