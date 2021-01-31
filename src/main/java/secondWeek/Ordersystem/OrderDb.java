package secondWeek.Ordersystem;

import java.util.*;

public class OrderDb {

 private HashMap<Integer, Order> orderDb = new HashMap<>();

 public void add (Order order) {
	orderDb.put( order.getId(), order );
 }

 public void remove (int id) {
	this.orderDb.remove( id );
 }

 public Optional<List<Order>> get (int id) {
	List<Order> list = new ArrayList<>();
	try {
	 Order order = orderDb.get( id );
	 if ( order == null ) {
		throw new Exception( "Order with ID is not available" );
	 } else {
		list.add( order );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	 return Optional.empty();
	}
	return Optional.of( list );
 }

 public List<Order> list () {
	Collection val = orderDb.values();
	return new ArrayList<Order>( val );
 }

 public void refresh (Optional<List<Order>> orders) {
	HashMap<Integer, Order> orderDb = new HashMap<>();
	if ( orders.isPresent() ) {
	 for ( Order order : orders.get() ) {
		orderDb.put( order.getId(), order );
	 }
	}
	this.orderDb = orderDb;
 }

 @Override
 public String toString () {
	return "OrderDb{" +
					"orderDb=" + orderDb +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	OrderDb orderDb1 = (OrderDb) o;
	return Objects.equals( orderDb, orderDb1.orderDb );
 }

 @Override
 public int hashCode () {
	return Objects.hash( orderDb );
 }
}