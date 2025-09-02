import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


public class Dijkstra {
    static class Edge {
        int src;
        int destination;
        int weight;

        public Edge(){}

        public Edge(int src, int destination, int weight){
            this.src=src;
            this.destination=destination;
            this.weight=weight;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }

    }

    public static void createGraph(List<Edge> graph[], int v){
        for(int i=0;i<v;i++){
            graph[i]= new ArrayList<>(); 
        }
        graph[0].add(new Edge(0,1,2));
        graph[0].add(new Edge(0,2,4));

        graph[1].add(new Edge(1,2,1));
        graph[1].add(new Edge(1,3,7));
        
        graph[2].add(new Edge(2,4,3));

        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
    }

    public static int[] dijkstra(List<Edge>graph[],int v){
        boolean[]visited= new boolean[v];
        int[]dist= new int[v];
        for(int i=1;i<v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        return dijkstra(graph, visited, dist);
    }

    private static int[] dijkstra(List<Dijkstra.Edge>[] graph, boolean[] visited, int[] dist) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            for(Pair p:pq){
                System.out.print("("+p.node+","+p.dist+")"+",");
            }
            System.out.println();
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]=true;

                for(Edge e : graph[curr.node]){
                    int u=e.src;
                    int v=e.destination;

                    if(dist[u]+e.weight<dist[v]){
                        dist[v]=dist[u]+e.weight;
                        pq.add(new Pair(v, dist[v]));
                    }
                    
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int v=6;
        List<Edge>graph[] = new ArrayList[v];
        createGraph(graph, v);
        System.out.println(Arrays.toString(dijkstra(graph,v)));
    }
}
