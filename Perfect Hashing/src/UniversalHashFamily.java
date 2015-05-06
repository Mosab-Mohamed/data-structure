import java.io.*;
import java.util.Random;

public class UniversalHashFamily {
	
	private int rowsNumber , columnsNumber ;
	
	
	public int[][] getHashFuction(int tableSize){
		
		if(tableSize==1)
			rowsNumber = 1 ;
		else 
			rowsNumber = Integer.toBinaryString(tableSize).length() -1 ;
		
		columnsNumber = 32 ;
		int[][] h = new int[rowsNumber][columnsNumber];
		Random rand = new Random();
		for(int i=0 ; i<rowsNumber ; i++){
			for(int j=0 ; j<columnsNumber ; j++){
				h[i][j] = rand.nextInt(2);
			}
		}
		return h ;
	}
	
	public int getRowsNumber(){
		return rowsNumber ;
	}
	
	public int getColumnsNumber(){
		return columnsNumber ;
	}
	
}
