//just do bfs or dfs from the boundary and the ones that are left are the ans
//just return the count of the unvisited ones

class Solution {

    public static int bfs(int[][] grid, int[][] vis, Queue<int[]> q){
        while(!q.isEmpty()){
            int[] val = q.poll();
            int row = val[0];
            int col = val[1];

            int[] delrow = {0,1,0,-1};
            int[] delcol = {1,0,-1,0};

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && ncol>=0 && nrow<grid.length && ncol<grid[0].length){
                    if(grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                        q.add(new int[]{nrow,ncol});
                        vis[nrow][ncol]=1;
                    }
                }
            }
        }
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        return count;
    }

    public int numEnclaves(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[grid.length][grid[0].length];
        int n = grid.length;
        int m = grid[0].length;

        //need to mark the boundaries visited before doing the bfs to ensure the corners 
        //are not put in the queue twice
        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && grid[i][0] == 1) {
                q.add(new int[]{i,0});
                vis[i][0] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && grid[0][j] == 1) {
                q.add(new int[]{0,j});
                vis[0][j] = 1;

            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i][m - 1] == 0 && grid[i][m - 1] == 1) {
                q.add(new int[]{i, m - 1});
                vis[i][m-1] = 1;
            }
        }

        for (int j = 0; j < m; j++) {
            if (vis[n - 1][j] == 0 && grid[n - 1][j] == 1) {
                q.add(new int[]{n - 1, j});
                vis[n-1][j]=1;
            }
        }

        return bfs(grid,vis,q);
    }
}