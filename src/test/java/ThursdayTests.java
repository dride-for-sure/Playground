import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;
import java.util.zip.CheckedInputStream;

import static org.junit.jupiter.api.Assertions.*;

public class ThursdayTests {

 // CSV Source
 @DisplayName ("Check the People in the room")
 @ParameterizedTest (name = "{0} people entered and it returns {1}")
 @CsvSource ({
				 "31, true",
				 "30, false",
 })
 void checkPeopleTest (int numbers, boolean status) {
	assertEquals( status, Thursday.checkPeople( numbers ) );
 }

 // Method Source
 @DisplayName ("Check return value for people + alarmStatus")
 @ParameterizedTest (name = "{0} people entered at {1} and it returns {2}")
 @MethodSource
 void alarmHandlerTest (int number, String alarmStatus, boolean expected) {
	assertEquals( expected, Thursday.alarmHandler( number, alarmStatus ) );
 }

 private static Stream<Arguments> alarmHandlerTest () {
	return Stream.of(
					Arguments.of( 31, "yellow", false ),
					Arguments.of( 60, "green", true ),
					Arguments.of( 61, "green", false ),
					Arguments.of( 1, "red", false )
	);
 }
}
