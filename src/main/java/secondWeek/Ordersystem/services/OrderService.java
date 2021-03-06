package secondWeek.Ordersystem.services;

import secondWeek.Ordersystem.db.OrderDb;
import secondWeek.Ordersystem.db.ProductDb;
import secondWeek.Ordersystem.model.Order;
import secondWeek.Ordersystem.model.Product;

import java.util.List;
import java.util.Optional;

public class OrderService {
 private final OrderDb orderDb;
 private final ProductDb productDb;
 private final StorageService storage;

 public OrderService () {
	this.productDb = new ProductDb();
	this.orderDb = new OrderDb();
	this.storage = new StorageService();
 }

 public void addOrder (Order order) {
	this.orderDb.add( order );
	this.orderDb.refresh( this.storage.updateOrders( this.orderDb.list() ) );
 }

 public Optional<List<Order>> getOrder (int id) {
	Optional<List<Order>> order;
	try {
	 order = this.orderDb.get( id );
	 if ( order.isEmpty() ) {
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
	this.orderDb.refresh( this.storage.updateOrders( this.orderDb.list() ) );
 }

 public Optional<List<Order>> listOrders () {
	return this.orderDb.list();
 }
}
