package prvi_java_projekt;

/*
 * This program takes in a string and checks if it can be read from both sides
 * the same. It is case-insensitive and space-insensitive.
 */

public class PlayingWithStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String testString="ANA VOLIMILOvANA";
		String toEliminate=" "; // eliminate spaces from the string
		char[] toEliminateChar=toEliminate.toCharArray();
		
		testString=testString.toLowerCase(); // all lower case
		
		char[] testStringToArray=testString.toCharArray(); // convert to char
		
		testStringToArray=kickOutElement(testStringToArray,toEliminateChar[0]); // eliminate spaces
		
		System.out.println(testString);
		System.out.println(testStringToArray);
		//System.out.println(helloArray);
		int flag=0;
		
		outerloop:
		for (int i=0;i<testStringToArray.length/2;i++) {
			//System.out.println(testStringToArray[i]);
			if (testStringToArray[i]==testStringToArray[(testStringToArray.length-1-i)]) {
				flag=1;
			}
			else {
				flag=0; // not same from both sides
				//return;
				break outerloop;
			}
				
		}
		
		if (flag==1) {
			System.out.println("String is same from both sides");
		}
		else {
			System.out.println("String is not the same from both sides");
		}
		
	}
	
	public static char[] kickOutElement(char[] arrayIn, char element) {
		int counter=0; int j=0;
		
		for (int i=0; i<arrayIn.length; i++) {
			if (arrayIn[i]==element) {
				counter=counter+1;
			}
		}
		
		char[] arrayOut=new  char[arrayIn.length-counter];
		
		for (int i=0; i<arrayIn.length; i++) {
			if (arrayIn[i]!=element) {
				arrayOut[j]=arrayIn[i]; j++;
			}
		}
		
		
		return arrayOut;
	}

}
