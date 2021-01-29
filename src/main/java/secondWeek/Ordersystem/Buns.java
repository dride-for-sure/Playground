package secondWeek.Ordersystem;

import java.util.Objects;

public class Buns extends Products {

 private final boolean sesam;

 public Buns (int id, String name, boolean sesam) {
	super( id, name );
	this.sesam = sesam;
 }

 public boolean getSesam () {
	return this.sesam;
 }

 @Override
 public String toString () {
	return "Buns{" +
					"sesam=" + sesam +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	Buns buns = (Buns) o;
	return getSesam() == buns.getSesam();
 }

 @Override
 public int hashCode () {
	return Objects.hash( getSesam() );
 }
}
