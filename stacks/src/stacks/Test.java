package stacks;

public class Test {

	public static void main(String[] args) {

		Stack l =new Stack();
		ListNode node1 = new ListNode('a');
		ListNode node2 = new ListNode('b');
		ListNode node3 = new ListNode('c');
		ListNode node4 = new ListNode('d');
		ListNode node5 = new ListNode('e');
		ListNode node6 = new ListNode('h');
		
		l.pop();
		l.push(node1);
		l.push(node2);
		l.push(node3);
		l.push(node4);
		l.push(node5);
		l.push(node6);
		
		System.out.println(l.size());
		System.out.println();
		System.out.println(l.pop().value);
		System.out.println(l.pop().value);
		System.out.println(l.pop().value);
		System.out.println();
		System.out.println(l.size());
		System.out.println();
		System.out.println(l.peek().value);
		System.out.println();
		System.out.println(l.size());
		System.out.println();
		
		System.out.println(l.pop().value);
		System.out.println(l.pop().value);
		System.out.println(l.pop().value);
		if(l.isEmpty()){
			System.out.println("hhhhhhhhhhhhh");
		}
		

	}

}