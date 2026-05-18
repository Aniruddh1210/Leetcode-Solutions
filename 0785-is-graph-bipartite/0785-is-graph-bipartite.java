//adjacents can't have the same colour
//linear(graphs without cycle) can be bipartite
//Even cycle graphs can be bipartite
//Odd length cycle graphs can never be bipartite
//just keep giving the neighbours the opposite colour from the source node
//keep checking if neighbours are having alternate colour if they are already visited
//just use bfs

class Solution {

    public static boolean bfs(int val,int[][]graph, int[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(val);
        vis[val]=1;

        while(!q.isEmpty()){
            int node = q.poll();
            for(int it : graph[node]){
                if(vis[it]==vis[node]){
                    return false;
                }else if(vis[it]==0){
                    if(vis[node]==1){
                        vis[it]=2;
                    }else{
                        vis[it]=1;
                    }
                    q.add(it);
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        int[] vis = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (vis[i] == 0) {
                if (!bfs(i,graph, vis))
                    return false;
            }
        }
        return true;
    }
}