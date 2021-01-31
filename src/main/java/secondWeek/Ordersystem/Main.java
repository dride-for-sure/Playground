package secondWeek.Ordersystem;

public class Main {
 public static void main (String[] args) {
	ProductDb productDb = new ProductDb();
	productDb.add( new Bread( 1, "Bauernbrot", true ) );

	OrderService orderService = new OrderService();
	orderService.add( new Order( 1, productDb.get( 2 ).get() ) );


	System.out.print( orderService.list() );

 }
}
