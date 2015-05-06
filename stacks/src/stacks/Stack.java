package stacks;

public class Stack implements MyStack {
	
	ListNode head;
	
	public void push(ListNode newNode){
		newNode.next=head;
		head=newNode;
	}
	
	public ListNode pop(){
		
		ListNode element = head;
		try{
		head=element.next;
		element.next=null;
		}
		catch(Exception e){
			System.out.println("Stack is empty");
		}
		return element ;
	}
	
	public ListNode peek(){
		return head ;
	}
	
	public boolean isEmpty(){
		return head == null ;
		}
	
	public int size(){
		int counter=0;
		ListNode IteratNode= head ;
		while(IteratNode!= null){
			counter++;
			IteratNode=IteratNode.next;	
		}
		return counter;
	}

}
