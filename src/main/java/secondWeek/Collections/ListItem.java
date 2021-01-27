package secondWeek.Collections;

public class ListItem {
 private Animal value;
 private ListItem next;

 public ListItem (Animal value) {
	this.value = value;
 }

 public Animal getValue () {
	return value;
 }

 public void setValue (Animal value) {
	this.value = value;
 }

 public ListItem getNext () {
	return next;
 }

 public void setNext (ListItem next) {
	this.next = next;
 }

 @Override
 public String toString () {
	return "ListItem{" +
					"value=" + value.getName() +
					", next=" + next +
					'}';
 }

 public void add (ListItem listItem) {
	if ( this.next == null ) {
	 this.next = listItem;
	} else {
	 this.next.add( listItem );
	}
 }

 public String list () {
	String list = "";
	ListItem thisListItem = this;
	do {
	 if ( thisListItem.getValue() != null ) {
		list += thisListItem.getValue().getName();
		if ( thisListItem.getNext() != null ) {
		 list += " -> ";
		}
	 }
	 thisListItem = thisListItem.getNext();
	} while ( thisListItem != null );
	return list;
 }

 public void removeItemsLike (ListItem listItem) {
	if ( listItem.getValue().getName() == this.getValue().getName() ) {
	 this.removeHead( listItem );
	} else {
	 this.removeTail( listItem );
	}
 }

 private void removeHead (ListItem listHead) {
	listHead.setValue( null );
 }

 private void removeTail (ListItem listItem) {
	ListItem thisListItem = this;
	while ( thisListItem.getNext() != null ) {
	 if ( thisListItem.getNext().getValue().getName() == listItem.getValue().getName() ) {
		thisListItem.setNext( thisListItem.getNext().getNext() );
	 }
	 if ( thisListItem.getNext() != null ) {
		thisListItem = thisListItem.getNext();
	 } else {
		break;
	 }
	}
 }
}
