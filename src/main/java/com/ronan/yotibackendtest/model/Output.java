package com.ronan.yotibackendtest.model;

import java.util.Arrays;

public class Output {

    private int[] coords;
    private int patches;

    public Output(int cartesianPosX, int cartesianPosY, int cleanCount) {
        coords = new int[] {cartesianPosX, cartesianPosY};
        patches = cleanCount;
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
