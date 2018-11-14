package com.ronan.yotibackendtest.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoboHoover {

    private Room room;
    private int cartesianPosX;
    private int cartesianPosY;
    private String instructions;
    private int cleanCount;


    public RoboHoover(int cartesianPosX, int cartesianPosY, String instructions, Room room) {
        this.room = room;
        this.cartesianPosX = cartesianPosX;
        this.cartesianPosY = cartesianPosY;
        this.instructions = instructions;
    }

    public void move() {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'N':
                    goNorth();
                    break;
                case 'E':
                    goEast();
                    break;
                case 'S':
                    goSouth();
                    break;
                case 'W':
                    goWest();
                    break;
                default:
                    System.out.println("Invalid instruction.");
                    break;
            }
            clean();
        }
    }

    private void clean() {
        //Convert Cartesian to Java
        int arrayIndexX = cartesianPosX;
        int arrayIndexY = (room.getHeight() - 1) - cartesianPosY;
        if(room.cleanDirt(arrayIndexX, arrayIndexY)){
            cleanCount++;
        }
    }

    private void goWest() {
        if (cartesianPosX != 0) {
            cartesianPosX -= 1;
        }
    }

    private void goEast() {
        if (cartesianPosX != room.getWidth()) {
            cartesianPosX += 1;
        }
    }

    private void goSouth() {
        if (cartesianPosY != 0) {
            cartesianPosY -= 1;
        }
    }

    private void goNorth() {
        if (cartesianPosY != room.getHeight()) {
            cartesianPosY += 1;
        }
    }

    public String report() {
        ObjectMapper objectMapper = new ObjectMapper();
        Output output = new Output(cartesianPosX, cartesianPosY, cleanCount);
        System.out.println(output.toString());
        try {
            return objectMapper.writeValueAsString(output);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
