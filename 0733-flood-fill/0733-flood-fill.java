class Solution {

    public void dfs(int[][] image, int sr, int sc, int color,int oldcolor){

        if(color==oldcolor){
            return;
        }

        image[sr][sc] = color;

        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow>=0 && nrow<image.length && ncol>=0 && ncol<image[0].length){
                if(image[nrow][ncol]==oldcolor){
                    dfs(image,nrow,ncol,color,oldcolor);
                }
            }
        } 
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolor = image[sr][sc];
        dfs(image,sr,sc,color,oldcolor);
        return image;
    }
}