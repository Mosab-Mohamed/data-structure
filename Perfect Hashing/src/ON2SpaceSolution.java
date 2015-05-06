import java.util.LinkedList;


public class ON2SpaceSolution {
	
	int tableSize , numOfTries ;
	HashFunction f ;
	UniversalHashFamily u ;
	LinkedList[] table ;
	
	void buildTable(int[] set){
		numOfTries = 0 ;
		boolean collision = true ;
		tableSize = set.length * set.length ;
		
		
		while(collision){
			
			table = new LinkedList[tableSize];
			collision = false ;
			numOfTries ++ ;
			u = new UniversalHashFamily();
			int[][] h = u.getHashFuction(tableSize) ;
			f = new HashFunction(h);
			
			for(int i=0 ; i<set.length ; i++){
				int hashedKey = f.getHashValue(set[i],tableSize);
				if(table[hashedKey]==null)
					table[hashedKey] = new LinkedList();
				
				if(! (table[hashedKey].isEmpty()) )
					collision = true ;
				table[hashedKey].add(set[i]) ; 
			}
		}
	}
	
	int getNumOfTries(){
		return numOfTries ;
	}
	
	LinkedList[] getTable(){
		return table ;
	}
	
}
