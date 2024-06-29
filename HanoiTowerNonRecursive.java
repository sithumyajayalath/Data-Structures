package trees;

import java.util.Stack;

public class HanoiTowerNonRecursive {

	public static void main(String[] args) {
		
		int numDisks = 3;
        solveHanoi(numDisks, 'A', 'C', 'B');

	}
	
	 public static void solveHanoi(int numDisks, char source, char destination, char auxiliary) {
	        Stack<Integer> sourceStack = new Stack<>();
	        Stack<Integer> destinationStack = new Stack<>();
	        Stack<Integer> auxiliaryStack = new Stack<>();

	        // Initialize source stack with disks
	        for (int i = numDisks; i > 0; i--) {
	            sourceStack.push(i);
	        }

	        int moves = 0; // Keep track of the moves
	        while (!(destinationStack.size() == numDisks)) {
	            // Move a disk from one stack to another
	            if (sourceStack.isEmpty()) {
	                // If source is empty, move from auxiliary to destination
	                if (!auxiliaryStack.isEmpty()) {
	                    destinationStack.push(auxiliaryStack.pop());
	                    System.out.println("Move disk " + destinationStack.peek() + " from " + auxiliary + " to " + destination);
	                }
	            } else if (destinationStack.isEmpty() || sourceStack.peek() < destinationStack.peek()) {
	                // Move from source to destination if destination is empty or disk on source is smaller
	                destinationStack.push(sourceStack.pop());
	                System.out.println("Move disk " + destinationStack.peek() + " from " + source + " to " + destination);
	            } else {
	                // Move from source to auxiliary if destination is not empty and disk on source is larger
	                auxiliaryStack.push(sourceStack.pop());
	                System.out.println("Move disk " + auxiliaryStack.peek() + " from " + source + " to " + auxiliary);
	            }
	            moves++;
	        }
	        System.out.println("Total moves: " + moves);
	    }

}
