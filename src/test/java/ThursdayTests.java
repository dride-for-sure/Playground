import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThursdayTests {

 // checkPeopleTest

 @ParameterizedTest
 @ValueSource (ints = { 31, 40, 50 })
 void checkPeopleTest (int numbers) {
	assertTrue( Thursday.checkPeople( numbers ) );
 }

 @ParameterizedTest
 @ValueSource (ints = { 0, 10, 30 })
 void checkPeopleTest2 (int numbers) {
	assertFalse( Thursday.checkPeople( numbers ) );
 }

 // alarmHandler
// red
 @ParameterizedTest
 @ValueSource (ints = { 0, 10, 20, 30, 40, 50, 60, 70 })
 void alarmHandlerTestRed (int numbers) {
	String alarmStatus = "red";
	assertFalse( Thursday.alarmHandler( numbers, alarmStatus ) );
 }

 // yellow
 @ParameterizedTest
 @ValueSource (ints = { 0, 10, 20, 30 })
 void alarmHandlerTestYellowTrue (int numbers) {
	String alarmStatus = "yellow";
	assertTrue( Thursday.alarmHandler( numbers, alarmStatus ) );
 }

 @ParameterizedTest
 @ValueSource (ints = { 31, 40, 50 })
 void alarmHandlerTestYellowFalse (int numbers) {
	String alarmStatus = "yellow";
	assertFalse( Thursday.alarmHandler( numbers, alarmStatus ) );
 }

 // green
 @ParameterizedTest
 @ValueSource (ints = { 0, 10, 20, 30, 40, 50, 60 })
 void alarmHandlerTestGreenTrue (int numbers) {
	String alarmStatus = "green";
	assertTrue( Thursday.alarmHandler( numbers, alarmStatus ) );
 }

 @ParameterizedTest
 @ValueSource (ints = { 61, 70, 80 })
 void alarmHandlerTestGreenFalse (int numbers) {
	String alarmStatus = "green";
	assertFalse( Thursday.alarmHandler( numbers, alarmStatus ) );
 }

}
