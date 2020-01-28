package queues;

public class EmptyQueuedException extends Exception {
	
	public void EmptyQueuedException() {
		System.out.println("ERROR! Queue is empty!");
	}
}
