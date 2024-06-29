package trees;

public class HanoiTowerRecursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int numDisks = 3;
        solveHanoi(numDisks, 'A', 'C', 'B');
    }
	
	public static void solveHanoi(int numDisks, char source, char destination, char auxiliary) {
        if (numDisks == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
        } else {
            solveHanoi(numDisks - 1, source, auxiliary, destination);
            System.out.println("Move disk " + numDisks + " from " + source + " to " + destination);
            solveHanoi(numDisks - 1, auxiliary, destination, source);
        }
    }

}
