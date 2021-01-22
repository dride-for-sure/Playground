import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Friday {

 public static void main (String[] args) {
 }

 private static boolean passwordLength (String password, int minLength) {
	return password.length() >= minLength;
 }

 private static boolean passwordIncludesUpperLowerCases (String password, int minCount) {
	char[] letters = password.toCharArray();
	int counterUpperCase = 0;
	int counterLowerCase = 0;
	for ( char letter : letters ) {
	 if ( Character.isUpperCase( letter ) ) {
		counterUpperCase += 1;
	 } else if ( Character.isLowerCase( letter ) ) {
		counterLowerCase += 1;
	 }
	}
	return ( counterUpperCase >= minCount && counterLowerCase >= minCount );
 }

 private static boolean passwordIncludesNumbers (String password, int minCount) {
	char[] letters = password.toCharArray();
	int counter = 0;
	for ( char letter : letters ) {
	 if ( Character.isDigit( letter ) ) {
		counter += 1;
	 }
	}
	return counter >= minCount;
 }

 public static boolean passwordBlacklist (String password) {
	try {
	 String encodedPassword = URLEncoder.encode( password, StandardCharsets.UTF_8.toString() );
	 HttpRequest request = HttpRequest.newBuilder()
					 .uri( URI.create( "https://wordsapiv1.p.rapidapi.com/words/" + encodedPassword ) )
					 .header( "x-rapidapi-key", "d5e45ae827msh05bf65de7239771p1fccbfjsn93ccbace0628" )
					 .header( "x-rapidapi-host", "wordsapiv1.p.rapidapi.com" )
					 .method( "GET", HttpRequest.BodyPublishers.noBody() )
					 .build();
	 HttpResponse<String> response = HttpClient.newHttpClient().send( request, HttpResponse.BodyHandlers.ofString() );

	 int statusCode = response.statusCode();
	 if ( statusCode != 200 ) {
		return true;
	 } else {
		// Access JSON Keys
		// ObjectMapper objectMapper = new ObjectMapper();
		// JsonNode jsonNode = objectMapper.readTree( response.body() );
		// String word = jsonNode.get( "word" ).asText();
		// System.out.println( word );
		return false;
	 }
	} catch ( Exception e ) {
	 e.printStackTrace();
	}
	return false;
 }

 public static boolean passwordValidation (String password, int minLength, int minNumbersCount, int minUpperLowerCount) {
	return passwordIncludesNumbers( password, minNumbersCount )
					&& passwordIncludesUpperLowerCases( password, minUpperLowerCount )
					&& passwordLength( password, minLength )
					&& passwordBlacklist( password );
 }

 public static Boolean passwordBatchValidation (List<String> passwords, int minLength, int minNumbersCount, int minUpperLowerCount) {
	boolean boolToggle = false;
	for ( String password : passwords ) {
	 boolToggle = passwordValidation( password, minLength, minNumbersCount, minUpperLowerCount );
	}
	return boolToggle;
 }
}