package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrderDbTester {

 @Test
 void addAndGetOrders () {
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

	OrderDb orderDb = new OrderDb();
	orderDb.add( order1 );
	orderDb.add( order2 );

	List<Order> actual = orderDb.getOrders();

	ArrayList<Product> expectedOrder1List = new ArrayList<>();
	expectedOrder1List.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	expectedOrder1List.add( new Buns( 2, "Mohnbrötchen", false ) );
	Order expectedOrder1 = new Order( 1, expectedOrder1List );

	ArrayList<Product> expectedOrder2List = new ArrayList<>();
	expectedOrder2List.add( new Bread( 1, "Bauernbrot", false ) );
	expectedOrder2List.add( new Buns( 2, "Seelenbrötchen", false ) );
	Order expectedOrder2 = new Order( 2, expectedOrder2List );

	ArrayList<Order> expected = new ArrayList<>();
	expected.add( expectedOrder1 );
	expected.add( expectedOrder2 );

	assertEquals( actual, expected );
 }

 @Test
 void addAndGetOrdersEmpty () {
	OrderDb orderDb = new OrderDb();
	List<Order> actual = orderDb.getOrders();
	ArrayList<Order> expected = new ArrayList<>();
	assertEquals( actual, expected );
 }

 @Test
 void addAndGetProduct () {
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

	OrderDb orderDb = new OrderDb();
	orderDb.add( order1 );
	orderDb.add( order2 );

	Order actual = orderDb.get( 1 );

	ArrayList<Product> expectedOrder = new ArrayList<>();
	expectedOrder.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	expectedOrder.add( new Buns( 2, "Mohnbrötchen", false ) );
	Order expected = new Order( 1, expectedOrder );

	assertEquals( actual, expected );
 }

 @Test
 void addAndGetProductNull () {
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

	OrderDb orderDb = new OrderDb();
	orderDb.add( order1 );
	orderDb.add( order2 );

	Order actual = orderDb.get( 3 );

	assertEquals( actual, null );
 }
}
