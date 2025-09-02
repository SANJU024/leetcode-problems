import java.util.*;

public class BellmanFord {
    public static class Edge{
        int src;
        int destination;
        int weight;

        public Edge(int src, int destination, int weight){
            this.src=src;
            this.destination=destination;
            this.weight=weight;
        }
    }

    public static void createGraph(List<Edge> graph[], int v){
        for(int i=0; i<v; i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,-4));

        graph[2].add(new Edge(2,3,2));

        graph[3].add(new Edge(3,4,4));

        graph[4].add(new Edge(4,1,-1));
    } 

    public static int[] bellmanFord(List<Edge> graph[], int v){
        int []dist= new int[v];
        for(int i=1;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        bellmanFord(graph, v,dist );
        return dist;
    }
    
    private static int[] bellmanFord(List<Edge>[] graph, int V, int[]dist) {
        for(int i=0;i<V-1;i++){
            for(int j=0;j<V;j++){
                for(Edge e:graph[j]){
                    int u=e.src;
                    int v=e.destination;
                    if(dist[u]!=Integer.MAX_VALUE && dist[v]>dist[u]+e.weight){
                        dist[v]=dist[u]+e.weight;
                    }
                }
            }
        }
        return dist;
    }
    public static void main(String[] args) {
        int v=5;
        List<Edge> graph[] = new ArrayList[v]; 
        createGraph(graph, v);

        System.out.println(Arrays.toString(bellmanFord(graph, v)));
    }
}
