package firstWeek;

public class FirstWednesday {

 String constructorString;

 FirstWednesday (String str) {
	this.constructorString = str;
 }

 public static void main (String[] args) {
	String passToConstructor = "Hello";
	FirstWednesday pft = new FirstWednesday( passToConstructor );
	System.out.println( pft.constructorString );
 }

 public static boolean stringLengthGreaterThen (String str, int length) {
	return str.length() > length;
 }

 public static int sum (int summand1, int summand2) {
	return summand1 + summand2;
 }
}