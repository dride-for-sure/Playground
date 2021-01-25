package secondWeek.StudentDB.model;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {
 private final List<Student> students = new ArrayList<Student>();

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
 public List<Student> getStudents () {
	return this.students;
 }

 public void addStudents (List<Student> students) {
	this.students.addAll( students );
 }

 public void deleteStudents (List<Student> deleteStudents) {
	for ( Student deleteStudent : deleteStudents ) {
	 students.removeIf( student -> student == deleteStudent );
	}
 }

 public List<Student> getRandomStudents () {
	List<Student> students = new ArrayList<Student>();
	int count = (int) ( Math.random() * this.students.size() );
	int i = 0;
	while ( i < count ) {
	 int randomIndex = (int) ( Math.random() * this.students.size() );
	 if ( !students.contains( this.students.get( randomIndex ) ) ) {
		students.add( this.students.get( randomIndex ) );
		i++;
	 }
	}
	return students;
 }

}