package secondWeek.StudentDB.model;

import java.util.*;

public class StudentDB {
 private final HashMap<Integer, Student> students = new HashMap<>();

 // Single
 public Student getStudent (int id) {
	return this.students.get( id );
 }

 public void addStudent (Student student) {
	this.students.put( student.getId(), student );
 }

 public void deleteStudent (Student deleteStudent) {
	this.students.remove( deleteStudent.getId() );
 }

 public Student getRandomStudent () {
	Object[] array = this.students.keySet().toArray();
	Object randomKey = array[ (int) ( Math.random() * this.students.size() ) ];
	return this.students.get( randomKey );
 }

 public Optional<Student> findById (int id) {
	Student possibleStudent = this.students.get( id );
	if ( possibleStudent == null ) {
	 return Optional.empty();
	}
	return Optional.of( possibleStudent );
 }

 // Batch
 public List<Student> getStudents () {
	Collection<Student> values = this.students.values();
	return new ArrayList<Student>( values );
 }

 public void addStudents (List<Student> students) {
	for ( Student student : students ) {
	 this.students.put( student.getId(), student );
	}
 }

 public void deleteStudents (List<Student> deleteStudents) {
	for ( Student deleteStudent : deleteStudents ) {
	 students.remove( deleteStudent.getId() );
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

