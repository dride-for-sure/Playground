import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ThursdayTests {

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
}
