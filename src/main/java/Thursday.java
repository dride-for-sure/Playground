public class Thursday {

 public static void main (String[] args) {
 }

 public static boolean checkPeople (int people) {
	return people > 30;
 }

 public static boolean alarmHandler (int number, String alarmStatus) {
	switch ( alarmStatus ) {
	 case "red":
		return false;
	 case "yellow":
		return number <= 30;
	 case "green":
		return number <= 60;
	}
	return true;
 }

 public static int factorial (int number) {
	if ( number == 0 ) {
	 return 1;
	} else {
	 return ( number * factorial( number - 1 ) );
	}
 }
}
