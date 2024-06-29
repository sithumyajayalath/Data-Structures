package qUE;

import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class EnqFriPrioQue {

	
		
		private PriorityQueue<Integer> priorityQueue;
	    private LinkedHashMap<Integer, Integer> enqueueOrder;

	    public EnqFriPrioQue() {
	        priorityQueue = new PriorityQueue<>();
	        enqueueOrder = new LinkedHashMap<>();
	    }

	    public void enqueue(int value) {
	        priorityQueue.offer(value);
	        enqueueOrder.put(value, value); // Store in LinkedHashMap for order
	    }

	    public int dequeue() {
	        int topValue = priorityQueue.poll(); 
	        enqueueOrder.remove(topValue); // Remove from LinkedHashMap
	        return topValue;
	    }

	    public static void main(String[] args) {
	    	EnqFriPrioQue queue = new EnqFriPrioQue();
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
