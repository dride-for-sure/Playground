package secondWeek.Ordersystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderServiceTest {

 @Test
 void addAndList () {
	ArrayList<Product> order1List = new ArrayList<>();
	order1List.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	order1List.add( new Buns( 2, "Mohnbrötchen", false ) );
	Order order1 = new Order( 1, order1List );

	ArrayList<Product> order2List = new ArrayList<>();
	order2List.add( new Bread( 1, "Bauernbrot", false ) );
	order2List.add( new Buns( 2, "Seelenbrötchen", false ) );
	Order order2 = new Order( 2, order2List );

	OrderService orderService = new OrderService();
	orderService.add( order1 );
	orderService.add( order2 );
	List<Order> actual = orderService.list();

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

	assertEquals( expected, actual );
 }

 @Test
 void listEmpty () {
	OrderService orderService = new OrderService();
	List<Order> actual = orderService.list();
	assertEquals( new ArrayList<Order>(), actual );
 }

 @Test
 void get () {
	ArrayList<Product> order1List = new ArrayList<>();
	order1List.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	order1List.add( new Buns( 2, "Mohnbrötchen", false ) );
	Order order1 = new Order( 1, order1List );

	ArrayList<Product> order2List = new ArrayList<>();
	order2List.add( new Bread( 1, "Bauernbrot", false ) );
	order2List.add( new Buns( 2, "Seelenbrötchen", false ) );
	Order order2 = new Order( 2, order2List );

	OrderService orderService = new OrderService();
	orderService.add( order1 );
	orderService.add( order2 );
	Optional<Order> actual = orderService.get( 1 );

	ArrayList<Product> productList = new ArrayList<>();
	productList.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	productList.add( new Buns( 2, "Mohnbrötchen", false ) );
	Order expected = new Order( 1, productList );
	assertEquals( expected, actual.get() );
 }

 @Test
 void getNull () {
	ArrayList<Product> order1List = new ArrayList<>();
	order1List.add( new Bread( 1, "Roggenvollkornbrot", true ) );
	order1List.add( new Buns( 2, "Mohnbrötchen", false ) );
	Order order1 = new Order( 1, order1List );

	ArrayList<Product> order2List = new ArrayList<>();
	order2List.add( new Bread( 1, "Bauernbrot", false ) );
	order2List.add( new Buns( 2, "Seelenbrötchen", false ) );
	Order order2 = new Order( 2, order2List );

	OrderService orderService = new OrderService();
	orderService.add( order1 );
	orderService.add( order2 );
	Optional<Order> actual = orderService.get( 3 );

	assertTrue( actual.isEmpty() );
 }
}
