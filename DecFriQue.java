package qUE;

import java.util.TreeMap;

public class DecFriQue {

	private TreeMap<Integer, Integer> priorityQueue;

    public DecFriQue() {
        priorityQueue = new TreeMap<>();
    }

    public void enqueue(int value) {
        priorityQueue.put(value, value);
    }

    public int dequeue() {
        return priorityQueue.pollFirstEntry().getValue(); // Dequeues in order
    }

    public static void main(String[] args) {
    	DecFriQue queue = new DecFriQue();
        queue.enqueue(5);
        queue.enqueue(2);
        queue.enqueue(9);
        queue.enqueue(1);
        queue.enqueue(7);

        System.out.println("Dequeue elements:");
        while (!queue.priorityQueue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
}
}
