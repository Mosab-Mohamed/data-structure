package queue;

public class Test {

	public static void main(String[] args) {
		Test j = new Test ();
//		j.userInterface1();
		j.userInterface2();
	}
	public void userInterface1(){
		ListImplementation k = new ListImplementation();
		ListNode node = new ListNode(6);
		ListNode node1 = new ListNode(6);
		ListNode node2 = new ListNode(6);
		ListNode node3 = new ListNode(6);
		if(k.isEmpty()){
			System.out.println("hhhhhhhhhhhhhh");
		}
		System.out.println(k.size());
		System.out.println(k.dequeue());
		k.enqueue(node);
		k.enqueue(node1);
		k.enqueue(node2);
		k.enqueue(node3);
		System.out.println(k.isEmpty());
		System.out.println(k.size());
		k.dequeue();
		k.dequeue();
		k.dequeue();
		k.dequeue();
		k.dequeue();
		System.out.println(k.size());
	}

	public void userInterface2(){
		ArrayImplementation k = new ArrayImplementation(6);
		k.enqueue(0);
		k.enqueue(1);
		k.enqueue(2);
		k.enqueue(3);
		k.enqueue(4);
		System.out.println(k.isFull());
		k.enqueue(5);
		System.out.println(k.isFull());
		k.enqueue(7);
		System.out.println(k.isFull());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.dequeue());
		System.out.println(k.isEmpty());


	}
}
