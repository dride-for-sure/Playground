package secondWeek.Ordersystem;

import java.util.*;

public class ProductDb {

 private HashMap<Integer, Product> productDb = new HashMap<>();

 public void add (Product products) {
	productDb.put( products.getId(), products );
 }

 public Product getProduct (int id) {
	return productDb.get( id );
 }

 public List<Product> getProducts () {
	Collection val = productDb.values();
	return new ArrayList<Product>( val );
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
