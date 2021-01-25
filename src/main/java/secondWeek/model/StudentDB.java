package secondWeek.model;

import java.util.ArrayList;

public class StudentDB {
 private ArrayList<Student> students = new ArrayList<Student>();

 // Single
 public Student getStudent (int id) {
	for ( Student student : this.students ) {
	 System.out.println( student.id );
	 if ( student.id == id ) {
		return student;
	 }
	}
	return null; // what to return?
 }

 public void addStudent (Student student) {
	this.students.add( student );
 }

 public void deleteStudent (Student deleteStudent) {
	students.removeIf( student -> student == deleteStudent );
 }

 public Student getRandomStudent () {
	return this.students.get( (int) ( Math.random() * this.students.size() ) );
 }


 // Batch
 public ArrayList<Student> getStudents () {
	return this.students;
 }

 public void addStudents (ArrayList<Student> students) {
	this.students.addAll( students );
 }

 public void deleteStudents (ArrayList<Student> deleteStudents) {
	for ( Student deleteStudent : deleteStudents ) {
	 students.removeIf( student -> student == deleteStudent );
	}
 }
}