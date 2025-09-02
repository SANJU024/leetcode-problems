import java.util.*;

public class Province{
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                ans++;
                bfs(isConnected, n, i, visited);
            }
        }
        return ans;
    }

    public static void bfs(int[][] mat, int n, int curr, boolean[] visited) {
        visited[curr] = true;
        Queue<Integer> q = new LinkedList<Integer>(); 
        q.add(curr);

        while (!q.isEmpty()){
            int src = q.remove();
            for (int i=0;i<mat[src].length;i++) {  
                if (mat[src][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] mat = {
            {1,0,0,1},
            {0,1,1,0},
            {0,1,1,1},
            {1,0,1,1}
        };
        System.out.println(findCircleNum(mat));
    }
}


