package Algorithms;
import java.util.*;
public class Graph {
    private final LinkedList<Integer>[] graph;

    public Graph(int n){
        graph=new LinkedList[n];
        for(int i=0;i<n;i++){
            graph[i]= new LinkedList<>();
        }
    }
    public void insert(int start,int end){
        graph[start].add(end);
        graph[end].add(start);
    }

    public void  bfs(int source,int destination){
        boolean []visited=new boolean[graph.length];
        int [] parent=new int[graph.length];
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        parent[source]=-1;
        visited[source]=true;

            while(!queue.isEmpty()){
                int curr=queue.poll();
                if(curr==destination) break;
                for (int neigbhor: graph[curr]){
                    if (!visited[neigbhor]){
                        visited[neigbhor]=true;
                        queue.add(neigbhor);
                        parent[neigbhor]=curr;
                    }
                }
            }

            int curr=destination;
            int distance=0;
        System.out.println("The Shortest path from "+source+" and "+ destination+" is:");
            while(parent[curr]!=-1){
                System.out.print(curr+"->");
                curr=parent[curr];
                distance++;
            }
            System.out.println();
            System.out.println("The smallest distance between the "+source+" and "+destination+" is :");
            System.out.println(distance);
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter th no. of vertices and edges");
        int n=sc.nextInt();
        int edge=sc.nextInt();
        Graph graph=new Graph(n);
        System.out.println("Enter "+edge+" Edges");
        for(int i=0;i<edge;i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            graph.insert(s, e);
        }
        graph.bfs(0,3);
    }
}
