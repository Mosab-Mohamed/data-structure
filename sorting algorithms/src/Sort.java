
public class Sort {

	public static void main(String[] args) {
		new Sort().start();

	}

	private void start() {
		
		int[] arr = {1,4,3,5,2,6};
		isertionSort(arr);

		
		
	}
	
	void isertionSort(int[] arr){
		
		int key ;
		
		for(int i=1 ; i<arr.length ; i++){
			key = arr[i];
			int j ; 
			for(j=i-1 ; j>=0 && arr[j]>key ; j--){
				arr[j+1] = arr[j] ;			//shifting elements to put key in the
											//right position 
			}
			arr[j+1] = key ;
		}
	}

}
