public class Wednesday {

 String constructorString;

 Wednesday (String str) {
	this.constructorString = str;
 }

 public static void main (String[] args) {
	String passToConstructor = "Hello";
	Wednesday pft = new Wednesday( passToConstructor );
	System.out.println( pft.constructorString );
 }

 public static boolean stringLengthGreaterThen (String str, int length) {
	return str.length() > length;
 }

 public static int sum (int summand1, int summand2) {
	return summand1 + summand2;
 }
}