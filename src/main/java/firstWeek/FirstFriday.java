package firstWeek;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FirstFriday {

 private static HttpResponse<String> getRapidApi (String uri, String apiKey, String rapidHost) {
	try {
	 HttpRequest request = HttpRequest.newBuilder()
					 .uri( URI.create( uri ) )
					 .header( "x-rapidapi-key", apiKey )
					 .header( "x-rapidapi-host", rapidHost )
					 .method( "GET", HttpRequest.BodyPublishers.noBody() )
					 .build();
	 return HttpClient.newHttpClient().send( request, HttpResponse.BodyHandlers.ofString() );
	} catch ( Exception e ) {
	 e.printStackTrace();
	 return null;
	}
 }

 private static String encodeURL (String str) {
	try {
	 return URLEncoder.encode( str, StandardCharsets.UTF_8.toString() );
	} catch ( Exception e ) {
	 e.printStackTrace();
	}
	return null;
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

 private static boolean passwordBlacklist (String password) {
	String encodedPassword = encodeURL( password );
	String uri = "https://wordsapiv1.p.rapidapi.com/words/" + encodedPassword;
	String apiKey = "d5e45ae827msh05bf65de7239771p1fccbfjsn93ccbace0628";
	String rapidHost = "wordsapiv1.p.rapidapi.com";
	HttpResponse<String> response = getRapidApi( uri, apiKey, rapidHost );
	return response.statusCode() != 200;
 }

 private static boolean passwordIsBoring (String password, int hits) {
	if ( password.length() == 0 ) {
	 return true;
	}

	String encodedPassword = encodeURL( password );
	String uri = "https://google-search5.p.rapidapi.com/google-serps/?q=" + encodedPassword;
	String apiKey = "d5e45ae827msh05bf65de7239771p1fccbfjsn93ccbace0628";
	String rapidHost = "google-search5.p.rapidapi.com";
	HttpResponse<String> response = getRapidApi( uri, apiKey, rapidHost );

	try {
	 ObjectMapper objectMapper = new ObjectMapper();
	 JsonNode jsonNode = objectMapper.readTree( response.body() );
	 String creditsLeft = jsonNode.get( "data" ).get( "meta" ).get( "credits_left" ).asText();
	 int convertedNumber = Integer.parseInt( creditsLeft );
	 return convertedNumber > hits;
	} catch ( Exception e ) {
	 e.printStackTrace();
	 return false;
	}
 }

 public static boolean passwordValidation (String password, int minLength, int minNumbersCount, int minUpperLowerCount, int maxGoogleHits) {
	return passwordIncludesNumbers( password, minNumbersCount )
					&& passwordIncludesUpperLowerCases( password, minUpperLowerCount )
					&& passwordLength( password, minLength )
					&& passwordBlacklist( password )
					&& passwordIsBoring( password, maxGoogleHits );
 }

 public static boolean passwordBatchValidation (List<String> passwords, int minLength, int minNumbersCount, int minUpperLowerCount, int maxGoogleHits) {
	boolean boolToggle = false;
	for ( String password : passwords ) {
	 boolToggle = passwordValidation( password, minLength, minNumbersCount, minUpperLowerCount, maxGoogleHits );
	}
	return boolToggle;
 }
}