import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private int src;
    private int destination;

    public int getSrc(){
        return this.src;
    }

    public int getDestination(){
        return this.destination;
    }

    Graph(){
    }

    Graph(int src, int destination){
        this.destination=destination;
        this.src=src;
    }
    public static void main(String[] args) {
        int v=7;
        List<Graph> graph[] = new ArrayList[v];
        createGraph(graph,v);
        
        bfs(graph);
        dfs(graph, 0, new boolean[graph.length]);
        System.out.println();

        List<List<Integer>> res = new ArrayList<>();
        boolean[]visited=new boolean[v];
        findPath(graph, visited,2, 6, new ArrayList<>(), res);
        
        System.out.println(res);
    }

    public static void bfs(List<Graph> graph[]){
        boolean[]visited = new boolean[graph.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0]=true;
        while(!q.isEmpty()){
            int curr=q.poll();
            System.out.print(curr+"->");
            for(Graph edge: graph[curr]){
                int neighbour=edge.destination;
                if(!visited[neighbour]){
                    q.offer(neighbour);
                    visited[neighbour]=true;
                }
            }
        }
        System.out.println();
    }

    public static void findPath(List<Graph> graph[],boolean[]visited,int src, int target,List<Integer> path,List<List<Integer>>res){
        if(src==target){
            path.add(src);
            res.add(new ArrayList<>(path));
            return;
        }
        path.add(src);
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Graph edge = graph[src].get(i);
            if(!visited[edge.destination]){
                findPath(graph, visited,edge.destination, target, path, res);
                path.remove(path.size()-1);
                visited[edge.destination]=false;
            }
        }
    }

    public static void dfs(List<Graph> graph[],int curr, boolean[]visited){
        System.out.print(curr+" ");
        visited[curr]=true;

        for(int i=0;i<graph[curr].size();i++){
            Graph edge = graph[curr].get(i);
            if(!visited[edge.destination]){
                dfs(graph, edge.destination, visited);
            }
        }
    }

    public static void createGraph(List<Graph> graph[],int v){
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<Graph>();
        }

        graph[0].add(new Graph(0, 1));
        graph[0].add(new Graph(0, 2));
        
        graph[1].add(new Graph(1, 0));
        graph[1].add(new Graph(1, 3));

        
        graph[2].add(new Graph(2, 0));
        graph[2].add(new Graph(2, 4));

        
        graph[3].add(new Graph(3, 1));
        graph[3].add(new Graph(3, 4));
        graph[3].add(new Graph(3, 5));

        graph[4].add(new Graph(4, 2));
        graph[4].add(new Graph(4, 3));
        graph[4].add(new Graph(4, 5));

        graph[5].add(new Graph(5, 3));
        graph[5].add(new Graph(5, 4));
        graph[5].add(new Graph(5, 6));

        graph[6].add(new Graph(6, 5));
    }

}
