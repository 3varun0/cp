package com.vk.dsa.problem24;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This problem is from Leetcode and Hackerrank
 * Medium level problem.
 */
public class RottingOranges {

    public static void main(String[] args) {
        //Use case 1
        //int [][]grid = {{2,1,1}, {1,1,0},{0,1,1}}; // Output = 4

        //Use case 2
        //int [][]grid = {{2,1,1}, {0,1,1},{1,0,1}}; // Output = -1

        //Use case 3
        int [][]grid = {{0,2}}; // Output = 0

        int minTime = 0;
        Queue<Element> freshOranges = findFreshOranges(grid);

        if (freshOranges.isEmpty() && grid[0].length > 0) {
            minTime = 0;
        } else {
            if (freshOranges.isEmpty()) {
                minTime = -1;
            } else {
                minTime = timeToRotAllOranges(freshOranges, grid, minTime);
            }
        }
        System.out.println(minTime);
    }

    private static int timeToRotAllOranges(Queue<Element> freshOranges, int[][] grid, int minTime) {
        minTime++;

        Queue<Element> stillFresh = new LinkedList<>();
        Queue<Element> toBeRotten = new LinkedList<>();

        while (!freshOranges.isEmpty()) {
            Element e = freshOranges.poll();
            int i = e.i;
            int j = e.j;
            int r = grid.length;
            int c = grid[0].length;
            if (isValid(i-1, j, r, c) && 2 == grid[i-1][j] ||
                    isValid(i+1, j, r, c) && 2 == grid[i+1][j] ||
                    isValid(i, j-1, r, c) && 2 == grid[i][j-1] ||
                    isValid(i, j+1, r, c) && 2 == grid[i][j+1] ) {
                toBeRotten.offer(e);
            } else {
                stillFresh.offer(e);
            }
        }

        if (stillFresh.isEmpty()) {
            return minTime;
        }

        if (toBeRotten.isEmpty()) {
            return -1;
        } else {
            while(!toBeRotten.isEmpty()) {
                Element e2 = toBeRotten.poll();
                grid[e2.i][e2.j] = 2;
            }
        }
        return timeToRotAllOranges(stillFresh, grid, minTime);
    }

    private static boolean isValid(int i, int j, int r, int c) {
        return (i>=0 && i<r && j>=0 && j<c);
    }

    private static Queue<Element> findFreshOranges(int [][] grid) {
        Queue<Element> freshOranges = new LinkedList<>();
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[i].length; j++) {
                if (1 == grid[i][j]) {
                    freshOranges.offer(new Element(i, j));
                }
            }
        }
        return freshOranges;
    }
}
class Element {
    int i;
    int j;
    public Element (int i, int j) {
        this.i = i;
        this.j = j;
    }
}