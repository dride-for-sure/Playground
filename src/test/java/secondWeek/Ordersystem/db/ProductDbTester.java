package secondWeek.Ordersystem.db;

import org.junit.jupiter.api.Test;
import secondWeek.Ordersystem.db.ProductDb;
import secondWeek.Ordersystem.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProductDbTester {

 @Test
 void addAndList () {
	Product product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product product2 = new Product( 2, "Mohnbrötchen", false );
	Product product3 = new Product( 3, "Bauernbrot", false );
	Product product4 = new Product( 4, "Seelenbrötchen", false );

	ProductDb db = new ProductDb();
	db.add( product1 );
	db.add( product2 );
	db.add( product3 );
	db.add( product4 );
	List<Product> actual = db.list();

	List<Product> expected = new ArrayList<Product>();
	expected.add( new Product( 1, "Roggenvollkornbrot", true ) );
	expected.add( new Product( 2, "Mohnbrötchen", false ) );
	expected.add( new Product( 3, "Bauernbrot", false ) );
	expected.add( new Product( 4, "Seelenbrötchen", false ) );
	assertEquals( expected, actual );
 }

 @Test
 void addAndListEmpty () {
	ProductDb db = new ProductDb();
	List<Product> actual = db.list();
	assertTrue( actual.isEmpty() );
 }

 @Test
 void addAndGet () {
	Product product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product product2 = new Product( 2, "Mohnbrötchen", false );
	Product product3 = new Product( 3, "Bauernbrot", false );
	Product product4 = new Product( 4, "Seelenbrötchen", false );

	ProductDb db = new ProductDb();
	db.add( product1 );
	db.add( product2 );
	db.add( product3 );
	db.add( product4 );

	Optional<List<Product>> actual = db.get( 3 );
	Product expectedProduct = new Product( 3, "Bauernbrot", false );
	List<Product> expected = new ArrayList<>();
	expected.add( expectedProduct );


	assertEquals( expected, actual.get() );
 }

 @Test
 void addAndGetNull () {
	Product product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product product2 = new Product( 2, "Mohnbrötchen", false );
	Product product3 = new Product( 3, "Bauernbrot", false );
	Product product4 = new Product( 4, "Seelenbrötchen", false );

	ProductDb db = new ProductDb();
	db.add( product1 );
	db.add( product2 );
	db.add( product3 );
	db.add( product4 );

	Optional<List<Product>> actual = db.get( 5 );
	assertTrue( actual.isEmpty() );
 }

 @Test
 void refresh () {

 }

 @Test
 void refreshEmpty () {

 }
}
