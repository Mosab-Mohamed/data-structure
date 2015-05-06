import java.util.LinkedList;


public class HashFunction {

	int[][] h ;
	int columnsNumber , rowsNumber ;
	
	public HashFunction(int[][] h){
		this.h = h ;
	}
	
	public int getHashValue(int x,int tableSize){
		
		String binaryValue = Integer.toBinaryString(x);
		int numOfBits ;
		if(tableSize==1)
			return 0;
		
		numOfBits = Integer.toBinaryString(tableSize).length()-1;
//		System.out.println(tableSize+".."+numOfBits);
		int valueLength = binaryValue.length();
		int rowValue = 0 ;
		String returnedValue = "" ;
		int k ;
		
		for(int i=0 ; i<numOfBits ; i++){
			rowValue = 0 ;
			k=0 ;
			for(int j=32-valueLength ; j<32 ; j++){
				if(binaryValue.charAt(k)=='1')
					rowValue += h[i][j] ;
				
				k++;
			}
			returnedValue += Integer.toString(rowValue%2) ; 
		}
//		System.out.println("string value : "+returnedValue);
		return Integer.parseInt(returnedValue, 2);
	}
}
