package list;

import java.util.PriorityQueue;

public class Priority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue <Integer> pq = new PriorityQueue<>(); //11 element limit
		
		pq.add(20);
		pq.add(40);
		pq.add(10);
		pq.add(100);
		pq.add(60);

		System.out.println(pq);
		System.out.println(pq.peek());
		pq.poll();
		System.out.println(pq);
		pq.toArray();
		System.out.println(pq);


	}

}
