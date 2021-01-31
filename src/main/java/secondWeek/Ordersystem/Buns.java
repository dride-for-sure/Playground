package secondWeek.Ordersystem;

import java.util.Objects;

public class Buns {

 private final boolean sesam;
 private final String name;
 private final int id;

 public Buns (int id, String name, boolean sesam) {
	this.name = name;
	this.id = id;
	this.sesam = sesam;
 }

 public int getId () {
	return this.id;
 }

 public String getName () {
	return this.name;
 }

 public boolean getSesam () {
	return this.sesam;
 }

 @Override
 public String toString () {
	return "Buns{" +
					"sesam=" + sesam +
					", name='" + name + '\'' +
					", id=" + id +
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
