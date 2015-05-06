import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Dictionary {

	AVLTree tree ;
	
	Scanner reader ;

	public Dictionary(){
		tree = new AVLTree();
	}
	
	public void loadDictionary(){
		try {
			reader = new Scanner(new File("dictionary.txt"));
			while(reader.hasNextLine()){
				tree.insertNode( new Node(reader.nextLine(),null,null) );
			}
			System.out.println("dictionary loaded successfuly.");
			printDictionarySize();
			System.out.println("AVL Tree height : "+tree.getTreeHeight());
			System.out.println("=================================================");
			reader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Unable to load dictionary missing load file !");
			System.out.println("=================================================");
		}
	}
	
	public void printDictionarySize(){
		System.out.println("Dictionary size : "+tree.getSize() );
		System.out.println("=================================================");
	}
	
	public void insertWord(String value){
		try{
			tree.search(value);
			System.out.println("the word is already in the dictionary !!");
			System.out.println("=================================================");
		}
		catch(NullPointerException e){
			tree.insertNode(new Node(value,null,null));
			System.out.println("insertion complete..");
			printDictionarySize();
			System.out.println("AVL Tree height : "+tree.getTreeHeight());
			System.out.println("================================================");
		}
	}
	
	public void lookUpWord(String value){
		try{
			String s = tree.search(value).getNodeValue();
			System.out.println(s+" YES!");
			System.out.println("================================================");
		}
		catch(NullPointerException e){
			System.out.println("NO!");
			System.out.println("================================================");
		}
	}
	
	public void removeWord(String value){
		try{
			tree.search(value);
			tree.deleteNode(value);
			System.out.println("Dictionary size : "+tree.getSize());
			System.out.println("AVL Tree height : "+tree.getTreeHeight());
			System.out.println("=================================================");
		}
		catch(NullPointerException e){
			System.out.println("the word \""+value+"\" isn't in the dictionary");
			System.out.println("=================================================");
		}
	}
	
	public void batchLookUps(){
		try {
			reader = new Scanner(new File("queries.txt"));
			int counter =0 ;
			while(reader.hasNextLine()){
				try{
					tree.search(reader.nextLine());
					System.out.println("YES!");
					counter++;
				}
				catch(NullPointerException e){
					System.out.println("NO!");
				}
			}
			System.out.println("# of words found in dictionary : "+counter);
			System.out.println("===============================================");
			reader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Unable to load queries from batch file !");
			System.out.println("===============================================");
		}
	}
	
	public void batchDeletions(){
		try {
			reader = new Scanner(new File("deletions.txt"));
			int counter =0 ;
			while(reader.hasNextLine()){
				try{
					String value = reader.nextLine() ;
					tree.search(value);
					tree.deleteNode(value);
					counter++;
				}
				catch(NullPointerException e){
					
				}
			}
			System.out.println("# of words found and deleted from dictionary : "+counter);
			System.out.println("Dictionary size : "+tree.getSize());
			System.out.println("AVL Tree height : "+tree.getTreeHeight());
			System.out.println("===============================================");
			reader.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("Unable to load deletions from batch file !");
			System.out.println("===============================================");
		}
	}
	
	
}
