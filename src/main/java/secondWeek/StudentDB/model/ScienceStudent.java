package secondWeek.StudentDB.model;

import java.util.Objects;

public class ScienceStudent extends GenericStudent implements Nerd {

 private String name;
 private int id;
 private String studies;
 private boolean nerd;

 public ScienceStudent (String name, int id, String studies, boolean nerd) {
	super( name, id, studies );
	this.nerd = nerd;
 }

 public boolean getNerd () {
	return nerd;
 }

 public void setNerd (boolean nerd) {
	this.nerd = nerd;
 }

 @Override
 public String toString () {
	return "ScienceStudent{" +
					"name='" + name + '\'' +
					", id=" + id +
					", nerd=" + nerd +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	ScienceStudent that = (ScienceStudent) o;
	return getId() == that.getId() && getNerd() == that.getNerd() && getName().equals( that.getName() );
 }

 @Override
 public int hashCode () {
	return Objects.hash( getName(), getId(), getNerd() );
 }
}
