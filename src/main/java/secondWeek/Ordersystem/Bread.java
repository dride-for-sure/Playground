package secondWeek.Ordersystem;

import java.util.Objects;

public class Bread {

 private final boolean vollkorn;
 private final String name;
 private final int id;

 public Bread (int id, String name, boolean vollkorn) {
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
	Bread bread = (Bread) o;
	return getVollkorn() == bread.getVollkorn();
 }

 @Override
 public int hashCode () {
	return Objects.hash( getVollkorn() );
 }
}
