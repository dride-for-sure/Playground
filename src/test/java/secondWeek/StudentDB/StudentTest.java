package secondWeek.StudentDB;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import secondWeek.StudentDB.model.Student;
import secondWeek.StudentDB.model.StudentDB;

import java.util.ArrayList;
import java.util.List;
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
	List<Student> students = new ArrayList<Student>();
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
	List<Student> students = new ArrayList<Student>();
	students.add( new Student( "Hans", 1 ) );
	students.add( new Student( "Otto", 2 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	assertEquals( students, db.getStudents() );
 }

 @Test
 void randomStudent () {
	List<Student> students = new ArrayList<Student>();
	students.add( new Student( "Hans", 1 ) );
	students.add( new Student( "Otto", 2 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	assertTrue( db.getRandomStudent() instanceof Student );
 }

 @Test
 void randomStudents () {
	List<Student> students = new ArrayList<Student>();
	students.add( new Student( "Otto", 1 ) );
	students.add( new Student( "Otto", 2 ) );
	students.add( new Student( "Otto", 3 ) );
	students.add( new Student( "Otto", 4 ) );
	students.add( new Student( "Otto", 5 ) );

	StudentDB db = new StudentDB();
	db.addStudents( students );
	System.out.print( db.getRandomStudents() );
	assertTrue( db.getRandomStudents() instanceof List );
 }
}