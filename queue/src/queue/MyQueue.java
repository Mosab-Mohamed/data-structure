package queue;

public interface MyQueue {
	
	public void enqueue(ListNode item);
	public ListNode dequeue();
	public boolean isEmpty();
	public int size();

}
