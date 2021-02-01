package secondWeek.Ordersystem.services;

import secondWeek.Ordersystem.db.ProductDb;
import secondWeek.Ordersystem.model.Product;

import java.util.List;
import java.util.Optional;

public class ProductService {

 private final ProductDb productDb;
 private final StorageService storage;

 public ProductService () {
	this.productDb = new ProductDb();
	this.storage = new StorageService();
 }

 public void addProduct (Product product) {
	this.productDb.add( product );
	this.productDb.refresh( this.storage.updateProducts( this.productDb.list() ) );
 }

 public Optional<List<Product>> getProduct (int id) {
	Optional<List<Product>> product;
	try {
	 product = this.productDb.get( id );
	 if ( product.isEmpty() ) {
		throw new Exception( "Order with ID is not available" );
	 }
	} catch ( Exception e ) {
	 System.out.println( e );
	 return Optional.empty();
	}
	return product;
 }

 public void removeProduct (int id) {
	this.productDb.remove( id );
	this.productDb.refresh( this.storage.updateProducts( this.productDb.list() ) );
 }

 public Optional<List<Product>> listProducts () {
	return this.productDb.list();
 }
}
