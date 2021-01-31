package secondWeek.Ordersystem;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Storage {
 ObjectMapper objectMapper = new ObjectMapper();
 String orderDbPath = "target/orderDb.json";
 String productDbPath = "target/orderDb.json";

 public void putOrderDb (List<Order> orders) {
	try {
	 objectMapper.writeValue( new File( orderDbPath ), orders );
	} catch ( Exception e ) {
	 System.out.println( "Could not write orderDb" );
	}
 }

 public void putProductDb (List<Product> productDb) {
	try {
	 objectMapper.writeValue( new File( productDbPath ), productDb );
	} catch ( Exception e ) {
	 System.out.println( "Could not write productDb" );
	}
 }

 public List<Order> getOrderDb () {
	try {
	 List<Order> orders = objectMapper.readValue( new File( orderDbPath ), new TypeReference<List<Order>>() {
	 } );
	 return orders;
	} catch ( Exception e ) {
	 System.out.println( "No orderDb found" );
	}
	return null;
 }

 public List<Product> getProductDb () {
	try {
	 List<Product> productDb =
					 new ArrayList<Product>( objectMapper.readValue( new File( productDbPath ),
									 List.class ) );
	 return productDb;
	} catch ( Exception e ) {
	 System.out.println( "No productDb found" );
	}
	return new ArrayList<>();
 }
}
