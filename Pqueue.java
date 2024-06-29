package qUE;

import java.util.PriorityQueue;

public class Pqueue {

	public static void main(String[] args) {
		// Create a PriorityQueue (min-heap by default)
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        // Add elements to the priority queue
        priorityQueue.offer(5);
        priorityQueue.offer(2);
        priorityQueue.offer(9);
        priorityQueue.offer(1);
        priorityQueue.offer(7);

        // Print the elements in the priority queue (in sorted order)
        System.out.println("Elements in the priority queue (min-heap):");
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll()); // Poll returns and removes the smallest element
        }

        System.out.println("\n--------------------\n");

        // Create a PriorityQueue with a custom Comparator for a max-heap
        PriorityQueue<Integer> maxHeapPriorityQueue = new PriorityQueue<>(
                (a, b) -> b - a // Compare in reverse order (max-heap)
        );

        // Add elements to the max-heap priority queue
        maxHeapPriorityQueue.offer(5);
        maxHeapPriorityQueue.offer(2);
        maxHeapPriorityQueue.offer(9);
        maxHeapPriorityQueue.offer(1);
        maxHeapPriorityQueue.offer(7);

        // Print the elements in the priority queue (in reverse sorted order)
        System.out.println("Elements in the priority queue (max-heap):");
        while (!maxHeapPriorityQueue.isEmpty()) {
            System.out.println(maxHeapPriorityQueue.poll()); // Poll returns and removes the largest element

        }
	}

}
