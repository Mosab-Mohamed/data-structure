package stacks;

public class MyException extends Exception {
	
	private String reason = "";
	private int causeCode = 0;

	public MyException(int CauseCode,String reason ){
		this.causeCode = CauseCode ;
		this.reason = reason ;
	}
	
	public int getCauseCode(){
		return causeCode;
	}
	
	public String getReason(){
		return reason;
	}
	
	public static final int SUCCESS = 0;
	public static final int STACK_IS_EMPTY = 404;
	public static final int STACK_IS_FULL = 505;
	
	public String getCauseCodeString(){
		
		String causeCodeString = null ;
		switch(this.causeCode){
			
		case STACK_IS_EMPTY : 
			causeCodeString = "Stack is empty";
			break;
		case STACK_IS_FULL :
			causeCodeString = "Stack is full";
			break;
		default :
			causeCodeString = "incorrect reason";
		
		}
		return causeCodeString;
	}
	
}
