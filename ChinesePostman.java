package graph;

import java.util.*;  

public class ChinesePostman {  
    private int V; // Number of vertices  
    private LinkedList<Edge>[] adj; // Adjacency list  
    private boolean[] visited; // To track visited edges  

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
    public ChinesePostman(int v) {  
        V = v;  
        adj = new LinkedList[v];  
        for (int i = 0; i < v; i++) {  
            adj[i] = new LinkedList<>();  
        }  
        visited = new boolean[v];  
    }  

    // Add edge to the graph  
    public void addEdge(int u, int v, int weight) {  
        adj[u].add(new Edge(v, weight));  
        adj[v].add(new Edge(u, weight)); // For undirected graph  
    }  

    // Find the shortest path using Dijkstra's algorithm  
    private int[] dijkstra(int src) {  
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

    // Find the total weight of the Eulerian circuit  
    public int findChinesePostman() {  
        int totalWeight = 0;  
        for (int i = 0; i < V; i++) {  
            for (Edge edge : adj[i]) {  
                totalWeight += edge.weight;  
            }  
        }  
        totalWeight /= 2; // Each edge is counted twice  

        // Check for odd degree vertices  
        List<Integer> oddVertices = new ArrayList<>();  
        for (int i = 0; i < V; i++) {  
            if (adj[i].size() % 2 != 0) {  
                oddVertices.add(i);  
            }  
        }  

        // If there are odd degree vertices, find the shortest path between them  
        if (oddVertices.size() > 0) {  
            int minPath = Integer.MAX_VALUE;  
            for (int i = 0; i < oddVertices.size(); i++) {  
                for (int j = i + 1; j < oddVertices.size(); j++) {  
                    int[] distFromI = dijkstra(oddVertices.get(i));  
                    minPath = Math.min(minPath, distFromI[oddVertices.get(j)]);  
                }  
            }  
            totalWeight += minPath; // Add the shortest path to make it Eulerian  
        }  

        return totalWeight;  
    }  

    public static void main(String[] args) {  
        ChinesePostman graph = new ChinesePostman(5);  
        graph.addEdge(0, 1, 10);  
        graph.addEdge(0, 2, 25);  
        graph.addEdge(1, 2, 5);  
        graph.addEdge(1, 3, 20);  
        graph.addEdge(2, 3, 10);  
        graph.addEdge(3, 4, 25);  

        int totalWeight = graph.findChinesePostman();  
        System.out.println("Total weight of the Chinese Postman route: " + totalWeight);  
    }  
}