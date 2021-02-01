package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;
import secondWeek.Ordersystem.model.Order;
import secondWeek.Ordersystem.model.Product;
import secondWeek.Ordersystem.services.OrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderServiceTest {

 @Test
 void addAndListOrders () {
	ArrayList<Product> order1List = new ArrayList<>();
	order1List.add( new Product( 1, "Roggenvollkornbrot", true ) );
	order1List.add( new Product( 2, "Mohnbrötchen", false ) );
	Order order1 = new Order( 1, order1List );

	ArrayList<Product> order2List = new ArrayList<>();
	order2List.add( new Product( 3, "Bauernbrot", false ) );
	order2List.add( new Product( 4, "Seelenbrötchen", false ) );
	Order order2 = new Order( 2, order2List );

	OrderService orderService = new OrderService();
	orderService.addOrder( order1 );
	orderService.addOrder( order2 );
	List<Order> actual = orderService.listOrders();

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

	assertEquals( expected, actual );
 }

 @Test
 void listOrdersEmpty () {
	OrderService orderService = new OrderService();
	List<Order> actual = orderService.listOrders();
	assertEquals( new ArrayList<Order>(), actual );
 }

 @Test
 void getOrderById () {
	ArrayList<Product> order1List = new ArrayList<>();
	order1List.add( new Product( 1, "Roggenvollkornbrot", true ) );
	order1List.add( new Product( 2, "Mohnbrötchen", false ) );
	Order order1 = new Order( 1, order1List );

	ArrayList<Product> order2List = new ArrayList<>();
	order2List.add( new Product( 3, "Bauernbrot", false ) );
	order2List.add( new Product( 4, "Seelenbrötchen", false ) );
	Order order2 = new Order( 2, order2List );

	OrderService orderService = new OrderService();
	orderService.addOrder( order1 );
	orderService.addOrder( order2 );
	Optional<List<Order>> actual = orderService.getOrder( 1 );

	ArrayList<Product> productList = new ArrayList<>();
	productList.add( new Product( 1, "Roggenvollkornbrot", true ) );
	productList.add( new Product( 2, "Mohnbrötchen", false ) );
	Order expected = new Order( 1, productList );
	assertEquals( expected, actual.get().get( 0 ) );
 }

 @Test
 void getOrderByIdInvalid () {
	ArrayList<Product> order1List = new ArrayList<>();
	order1List.add( new Product( 1, "Roggenvollkornbrot", true ) );
	order1List.add( new Product( 2, "Mohnbrötchen", false ) );
	Order order1 = new Order( 1, order1List );

	ArrayList<Product> order2List = new ArrayList<>();
	order2List.add( new Product( 3, "Bauernbrot", false ) );
	order2List.add( new Product( 4, "Seelenbrötchen", false ) );
	Order order2 = new Order( 2, order2List );

	OrderService orderService = new OrderService();
	orderService.addOrder( order1 );
	orderService.addOrder( order2 );
	Optional<List<Order>> actual = orderService.getOrder( 3 );

	assertTrue( actual.isEmpty() );
 }

 @Test
 void removeOrderById () {
 }

 @Test
 void removeOrderByIdInvalid () {
 }

 @Test
 void addAndListProduct () {
 }

 @Test
 void listProductsEmpty () {
 }

 @Test
 void getProductById () {
 }

 @Test
 void getProductByIdInvalid () {

 }

 @Test
 void removeProductById () {
 }

 @Test
 void removeProductByIdInvalid () {
 }
}

