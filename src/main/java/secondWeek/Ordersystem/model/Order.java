package secondWeek.Ordersystem.model;

import java.util.List;
import java.util.Objects;

public class Order {

 private int id;
 private List<Product> products;

 public Order (int id, List<Product> products) {
	this.id = id;
	this.products = products;
 }

 public Order () {
 }

 public int getId () {
	return id;
 }

 public List<Product> getProducts () {
	return products;
 }

 public void setId (int id) {
	this.id = id;
 }

 public void setProducts (List<Product> products) {
	this.products = products;
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
