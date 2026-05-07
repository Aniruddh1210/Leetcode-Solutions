import java.util.*;

class Solution {
    public int orangesRotting(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                q.add(new int[]{i,j,0});
                }
            }
        }

        int maxtime = 0;

        int n = grid.length;
        int m = grid[0].length;

        while(!q.isEmpty()){

            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            int time = curr[2];

            maxtime = Math.max(time,maxtime);

            int[] delRow = {-1,0,1,0};
            int[] delCol = {0,+1,0,-1};

            for(int i=0;i<4;i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m) {
                    if(grid[nrow][ncol]==1){
                        grid[nrow][ncol]=2;
                        q.add(new int[]{nrow,ncol,time+1});
                    }
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return maxtime;
    }
}