package com.ronan.yotibackendtest.model;

public class Room {

    private boolean[][] dirtMap;
    private int roomX;
    private int roomY;

    public Room(int roomX, int roomY, int[][] patches) {
        this.roomX = roomX;
        this.roomY = roomY;
        dirtMap = new boolean[roomX][roomY];

        for (int[] patch : patches) {
            int patchX = patch[0];
            int patchY = (roomY - 1) - patch[1];
            dirtMap[patchX][patchY] = true;
        }
    }


    public int getWidth() {
        return roomX;
    }

    public int getHeight() {
        return roomY;
    }

    public boolean cleanDirt(int arrayIndexX, int arrayIndexY) {

        if (validCoordinates(arrayIndexX, arrayIndexY) && dirtMap[arrayIndexX][arrayIndexY]){
            dirtMap[arrayIndexX][arrayIndexY] = false;
            return true;
        } else {
            return false;
        }
    }

    private boolean validCoordinates(int arrayIndexX, int arrayIndexY) {
        return arrayIndexX < getWidth() && arrayIndexX >= 0 && arrayIndexY < getWidth() && arrayIndexY >= 0;
    }
}
