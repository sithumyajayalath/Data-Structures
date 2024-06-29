package qUE;

import java.util.Stack;

public class ExStack {

	public static void main(String[] args) {
		
		// Create a stack of integers
		Stack<Integer> myStack = new Stack<>();

        // Push elements onto the stack
        myStack.push(10);
        myStack.push(20);
        myStack.push(30);

        // Print the stack's contents
        System.out.println("Stack: " + myStack); // Output: [10, 20, 30]

        // Peek at the top element
        System.out.println("Top element: " + myStack.peek()); // Output: 30

        // Pop elements from the stack
        System.out.println("Popped: " + myStack.pop());  // Output: 30
        System.out.println("Popped: " + myStack.pop());  // Output: 20

        // Check if the stack is empty
        System.out.println("Stack is empty? " + myStack.isEmpty()); // Output: false

        // Push another element
        myStack.push(40);

        // Print the stack's contents again
        System.out.println("Stack: " + myStack); // Output: [10, 40]
		

	}

}
