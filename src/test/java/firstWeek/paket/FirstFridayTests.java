package firstWeek.paket;

import firstWeek.FirstFriday;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstFridayTests {

 @DisplayName ("PasswordValidation")
 @ParameterizedTest (name = "\"{0}\" has been tested")
 @MethodSource ("passwordValidationList")
 void passwordValidationTest (String password, int minLength, int minNumbersCount, int minUpperLowerCount, int maxGoogleHits, boolean expected) {
	assertEquals( expected, FirstFriday.passwordValidation( password, minLength, minNumbersCount, minUpperLowerCount, maxGoogleHits ) );
 }

 static Stream<Arguments> passwordValidationList () {
	return Stream.of(
					Arguments.of( "ÑèÒmígÒSPpÅ¢@_£Ê²(ÀåA", 20, 0, 2, 0, true ), // too long
					Arguments.of( "Ì^åÐRw[(fÅ¡Ø®jÊ1s\\qÜ", 20, 1, 3, 0, true ), // equal
					Arguments.of( "Ì^åÐRw[(fÅ¡Ø®jÊ1s\\qÜ", 20, 2, 2, 0, false ), // equal but less numbers
					Arguments.of( "~QB÷bzìDì¹loßÁ¢Ø/q$", 20, 3, 2, 0, false ), // too short
					Arguments.of( "                    ", 20, 4, 0, 0, false ), // whitespace
					Arguments.of( "password", 20, 4, 0, 0, false ), // googlehits
					Arguments.of( "test", 20, 4, 0, 0, false ), // googlehits
					Arguments.of( "", 20, 0, 1, 0, false ), // empty
					Arguments.of( "", 0, 0, 0, 0, true ) // empty
	);
 }

 @DisplayName ("PasswordBatchValidation")
 @ParameterizedTest
 @MethodSource ("passwordBatchValidationList")
 void passwordBatchValidationTest (List<String> passwords, int minLength, int minNumbersCount, int minUpperLowerCount, int maxGoogleHits, boolean expected) {
	assertEquals( expected, FirstFriday.passwordBatchValidation( passwords, minLength, minNumbersCount, minUpperLowerCount, maxGoogleHits ) );
 }

 static Stream<Arguments> passwordBatchValidationList () {
	return Stream.of(
					Arguments.of(
									Arrays.asList(
													"ÑèÒmígÒSPpÅ¢@_£Ê²(ÀåA",
													"23paisAkeBajdkW@_£Ê²(ÀåA",
													"Ì^åÐRw[(fÅ¡Ø®jÊ1s\\\\qÜ"
									), 20, 0, 2, 0, true ),
					Arguments.of(
									Arrays.asList(
													"~QB÷bzìDì¹loßÁ¢Ø/q$",
													"                    ",
													" ",
													""
									), 20, 1, 1, 0, false )
	);
 }
}
