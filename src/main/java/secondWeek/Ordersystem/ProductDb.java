package secondWeek.Ordersystem;

import java.util.*;

public class ProductDb {

 private HashMap<Integer, Product> productDb = new HashMap<>();

 public void add (Product products) {
	productDb.put( products.getId(), products );
 }

 public void remove (int id) {
	this.productDb.remove( id );
 }

 public Optional<List<Product>> get (int id) {
	List<Product> list = new ArrayList<>();
	try {
	 Product product = productDb.get( id );
	 if ( product == null ) {
		throw new Exception( "Product with ID is not available" );
	 } else {
		list.add( product );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	 return Optional.empty();
	}
	return Optional.of( list );
 }

 public List<Product> list () {
	Collection val = productDb.values();
	return new ArrayList<Product>( val );
 }

 public void refresh (Optional<List<Product>> products) {
	HashMap<Integer, Product> productDb = new HashMap<>();
	if ( products.isPresent() ) {
	 for ( Product product : products.get() ) {
		productDb.put( product.getId(), product );
	 }
	}
	this.productDb = productDb;
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
