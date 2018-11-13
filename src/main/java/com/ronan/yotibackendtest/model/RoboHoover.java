package com.ronan.yotibackendtest.model;

public class RoboHoover {

    private Room room;
    private int posX;
    private int posY;
    private String instructions;


    public RoboHoover(int posX, int posY, String instructions, Room room) {
        this.room = room;
        this.posX = posX;
        this.posY = posY;
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

        }
    }

    private void clean() {
        //TODO: Implement mapping to from Cartesian to regular java
    }

    private void goWest() {
        if (posX != 0) {
            posX -= 1;
        }
    }

    private void goEast() {
        if (posX != room.getWidth()) {
            posX += 1;
        }
    }

    private void goSouth() {
        if (posY != 0) {
            posY -= 1;
        }
    }

    private void goNorth() {
        if (posY != room.getHeight()) {
            posY += 1;
        }
    }
}
