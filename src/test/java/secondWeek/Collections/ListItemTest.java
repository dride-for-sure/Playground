package secondWeek.Collections;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListItemTest {

 @Test
 void addTester () {
	ListItem listHead = new ListItem( new Animal( "A" ) );
	ListItem listItem1 = new ListItem( new Animal( "B" ) );
	listHead.add( listItem1 );
	assertEquals( listHead.getNext(), listItem1 );
 }

 @Test
 void getListTester () {
	ListItem listHead = new ListItem( new Animal( "A" ) );
	ListItem listItem1 = new ListItem( new Animal( "B" ) );
	ListItem listItem2 = new ListItem( new Animal( "C" ) );
	listHead.add( listItem1 );
	listHead.add( listItem2 );
	assertEquals( "A -> B -> C", listHead.list() );
 }

 @Test
 void removeNotFirstItem () {
	ListItem listHead = new ListItem( new Animal( "A" ) );
	ListItem listItem1 = new ListItem( new Animal( "B" ) );
	ListItem listItem2 = new ListItem( new Animal( "C" ) );
	ListItem listItem3 = new ListItem( new Animal( "B" ) );
	ListItem listItem4 = new ListItem( new Animal( "D" ) );
	listHead.add( listItem1 );
	listHead.add( listItem2 );
	listHead.add( listItem3 );
	listHead.add( listItem4 );
	listHead.removeItemsLike( listItem1 );
	assertEquals( "A -> C -> D", listHead.list() );
 }

 @Test
 void removeFirstItem () {
	ListItem listHead = new ListItem( new Animal( "A" ) );
	ListItem listItem1 = new ListItem( new Animal( "B" ) );
	ListItem listItem2 = new ListItem( new Animal( "C" ) );
	ListItem listItem3 = new ListItem( new Animal( "B" ) );
	ListItem listItem4 = new ListItem( new Animal( "D" ) );
	listHead.add( listItem1 );
	listHead.add( listItem2 );
	listHead.add( listItem3 );
	listHead.add( listItem4 );
	listHead.removeItemsLike( listHead );
	assertEquals( "B -> C -> B -> D", listHead.list() );
 }

 @Test
 void removeLastItem () {
	ListItem listHead = new ListItem( new Animal( "A" ) );
	ListItem listItem1 = new ListItem( new Animal( "B" ) );
	ListItem listItem2 = new ListItem( new Animal( "C" ) );
	ListItem listItem3 = new ListItem( new Animal( "B" ) );
	ListItem listItem4 = new ListItem( new Animal( "D" ) );
	listHead.add( listItem1 );
	listHead.add( listItem2 );
	listHead.add( listItem3 );
	listHead.add( listItem4 );
	listHead.removeItemsLike( listItem3 );
	assertEquals( "A -> C -> D", listHead.list() );
 }
}
