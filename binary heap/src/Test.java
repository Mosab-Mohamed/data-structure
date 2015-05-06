import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;


public class Test {

	public static void main(String[] args) {
		new Test().start();

	}
	
	void start(){
		Heap heap = new Heap(7);
		heap.insert(0);
		heap.print();
		heap.insert(1);
		heap.print();
		heap.insert(2);
		heap.print();
		heap.insert(3);
		heap.print();
		heap.insert(4);
		heap.print();
		heap.insert(5);
		heap.print();
		heap.insert(6);
		heap.print();
		heap.insert(7);
		heap.print();
		heap.insert(7);
		heap.print();
		heap.insert(7);
		heap.print();
		heap.insert(7);
		heap.print();
		heap.insert(7);
		heap.print();
		
		System.out.println();
		System.out.println("=================================");
		int[] arr = {0,1,2,516,947,0,646,196,65,7,8};
		heap = heap.buildHeap(arr);
		arr = heap.getSortedArray();
		System.out.println(arr.length);
		for(int i=0 ; i<arr.length ;i++){
			System.out.print(arr[i]+" ");
		}
		
//		
//		Formatter f ;
//		Random rand = new Random();
//		try {
//			f = new Formatter("test4.txt");
//			f.format("%d\n", 1000000);
//			for(int i=0 ; i<1000000 ; i++){
//				if(i==(1000000-1))
//					f.format("%d\n", rand.nextInt(1000000));
//				else
//					f.format("%d ", rand.nextInt(1000000));
//			}
//			f.close();
//		} 
//		catch (FileNotFoundException e1) {
//			System.out.println("error open file");
//		}
//		
		
		Scanner reader ;
		long startTime, endTime;
		Sort sort = new Sort();
		
		////////////////////////////////////////////////////
		/*first test*/
		
		System.out.println("\n=====================================");
		System.out.println("heap sort against O(n^2) sorting algorithm :");
		System.out.print("test #1 (n=20) : ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.nanoTime();
			t = heap.getSortedArray();
			endTime = System.nanoTime();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" nano sec )");
			startTime = System.nanoTime();
			t = sort.isertionSort(array);
			endTime = System.nanoTime();
			System.out.print("(insertion sort time = "+(endTime-startTime)+" nano sec )\n\n");
		}
		catch (FileNotFoundException e) {
			System.out.println("error test #1");
		}
		
		
		////////////////////////////////////////////////////
		/*second test*/
		
		System.out.println("=====================================");
		System.out.print("test #2 ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test2.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				System.out.print("(n="+size+") : ");
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.nanoTime();
			t = heap.getSortedArray();
			endTime = System.nanoTime();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" nano sec )");
			startTime = System.nanoTime();
			t = sort.isertionSort(array);
			endTime = System.nanoTime();
			System.out.print("(insertion sort time = "+(endTime-startTime)+" nano sec )\n\n");
		}
		catch (FileNotFoundException e) {
		System.out.println("error test #2");
		}
		
		////////////////////////////////////////////////////
		/*third test*/
		
		System.out.println("=====================================");
		System.out.print("test #3 ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test3.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				System.out.print("(n="+size+") : ");
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.currentTimeMillis();
			t = heap.getSortedArray();
			endTime = System.currentTimeMillis();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" milli sec )");
			startTime = System.currentTimeMillis();
			t = sort.isertionSort(array);
			endTime = System.currentTimeMillis();
			System.out.print("(insertion sort time = "+(endTime-startTime)+" milli sec )\n\n");
		}
		catch (FileNotFoundException e) {
		System.out.println("error test #3");
		}
		

		////////////////////////////////////////////////////
		/*fourth test*/
		
		System.out.println("=====================================");
		System.out.print("test #4 ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test4.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				System.out.print("(n="+size+") : ");
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.currentTimeMillis();
			t = heap.getSortedArray();
			endTime = System.currentTimeMillis();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" milli sec )");
			startTime = System.currentTimeMillis();
			t = sort.isertionSort(array);
			endTime = System.currentTimeMillis();
			System.out.print("(insertion sort time = "+(endTime-startTime)+" milli sec )\n\n");
		}
		catch (FileNotFoundException e) {
		System.out.println("error test #4");
		}
		

		/////////////////////////////////////////////////////////////////////
		
		
		////////////////////////////////////////////////////
		/*first test*/
		
		System.out.println("\n========================================================\n");
		System.out.println("heap sort against O(nlogn) sorting algorithm :");
		System.out.print("test #1 (n=20) : ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.nanoTime();
			t = heap.getSortedArray();
			endTime = System.nanoTime();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" nano sec )");
			startTime = System.nanoTime();
			t = sort.mergeSort(array);
			endTime = System.nanoTime();
			System.out.print("(merge sort time = "+(endTime-startTime)+" nano sec )\n\n");
		}
		catch (FileNotFoundException e) {
			System.out.println("error test #1");
		}
		
		
		////////////////////////////////////////////////////
		/*second test*/
		
		System.out.println("=====================================");
		System.out.print("test #2 ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test2.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				System.out.print("(n="+size+") : ");
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.nanoTime();
			t = heap.getSortedArray();
			endTime = System.nanoTime();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" nano sec )");
			startTime = System.nanoTime();
			t = sort.mergeSort(array);
			endTime = System.nanoTime();
			System.out.print("(merge sort time = "+(endTime-startTime)+" nano sec )\n\n");
		}
		catch (FileNotFoundException e) {
		System.out.println("error test #2");
		}
		
		////////////////////////////////////////////////////
		/*third test*/
		
		System.out.println("=====================================");
		System.out.print("test #3 ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test3.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				System.out.print("(n="+size+") : ");
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.currentTimeMillis();
			t = heap.getSortedArray();
			endTime = System.currentTimeMillis();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" milli sec )");
			startTime = System.currentTimeMillis();
			t = sort.mergeSort(array);
			endTime = System.currentTimeMillis();
			System.out.print("(merge sort time = "+(endTime-startTime)+" milli sec )\n\n");
		}
		catch (FileNotFoundException e) {
		System.out.println("error test #3");
		}
		

		////////////////////////////////////////////////////
		/*fourth test*/
		
		System.out.println("=====================================");
		System.out.print("test #4 ");
		try {
			int[] array = null ;
			reader = new Scanner(new File("test4.txt"));
			while(reader.hasNext()){
				int size = reader.nextInt();
				System.out.print("(n="+size+") : ");
				array = new int[size];
				for(int i=0 ; i<size ; i++){
					array[i] = reader.nextInt();
				}	
			}
			int[] t;
			heap = heap.buildHeap(array);
			startTime = System.currentTimeMillis();
			t = heap.getSortedArray();
			endTime = System.currentTimeMillis();
			
			System.out.print("(heap sort time = "+(endTime-startTime)+" milli sec )");
			startTime = System.currentTimeMillis();
			t = sort.mergeSort(array);
			endTime = System.currentTimeMillis();
			System.out.print("(merge sort time = "+(endTime-startTime)+" milli sec )\n\n");
		}
		catch (FileNotFoundException e) {
		System.out.println("error test #4");
		}
		


	}



}
