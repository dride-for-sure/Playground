package secondWeek.Ordersystem;

import java.util.Objects;

public class Bread extends Products {

 private final boolean vollkorn;

 public Bread (int id, String name, boolean vollkorn) {
	super( id, name );
	this.vollkorn = vollkorn;
 }

 public boolean getVollkorn () {
	return this.vollkorn;
 }

 @Override
 public String toString () {
	return "Bread{" +
					"vollkorn=" + vollkorn +
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
