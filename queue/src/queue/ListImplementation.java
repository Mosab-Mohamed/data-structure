package queue;

public class ListImplementation implements MyQueue {
	
	ListNode head = null ;
	ListNode tail = null ;
	
	
	public void enqueue(ListNode node){
		if( ! (this.isEmpty()) ){
			node.next = head ;
			head = node ;
		}
		else{
			node.next = head;
			head = node ;
			tail = node ;
		}
	}
	
	public ListNode dequeue(){
		ListNode backNode = tail  ;
		ListNode iterateNode = head  ;
		try{
			if(head==tail && head != null){
				head = null ;
				tail = null ;
			}
			else if(head.next== tail){
				tail = head ;
				head.next = null ;
			}
			else{
				for( int i = 0 ; i < this.size()-2 ;  i++){
					iterateNode = iterateNode.next ;
				}
				tail = iterateNode ;
				iterateNode.next = null ;
			}
			
		}
		catch(Exception e){
			System.out.println("error the queue is empyt ");
		}
		return backNode;
		
	}
	
	public boolean isEmpty(){
		if(head == null){
			return true;
		}
		return false;
	}
	
	public int size(){
		ListNode iterateNOde = head;
		int i;
		for(i=0 ; iterateNOde != null ; i++){
			iterateNOde = iterateNOde.next;
		}
		return i;
	}
	

}
