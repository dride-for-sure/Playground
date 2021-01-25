package secondWeek;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import secondWeek.model.Student;
import secondWeek.model.StudentDB;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

 @ParameterizedTest
 @MethodSource
 void addGetStudent (String name, int id) {
	Student student = new Student( name, id );
	StudentDB db = new StudentDB();
	db.addStudent( student );
	assertEquals( student, db.getStudent( id ) );
 }

 static Stream<Arguments> addGetStudent () {
	return Stream.of(
					Arguments.of( "Hans", 1 ),
					Arguments.of( "Otto", 2 ),
					Arguments.of( "", 0 )
	);
 }

 @Test
 void addGetStudents () {
	ArrayList<Student> students = new ArrayList<Student>();
	students.add( new Student( "Hans", 1 ) );
	students.add( new Student( "Otto", 2 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	assertEquals( students, db.getStudents() );
 }

 @ParameterizedTest
 @MethodSource
 void deleteStudent (String name, int id) {
	Student student = new Student( name, id );
	StudentDB db = new StudentDB();
	db.addStudent( student );
	db.deleteStudent( student );
	assertFalse( db.getStudents().contains( student ) );
 }

 static Stream<Arguments> deleteStudent () {
	return Stream.of(
					Arguments.of( "Hans", 1 ),
					Arguments.of( "Otto", 2 ),
					Arguments.of( "", 0 )
	);
 }

 @Test
 void deleteStudents () {
	ArrayList<Student> students = new ArrayList<Student>();
	students.add( new Student( "Hans", 1 ) );
	students.add( new Student( "Otto", 2 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	assertEquals( students, db.getStudents() );
 }

 @Test
 void randomStudent () {
	ArrayList<Student> students = new ArrayList<Student>();
	students.add( new Student( "Hans", 1 ) );
	students.add( new Student( "Otto", 2 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	db.getRandomStudent();
	assertTrue( db.getRandomStudent() instanceof Student );
 }
}