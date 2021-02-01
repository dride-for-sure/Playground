package secondWeek.Ordersystem.services;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import secondWeek.Ordersystem.model.Order;
import secondWeek.Ordersystem.model.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StorageService {
 ObjectMapper objectMapper = new ObjectMapper();
 String orderDbPath = "target/orderDb.json";
 String productDbPath = "target/productDb.json";

 public Optional<List<Order>> refreshOrders (List<Order> orders) {
	this.putOrderDb( orders );
	return this.getOrderDb();
 }

 public Optional<List<Product>> refreshProducts (List<Product> products) {
	this.putProductDb( products );
	return this.getProductDb();
 }

 private void putOrderDb (List<Order> orders) {
	try {
	 objectMapper.writeValue( new File( orderDbPath ), orders );
	} catch ( Exception e ) {
	 System.out.println( "Could not write orderDb" );
	}
 }

 private void putProductDb (List<Product> productDb) {
	try {
	 objectMapper.writeValue( new File( productDbPath ), productDb );
	} catch ( Exception e ) {
	 System.out.println( "Could not write productDb" );
	}
 }

 private Optional<List<Order>> getOrderDb () {
	try {
	 List<Order> orders = objectMapper.readValue( new File( orderDbPath ),
					 new TypeReference<List<Order>>() {
					 } );
	 if ( !orders.isEmpty() ) {
		return Optional.of( orders );
	 }
	} catch ( Exception e ) {
	 System.out.println( "No orderDb found" );
	}
	return Optional.empty();
 }

 private Optional<List<Product>> getProductDb () {
	try {
	 List<Product> products =
					 new ArrayList<Product>( objectMapper.readValue( new File( productDbPath ),
									 new TypeReference<List<Product>>() {
									 } ) );
	 if ( !products.isEmpty() ) {
		return Optional.of( products );
	 }
	} catch ( Exception e ) {
	 System.out.println( "No productDb found" );
	}
	return Optional.empty();
 }
}
