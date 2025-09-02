package medium;
import java.util.*;
class RatInMaze {
    public static List<String> findPath(int[][] grid) {
        //your code goes here
        List<String> ans= new ArrayList<>();
        int n = grid.length;
        boolean [][]visited= new boolean[n][n];
        helper(grid,visited,ans,0,0,n,"");
        System.out.println(ans.size());
        return ans;
    }

    public static void helper(int[][]grid,boolean[][] visited,List<String> ans,int i, int j, int n,String ds){
        if(i==n-1 && j==n-1){
            ans.add(ds);
            return;
        }
        
        visited[i][j]=true;
        if(i+1<n && grid[i+1][j]!=0 && !visited[i+1][j]){
            helper(grid,visited,ans,i+1,j,n,ds+"D");
        }

        if(j+1<n && grid[i][j+1]!=0 && !visited[i][j+1]){
            helper(grid,visited,ans,i,j+1,n,ds+"R");
        }

        if(i-1>=0 && grid[i-1][j]!=0 && !visited[i-1][j]){
            helper(grid,visited,ans,i-1,j,n,ds+"U");
        }

        if(j-1>=0 && grid[i][j-1]!=0 && !visited[i][j-1] ){
            helper(grid,visited,ans,i,j-1,n,ds+"L");
        }

        //right dia
        // if(j+1<n && i-1>0 && grid[i-1][j+1]!=0 && !visited[i-1][j+1]){
        //     helper(grid, visited, ans, i-1, j+1, n, ds+"Di");
        // }

        visited[i][j]=false;
    }
    public static void main(String[] args) {
        int[][]grid={
            {1,0,0,1},
            {1,1,1,1},
            {1,1,0,1},
            {1,0,0,1}
        };
        // System.out.println(findPath(grid));
        for(int i=1;i<=9;i++){
            char ch=(char)(5);
            System.out.println(ch);

        }
    }
}