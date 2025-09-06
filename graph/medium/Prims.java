import java.util.*;
public class Prims {

    public static class Edge{
        int src;
        int destination;
        int weight;

        Edge(int src, int destination, int weight){
            this.src=src;
            this.destination=destination;
            this.weight=weight;
        }
    }

    public static class Pair implements Comparable<Pair>{
        int node;
        int cost;

        public Pair(int node, int cost){
            this.cost=cost;
            this.node=node;
        }

        @Override
        public int compareTo(Pair p2){
            return this.cost-p2.cost;
        }
    }

    public static void createGraph(List<Edge>graph[], int V){
        for(int i=0;i<V;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edge(0,1,10));
        graph[0].add(new Edge(0,2,15));
        graph[0].add(new Edge(0,3,30));

        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,3,40));

        graph[2].add(new Edge(2,0,15));
        graph[2].add(new Edge(2,3,50));

        graph[3].add(new Edge(3,0,30));
        graph[3].add(new Edge(3,1,40));
        graph[3].add(new Edge(3,2,50));

    }

    public static void primsAlgo(List<Edge>graph[], int V){
        boolean[] visited =  new boolean[V];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(0,0));

        int mstCost=0;
        while(!pq.isEmpty()){
            Pair curr = pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                mstCost+=curr.cost;
                for(Edge e:graph[curr.node]){
                    if(!visited[e.destination]){
                        pq.add(new Pair(e.destination, e.weight));
                        System.out.println(pq);
                    }
                }
            }
        }
        System.out.println("mstCost:"+mstCost);
    }

    public static void main(String[] args) {
        int v=4;
        List<Edge>graph[]=new ArrayList[v];
        createGraph(graph, v);
        primsAlgo(graph,v);
    }
}
