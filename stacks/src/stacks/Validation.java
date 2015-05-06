package stacks;

public class Validation {
	
	public boolean ExpresionValidate(String S){
		char[] C = S.toCharArray();
		int counter =0 ;
		int last = C.length-1;
		char[] usedAlphabet = new char[26] ;
		
		if(C.length==0){
			return false;
		}
		if( C[last] == '*' || C[last] == '-' || C[last] == '+' || C[last] == '/' ){
			return false;
		}
		if( C[0] == '*' || C[0] == '-' || C[0] == '+' || C[0] == '/' ){
			return false;
		}
		for(int i= 0 ; i< C.length ; i++){
			if(! ( (C[i]>='a' && C[i]<='z') || (C[i]>='(' && C[i]<='+') || (C[i]=='/') || (C[i]=='-')  ) ){
				return false ;
			}
			if( C[i] >= 'a' && C[i] <= 'z'  ){
				for(int j = 0 ; j < counter  ; j++){
					if(usedAlphabet[j]==C[i])
						return false;
				}
				usedAlphabet[counter]=C[i];
				counter++;
			}
			if( C[i]=='/' || C[i]=='*' || C[i]=='+' || C[i]=='-' ){
				if( i<last && (C[i+1]=='/' || C[i+1]=='*' || C[i+1]=='+' || C[i+1]=='-') ){
					return false;
				}
			}
			else if( C[i] >= 'a' && C[i] <= 'z' ){
				if( i<last && (C[i+1] >= 'a' && C[i+1] <= 'z')){
					return false;
				}
				
			}
		}
		return true ;
	}
	
	public boolean ChoiceValidate(String S){
		int choice = 0;
		try{
			choice = Integer.parseInt(S);
		}
		catch(Exception e){
			System.out.println("you should enter an integer !!!");
		}
		if(choice==1  || choice==2)
			return true;
		else
			return false ;
	}
	

}
