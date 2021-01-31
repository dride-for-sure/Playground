package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StorageTester {

 @Test
 void putOrderDbTest () {
 }

 @Test
 void putProductDbTest () {
 }

 @Test
 void getOrderDbTest () {
	Product order1Product1 = new Bread( 1, "Roggenvollkornbrot", true );
	Product order1Product2 = new Buns( 2, "Mohnbrötchen", false );
	ArrayList<Product> order1Products = new ArrayList<>();
	order1Products.add( order1Product1 );
	order1Products.add( order1Product2 );

	Product order2Product1 = new Bread( 1, "Bauernbrot", false );
	Product order2Product2 = new Buns( 2, "Seelenbrötchen", false );
	ArrayList<Product> order2Products = new ArrayList<>();
	order2Products.add( order2Product1 );
	order2Products.add( order2Product2 );

	Order order1 = new Order( 1, order1Products );
	Order order2 = new Order( 2, order2Products );

	OrderService orderService = new OrderService();
	orderService.add( order1 );
	orderService.add( order2 );

	Storage storage = new Storage();
	storage.putOrderDb( orderService.list() );

	List<Order> actual = storage.getOrderDb();

	Product expectedOrder1Product1 = new Bread( 1, "Roggenvollkornbrot", true );
	Product expectedOrder1Product2 = new Buns( 2, "Mohnbrötchen", false );
	ArrayList<Product> expectedOrder1Products = new ArrayList<>();
	expectedOrder1Products.add( expectedOrder1Product1 );
	expectedOrder1Products.add( expectedOrder1Product2 );

	Product expectedOrder2Product1 = new Bread( 1, "Bauernbrot", false );
	Product expectedOrder2Product2 = new Buns( 2, "Seelenbrötchen", false );
	ArrayList<Product> expectedOrder2Products = new ArrayList<>();
	expectedOrder2Products.add( expectedOrder2Product1 );
	expectedOrder2Products.add( expectedOrder2Product2 );

	Order expectedOrder1 = new Order( 1, expectedOrder1Products );
	Order expectedOrder2 = new Order( 2, expectedOrder2Products );

	List<Order> expected = new ArrayList<>();
	expected.add( expectedOrder1 );
	expected.add( expectedOrder2 );

	assertEquals( expected, actual );
 }

 /*@Test
 void getOrderDbTestEmpty () {
	Storage storage = new Storage();
	List<Order> orderDb = storage.getOrderDb();
	assertEquals( orderDb, new ArrayList<>() );
 }*/

 @Test
 void getProductDbTest () {
 }
}
