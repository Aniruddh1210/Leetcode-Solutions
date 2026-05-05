class Solution {

    public static void dfs(int oldcolour, int[][] image, int colour, int i, int j){

        if (oldcolour == colour) return ;

        image[i][j] = colour;

        if(i>0 && image[i-1][j] == oldcolour){
            dfs(oldcolour,image,colour, i-1,j);
        }
        if(j>0 && image[i][j-1] == oldcolour){
            dfs(oldcolour,image,colour, i,j-1);
        }
        if(i<image.length-1 && image[i+1][j] == oldcolour){
            dfs(oldcolour,image,colour, i+1,j);
        }
        if(j<image[0].length-1 && image[i][j+1] == oldcolour){
            dfs(oldcolour,image,colour, i,j+1);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int oldcolour = image[sr][sc];
        dfs(oldcolour,image,color,sr,sc);
        return image;
    }
}