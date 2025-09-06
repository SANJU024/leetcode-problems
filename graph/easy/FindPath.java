// package graph.easy;
import java.util.*;
public class FindPath {
    static class Edges{
        int src;
        int dest;
        int weight;

        Edges(){}

        Edges(int src, int dest, int weight){
            this.dest=dest;
            this.src=src;
            this.weight=weight;
        }
    } 
    static class Result{
            int minWeight=Integer.MAX_VALUE;
            String minPath="";
    }

    static class Pair implements Comparable<Pair>{
        int node;
        int dist;

        public Pair(){}

        public Pair(int n, int d){
            this.dist=d;
            this.node=n;
        }

        @Override
        public int compareTo(Pair p2){
            return this.dist-p2.dist;
        }

    }

    public static void dijkstra(List<Edges> graph[], int src, int V){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        boolean[]visited = new boolean[V];
        int dist[]= new int[V];
        for(int i=0;i<V;i++){
            if(src!=i){
                dist[i]=Integer.MAX_VALUE;
            }
        }
        pq.add(new Pair(0, 0));

        while(!pq.isEmpty()){
            Pair curr=pq.remove();
            if(!visited[curr.node]){
                visited[curr.node]=true;
                for(Edges e: graph[curr.node]){
                    int u=e.src;
                    int v=e.dest;
                    if(dist[u]+e.weight<dist[v]){//relaxation
                        dist[v]=dist[u]+e.weight;
                        pq.add(new Pair(v,dist[v]));
                    }
                }
            }
        }
        for(int i: dist){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
    //     int v=6;
    //     List<Edges> graph[]= new ArrayList[v];
    //     createGraph(graph);
    //     boolean[]visited= new boolean[v];
    //    dijkstra(graph, 0, v);
        int size=2;
        for(int i=0;i<size;i++){
            size+=1;
            System.out.println(size);
        }
    }

    public static void findPath(List<Edges> graph[], boolean[]visited,int curr,int dest,String path,int weight, Result res){
        if(curr==dest){
            if(weight<res.minWeight){
                res.minWeight=weight;
                res.minPath=path;
            }
            return;
        }
        visited[curr]=true;
        for(Edges e : graph[curr]){
            int neighbour = e.dest;
            if(!visited[neighbour]){
                findPath(graph, visited, neighbour, dest,path+neighbour,weight+e.weight,res);
            }
        }
        visited[curr]=false;
    }

    public static void createGraph(List<Edges> graph[]){
        for(int i=0;i<graph.length;i++){
            graph[i]=new ArrayList<>();
        }

        graph[0].add(new Edges(0, 1, 2));
        graph[0].add(new Edges(0, 2, 4));

        graph[1].add(new Edges(1, 2, 1));
        graph[1].add(new Edges(1, 3, 7));

        graph[2].add(new Edges(2, 4, 3));

        graph[3].add(new Edges(3, 5, 1));

        graph[4].add(new Edges(4, 3, 2));
        graph[4].add(new Edges(4, 5, 5));

    }
}
