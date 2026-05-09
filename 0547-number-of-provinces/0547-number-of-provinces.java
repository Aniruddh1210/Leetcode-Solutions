class Solution {

    public static void dfs(int i,int[][] isConnected, int[]vis){
        vis[i]=1;
        for(int j=0;j<isConnected[0].length;j++){
            if(vis[j]==0 && isConnected[i][j]==1){
                dfs(j,isConnected,vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int count = 0;


        for(int i=0;i<isConnected.length;i++){
            if(vis[i]==0){
                count++;
                dfs(i,isConnected,vis);
            }
        }

        return count;
    }
}