package secondWeek.StudentDB.model;

import java.util.Objects;

public class SportStudent extends GenericStudent implements Talent {

 private String name;
 private int id;
 private String studies;
 private String talent;

 public SportStudent (String name, int id, String studies, String talent) {
	super( name, id, studies );
	this.talent = talent;
 }

 public String getTalent () {
	return talent;
 }

 public void setTalent (String talent) {
	this.talent = talent;
 }

 @Override
 public String toString () {
	return "SportStudent{" +
					"name='" + name + '\'' +
					", id=" + id +
					", talent=" + talent +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	SportStudent that = (SportStudent) o;
	return getId() == that.getId() && getTalent() == that.getTalent() && getName().equals( that.getName() );
 }

 @Override
 public int hashCode () {
	return Objects.hash( getName(), getId(), getTalent() );
 }
}
