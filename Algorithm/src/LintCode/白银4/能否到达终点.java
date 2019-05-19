package LintCode.白银4;

/**
 给一个大小为 m*n 的map，1 代表空地，0 代表障碍物，9代表终点。请问如果你从 (0, 0) 开始能否到达终点？

 样例
 样例1

 输入:
 [
 [1,1,1],
 [1,1,1],
 [1,1,9]
 ]
 输出: true
 样例2

 输入:
 [
 [1,1,1],
 [1,0,0],
 [1,0,9]
 ]
 输出: false
 */
public class 能否到达终点 {
    public static void main(String[] args) {
        int[][] map = new int[][]{
                {1,1,1,1,0,1},
                {0,1,0,0,0,0},
                {1,0,0,0,1,0},
                {0,0,1,1,1,0},
                {1,1,0,0,0,0},
                {1,9,1,1,0,0}
        };
        System.out.println(new 能否到达终点().reachEndpoint(map));
        //System.out.println(reachEndpoint2(map));
    }

    /**
     * @param map: the map
     * @return: can you reach the endpoint
     */
    public boolean reachEndpoint(int[][] map) {
        int x = map[0].length;
        int y = map.length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (map[i][j] == 9) {
                    f(map,0,0,j,i);
                    break;
                }
            }
        }
        return flag;

    }

    boolean flag = false;

    public void f(int[][] map,int x,int y,int tox,int toy) {
        if (x == tox && y == toy) {
            flag = true;
            return;
        }
        if (flag ) {
            return;
        }

        if (x < tox && (map[y][x+1] == 1 || map[y][x+1] == 9)) {
            f(map,x+1,y,tox,toy);
        }
        if (y < toy && (map[y+1][x] == 1 || map[y+1][x] == 9)) {
            f(map,x,y+1,tox,toy);
        }
    }

    public static boolean reachEndpoint2(int[][] map) {
        int R=map.length;
        if(R==0)
            return false;
        int C=map[0].length;
        return dfs(R,C,0,0,map);
    }

    private static boolean dfs(int R, int C, int x, int y, int[][] map){

        if(map[x][y]==0)
            return false;

        if(map[x][y]==9)
            return true;

        if(y+1<R && dfs(R,C,x,y+1,map))
            return true;
        if(x+1<C && dfs(R,C,x+1,y,map))
            return true;

        return false;
    }
}
