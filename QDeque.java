package qUE;
import java.util.ArrayDeque;
import java.util.Deque;

public class QDeque { // Renamed your class to QDeque, you can choose any other name

    public static void main(String[] args) {
        // Create a Deque using ArrayDeque
        Deque<String> deque = new ArrayDeque<>(); // Use ArrayDeque here

        // Add elements to the deque (both ends)
        deque.offerFirst("Apple");   // Add to the front
        deque.offerLast("Banana");    // Add to the back
        deque.offerLast("Cherry");   // Add to the back

        // Print the elements in the deque
        System.out.println("Elements in the deque: " + deque);

        // Access and remove elements from both ends
        String firstElement = deque.peekFirst();  // Access the first element
        System.out.println("First element: " + firstElement);

        String removedFirst = deque.pollFirst(); // Remove and return the first element
        System.out.println("Removed first element: " + removedFirst);

        String lastElement = deque.peekLast();  // Access the last element
        System.out.println("Last element: " + lastElement);

        String removedLast = deque.pollLast(); // Remove and return the last element
        System.out.println("Removed last element: " + removedLast);

        // Print the deque after removal
        System.out.println("Elements in the deque after removal: " + deque);
    }
}