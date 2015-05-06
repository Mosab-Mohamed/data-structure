package queue;

public class ArrayImplementation implements MyQueue1 {

	private int size ;
	int[] queue ;
	public ArrayImplementation(int n){
		size = n ;
		queue = new int[size];
	}
	
	private int head = -1;
	private int tail = -1;
	
	public void enqueue(int value){
		try{
			if(this.isFull()){
				System.out.println("the queue is full");
			}
			else{
				head++;
				head = (head) % size ;
				queue[head] = value ;
			}
			
		}
		catch(Exception e){
			System.out.println("error the queue is empyt ");
		}
		
	}
	
	public int dequeue(){
		try{
			if(head ==  tail && head != -1){
				head = -1;
				tail = -1;
				return -1;
			}
			if(this.isEmpty()){
				return -1;
			}
			tail++;
			tail = (tail) % size ;
			return queue[tail];
		}
		catch(Exception e){
			System.out.println("error the queue is empyt ");
		}
		return queue[tail];
	}
	
	public boolean isEmpty(){
		return head==tail && tail==-1;
	}
	
	public boolean isFull(){
		return (head==tail && head != -1) || (head == size-1 && tail==-1);
	}
	
	public int size(){
		return head - tail ;
		
	}

}
