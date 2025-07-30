// package graph.implimentation;

import java.util.*;

public class ArrayOfLists {
    static class Edge{
        int source;
        int destination;

        public Edge(int source,int destination){
            this.destination=destination;
            this.source=source;
        }
        public Edge(){};
    }
    public static void main(String[] args) {
        int v=4;
        List<Edge> graph[] = new ArrayList[v];
        for(int i=0;i<v;i++){
            graph[i]= new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,2));
        graph[1].add(new Edge(1,3));

        graph[2].add(new Edge(2,0));
        graph[2].add(new Edge(2,1));
        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,2));

        for(int i=0;i<v;i++){
            for(int j=0;j<graph[i].size();j++){
                System.out.println(graph[i].get(j).source+","+graph[i].get(j).destination);
            }
            System.out.println();
        }
        
    }
    
}
