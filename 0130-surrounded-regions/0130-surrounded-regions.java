//just mark the boundary O's and all its neighbours, don't change those O's change all the rest
//can use either bfs or dfs

class Solution {

    public static void bfs(int r, int c, char[][] board, int[][] vis) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { r, c });
        vis[r][c] = 1;

        int[] delrow = { 0, 1, 0, -1 };
        int[] delcol = { 1, 0, -1, 0 };

        while (!q.isEmpty()) {
            int val[] = q.poll();
            int row = val[0];
            int col = val[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if (nrow >= 0 && nrow < board.length && ncol >= 0 && ncol < board[0].length) {
                    if(board[nrow][ncol]=='O' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new int[]{nrow,ncol});
                    }
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        //Applying bfs/dfs for all the boundaries

        for (int i = 0; i < n; i++) {
            if (vis[i][0] == 0 && board[i][0] == 'O') {
                bfs(i, 0,board,vis);
            }
        }

        for (int j = 0; j < m; j++) {
            if (vis[0][j] == 0 && board[0][j] == 'O') {
                bfs(0, j,board,vis);
            }
        }

        for (int i = 0; i < n; i++) {
            if (vis[i][m - 1] == 0 && board[i][m - 1] == 'O') {
                bfs(i, m - 1,board,vis);
            }
        }

        for (int j = 0; j < m; j++) {
            if (vis[n - 1][j] == 0 && board[n - 1][j] == 'O') {
                bfs(n - 1, j,board,vis);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 0 && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

    }
}