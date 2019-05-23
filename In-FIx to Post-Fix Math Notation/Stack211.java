/* Student: Samuel Vanderlinda
 * Email: samuel.vanderlinda@bellevuecollege.edu
 * Assignment #: 5 (Stack)
 * Due: 3/6/19
 * This is class serves as a manual stack to 
 * make computations
 */

import java.util.*;

//generic class type
public class Stack211 <T>{
	
	//will utilize ArrayList to represent stack
	ArrayList<T> myStack = new ArrayList<>();
	
	//pushes a token into the top layer of the stack
	public void push (T c) {
		myStack.add(c);	
	}
	
	//pops and returns the top layer of the stack
	public T pop() {
		return myStack.remove(myStack.size()-1);
	}
	
	//Returns True/False if stack is empty
	public boolean isEmpty() {
		return myStack.isEmpty();
	}
	
	//Sends the top value without deleting it
	public T read() {
		return myStack.get(myStack.size()-1);
	}
}
