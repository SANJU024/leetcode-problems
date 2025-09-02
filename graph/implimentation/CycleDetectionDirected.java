import java.util.*;

public class CycleDetectionDirected {
    class Edge{
        int src;
        int destination;

        public Edge(int src, int destination){
            this.src=src;
            this.destination=destination;
        }
        public Edge(){}
    }

    public void createGraph(List<Edge>graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

    }

    public boolean detectCycle(List<Edge>[] graph,  int v ){
        boolean[] visited= new boolean[v];
        boolean[] recStack= new boolean[v];

        for(int i=0;i<v;i++){
            if(!visited[i]){
                if(dfs(graph, v, i, visited,recStack)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(List<Edge>[] graph,  int v ,int curr, boolean[]visited , boolean[]recStack){
        visited[curr]=true;
        recStack[curr]=true;
        System.out.print(curr+"->");
        for(Edge e: graph[curr]){
            int neighbour=e.destination;
            if(!visited[neighbour]){
                if(dfs(graph, v, neighbour, visited, recStack)){
                    return true;
                }
            }else if(recStack[neighbour]){
                return true;
            }
        }
        recStack[curr]=false;
        return false;
    }

    public static void main(String[] args) {
        int v=4;
        CycleDetectionDirected cd = new CycleDetectionDirected();
        List<Edge>graph[]= new ArrayList[v];
        cd.createGraph(graph,v);
        System.out.println(cd.detectCycle(graph,v));
    }
    
}
