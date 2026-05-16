//Find the nearest zero
//use multisource bfs with zero as source
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] vis = new int[m][n];
        int[][] dis = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==0)
                q.add(new int[]{i,j});
            }
        }

        while(!q.isEmpty()){
            int[] popped = q.poll();
            int row = popped[0];
            int col = popped[1];

            int[] delrow = {0,1,0,-1};
            int[] delcol = {1,0,-1,0};

            for(int i=0;i<4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(nrow>=0 && ncol>=0 && nrow<m && ncol<n){
                    if(mat[nrow][ncol]==1 && vis[nrow][ncol]==0){
                        vis[nrow][ncol] = 1;
                        q.add(new int[]{nrow,ncol});
                        dis[nrow][ncol] = dis[row][col] + 1;
                    }
                }
            }

        }
        return dis;

    }
}