class Solution {
    //using dfs
    //if any adj node is already coloured it means it can't be a bipartite
    //-1 means unvis

    public static boolean dfs(int[][] graph,int[] colours,int node,int colour){
        for(int it :graph[node]){
            if(colours[it]==-1){
                if(colours[node]==0){
                    colours[it]=1;
                    if(!dfs(graph,colours,it,1)) return false;
                }else{
                    colours[it]=0;
                    return dfs(graph,colours,it,0);
                }
            }else{
                if(colours[it]==colours[node]){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colours = new int[graph.length];
        Arrays.fill(colours,-1);

        for(int i=0;i<graph.length;i++){
            if(colours[i]==-1){
                colours[i]=0;
                if(!dfs(graph,colours,i,0))return false;
            }
        }    
        return true;
    }
}