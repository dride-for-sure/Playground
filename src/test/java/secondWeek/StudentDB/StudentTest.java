package secondWeek.StudentDB;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import secondWeek.StudentDB.model.GenericStudent;
import secondWeek.StudentDB.model.ScienceStudent;
import secondWeek.StudentDB.model.StudentDB;
import secondWeek.StudentDB.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest<V> {

 @ParameterizedTest
 @MethodSource
 void addGetStudent (String name, int id, String studies) {
	Student student = new ScienceStudent( name, id, studies, true );
	StudentDB db = new StudentDB();
	db.addStudent( student );

	Student expectedStudent = new ScienceStudent( name, id, studies, true );
	assertEquals( expectedStudent, db.getStudent( id ) );
 }

 static Stream<Arguments> addGetStudent () {
	return Stream.of(
					Arguments.of( "Hans", 1, "physics" ),
					Arguments.of( "Otto", 2, "bio" ),
					Arguments.of( "", 0, "nix" )
	);
 }

 @Test
 void addGetStudents () {
	List<Student> students = new ArrayList<Student>();
	students.add( new GenericStudent( "Hans", 1, "Deutsch" ) );
	students.add( new GenericStudent( "Otto", 2, "Philosophie" ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );

	List<Student> expectedStudents = new ArrayList<Student>();
	expectedStudents.add( new GenericStudent( "Hans", 1, "Deutsch" ) );
	expectedStudents.add( new GenericStudent( "Otto", 2, "Philosophie" ) );
	assertEquals( expectedStudents, db.getStudents() );
 }

 @Test
 void findStudentsByIDWithSuccess () {
	List<Student> students = new ArrayList<Student>();
	students.add( new GenericStudent( "Hans", 1, "Deutsch" ) );
	students.add( new GenericStudent( "Otto", 2, "Philosophie" ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	Optional<Student> studentOptional = db.findById( 1 );
	assertTrue( studentOptional.isPresent() );
 }

 @Test
 void findStudentsByIDWithoutSuccess () {
	List<Student> students = new ArrayList<Student>();
	students.add( new GenericStudent( "Hans", 1, "Deutsch" ) );
	students.add( new GenericStudent( "Otto", 2, "Philosophie" ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	Optional<Student> studentOptional = db.findById( 3 );
	assertTrue( studentOptional.isEmpty() );

 }

 @ParameterizedTest
 @MethodSource
 void deleteStudent (String name, int id, String studies) {
	Student student = new GenericStudent( name, id, studies );
	StudentDB db = new StudentDB();
	db.addStudent( student );
	db.deleteStudent( student );
	assertFalse( db.getStudents().contains( student ) );
 }

 static Stream<Arguments> deleteStudent () {
	return Stream.of(
					Arguments.of( "Hans", 1, "Deutsch" ),
					Arguments.of( "Otto", 2, "Philosophie" ),
					Arguments.of( "", 0, "Nix" )
	);
 }

 @Test
 void deleteStudents () {
	List<Student> students = new ArrayList<Student>();
	students.add( new GenericStudent( "Hans", 1, "Deutsch" ) );
	students.add( new GenericStudent( "Otto", 2, "Philosophie" ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	assertEquals( students, db.getStudents() );
 }

 @Test
 void randomStudent () {
	List<Student> students = new ArrayList<Student>();
	students.add( new GenericStudent( "Hans", 1, "Deutsch" ) );
	students.add( new GenericStudent( "Otto", 2, "Philosophie" ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	Student randomStudent = db.getRandomStudent();
	assertTrue( randomStudent.equals( students.get( 0 ) )
					|| randomStudent.equals( students.get( 1 ) ) );
 }

 /* Mocking d. Math.random() method
 @Test
 void randomStudents () {
	List<Students> students = new ArrayList<Students>();
	students.add( new Student( "Otto", 1 ) );
	students.add( new Student( "Otto", 2 ) );
	students.add( new Student( "Otto", 3 ) );
	students.add( new Student( "Otto", 4 ) );
	students.add( new Student( "Otto", 5 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	System.out.print( db.getRandomStudents() );
	assertTrue();
 }
 */
}