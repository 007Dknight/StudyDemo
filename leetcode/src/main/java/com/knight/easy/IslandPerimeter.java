package com.knight.easy;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

 Answer: 16
 Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class IslandPerimeter {
    public int islandPerimeter1(int[][] grid) {
        int number = 0;
        int row = 0;
        int column = 0;
        for(int[] i : grid){
            for(int j : i){
                if(j == 1){
                    number++ ;
                }
            }
        }
        for(int i = 0;i<grid.length;i++){
            for(int j = 0; j < grid[i].length-1;j++){
                if(grid[i][j] == 1 && grid[i][j+1] == 1){
                    column++;
                }
            }
        }
        for(int i = 0;i<grid[0].length;i++){
            for(int j = 0; j < grid.length - 1;j++){
                if(grid[j][i] == 1 && grid[j+1][i] == 1){
                    row++;
                }
            }
        }
        return number * 4 - 2*(row+column);
    }

    /**
     * 有问题还是
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i = 0;i<grid.length-1;){
            for(int j = 0; j < grid[i].length - 1;){
                if((i == 0 || i == grid.length-1) && grid[i][j] == 1){
                    System.out.println("边" + i  + "j:" + j);
                    count++;
                }else if((j == 0 || j== grid.length-1) && (grid[i][j] == 1)){
                    System.out.println("列"+i + "j:" + j);
                    count++;
                }else if((grid[i][j] == 0 && grid[i][j+1] == 1) || (grid[i][j] == 1 && grid[i][j+1] == 0)||(grid[i][j] == 0 && grid[i+1][j] == 1) || (grid[i][j] == 1 && grid[i+1][j] == 0)){
                    System.out.println(i + "j:" + j);
                    count++;
                }
                j++;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        IslandPerimeter perimeter = new IslandPerimeter();
        int[][] a = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int[][] b = {{1}};
        System.out.println(perimeter.islandPerimeter1(b));
        System.out.println(perimeter.islandPerimeter(a));
    }

}
