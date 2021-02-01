package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;
import secondWeek.Ordersystem.db.OrderDb;
import secondWeek.Ordersystem.model.Order;
import secondWeek.Ordersystem.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderDbTester {

 @Test
 void addAndGetOrders () {
	Product order1Product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product order1Product2 = new Product( 2, "Mohnbrötchen", false );
	ArrayList<Product> order1Products = new ArrayList<>();
	order1Products.add( order1Product1 );
	order1Products.add( order1Product2 );

	Product order2Product1 = new Product( 3, "Bauernbrot", false );
	Product order2Product2 = new Product( 4, "Seelenbrötchen", false );
	ArrayList<Product> order2Products = new ArrayList<>();
	order2Products.add( order2Product1 );
	order2Products.add( order2Product2 );

	Order order1 = new Order( 1, order1Products );
	Order order2 = new Order( 2, order2Products );

	OrderDb orderDb = new OrderDb();
	orderDb.add( order1 );
	orderDb.add( order2 );

	List<Order> actual = orderDb.list();

	ArrayList<Product> expectedOrder1List = new ArrayList<>();
	expectedOrder1List.add( new Product( 1, "Roggenvollkornbrot", true ) );
	expectedOrder1List.add( new Product( 2, "Mohnbrötchen", false ) );
	Order expectedOrder1 = new Order( 1, expectedOrder1List );

	ArrayList<Product> expectedOrder2List = new ArrayList<>();
	expectedOrder2List.add( new Product( 3, "Bauernbrot", false ) );
	expectedOrder2List.add( new Product( 4, "Seelenbrötchen", false ) );
	Order expectedOrder2 = new Order( 2, expectedOrder2List );

	ArrayList<Order> expected = new ArrayList<>();
	expected.add( expectedOrder1 );
	expected.add( expectedOrder2 );

	assertEquals( actual, expected );
 }

 @Test
 void addAndGetOrdersEmpty () {
	OrderDb orderDb = new OrderDb();
	List<Order> actual = orderDb.list();
	ArrayList<Order> expected = new ArrayList<>();
	assertEquals( actual, expected );
 }

 @Test
 void addAndGetProduct () {
	Product order1Product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product order1Product2 = new Product( 2, "Mohnbrötchen", false );
	ArrayList<Product> order1Products = new ArrayList<>();
	order1Products.add( order1Product1 );
	order1Products.add( order1Product2 );

	Product order2Product1 = new Product( 3, "Bauernbrot", false );
	Product order2Product2 = new Product( 4, "Seelenbrötchen", false );
	ArrayList<Product> order2Products = new ArrayList<>();
	order2Products.add( order2Product1 );
	order2Products.add( order2Product2 );

	Order order1 = new Order( 1, order1Products );
	Order order2 = new Order( 2, order2Products );

	OrderDb orderDb = new OrderDb();
	orderDb.add( order1 );
	orderDb.add( order2 );

	Optional<List<Order>> actual = orderDb.get( 1 );

	ArrayList<Product> expectedOrder = new ArrayList<>();
	expectedOrder.add( new Product( 1, "Roggenvollkornbrot", true ) );
	expectedOrder.add( new Product( 2, "Mohnbrötchen", false ) );
	Order expected = new Order( 1, expectedOrder );

	assertEquals( actual.get().get( 0 ), expected );
 }

 @Test
 void addAndGetProductNull () {
	Product order1Product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product order1Product2 = new Product( 2, "Mohnbrötchen", false );
	ArrayList<Product> order1Products = new ArrayList<>();
	order1Products.add( order1Product1 );
	order1Products.add( order1Product2 );

	Product order2Product1 = new Product( 3, "Bauernbrot", false );
	Product order2Product2 = new Product( 4, "Seelenbrötchen", false );
	ArrayList<Product> order2Products = new ArrayList<>();
	order2Products.add( order2Product1 );
	order2Products.add( order2Product2 );

	Order order1 = new Order( 1, order1Products );
	Order order2 = new Order( 2, order2Products );

	OrderDb orderDb = new OrderDb();
	orderDb.add( order1 );
	orderDb.add( order2 );

	Optional<List<Order>> actual = orderDb.get( 3 );

	assertTrue( actual.isEmpty() );
 }

 @Test
 void refresh () {

 }

 @Test
 void refreshEmpty () {

 }
}
