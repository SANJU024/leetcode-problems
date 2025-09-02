import java.util.ArrayList;
import java.util.List;

public class DetectCycleUndirected {
    
    static class Edge {
        int src;
        int destination;

        public Edge(){

        }

        public Edge(int src, int destination){
            this.src=src;
            this.destination=destination;
        }
        
    }

    public static void createGraph(List<Edge> graph[], int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1));
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,4));

        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,3));
        graph[4].add(new Edge(4,5));

    }

    public static boolean isCycle(List<Edge>graph[], int v){
        boolean[] visited=new boolean[v];
        return isCycle(graph, v, visited,-1,0);
    }

    public static boolean isCycle(List<Edge>graph[], int v, boolean[]visited, int parent, int curr){
        visited[curr]=true;

        for(Edge e:graph[curr]){
            int neighbour=e.destination;
            if(visited[neighbour] && parent!=neighbour){
                return true;
            }else if(!visited[neighbour]){
                if(isCycle(graph, v, visited, curr, neighbour)){
                    return true;
                }
            }
        }
        return false;
        
    }

    public static void main(String[] args) {
        int v=6;
        List<Edge> graph[] = new ArrayList[v];
        createGraph(graph, v);

        System.out.println(isCycle(graph, v));
    }
    
}