package secondWeek.Ordersystem;

public class Products implements Product {

 private final String name;
 private final int id;

 public Products (int id, String name) {
	this.name = name;
	this.id = id;
 }

 public int getId () {
	return this.id;
 }

 public String getName () {
	return this.name;
 }

}
