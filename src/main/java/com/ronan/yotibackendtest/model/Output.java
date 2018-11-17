package com.ronan.yotibackendtest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Arrays;

@Entity
public class Output {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private int[] coords;
    private int patches;

    public Output(int cartesianPosX, int cartesianPosY, int cleanCount) {
        coords = new int[] {cartesianPosX, cartesianPosY};
        patches = cleanCount;
    }

    public Output(){

    }

    public int[] getCoords() {
        return coords;
    }

    public int getPatches() {
        return patches;
    }

    @Override
    public String toString() {
        return "I finished at: " + Arrays.toString(coords) +
                "\nNumber of patches I cleaned: " + patches;
    }
}
