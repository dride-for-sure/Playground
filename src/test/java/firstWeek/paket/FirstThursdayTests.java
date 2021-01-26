package firstWeek.paket;

import firstWeek.FirstThursday;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class FirstThursdayTests {

 // Check People
 // CSV Source
 @DisplayName ("Check the People in the room")
 @ParameterizedTest (name = "{0} people entered and it returns {1}")
 @CsvSource ({
				 "31, true",
				 "30, false",
 })
 void checkPeopleTest (int numbers, boolean status) {
	assertEquals( status, FirstThursday.checkPeople( numbers ) );
 }

 // AlarmHandler
 // Method Source
 @DisplayName ("Check return value for people + alarmStatus")
 @ParameterizedTest (name = "{0} people entered at {1} and it returns {2}")
 @MethodSource
 void alarmHandlerTest (int number, String alarmStatus, boolean expected) {
	assertEquals( expected, FirstThursday.alarmHandler( number, alarmStatus ) );
 }

 private static Stream<Arguments> alarmHandlerTest () {
	return Stream.of(
					Arguments.of( 31, "yellow", false ),
					Arguments.of( 60, "green", true ),
					Arguments.of( 61, "green", false ),
					Arguments.of( 1, "red", false )
	);
 }

 // Factorial
 // Method Source
 @DisplayName ("Check factorial")
 @ParameterizedTest (name = "{0}! is {1}")
 @MethodSource
 void factorialTest (int number, int expected) {
	assertEquals( expected, FirstThursday.factorial( number ) );
 }

 private static Stream<Arguments> factorialTest () {
	return Stream.of(
					Arguments.of( 0, 1 ),
					Arguments.of( 1, 1 ),
					Arguments.of( 5, 120 )
	);
 }

 // Student Array
 // Value Source
 @DisplayName ("Check student array")
 @ParameterizedTest (name = "Länge: {1}")
 @ValueSource (ints = { 1, 2, 3, 4 })
 void studentArrayTest (int length) {
	assertEquals( length, FirstThursday.studentArray( length ).length );
 }
}
