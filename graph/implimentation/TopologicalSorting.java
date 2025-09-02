import java.util.*;

public class TopologicalSorting {
    static class Edge{
        int src;
        int destination;
        Edge(){}
        Edge(int src, int destination){
            this.src=src;
            this.destination=destination;
        }
    }
    public static void main(String[] args) {
        int v=6;
        List<Edge> graph[]= new ArrayList[v];
        createGraph(graph, v);
        
        boolean[]visited= new boolean[v];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<v;i++){
            if(!visited[i]){
                dfs(graph, visited,i,st); 
            }
        }
        System.out.println(st);
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
    }

    public static void dfs(List<Edge>graph[], boolean[]visited,int curr, Stack<Integer> st){
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            int neighbour=graph[curr].get(i).destination;
            if(!visited[neighbour]){
                dfs(graph, visited, neighbour, st);
            }
        }
        st.push(curr);
    }

    public static Stack<Integer> bfs(List<Edge>graph[], boolean[]visited, int ind,Stack<Integer> st){
        Queue<Integer> q = new LinkedList<>();
        q.offer(ind);
        visited[ind]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int i=0;i<graph[curr].size();i++){
                int neighbour=graph[curr].get(i).destination;
                if(!visited[neighbour]){
                    st.push(neighbour);
                    q.offer(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        return st;
    }

    public static void createGraph(List<Edge>graph[], int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<Edge>();
        }

        graph[2].add(new Edge(2,3));
       
        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }
}
