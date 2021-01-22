import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FridayTests {

 /*
 @DisplayName ("Password includes Numbers")
 @ParameterizedTest (name = "{0} has been tested with Numbers count {1}: {2}")
 @MethodSource ("passwordNumberList")
 void passwordIncludesNumbersTest (String password, int minCount, boolean expected) {
	assertEquals( expected, Friday.passwordIncludesNumbers( password, minCount ) );
 }

 static Stream<Arguments> passwordNumberList () {
	return Stream.of(
					Arguments.of( "aaaaaa", 0, true ),
					Arguments.of( "1aaaaa", 1, true ),
					Arguments.of( "11aaaa", 2, true ),
					Arguments.of( "11aaaa", 3, false ),
					Arguments.of( "", 1, false ),
					Arguments.of( " ", 2, false )
	);
 }

 @DisplayName ("Password includes upper- & lowercase letters")
 @ParameterizedTest (name = "{0} has been tested with upper/lowercase count {1}: {2}")
 @MethodSource ("passwordUpperLowerCaseList")
 void passwordIncludesUpperLowerCasesTest (String password, int minCount, boolean expected) {
	assertEquals( expected, Friday.passwordIncludesUpperLowerCases( password, minCount ) );
 }

 static Stream<Arguments> passwordUpperLowerCaseList () {
	return Stream.of(
					Arguments.of( "Aaaaaa", 1, true ), // equal
					Arguments.of( "AaaAaa", 3, false ), // less
					Arguments.of( "AAAAaa", 3, false ), // more
					Arguments.of( " ", 5, false ), // whitespace
					Arguments.of( "", 1, false ), // empty
					Arguments.of( "", 0, true ) // empty
	);
 }

 @DisplayName ("Password Length")
 @ParameterizedTest (name = "{0} has been tested with length {1}: {2}")
 @MethodSource ("passwordLengthValidationList")
 void passwordLengthTest (String password, int minLength, boolean expected) {
	assertEquals( expected, Friday.passwordLength( password, minLength ) );
 }

 static Stream<Arguments> passwordLengthValidationList () {
	return Stream.of(
					Arguments.of( "aaaaaaaaaaaaaaaaaaaaaa", 20, true ), // too long
					Arguments.of( "aaaaaaaaaaaaaaaaaaaaa", 20, true ), // equal
					Arguments.of( "aaaaaaaaaaaaaaaaaaa", 20, false ), // too short
					Arguments.of( " ", 20, false ), // whitespace
					Arguments.of( "", 20, false ), // empty
					Arguments.of( "", 0, true ) // empty
	);
 }*/

 @DisplayName ("PasswordValidation")
 @ParameterizedTest (name = "\"{0}\" has been tested")
 @MethodSource ("passwordValidationList")
 void passwordValidationTest (String password, int minLength, int minNumbersCount, int minUpperLowerCount, boolean expected) {
	assertEquals( expected, Friday.passwordValidation( password, minLength, minNumbersCount, minUpperLowerCount ) );
 }

 static Stream<Arguments> passwordValidationList () {
	return Stream.of(
					Arguments.of( "ÑèÒmígÒSPpÅ¢@_£Ê²(ÀåA", 20, 0, 2, true ), // too long
					Arguments.of( "Ì^åÐRw[(fÅ¡Ø®jÊ1s\\qÜ", 20, 1, 3, true ), // equal
					Arguments.of( "Ì^åÐRw[(fÅ¡Ø®jÊ1s\\qÜ", 20, 2, 2, false ), // equal but less numbers
					Arguments.of( "~QB÷bzìDì¹loßÁ¢Ø/q$", 20, 3, 2, false ), // too short
					Arguments.of( "                    ", 20, 4, 0, false ), // whitespace
					Arguments.of( "", 20, 0, 1, false ), // empty
					Arguments.of( "", 0, 0, 0, true ) // empty
	);
 }

 @DisplayName ("PasswordBlacklist")
 @ParameterizedTest (name = "\"{0}\" has been tested")
 @MethodSource ("passwordBlackListValidationList")
 void passwordBlackListValidationTest (String password, boolean expected) {
	assertEquals( expected, Friday.passwordBlacklist( password ) );
 }

 static Stream<Arguments> passwordBlackListValidationList () {
	return Stream.of(
					Arguments.of( "ÑèÒmígÒSPpÅ¢@_£Ê²(ÀåA", true ),
					Arguments.of( "password", false ),
					Arguments.of( "test", false )
	);
 }

 @DisplayName ("PasswordBatchValidation")
 @ParameterizedTest
 @MethodSource ("passwordBatchValidationList")
 void passwordBatchValidationTest (List<String> passwords, int minLength, int minNumbersCount, int minUpperLowerCount, boolean expected) {
	assertEquals( expected, Friday.passwordBatchValidation( passwords, minLength, minNumbersCount, minUpperLowerCount ) );
 }

 static Stream<Arguments> passwordBatchValidationList () {
	return Stream.of(
					Arguments.of(
									Arrays.asList(
													"ÑèÒmígÒSPpÅ¢@_£Ê²(ÀåA",
													"23paisAkeBajdkW@_£Ê²(ÀåA",
													"Ì^åÐRw[(fÅ¡Ø®jÊ1s\\\\qÜ"
									), 20, 0, 2, true ),
					Arguments.of(
									Arrays.asList(
													"~QB÷bzìDì¹loßÁ¢Ø/q$",
													"                    ",
													" ",
													""
									), 20, 1, 1, false )
	);
 }
}
