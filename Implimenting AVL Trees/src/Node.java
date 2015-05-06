
public class Node {
	
	Node parent = null ;
	Node leftChild = null ;
	Node rightChild = null ;
	int height =-1 ;
	private String value ;
	
	public Node(String value,Node left,Node right){
		this.value = value ;
		this.leftChild = left ;
		this.rightChild = right ;
		height = 0;
	}
	
	public int getBalanceFactor(){
		return leftChild.getHeight() - rightChild.getHeight() ;
	}
	
	public Node getRightChild(){
		return rightChild ;
	}
	
	public Node getLeftChild(){
		return leftChild ;
	}
	
	public boolean isLeaf(){
		return leftChild==null && rightChild==null ;
	}
	
	public int getHeight(){
		return height ;
	}
	
	public String getNodeValue(){
		return value ;
	}
	
	public void setNodeValue(String value){
		this.value = value ;
	}
	
	public void incrementHeight(){
		height++;
	}
	
	public void decrementHeight(){
		height--;
	}
	
}
