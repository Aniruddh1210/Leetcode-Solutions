class Solution {

    public static void dfs(char[][]board,int[][]vis,int r, int c){
        int[] delrow = {0,1,0,-1};
        int[] delcol = {1,0,-1,0};
        for(int i=0;i<4;i++){
            int nr = r + delrow[i];
            int nc = c + delcol[i];
            if(nr>=0 && nc>=0 && nr<board.length && nc<board[0].length){
                if(board[nr][nc]=='O'&& vis[nr][nc]==0){
                    vis[nr][nc] = 1;
                    dfs(board,vis,nr,nc);
                }
            }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(vis[i][j]==0 && board[i][j]=='O'){
                        vis[i][j]=1;
                        dfs(board,vis,i,j);
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }

    }
}