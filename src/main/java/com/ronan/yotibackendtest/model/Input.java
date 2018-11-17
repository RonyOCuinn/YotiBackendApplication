package com.ronan.yotibackendtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Input {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private int[] roomSize;
    private int[] coords;
    private int[][] patches;
    private String instructions;

    public void setRoomSize(int[] roomSize) {
        this.roomSize = roomSize;
    }

    public void setCoords(int[] coords) {
        this.coords = coords;
    }

    public void setPatches(int[][] patches) {
        this.patches = patches;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

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
