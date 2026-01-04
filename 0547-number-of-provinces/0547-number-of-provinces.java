class Solution {

    private void dfs(int[][] grid,int[] visited,int node){
        visited[node] = 1;
        for(int i=0;i<grid[0].length;i++){
            if(grid[node][i]==1 && i!=node && visited[i]==0){
                dfs(grid,visited,i);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;

        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[0].length;j++){
                if(visited[i]==0){
                    count++;
                    dfs(isConnected,visited,i);
                }
            }
        }

        return count;
    }
}