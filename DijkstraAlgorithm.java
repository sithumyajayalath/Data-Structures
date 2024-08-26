package graph;

import java.util.*;  

public class DijkstraAlgorithm {  
    private int V; // Number of vertices  
    private LinkedList<Edge>[] adj; // Adjacency list  

    // Edge class to represent an edge with weight  
    static class Edge {  
        int dest;  
        int weight;  

        Edge(int dest, int weight) {  
            this.dest = dest;  
            this.weight = weight;  
        }  
    }  

    // Constructor  
    public DijkstraAlgorithm(int v) {  
        V = v;  
        adj = new LinkedList[v];  
        for (int i = 0; i < v; i++) {  
            adj[i] = new LinkedList<>();  
        }  
    }  

    // Add edge to the graph  
    public void addEdge(int u, int v, int weight) {  
        adj[u].add(new Edge(v, weight));  
        adj[v].add(new Edge(u, weight)); // For undirected graph  
    }  

    // Dijkstra's algorithm to find the shortest path from source  
    public int[] dijkstra(int src) {  
        int[] dist = new int[V];  
        Arrays.fill(dist, Integer.MAX_VALUE);  
        dist[src] = 0;  

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));  
        pq.add(new int[]{src, 0});  

        while (!pq.isEmpty()) {  
            int[] current = pq.poll();  
            int u = current[0];  

            for (Edge edge : adj[u]) {  
                int v = edge.dest;  
                int weight = edge.weight;  

                if (dist[u] + weight < dist[v]) {  
                    dist[v] = dist[u] + weight;  
                    pq.add(new int[]{v, dist[v]});  
                }  
            }  
        }  
        return dist;  
    }  

    public static void main(String[] args) {  
        DijkstraAlgorithm graph = new DijkstraAlgorithm(5);  
        graph.addEdge(0, 1, 10);  
        graph.addEdge(0, 2, 3);  
        graph.addEdge(1, 2, 1);  
        graph.addEdge(1, 3, 2);  
        graph.addEdge(2, 1, 4);  
        graph.addEdge(2, 3, 8);  
        graph.addEdge(2, 4, 2);  
        graph.addEdge(3, 4, 7);  
        
        int[] distances = graph.dijkstra(0);  
        
        System.out.println("Shortest distances from source vertex 0:");  
        for (int i = 0; i < distances.length; i++) {  
            System.out.println("Vertex " + i + ": " + distances[i]);  
        }  
    }  
}
