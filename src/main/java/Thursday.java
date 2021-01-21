public class Thursday {

 public static void main (String[] args) {
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
}
