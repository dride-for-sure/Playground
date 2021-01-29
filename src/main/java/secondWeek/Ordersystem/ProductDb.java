package secondWeek.Ordersystem;

import java.util.*;

public class ProductDb {

 private HashMap<Integer, Product> data = new HashMap<>();

 public void add (Product products) {
	data.put( products.getId(), products );
 }

 public Product get (int id) {
	return data.get( id );
 }

 public List<Product> list () {
	Collection val = data.values();
	return new ArrayList<Product>( val );
 }
}
