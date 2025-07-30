import java.security.spec.ECFieldF2m;
import java.util.ArrayList;
import java.util.List;

public class WithWeights {


    static class Edge{
        int weight;
        int src;
        int destination;

        public Edge(){

        }

        public Edge(int src, int destination, int weight){
            this.src=src;
            this.weight=weight;
            this.destination=destination;
        }

        @Override
        public String toString(){
            return "("+src+" "+destination+" "+weight+")";
        } 
    }
    public  List<Edge>[] createGraph(){
        int size=4;
        List<Edge> graph[] = new ArrayList[size];
        for(int i=0;i<size;i++){
            graph[i]= new ArrayList<Edge>();
        }  
        
        graph[0].add(new Edge(0,2,2));

        graph[1].add(new Edge(1,2,10));
        graph[1].add(new Edge(1,3,0));

        graph[2].add(new Edge(2,0,2));
        graph[2].add(new Edge(2,1,10));
        graph[2].add(new Edge(2,3,-1));

        graph[3].add(new Edge(3,1,0));
        graph[3].add(new Edge(3,2,-1));

        return graph;
    }
    
    public static void main(String[] args) {
        WithWeights obj = new WithWeights();
        List<Edge>[] graph=obj.createGraph();

        for(int i=0;i<graph.length;i++){
            System.out.print("Edges from node "+i+": ");
            for( Edge edge : graph[i]){
                System.out.print(edge+ " ");
            }
            System.out.println();
        }
        
    }

}
