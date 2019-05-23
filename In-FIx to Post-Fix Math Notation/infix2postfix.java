/* Student: Samuel Vanderlinda
 * Email: samuel.vanderlinda@bellevuecollege.edu
 * Due: 3/6/19
 * This serves as the main class to replicate the
 * stack operations of a computer to convert infix
 * math code to postfix
 */


import java.util.HashMap;

public class infix2postfix {
	
	//HashMap "maps" priority for operators
	
	static HashMap<Character, Integer> priority = new HashMap<>();
	static String[] Statement = {"2 + ( 2 - 0 )", "1 * 2 + 6 / 2 - 5", "{5 - 2} * (2 + 2)",
	"8 - { 2 + 1 } * 3", "(3 * ( 5 - 2 )) + 9"};
	
	
	public static void main(String[] args) {
		loadPrior();
		
		//First loop goes through all test statements
		
		for (int i = 0; i < Statement.length; i++) {
			System.out.println("infix:");
			System.out.println(Statement[i]);
			System.out.println("to\npostfix:");
			Stack211<Character> myStack = new Stack211<>();
			int lastChar = Statement[i].length();
		
			//Second loop goes through all characters in 
			//each test statement
		
			for (int j = 0; j < lastChar; j++) {
				
				char c = Statement[i].charAt(j);
				
				// if ( or { just push it at the top of the stack
				// no problem and stuff can stack on you
		
				if (c == '(' || c == '{') {
					myStack.push(c); 
				}
		
				//pop everything until you see (
		
				else if (c == ')') {
					groupers('(', myStack);
				}
		
				//pop everything until you see {
		
					else if (c == '}') {
					groupers('{', myStack);
				}
				
				if (c == '*' || c == '/' || c == '+' || c == '-') {
		
					//if there is nothing in the stack just push
		
					if (myStack.isEmpty()) {
						myStack.push(c);
					}
		
					//if the current operator is a higher priority push
		
					else if (priority.get(c) > priority.get(myStack.read())) {
						myStack.push(c);
					}
					else {
		
						//if operator is lower or equal priority to whats in the stack
						//pop and print stack tokens until operator is greater or stack
						//is empty
		
						while(myStack.isEmpty() || priority.get(c) <= priority.get(myStack.read())) {
							System.out.print(myStack.pop());
							if (myStack.isEmpty())
								break;
						}
						myStack.push(c);
					}
					
				}
		
				//print operands
		
				else if (c <= '9' && c >= '0') {
					System.out.print(c);
				}
			}

			//pop what is left in the stack
		
			while(true != myStack.isEmpty()) {
				System.out.print(myStack.pop());
			}
			System.out.println();

			//I stole Shay's --- organization
			
			System.out.println("------------------");
		}
	}
	
	//method for grouping operators
	
	public static void groupers(char p, Stack211<Character> myStack) {
		while(myStack.read() != p) {
			System.out.print(myStack.pop());
		}
		myStack.pop();
	}
	
	public static void loadPrior() {
		priority.put('*', 2);
		priority.put('/', 2);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('(', 0);
		priority.put('{', 0);
	}
}
