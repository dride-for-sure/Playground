package secondWeek.Ordersystem;

import java.util.List;
import java.util.Optional;

public class OrderService {
 private OrderDb orderDb;

 public OrderService () {
	this.orderDb = new OrderDb();
 }

 public void add (Order order) {
	this.orderDb.add( order );
 }

 public Optional<Order> get (int id) {
	Optional<Order> order = null;
	try {
	 order = this.orderDb.get( id );
	 if ( !order.isPresent() ) {
		throw new Exception( "Order with ID is not available" );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	}
	return order;
 } // RÜCKFRAGEN

 public List<Order> list () {
	return this.orderDb.list();
 }
}
