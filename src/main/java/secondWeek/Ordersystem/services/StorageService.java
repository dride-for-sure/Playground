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
 private ObjectMapper objectMapper = new ObjectMapper();
 private String orderDbPath = "target/orderDb.json";
 private String productDbPath = "target/productDb.json";

 public Optional<List<Order>> updateOrders (Optional<List<Order>> orders) {
	this.putOrderDb( orders );
	return this.getOrderDb();
 }

 public Optional<List<Product>> updateProducts (Optional<List<Product>> products) {
	this.putProductDb( products );
	return this.getProductDb();
 }

 public String getOrderDbPath () {
	return orderDbPath;
 }

 public String getProductDbPath () {
	return productDbPath;
 }

 private void putOrderDb (Optional<List<Order>> orders) {
	try {
	 if ( orders.isPresent() ) {
		objectMapper.writeValue( new File( orderDbPath ), orders.get() );
	 } else {
		throw new Exception( "Order Database seems to be empty" );
	 }
	} catch ( Exception e ) {
	 System.out.println( "Could not write orderDb" );
	}
 }

 private void putProductDb (Optional<List<Product>> products) {
	try {
	 if ( products.isPresent() ) {
		objectMapper.writeValue( new File( productDbPath ), products.get() );
	 } else {
		throw new Exception( "Product Database seems to be empty" );
	 }
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
