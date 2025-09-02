import java.util.*;

public class CycleDetection {
    static class Edge{
        int src;
        int dest;

        Edge(){}
        Edge(int src, int dest){
            this.dest=dest;
            this.src=src;
        }
    }

    public static void createGraph(List<Edge> graph[], int v){
        for(int i=0;i<v;i++){
            graph[i]= new ArrayList<Edge>(); 
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 4)); 

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[1].add(new Edge(1, 4));


        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 2)); 

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[4].add(new Edge(4, 5));

        graph[5].add(new Edge(5, 4));

    }
    public static void main(String[] args) {
        int v=6;
        boolean[]visited=new boolean[v];
        List<Edge> graph[]= new ArrayList[v];
        createGraph(graph, v);

        System.out.println(detectCycle(graph,0,-1,visited));
    }

    public  static boolean detectCycle(List<Edge>[] graph, int curr, int parent, boolean[] visited ) {
        visited[curr]=true;

        for(Edge e: graph[curr]){
            int neighbour=e.dest;
            if(visited[neighbour]  && parent!=neighbour){
                    return true;
            }else if(!visited[neighbour]){
                if(detectCycle(graph, neighbour,curr, visited)){
                    return true;
                }
            }
        }
        return false;
    }
    
}