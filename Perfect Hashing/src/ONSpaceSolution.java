import java.util.LinkedList;


public class ONSpaceSolution {
	
	int tableSize , numOfTries ;
	HashFunction f ;
	UniversalHashFamily u ;
	LinkedList[][] table ;
	
	void buildTable(int[] set){
		
		numOfTries = 0 ;
		boolean collision = true ;
		tableSize = set.length ;
		
		
		while(collision){
			
			table = new LinkedList[tableSize][1];
			collision = false ;
			numOfTries++;
			u = new UniversalHashFamily();
			int[][] h1 = u.getHashFuction(tableSize) ;
			f = new HashFunction(h1);
			int level1HashedKey , level2HashedKey;
			
			for(int i=0 ; i<set.length ; i++){
				level1HashedKey = f.getHashValue(set[i],tableSize);
				if(table[level1HashedKey][0]==null){
					table[level1HashedKey][0] = new LinkedList();
				}
				table[level1HashedKey][0].add(set[i]) ; 
			}
			
//			for(int i=0 ; i<set.length ; i++){
//				System.out.println(table[i][0]);
//			}
			
			for(int i=0 ; i<table.length ; i++){
				
				if(table[i][0] != null){
					
					if(table[i][0].size() > 1){
						LinkedList elements = new LinkedList();
						for(int j=0 ; j<table[i][0].size() ; j++){
							elements.add( table[i][0].get(j) );
						}
						table[i] = new LinkedList[elements.size()*elements.size()];
//						System.out.println("***"+elements.size()+"***");
						for(int j=0 ; j<elements.size() ; j++){
							u = new UniversalHashFamily();
							h1 = u.getHashFuction(table[i].length);
							f = new HashFunction(h1);
							level2HashedKey = f.getHashValue((int)elements.get(j), table[i].length);
							if(table[i][level2HashedKey]==null){
								table[i][level2HashedKey] = new LinkedList();
							}
							else{
								collision = true ;
							}
							table[i][level2HashedKey].add(elements.get(j));
						}
					}
				}
				
			}
			
		}
	}
	
	int getNumOfTries(){
		return numOfTries ;
	}
	
	LinkedList[][] getTable(){
		return table ;
	}
	
//	private LinkedList squareArraySize(LinkedList[] subTable,int size) {
//		LinkedList copy = new LinkedList();
//		for(int i=0 ; i<subTable[0].size() ; i++){
//			copy.add( subTable[0].get(i) );
//		}
//		subTable = new LinkedList[size*size];
//		return copy;
//	}

}
