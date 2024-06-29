package qUE;
import java.util.LinkedList;
import java.util.Queue;

public class Que {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 // Create a Queue using LinkedList
        Queue<String> queue = new LinkedList<>();

        // Add elements to the queue
        queue.offer("Apple");
        queue.offer("Banana");
        queue.offer("Cherry");

        // Print the elements in the queue
        System.out.println("Elements in the queue: " + queue);

        // Access and remove the head element
        String headElement = queue.peek(); // Access the head without removing it
        System.out.println("Head element: " + headElement);

        String removedElement = queue.poll(); // Remove and return the head
        System.out.println("Removed element: " + removedElement);//output is[banana,cherry]

        // Print the queue after removal
        System.out.println("Elements in the queue after removal: " + queue);
    
		}

	}


