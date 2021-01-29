package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductDBTester {

 @Test
 void addAndList () {
	Product product1 = new Bread( 1, "Roggenvollkornbrot", true );
	Product product2 = new Buns( 2, "Mohnbrötchen", false );
	Product product3 = new Bread( 3, "Bauernbrot", false );
	Product product4 = new Buns( 4, "Seelenbrötchen", false );

	ProductDb db = new ProductDb();
	db.add( product1 );
	db.add( product2 );
	db.add( product3 );
	db.add( product4 );
	List<Product> actual = db.list();
	
	List<Product> expected = new ArrayList<Product>();
	expected.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	expected.add( new Buns( 2, "Mohnbrötchen", false ) );
	expected.add( new Bread( 3, "Bauernbrot", false ) );
	expected.add( new Buns( 4, "Seelenbrötchen", false ) );
	assertEquals( expected, actual );
 }


}
