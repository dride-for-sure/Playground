package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;
import secondWeek.Ordersystem.db.ProductDb;
import secondWeek.Ordersystem.model.Order;
import secondWeek.Ordersystem.model.Product;
import secondWeek.Ordersystem.services.OrderService;
import secondWeek.Ordersystem.services.StorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StorageServiceTester {

 @Test
 void putAndGetOrderDb () {
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

	OrderService orderService = new OrderService();
	orderService.addOrder( order1 );
	orderService.addOrder( order2 );

	StorageService storage = new StorageService();
	Optional<List<Order>> actual = storage.refreshOrders( orderService.listOrders() ); // optional

	Product expectedOrder1Product1 = new Product( 1, "Roggenvollkornbrot", true );
	Product expectedOrder1Product2 = new Product( 2, "Mohnbrötchen", false );
	ArrayList<Product> expectedOrder1Products = new ArrayList<>();
	expectedOrder1Products.add( expectedOrder1Product1 );
	expectedOrder1Products.add( expectedOrder1Product2 );

	Product expectedOrder2Product1 = new Product( 3, "Bauernbrot", false );
	Product expectedOrder2Product2 = new Product( 4, "Seelenbrötchen", false );
	ArrayList<Product> expectedOrder2Products = new ArrayList<>();
	expectedOrder2Products.add( expectedOrder2Product1 );
	expectedOrder2Products.add( expectedOrder2Product2 );

	Order expectedOrder1 = new Order( 1, expectedOrder1Products );
	Order expectedOrder2 = new Order( 2, expectedOrder2Products );

	List<Order> expected = new ArrayList<>();
	expected.add( expectedOrder1 );
	expected.add( expectedOrder2 );

	assertEquals( expected, actual.get() );
 }

 @Test
 void putAndGetOrderDbEmpty () {
	StorageService storage = new StorageService();
	OrderService orderService = new OrderService();
	Optional<List<Order>> actual = storage.refreshOrders( orderService.listOrders() );
	assertTrue( actual.isEmpty() );
 }

 @Test
 void putAndGetProductDb () {
	ProductDb productDb = new ProductDb();
	Product orderProduct1 = new Product( 1, "Roggenvollkornbrot", true );
	Product orderProduct2 = new Product( 2, "Mohnbrötchen", false );
	Product orderProduct3 = new Product( 3, "Bauernbrot", false );
	Product orderProduct4 = new Product( 4, "Seelenbrötchen", false );
	productDb.add( orderProduct1 );
	productDb.add( orderProduct2 );
	productDb.add( orderProduct3 );
	productDb.add( orderProduct4 );

	StorageService storage = new StorageService();
	Optional<List<Product>> actual = storage.refreshProducts( productDb.list() );

	Product expectedOrderProduct1 = new Product( 1, "Roggenvollkornbrot", true );
	Product expectedOrderProduct2 = new Product( 2, "Mohnbrötchen", false );
	Product expectedOrderProduct3 = new Product( 3, "Bauernbrot", false );
	Product expectedOrderProduct4 = new Product( 4, "Seelenbrötchen", false );

	List<Product> expected = new ArrayList<>();
	expected.add( expectedOrderProduct1 );
	expected.add( expectedOrderProduct2 );
	expected.add( expectedOrderProduct3 );
	expected.add( expectedOrderProduct4 );

	assertEquals( expected, actual.get() );
 }

 @Test
 void putAndGetProductDbEmpty () {
	ProductDb productDb = new ProductDb();
	StorageService storage = new StorageService();
	Optional<List<Product>> actual = storage.refreshProducts( productDb.list() );
	assertTrue( actual.isEmpty() );
 }
}
