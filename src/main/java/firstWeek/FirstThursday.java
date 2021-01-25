package firstWeek;

import java.lang.reflect.Array;

public class FirstThursday {

 public static void main (String[] args) {
	studentArray( 5 );
 }

 public static boolean checkPeople (int people) {
	return people > 30;
 }

 public static boolean alarmHandler (int number, String alarmStatus) {
	return switch ( alarmStatus ) {
	 case "red" -> false;
	 case "yellow" -> number <= 30;
	 case "green" -> number <= 60;
	 default -> true;
	};
 }

 public static int factorial (int number) {
	if ( number == 0 ) {
	 return 1;
	} else {
	 return ( number * factorial( number - 1 ) );
	}
 }

 public static String[] studentArray (int length) {
	String[] students = new String[ length ];

	for ( int i = 0; i < students.length; i++ ) {
	 students[ i ] = "Students" + ( i + 1 );
	}

	return students;
 }
}
