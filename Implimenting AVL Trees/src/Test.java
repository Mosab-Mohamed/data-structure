import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		new Test().start();

	}

	private void start() {
		String s1 = "abc" ;
		String s2 = "abd";
		System.out.println(s1.compareToIgnoreCase(s2));
		System.out.println();
		Scanner reader = new Scanner(System.in);
		Dictionary dic = new Dictionary() ;
		while(true){
			
			System.out.println("choose Action to perform :-");
			System.out.println("========================================");
			System.out.println("1) Load Dictionary:");
			System.out.println("2) Print Dictionary Size:");
			System.out.println("3) Insert Word:");
			System.out.println("4) Look-up a Word:");
			System.out.println("5) Remove Word:");
			System.out.println("6) Batch Look-ups:");
			System.out.println("7) Batch Deletions:");
			System.out.println("8) exit:");
			System.out.println("*******************************************");
			System.out.print("enter your choice : ");
			int choice = Integer.parseInt( reader.nextLine() ) ;
			if(choice == 1){
				dic.loadDictionary();
			}
			
			else if(choice == 2)
				dic.printDictionarySize();
			
			else if(choice == 3){
				System.out.print("inter word to insert : ");
				String s = reader.nextLine();
				dic.insertWord(s);
			}
			
			else if(choice == 4){
				System.out.print("inter word to look up : ");
				String s = reader.nextLine();
				dic.lookUpWord(s);
			}
			
			else if(choice == 5){
				System.out.print("inter word to remove : ");
				String s = reader.nextLine();
				dic.removeWord(s);
			}
			
			else if(choice == 6){
				dic.batchLookUps();
			}
			
			else if(choice == 7){
				dic.batchDeletions();
			}
			
			else if(choice ==8 )
				break;
			System.out.println("************************************************");
		}
		
	}

}

