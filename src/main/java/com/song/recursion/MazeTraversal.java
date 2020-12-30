package com.song.recursion;

public class MazeTraversal {

    public static void main(String[] args) {
        //递归-迷宫遍历问题
        int[][] map = new int[8][8];
        for (int i = 0; i < 8; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 1; i <= 6; i++) {
            map[i][0] = 1;
            map[i][7] = 1;
        }
        for (int i = 2; i <= 5; i++) {
            for (int j = 2; j <= 5; j++) {
                map[i][j] = 0;

            }
        }
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        setWay(map, 1, 1);
        System.out.println();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][6] == 2) {
            //已经找到终点
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i + 1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)) {
                    return true;
                } else if (setWay(map, i - 1, j)) {
                    return true;
                } else if (setWay(map, i, j - 1)) {
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
