package secondWeek.Ordersystem;

import java.util.List;
import java.util.Optional;

public class OrderService {
 private final OrderDb orderDb;
 private final ProductDb productDb;
 private final Storage storage;

 public OrderService () {
	this.productDb = new ProductDb();
	this.orderDb = new OrderDb();
	this.storage = new Storage();
 }

 public void addOrder (Order order) {
	this.orderDb.add( order );
	// refresh
 }

 public Optional<List<Order>> getOrder (int id) {
	Optional<List<Order>> order;
	try {
	 order = this.orderDb.get( id );
	 if ( !order.isPresent() ) {
		throw new Exception( "Order with ID is not available" );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	 return Optional.empty();
	}
	return order;
 }

 public void removeOrder (int id) {
	this.orderDb.remove( id );
	// refresh
 }

 public List<Order> listOrders () {
	return this.orderDb.list();
 }

 public void addProduct (Product product) {
	this.productDb.add( product );
	// refresh
 }

 public Optional<List<Product>> getProduct (int id) {
	Optional<List<Product>> product;
	try {
	 product = this.productDb.get( id );
	 if ( !product.isPresent() ) {
		throw new Exception( "Order with ID is not available" );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	 return Optional.empty();
	}
	return product;
 }

 public void removeProduct (int id) {
	this.productDb.remove( id );
	// refresh
 }

 public List<Product> listProducts () {
	return this.productDb.list();
 }
}
