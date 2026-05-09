class Solution {

    public static int bfs(int[][]grid,Queue<int[]>q){

        int maxtime = 0;

        while(!q.isEmpty()){
        
        int[] vals = q.poll();
        int row = vals[0];
        int col = vals[1];
        int time = vals[2];

        maxtime = Math.max(maxtime,time);


        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};


        for(int i=0;i<4;i++){

            int newrow = row + delrow[i];
            int newcol = col + delcol[i];

            if(newrow>=0 && newrow<grid.length && newcol>=0 && newcol<grid[0].length){
                if(grid[newrow][newcol]==1){
                    grid[newrow][newcol]=2;
                    q.add(new int[]{newrow,newcol,time+1});
                }
            }
        }
        }
        return maxtime;

    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        int flag = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2)
                    q.add(new int[] { i, j, 0 });
            }
        }

        if (q.isEmpty()) {
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1) return -1;
                return 0; // ✅ no rotten, no fresh → 0
        }   

        int time = bfs(grid, q);

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    return -1;

        return time;
    }
}