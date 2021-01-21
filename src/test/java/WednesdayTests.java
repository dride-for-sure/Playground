import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WednesdayTests {
 @Test
 public void stringLengthGreaterThenTest () {
	String testCaseStringEmpty = "This is long string";
	int length = 10;

	assertTrue( Wednesday.stringLengthGreaterThen( testCaseStringEmpty, length ) );
 }

 @Test
 public void sumTest () {
	int num1 = 4;
	int num2 = 6;

	assertEquals( 10, Wednesday.sum( num1, num2 ) );
 }
}