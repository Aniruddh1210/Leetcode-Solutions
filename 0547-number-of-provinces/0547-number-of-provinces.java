class Solution {
    public static void dfs(int node, int[][] isConnected, int[] vis) {
        for (int it = 0; it < isConnected.length; it++) {
            if (isConnected[node][it] == 1 && vis[it] == 0) {
                vis[it] = 1;
                dfs(it, isConnected, vis);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int[] vis = new int[isConnected.length];
        int count = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (vis[i] == 0) {
                vis[i] = 1;
                count++;
                dfs(i, isConnected, vis);
            }
        }

        return count;
    }
}