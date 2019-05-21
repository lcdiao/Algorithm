package LintCode.白银4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 给定一个由数字 0 和 1 组成的迷宫 maze，其中 0 表示空地，1 表示障碍物，每次移动只能走到四个相邻格子。你现在可以从 start[][] 中任选一个点作为出发点，在 endd[][] 中任选一个点作为终点，输出走这个迷宫最少需要多少步。
 题目保证起点和终点一定在空地上，并且保证问题有解。

 样例
 样例 1：

 输入：
 maze = [
 [0,0,0,0,0,0,0],
 [1,0,0,1,0,0,0],
 [0,0,1,0,1,0,0],
 [0,0,0,1,0,0,0],
 [0,0,0,0,1,0,0],
 [0,0,0,0,1,0,1],
 [0,1,0,0,0,0,0]],
 start = [[2,5],[4,2],[3,4]],
 endd = [[0,5],[3,0]]
 输出：2
 解释：
 我们起点选择 (2, 5)，终点选择 (0, 5)，最少走 2 步。
 样例 2：

 输入：
 maze = [
 [0,1,0,0],
 [0,0,0,1],
 [0,1,0,1],
 [1,0,1,1]
 ],
 start = [[0,0],[3,1]],
 endd = [[1,1],[0,2]]
 输出：2
 解释：
 我们起点选择 (0, 0)，终点选择 (1, 1)，最少走 2 步。
 注意事项
 迷宫大小 <= 200000
 len(starts), len(endd) <= 10000




 TODO lintcode只通过70%
 */
public class 超级迷宫 {
    public static void main(String[] args) {
        int[][] maze = new int[][]{
                {0,0,0,0,0,0,0},
                {1,0,0,1,0,0,0},
                {0,0,1,0,1,0,0},
                {0,0,0,1,0,0,0},
                {0,0,0,0,1,0,0},
                {0,0,0,0,1,0,1},
                {0,1,0,0,0,0,0}};
        int[][] start = new int[][]{{2,5},{4,2},{3,4}};
        int[][] endd = new int[][]{{0,5},{3,0}};
        System.out.println(getAns(maze,start,endd));
    }
    /**
     * @param maze: the map of maze
     * @param start: the start points
     * @param endd: the end points
     * @return: Return the minimal steps
     */
    public static int getAns(int[][] maze, int[][] start, int[][] endd) {
        if (maze == null) {
            return 0;
        }
        min = maze.length * maze[0].length;
        for (int i = 0; i<start.length;i++) {
            for (int j = 0; j < endd.length; j++) {
                f(maze,start[i][0],start[i][1],endd[j][0],endd[j][1],0);
            }
        }

        return min;
    }

    static int min = 99999;

    public static void f(int[][] maze,int x,int y,int tox,int toy,int count){
        if (x == tox && y == toy) {
            min = count;
            return;
        }
        if (count >= min) {
            return;
        }

        if (x-1 >= 0 && maze[x-1][y]==0) {
            maze[x-1][y]=1;
            f(maze,x-1,y,tox,toy,count+1);
            maze[x-1][y]=0;
        }
        if (y-1 >= 0 && maze[x][y-1]==0) {
            maze[x][y-1]=1;
            f(maze,x,y-1,tox,toy,count+1);
            maze[x][y-1]=0;
        }
        if (x+1 < maze.length && maze[x+1][y]==0) {
            maze[x+1][y]=1;
            f(maze,x+1,y,tox,toy,count+1);
            maze[x+1][y]=0;
        }
        if (y+1 < maze[x].length && maze[x][y+1]==0) {
            maze[x][y+1]=1;
            f(maze,x,y+1,tox,toy,count+1);
            maze[x][y+1]=0;
        }
    }
}
