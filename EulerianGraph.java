package graph;

import java.util.*;  

public class EulerianGraph {  
    private int V; // Number of vertices  
    private LinkedList<Integer>[] adjce; // Adjacency list  

    // Constructor  
    public EulerianGraph(int v) {  
        V = v;  
        adjce = new LinkedList[v];  
        for (int i = 0; i < v; i++) {  
            adjce[i] = new LinkedList<>();  
        }  
    }  

    // Add edge to the graph  
    public void addEdge(int v, int w) {  
        adjce[v].add(w);  
        adjce[w].add(v); // For undirected graph  
    }  

    // Check if the graph is Eulerian  
    public boolean isEulerian() {  
        int oddCount = 0;  
        for (int i = 0; i < V; i++) {  
            if (adjce[i].size() % 2 != 0) {  
                oddCount++;  
            }  
        }  
        return (oddCount == 0 || oddCount == 2);  
    }  

    // Print Eulerian path or circuit  
    public void printEulerianPath() {  
        if (!isEulerian()) {  
            System.out.println("Graph is not Eulerian");  
            return;  
        }  
        // Find a starting point  
        int startVertex = 0;  
        for (int i = 0; i < V; i++) {  
            if (adjce[i].size() % 2 != 0) {  
                startVertex = i;  
                break;  
            }  
        }  
        // Create a stack to store the path  
        Stack<Integer> stack = new Stack<>();  
        List<Integer> path = new ArrayList<>();  
        stack.push(startVertex);  

        while (!stack.isEmpty()) {  
            int currVertex = stack.peek();  
            if (adjce[currVertex].size() == 0) {  
                path.add(currVertex);  
                stack.pop();  
            } else {  
                int nextVertex = adjce[currVertex].get(0);  
                stack.push(nextVertex);  
                adjce[currVertex].remove((Integer) nextVertex);  
                adjce[nextVertex].remove((Integer) currVertex);  
            }  
        }  

        // Print the path  
        System.out.println("Eulerian Path: " + path);  
    }  

    public static void main(String[] args) {  
        EulerianGraph graph = new EulerianGraph(5);  
        graph.addEdge(0, 1);  
        graph.addEdge(0, 2);  
        graph.addEdge(1, 2);  
        graph.addEdge(1, 3);  
        graph.addEdge(2, 3);  
        graph.addEdge(3, 4);  

        graph.printEulerianPath();  
    }  
}