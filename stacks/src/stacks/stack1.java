package stacks;

public class stack1 implements MyStack1{
	
	 ListNode1 head;
	
	public void push(ListNode1 newNode){
		newNode.next=head;
		head=newNode;
	}
	
	public ListNode1 pop(){
		ListNode1 element = head;
		try{
		head=element.next;
		element.next=null;
		}
		catch(Exception e){
			System.out.println("Stack is empty");
		}
		return element ;
	}
	
	public ListNode1 peek(){
		return head ;
	}
	
	public boolean isEmpty(){
		if(head==null)
			return true;
		else
			return false;
		}
	
	public int size(){
		int counter=0;
		ListNode1 IteratNode= head ;
		while(IteratNode!= null){
			counter++;
			IteratNode=IteratNode.next;	
		}
		return counter;
		}


}
