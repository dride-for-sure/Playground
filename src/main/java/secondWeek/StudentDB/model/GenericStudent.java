package secondWeek.StudentDB.model;

import java.util.Objects;

public class GenericStudent implements Student {

 private String name;
 private int id;
 private String studies;

 public GenericStudent (String name, int id, String studies) {
	this.name = name;
	this.id = id;
	this.studies = studies;
 }

 public String getName () {
	return this.name;
 }

 public void setName (String name) {
	this.name = name;
 }

 public int getId () {
	return this.id;
 }

 public void setId (int id) {
	this.id = id;
 }

 public String getStudies () {
	return studies;
 }

 public void setStudies (String studies) {
	this.studies = studies;
 }

 @Override
 public String toString () {
	return "Student{" +
					"name='" + name + '\'' +
					", id=" + id +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	GenericStudent student = (GenericStudent) o;
	return getId() == student.getId() && getName().equals( student.getName() );
 }

 @Override
 public int hashCode () {
	return Objects.hash( getName(), getId() );
 }
}