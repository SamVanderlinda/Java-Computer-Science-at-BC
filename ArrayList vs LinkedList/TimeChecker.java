/* Student: Samuel Vanderlinda
 * Email: samuel.vanderlinda@bellevuecollege.edu
 * Assignment #: 7 (LinkedList vs. ArrayList)
 * Due: 3/15/19
 * This class compares the processing time of adding
 * searching and removing values of different data structures
 */

import java.util.*;

public class TimeChecker {
	
	static ArrayList<Integer> myArrayList = new ArrayList<>();
	static LinkedList<Integer> myLinkedList = new LinkedList<>();
	static Random rand = new Random();
	static Scanner input = new Scanner(System.in);
	static double totalArrayTime;
	static double totalLinkedTime;
	static double startTime;
	static double endTime;
	
	public static void main(String[] args) {
		
		String s; int howMany;
		
		//user inputs string then converted to an integer
		
		while(true) {
			System.out.print("input integer number : ");
			s = input.next();
			try {
				howMany = Integer.parseInt(s); //convert to integer
		    } 
		
				//if not convertible, have user try again
		
				catch(NumberFormatException e) {  // if not an integer, error happened
				System.out.println("input error. You typed NOT an integer number ");
				continue; // run it again
			}
			break; // if integer, then stop
		}
	
		add(howMany);
		
		search(howMany);
		
		remove(howMany);
		
	}
	
	//tests the processing time of adding a randomly generated
	//integer to a desired data structure 
	
	public static void add(int howMany) {
		totalArrayTime=0.0;
		totalLinkedTime=0.0;
		
		for (int i=0; i<howMany; i++) {
	
			//selecting random integer
	
			int value = rand.nextInt(100000);  // range [0,99999]
	
			//adds the difference of time before and after adding
	
			startTime = System.currentTimeMillis();
			myArrayList.add(value);
			endTime = System.currentTimeMillis();
			totalArrayTime += (endTime-startTime);
			
			//adds the difference of time before and after adding
			
			startTime = System.currentTimeMillis();
			myLinkedList.add(value);
			endTime = System.currentTimeMillis();	
			totalLinkedTime += (endTime-startTime);
		}
		
		System.out.println("ArrayList add time:  " + totalArrayTime/1000 + " seconds");
		System.out.println("LinkedList add time: " + totalLinkedTime/1000 + " seconds");
		percent(totalArrayTime, totalLinkedTime);
		System.out.println();
	}
	
	//tests the processing time of searching a randomly generated
	//integer to a desired data structure 
	
	public static void search(int howMany) {
		totalArrayTime=0.0;
		totalLinkedTime=0.0;
			
		for(int i = 0; i < howMany; i++) {
			int value = rand.nextInt(100000);  
			
			//adds the difference of time before and after searching
			//the desired amount of times
			
			startTime = System.currentTimeMillis();
			myArrayList.indexOf(value);
			endTime = System.currentTimeMillis();
			totalArrayTime += (endTime-startTime);
			
			//adds the difference of time before and after searching
			//the desired amount of times
			
			startTime = System.currentTimeMillis();
			myLinkedList.indexOf(value);
			endTime = System.currentTimeMillis();	
			totalLinkedTime += (endTime-startTime);
		}
		System.out.println("ArrayList search time:  " + totalArrayTime/1000 + " seconds");
		System.out.println("LinkedList search time: " + totalLinkedTime/1000 + " seconds");
		percent(totalArrayTime, totalLinkedTime);
		System.out.println();
		
	}
	
	//tests the processing time of removing a randomly generated
	//integer to a desired data structure half the given amount
	
	public static void remove(int howMany) {
		totalArrayTime=0.0;
		totalLinkedTime=0.0;
		int length = howMany/2;
		
		for(int i = 0; i < length; i++) {
			int value = rand.nextInt(howMany); 
	
			//adds the difference of time before and after removing
			//the desired amount of times
	
			startTime = System.currentTimeMillis();
			myArrayList.remove(value);
			endTime = System.currentTimeMillis();
			totalArrayTime += (endTime-startTime);
	
			//adds the difference of time before and after removing
			//the desired amount of times
	
			startTime = System.currentTimeMillis();
			myLinkedList.remove(value);
			endTime = System.currentTimeMillis();	
			totalLinkedTime += (endTime-startTime);
			howMany--;
		}
		System.out.println("ArrayList remove time:  " + totalArrayTime/1000 + " seconds");
		System.out.println("LinkedList remove time: " + totalLinkedTime/1000 + " seconds");
		percent(totalArrayTime, totalLinkedTime);
		System.out.println();
	}
	
	//prints the percentage difference between arraylist and linkedlist
	
	public static void percent(double totalArrayTime, double totalLinkedTime) {
		
		if (totalArrayTime < totalLinkedTime) {
			double percentage = (100 * (1 - (totalArrayTime / totalLinkedTime)));
			System.out.printf("The ArrayList was faster by %.2f%%", percentage);
		}
		else if (totalLinkedTime < totalArrayTime) {
			double percentage = 100 * (1 - (totalLinkedTime / totalArrayTime));
			System.out.printf("The LinkedList was faster by %.2f%%", percentage);
		}
		else
			System.out.printf("They were equal in speed");
		System.out.println();
	}
}



