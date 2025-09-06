import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Kosaraju{
    public static class Edge{
        int src;
        int destination;

        public Edge(){}

        public Edge(int src, int destination){
            this.src=src;
            this.destination=destination;
        }
    }

    public static void createGraph(List<Edge>graph[], int v){
        for(int i=0;i<v;i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0,2));
        graph[0].add(new Edge(0,3));

        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,1));

        graph[3].add(new Edge(3,4));


    }

    public static Stack<Integer> topologicalSort(List<Edge>graph[],int v){
        Stack<Integer> st = new Stack<>();
        boolean[]visited=new boolean[v];
        topologicalSort(graph, v,st,visited,0);
        return st;
    }

    private static void topologicalSort(List<Edge>[] graph, int v, Stack<Integer> st, boolean[] visited, int curr) {
        
        visited[curr]=true;
        for(Edge e : graph[curr]){
            int neighbour=e.destination;
            if(!visited[neighbour]){
                topologicalSort(graph, v, st, visited, neighbour);
            }
        }
        st.push(curr);
    }

    public static void transposeGraph(List<Edge> graph[],List<Edge> transpose[]){
        for(int i=0;i<graph.length;i++){
            transpose[i]=new ArrayList<>();
        }
        for(int i=0;i<graph.length;i++){
            for(Edge e:graph[i]){
                transpose[e.destination].add(new Edge(e.destination,e.src));
            }
        }
    }

    public static List<List<Integer>> kosaraju(Stack<Integer>st, List<Edge>transpose[]){
        boolean[]visited= new boolean[transpose.length];
        List<List<Integer>>ans =new ArrayList<>();
        while(!st.isEmpty()){
            int curr=st.pop();
            if(!visited[curr]){
                List<Integer>ds =new ArrayList<>();
                kosaraju(st, transpose,visited,curr,ds);
                ans.add(ds);
            }
        }
        return ans;
    }

    private static void kosaraju(Stack<Integer> st, List<Edge>[] transpose, boolean[] visited, int curr,List<Integer>ds) {
        
        ds.add(curr);
        visited[curr]=true;
        for(Edge e:transpose[curr]){
            int neighbour=e.destination;
            if(!visited[neighbour]){
                kosaraju(st, transpose, visited, neighbour, ds);
            }
        }
    }

    public static void main(String[] args) {
        int v=5;
        List<Edge>graph[]= new ArrayList[v];

        createGraph(graph,v);
        Stack<Integer> st=topologicalSort(graph,v);
        List<Edge>transpose[]= new ArrayList[graph.length];
        transposeGraph(graph,transpose);
        System.out.println(kosaraju(st,transpose));
    }
}