import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ThursdayTests {

 // checkPeopleTest refactored
 @ParameterizedTest
 @CsvSource ({
				 "31, true",
				 "30, false",
 })
 void checkPeopleTest (int numbers, boolean status) {
	assertEquals( status, Thursday.checkPeople( numbers ) );
 }

 // yellow refactored
 @ParameterizedTest
 @CsvSource ({
				 "30, yellow, true",
				 "31, yellow, false",
				 "60, green, true",
				 "61, green, false",
				 "1, red, false"
 })
 void alarmHandlerTestYellowCSV (int number, String alarmStatus, boolean expected) {
	assertEquals( expected, Thursday.alarmHandler( number, alarmStatus ) );
 }

}
