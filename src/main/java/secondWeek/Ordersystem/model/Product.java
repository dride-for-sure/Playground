package secondWeek.Ordersystem.model;

import java.util.Objects;

public class Product {

 private boolean vollkorn;
 private String name;
 private int id;

 public Product () {
 }

 public Product (int id, String name, boolean vollkorn) {
	this.name = name;
	this.id = id;
	this.vollkorn = vollkorn;
 }

 public int getId () {
	return this.id;
 }

 public String getName () {
	return this.name;
 }

 public boolean getVollkorn () {
	return this.vollkorn;
 }

 public void setId (int id) {
	this.id = id;
 }

 public void setName (String name) {
	this.name = name;
 }

 public void setVollkorn (boolean vollkorn) {
	this.vollkorn = vollkorn;
 }

 @Override
 public String toString () {
	return "Bread{" +
					"vollkorn=" + vollkorn +
					", name='" + name + '\'' +
					", id=" + id +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	Product product = (Product) o;
	return getVollkorn() == product.getVollkorn();
 }

 @Override
 public int hashCode () {
	return Objects.hash( getVollkorn() );
 }
}
