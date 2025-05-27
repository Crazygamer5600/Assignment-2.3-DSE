package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author simont
 *
 */
public class DSEListGeneric implements ListGeneric {
	
	public NodeGeneric head;
	private NodeGeneric tail;

	public DSEListGeneric() {
		
	}
	public DSEListGeneric(NodeGeneric head_) {
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric other) { // Copy constructor. 
		this.head = other.head;
		NodeGeneric currNode = other.head;
		
		while (currNode != null) {
			NodeGeneric nodemaker = new NodeGeneric(currNode.next, currNode.prev, currNode.get());
			currNode = currNode.next;
		}
	}

	//remove and return the item at the parameter's index
	public void remove(int index) {

	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
	}
	
	//returns item at parameter's index
	public void get(int index) {
	}

	//checks if there is a list
	public boolean isEmpty() {
		if (this.head == null) {
			return true;
		} else {
			return true;
		}
	}

	//return the size of the list
	public int size() {
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
		NodeGeneric currNode = this.head;
		String concatLinkedList = "";
		
		while(currNode!= null){
			concatLinkedList+=currNode + " ";
			currNode = currNode.next;
		}	
		return concatLinkedList;
	}

	//add the parameter item at of the end of the list
	public boolean add(Object obj) {
	}

	//add item at parameter's index
	public boolean add(int index, Object obj) {
		if (this.head == null) {
			NodeGeneric addedNode = new NodeGeneric(null, null, obj);
			this.head = addedNode;
			this.tail = addedNode;
			return false;
		} else {
			NodeGeneric addedNode = new NodeGeneric(null, this.tail, obj);
			this.tail = addedNode;
			
			return false;
		}
	}

	//searches list for parameter's String return true if found
	public boolean contains(Object obj) {
	}

	//removes the parameter's item form the list
	public boolean remove(Object obj) {
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		Node LinkList1 = this.head;
		//Node LinkList2 =;
		return true;
	}
	@Override
	public int indexOf(Object node) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
