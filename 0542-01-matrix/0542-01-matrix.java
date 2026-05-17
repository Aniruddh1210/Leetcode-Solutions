//find the nearest 0

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int[][] dist = new int[mat.length][mat[0].length];
        int[][] vis = new int[mat.length][mat[0].length]; 
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new int[]{i,j});
                }
            }
        }       

        while(!q.isEmpty()){
            int[] val = q.poll();
            int row = val[0];
            int col = val[1];

            int[] delrow = {0,1,-1,0};
            int[] delcol = {1,0,0,-1};

            for(int i=0;i<4;i++){
                int nr = row + delrow[i];
                int nc = col + delcol[i];

                if(nr>=0 && nc>=0 && nr<mat.length && nc<mat[0].length){
                    if(mat[nr][nc]==1 && vis[nr][nc]==0){
                        dist[nr][nc] = dist[row][col] + 1;
                        vis[nr][nc]=1;
                        q.add(new int[]{nr,nc});
                    }
                }
            }
        }

        return dist;
    }
}