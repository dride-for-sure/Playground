import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Friday {

 public static void main (String[] args) {
 }

 private static boolean passwordLength (String password, int minLength) {
	return password.length() >= minLength;
 }


 private static boolean passwordIncludesUpperLowerCases (String password, int minCount) {
	char[] letters = password.toCharArray();
	int counterUpperCase = 0;
	int counterLowerCase = 0;
	for ( char letter : letters ) {
	 if ( Character.isUpperCase( letter ) ) {
		counterUpperCase += 1;
	 } else if ( Character.isLowerCase( letter ) ) {
		counterLowerCase += 1;
	 }
	}
	return ( counterUpperCase >= minCount && counterLowerCase >= minCount );
 }

 private static boolean passwordIncludesNumbers (String password, int minCount) {
	char[] letters = password.toCharArray();
	int counter = 0;
	for ( char letter : letters ) {
	 if ( Character.isDigit( letter ) ) {
		counter += 1;
	 }
	}
	return counter >= minCount;
 }


 public static boolean passwordValidation (String password, int minLength, int minNumbersCount, int minUpperLowerCount) {
	return passwordIncludesNumbers( password, minNumbersCount )
					&& passwordIncludesUpperLowerCases( password, minUpperLowerCount )
					&& passwordLength( password, minLength );
 }

 public static Boolean passwordBatchValidation (String[] passwords, int minLength, int minNumbersCount, int minUpperLowerCount) {
	Boolean boolToggle = false;
	for ( int i = 0; i < passwords.length; i++ ) {
	 boolToggle = passwordValidation( passwords[ i ], minLength, minNumbersCount, minUpperLowerCount );
	}
	return boolToggle;
 }
}