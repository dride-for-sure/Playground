package secondWeek.Ordersystem;

import java.util.ArrayList;
import java.util.Objects;

public class Order {

 private final int id;
 private final ArrayList<Product> products;

 public Order (int id, ArrayList<Product> products) {
	this.id = id;
	this.products = products;
 }

 public int getId () {
	return id;
 }

 public ArrayList<Product> getProducts () {
	return products;
 }

 @Override
 public String toString () {
	return "Order{" +
					"id=" + id +
					", products=" + products +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	Order order = (Order) o;
	return getId() == order.getId() && Objects.equals( getProducts(), order.getProducts() );
 }

 @Override
 public int hashCode () {
	return Objects.hash( getId(), getProducts() );
 }
}
