
public class AVLTree extends Throwable {

	private Node root = null ;
	private int size ;
	
	public int getTreeHeight(){
		if(root==null)
			return -1 ;
		return Math.max(height(root.rightChild), height(root.leftChild)) +1 ;
	}
	
	public int getSize(){
		return size;
	}

	public Node getRoot(){
		return root ;
	}
	
	private int height( Node node ){
		if(node==null)
			return -1;
		else
			return node.getHeight();
	}
	
	public void insertNode(Node newNode){
		root = insert(newNode,root);
		size++;
	}
	
	public void deleteNode(String value){
		root = remove(value,root);
		size--;
		
	}
	
	public Node search(String value) throws NullPointerException{
		Node searchNode = root ;
		boolean found = false ;	
		while( searchNode!=null ){

			int compareResult = value.compareToIgnoreCase( searchNode.getNodeValue() ) ;
			if(value.equals( searchNode.getNodeValue() )){
				found = true ;
				break ;
			}
			
			else if(compareResult>0)
				searchNode = searchNode.getRightChild() ;
				
			else
				searchNode = searchNode.getLeftChild() ;
		}
		if(found)
			return searchNode ;
		else
			throw new NullPointerException() ;
	}
	
	//return the new root of the sub tree which old root is "root"
	public Node insert(Node newNode , Node root){
		
		if(root==null)
			return newNode;
		
		String nodeValue = newNode.getNodeValue();
		int compareResult = nodeValue.compareToIgnoreCase(root.getNodeValue());
		
		if(compareResult>0)
			root.rightChild = insert(newNode,root.rightChild);
		
		else if(compareResult<=0)
			root.leftChild = insert(newNode,root.leftChild);
		
		return balance(root);
	}

	private Node balance(Node root) {

		if(root==null)
			return root;
		
		if( height( root.leftChild ) - height( root.rightChild ) > 1){           //left subtree deeper than right
			
			if(height(root.leftChild.leftChild) - height(root.leftChild.rightChild) >= 0 )         //left then left
				return rotateWithLeftChild( root );
			
			else{            //left then right (double rotation with left subtree)
				root.leftChild = rotateWithRightChild(root.leftChild) ;
				return rotateWithLeftChild(root);
			}
			
		}
		
		else if(height( root.leftChild ) - height( root.rightChild ) < -1){     //right subtree deeper than left
			
			if(height(root.rightChild.rightChild) >= height(root.rightChild.leftChild)  )         //right the right
				return rotateWithRightChild( root ); 
			
			else{                                               //right then left
				root.rightChild = rotateWithLeftChild(root.rightChild) ;
				return rotateWithRightChild(root);
			}
			
		}
		root.height = Math.max(height(root.leftChild), height(root.rightChild) ) + 1;
		return root;
	}

	private Node rotateWithRightChild(Node root) {
		Node newRoot = root.rightChild;
		root.rightChild = newRoot.leftChild ;
		newRoot.leftChild = root ;
		
		root.height = Math.max( height(root.leftChild), height(root.rightChild) ) +1 ;
		newRoot.height = Math.max( height(newRoot.leftChild), height(newRoot.rightChild) ) +1 ;
		return newRoot;
	}

	private Node rotateWithLeftChild(Node root) {
		
		Node newRoot = root.leftChild;
		root.leftChild = newRoot.rightChild ;
		newRoot.rightChild = root ;
		
		root.height = Math.max( height(root.leftChild), height(root.rightChild) ) +1 ;
		newRoot.height = Math.max( height(newRoot.leftChild), height(newRoot.rightChild) ) +1 ;
		return newRoot;
	}
	
	
	public Node remove( String value, Node root ) // put the left most of the right
	{                                             // child for the deleted node 
		if( root == null )                        // instead of deleted node and balance it
			return root; // base case ( return root if "value" not found )
	
		int compareValue = value.compareToIgnoreCase(root.getNodeValue());
		
		if( compareValue < 0 )
			root.leftChild = remove( value, root.leftChild ); //go left
		
		else if( compareValue > 0 )
			root.rightChild = remove( value, root.rightChild ); //go right
		
		else if( root.leftChild != null && root.rightChild != null ){ //2 children
			root.setNodeValue( findMin( root.rightChild ).getNodeValue() );
			root.rightChild = remove( root.getNodeValue() , root.rightChild );  //to delete the successor node
		}
		
		else{ // if one of 2 children =null or both=null
		      // then this child is the predecessor or we will the delete the node that we take the value of successor from it
			if(root.leftChild != null)
				root = root.leftChild ;
			else
				root = root.rightChild ;
		}
		
		return balance( root ); //balance each node of the affected bath
	}

	private Node findMin(Node root) {
		Node minNode ;
		if(root.leftChild==null)
			return root;
		else{
			minNode = findMin(root.leftChild);
		}
		
		return minNode;
	}
	
	public void print(Node root){
		if(root==null)
			return;
		
		print(root.leftChild);
		System.out.print( root.getNodeValue()+" " );
		print(root.rightChild);
	}
	
}
