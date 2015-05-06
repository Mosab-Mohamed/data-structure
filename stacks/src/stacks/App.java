package stacks;

import java.util.*;

public class App {

	Scanner reader = new Scanner(System.in) ;
	Stack operators = new Stack();
	stack1 operands = new stack1();
	String expresion ;
	int counter;
	
	public static void main(String[] args) {
		App prog = new App();
		prog.scanEXP();
	}

	public void scanEXP(){

		String postFixExpresion = "";
		System.out.print("enter the expresion with only variable form : ");
		expresion = reader.nextLine();
		Validation item = new Validation();
		while(! item.ExpresionValidate(expresion)){
			System.out.print("you entered wrong expresion re-enter the expresion : ");
			expresion = reader.nextLine();
		}
		expresion = putOnForm(expresion);
		boolean again = true ;
		while(again){
			System.out.println("=======================================================");
			System.out.println("Enter your choice : ");
			System.out.println("1_ get the postfix expresion");
			System.out.println("2_ sub in expresion");
			String choice ;
			choice =  reader.nextLine();
			while( item.ChoiceValidate(choice)== false ){
				System.out.println("wrong choice reenter your choice : ");
				System.out.println("1_ get the postfix expresion");
				System.out.println("2_ sub in expresion");
				choice =  reader.nextLine();
			}
			postFixExpresion = postFix();
			System.out.println("=======================================================");
			
			switch(Integer.parseInt(choice)){
				case 1 :
					
					System.out.println("the post fix of the expresion ( \""+expresion+ "\" ) is : ( "+postFixExpresion+" )");
					System.out.println("=======================================================");
					break ;
				case 2 :
					double result;
					result = InFix(postFixExpresion);
					System.out.println("the result of the expresion = "+result);
					System.out.println("=======================================================");
					break ;
				default :
					System.out.println("wrong entry");
					break;
			}
			System.out.println("do you want to do more ???");
			System.out.println("1_ yes");
			System.out.println("2_ no");
			String choice1 ;
			choice1 =  reader.nextLine();
			while( item.ChoiceValidate(choice1)== false ){
				System.out.println("wrong !!");
				System.out.println("do you want to do more ???");
				System.out.println("1_ yes ");
				System.out.println("2_ no ");
				choice1 =  reader.nextLine();
			}
			if(Integer.parseInt(choice1)==2){
				again=false;
			}
		}
		
	}
	
	public String postFix (){
		StringTokenizer cutter = new StringTokenizer(expresion," ");
		StringBuilder postfix = new StringBuilder();
		counter = 0;
		
		
		while(cutter.hasMoreElements()){
			
			char symb = cutter.nextToken().charAt(0);
			
			if(symb >= 97 && symb <= 122){
				counter++;
				postfix.append(symb+" ");
			}
			else{
				
				if(symb == ')' ){
					
					while(operators.peek().value != '('){
						postfix.append(operators.pop().value+" ");
					}
					operators.pop();
					
				}
				
				else if(symb == '(' ){
					ListNode newNode = new ListNode(symb);
					operators.push(newNode);
				}
				
				else if(symb == '+' || symb == '-'){
					
					boolean check = true;
					
					while(check){
						char element = 0;
						if(! operators.isEmpty()){
							element = operators.peek().value;
						}
						
						if(operators.isEmpty() || element == '('){
							
							ListNode newNode = new ListNode(symb);
							operators.push(newNode);
							check=false;
						}
						
						else {
							postfix.append(operators.pop().value+" ");
						}
						
					}
				}
				
				else if(symb == '*' || symb == '/'){
					
					boolean check = true;
					
					while(check){
						char element = 0;
						if(! operators.isEmpty()){
							element = operators.peek().value;
						}
						
						if(operators.isEmpty() || element == '(' || element == '+' || element == '-'){
							
							ListNode newNode = new ListNode(symb);
							operators.push(newNode);
							check=false;
						}
						
						else {
							postfix.append(operators.pop().value+" ");
						}
						
					}
				}
			}
		}
		
		while(! operators.isEmpty()){
			postfix.append(operators.pop().value+" ");
		}
		
		String expresionPostfix =  postfix.toString();
		return expresionPostfix;
	}
	
	public double InFix (String exp){
		
		int i;
		int[] values = new int[counter];
		double result =0 ;
		
		for( i = 0 ;  i< counter ; i++){
			
			System.out.println("enter the value of variable number "+(i+1)+" :");
			values[i] = reader.nextInt();
		}
		StringTokenizer cutter = new StringTokenizer(exp," ");
		
		i=0;
		while(cutter.hasMoreElements()){
			
			char symb = cutter.nextToken().charAt(0);
			
			if(symb >= 97 && symb <= 122){
				String value = Integer.toString(values[i]);
				ListNode1 newNode = new ListNode1(value);
				operands.push(newNode);
				i++;
			}
			else{
				
				if(symb == '+'){
					double operand1 = Double.parseDouble(operands.pop().value);
					double operand2 = Double.parseDouble(operands.pop().value);
					result = (operand2 + operand1);
					String value = Double.toString(result);
					ListNode1 newNode = new ListNode1(value);
					operands.push(newNode);
					}
				
				else if(symb == '-'){
					double operand1 = Double.parseDouble(operands.pop().value);
					double operand2 = Double.parseDouble(operands.pop().value);
					result = (operand2 - operand1);
					String value = Double.toString(result);
					ListNode1 newNode = new ListNode1(value);
					operands.push(newNode);
					}
				
				else if(symb == '*'){
					double operand1 = Double.parseDouble(operands.pop().value);
					double operand2 = Double.parseDouble(operands.pop().value);
					result = (operand2 * operand1);
					String value = Double.toString(result);
					ListNode1 newNode = new ListNode1(value);
					operands.push(newNode);
					}
				
				else if(symb == '-'){
					double operand1 = Double.parseDouble(operands.pop().value);
					double operand2 = Double.parseDouble(operands.pop().value);
					result = (operand2 / operand1);
					String value = Double.toString(result);
					ListNode1 newNode = new ListNode1(value);
					operands.push(newNode);
					}
				
				}
			}
		return result;
	}

	public String putOnForm(String S){
		char[] arr = S.toCharArray();
		StringBuilder builder = new StringBuilder();
		for(int i=0 ; i < arr.length-1 ; i++){
				builder.append(arr[i]+" ");
		}
		builder.append(arr[arr.length-1]);
		return builder.toString();
		
	}
}
