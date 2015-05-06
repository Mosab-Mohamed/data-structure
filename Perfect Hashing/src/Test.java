import java.io.*;
import java.util.*;


public class Test {

	public static void main(String[] args) {
		new Test().start();
//		new Test().write();

	}

	private void write() {
		try {
			Formatter f = new Formatter("keys1.txt");
			Random rand = new Random();
			for(int i=0 ; i<32 ; i++){
				
				f.format("%d\t", rand.nextInt());
			}
			f.close();
		} 
		
		catch (FileNotFoundException e) {
		}
		
	}

	private void start() {
		ON2SpaceSolution n2 = new ON2SpaceSolution();
		ONSpaceSolution n = new ONSpaceSolution() ;
		Scanner reader ;
		int[] set ;
		int size = 0 ;
		LinkedList[][] table ;
		LinkedList[] table2 ;
		
		try {
			 reader = new Scanner(new File("keys1.txt") );
			 while(reader.hasNextInt()){
				 reader.nextInt();
				 size++;
			 }
			 reader.close();
			 
			 set = new int[size];
			 reader = new Scanner(new File("keys1.txt") );
			 int i=0;
			 while(reader.hasNextInt()){
				 set[i] = reader.nextInt();
				 i++;
			 }
			 reader.close();
			 
			 n2.buildTable(set);
			 n.buildTable(set);
			 
			 table = n.getTable();
			 table2 = n2.getTable();
			 
			 int nSpaceCounter = 0 ;
			 
			 System.out.println("# of tries for O(N^2)-Space solution = "+ n2.getNumOfTries());
//			 System.out.println("the hash table : ");
//			 for(int j=0 ; j<table2.length ; j++){
//				 if(table2[j]==null )
//					 System.out.println("...");
//				 else
//					 System.out.println(table2[j]);
//			 }
			 System.out.println("n = "+size);
			 System.out.println("used space in this solution = "+table2.length);
			 System.out.println("\n");
			 
			 
			 System.out.println("# of tries for O(N)-Space solution = "+ n.getNumOfTries());
			 System.out.println("the hash table : ");
			 for(int j=0 ; j<table.length ; j++){
				 for(int k=0 ; k<table[j].length ; k++){
					 if(table[j][k]==null)
						 System.out.print("... ");
					 else
						 System.out.print(table[j][k]+" ");
					 
					 nSpaceCounter++;
				 }
				 System.out.println();
			 }
			 System.out.println("n = "+size);
			 System.out.println("used space in this solution = "+nSpaceCounter);
			 System.out.println("\n");
		
		} 
		catch (FileNotFoundException e) {
			System.out.println("file Not found !!");
		}
		
	}

}
