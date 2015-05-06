
public class Heap {
	
	private int[] heap ;
	private int last = -1 ;
	private int size ;
	
	public Heap(int size ){
		this.size = size ;
		heap = new int[size] ;
	}
	
	public Heap buildHeap(int[] arr){
		this.heap = arr ;
		this.last = arr.length-1 ;
		this.size = arr.length;
		for(int i=getParent(last) ; i>=0 ; i--){
			this.heapifyDown(i);
		}
		
		return this ;
	}
	
	void heapifyUp(int index){
		int parentInd = getParent(index) ;
		while( parentInd!=-1 && heap[index]>heap[parentInd] ){
			int tmp = heap[parentInd];
			heap[parentInd] = heap[index];
			heap[index] = tmp ;
			index = parentInd ;
			parentInd = getParent(index) ;
		}
	}
	
	void heapifyDown(int index){
		int rightInd = getright(index);
		int leftInd = getleft(index);
		while( (rightInd<=last || leftInd<=last) && rightInd<size && leftInd<size){
			
			if(heap[index]>=heap[rightInd] && heap[index]>=heap[leftInd]){
				break ;
			}
			int tmp ;
			if(heap[rightInd] >= heap[leftInd] && rightInd<=last){
				
				tmp = heap[index] ;
				heap[index] = heap[rightInd];
				heap[rightInd] = tmp ;
				index = rightInd ;
			}
			else if(heap[leftInd] > heap[rightInd] && leftInd<=last){
				tmp = heap[index] ;
				heap[index] = heap[leftInd];
				heap[leftInd] = tmp ;
				index = leftInd ;
			}
			rightInd = getright(index);
			leftInd = getleft(index);
		}
	}
	
	public int getMax(){
		if(last<0)
			return -1 ;
		
		else
			return heap[0];
	}
	
	int removeMax(){
		if(last<0)
			return -1 ;
		
		else{
			int returnedValue = heap[0];
			int index = 0 ;
			heap[0] = heap[last--] ;
			heapifyDown(index);
			return returnedValue ;
		}
			
		
	}
	 
	void insert(int value){
		if(last==heap.length-1)
			amplifyHeapSize();
		heap[++last] = value ;
		heapifyUp(last);
	}
	
	private void amplifyHeapSize() {
		int[] copy = heap.clone();
		heap = new int[2*copy.length];
		for(int i=0 ; i<=last ; i++){
			heap[i] = copy[i];
		}
		
	}

	private int getParent(int index){
		if(index!=0)
			return (index-1)/2 ;
		
		else return -1 ;
	}
	
	private int getright(int index){
		return (2*index)+2 ;
	}
	
	private int getleft(int index){
		return (2*index)+1 ;
	}
	
	void print(){
		for(int i=0 ; i<=last ; i++){
			System.out.print(heap[i]+"..");
		}
		System.out.println();
	}
	
	public int[] getSortedArray(){
		int[] arr = new int[last+1];
		for(int i=0 ; i<arr.length ; i++){
			arr[i] = this.removeMax();
		}
		return arr ;
	}
	
	

}
