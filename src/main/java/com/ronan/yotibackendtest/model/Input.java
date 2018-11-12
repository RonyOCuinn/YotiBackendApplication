package com.ronan.yotibackendtest.model;

public class Input {

    private int[] roomSize;
    private int[] coords;
    private int[][] patches;
    private String instructions;

    public int[] getRoomSize() {
        return roomSize;
    }

    public int[] getCoords() {
        return coords;
    }

    public int[][] getPatches() {
        return patches;
    }

    public String getInstructions() {
        return instructions;
    }
}
