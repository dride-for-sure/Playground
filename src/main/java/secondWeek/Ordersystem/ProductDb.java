package secondWeek.Ordersystem;

import java.util.*;

public class ProductDb {

 private HashMap<Integer, Product> productDb = new HashMap<>();

 public void add (Product products) {
	productDb.put( products.getId(), products );
 }

 public Optional<List<Product>> get (int id) {
	List<Product> list = new ArrayList<>();
	try {
	 Product product = productDb.get( id );
	 if ( product == null ) {
		throw new Exception( "Order with ID is not available" );
	 } else {
		list.add( product );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	}
	return Optional.of( list );
 }

 public Optional<List<Product>> list () {
	Collection val = productDb.values();
	if ( val.isEmpty() ) {
	 return Optional.empty();
	} else {
	 return Optional.of( new ArrayList<Product>( val ) );
	}
 }

 @Override
 public String toString () {
	return "ProductDb{" +
					"productDb=" + productDb +
					'}';
 }

 @Override
 public boolean equals (Object o) {
	if ( this == o ) return true;
	if ( o == null || getClass() != o.getClass() ) return false;
	ProductDb productDb1 = (ProductDb) o;
	return Objects.equals( productDb, productDb1.productDb );
 }

 @Override
 public int hashCode () {
	return Objects.hash( productDb );
 }
}
