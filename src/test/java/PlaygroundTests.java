import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class PlaygroundTests {

 @Test
 public void stringLengthGreaterThenTest () {
	String testCaseStringEmpty = "This is long string";
	int length = 10;

	assertFalse( Playground.stringLengthGreaterThen( testCaseStringEmpty, length ) );
 }

 @Test
 public void sumTest () {
	int num1 = 4;
	int num2 = 6;

	assertEquals( 10, Playground.sum( num1, num2 ) );
 }
}