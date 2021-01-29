package secondWeek.Ordersystem;

import java.util.*;

public class OrderDb {

 private HashMap<Integer, Order> orderDb = new HashMap<>();

 public void add (Order order) {
	orderDb.put( order.getId(), order );
 }

 public Order get (int id) {
	return orderDb.get( id );
 }

 public List<Order> getOrders () {
	Collection val = orderDb.values();
	return new ArrayList<Order>( val );
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
