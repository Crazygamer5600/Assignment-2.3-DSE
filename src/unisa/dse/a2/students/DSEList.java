package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.List;

/**
 * @author simont
 *
 */
public class DSEList implements List {
	
	public Node head;
	private Node tail;

	public DSEList() {
		
	}
	public DSEList(Node head) {
		this.head = head;
		
	}
	
	//Takes a list then adds each element into a new list
	public DSEList(DSEList other) {
		// Make a copy of the head from other
		Node headClone = new Node(null,null,other.head.getString());
		this.head = headClone;
		
		Node ogIterator = other.head;
		Node cloneIterator = headClone;
		while (ogIterator != null) {
			Node nodeClone = new Node(null, null, ogIterator.getString());
			cloneIterator.next = nodeClone;
			nodeClone.prev = cloneIterator;	
			cloneIterator = cloneIterator.next;
			ogIterator = ogIterator.next;
		}
		this.tail = cloneIterator;
	}

	//remove the String at the parameter's index
	public String remove(int index) {
		for(int nodeIterator = 0; nodeIterator <= index; nodeIterator+=1) {
			if (this.size() == 1) {
				this.head = null;
				this.tail = null;
			} 
			
		}
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		Node currNode = this.head;
		int currNodeIndex = 0;
		
		while (currNodeIndex < this.size()) {
			if (currNode.getString() == obj) {
				currNodeIndex += 1;
				break;
			}
			currNode = currNode.next;
			currNodeIndex += 1;
		}
		return currNodeIndex;
	}
	
	//returns String at parameter's index
	public String get(int index) {
		Node currNode = this.head;
		int currNodeIndex = 0;
		int listSize = this.size();
		
		if (listSize >= index && listSize != 0) {
			while (currNode != null && currNodeIndex < index-1) {
			currNode = currNode.next;
			currNodeIndex += 1;
			}
			return currNode.getString();
		} else {
			return "null";
		}
		
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
		Node currNode = this.head;
		int size = 0;
		while (currNode != null) {
			currNode = currNode.next;
			size+=1;
		}
		return size;
	}
	
	//Take each element of the list and writes them to a string 
	@Override
	public String toString() {
		Node currNode = this.head;
		String concatLinkedList = "";
		
		while(currNode!= null){
			concatLinkedList+=currNode.getString() + " ";
			currNode = currNode.next;
		}	
		return concatLinkedList;
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		if (this.head == null) {
			Node addedNode = new Node(null, null, obj);
			this.head = addedNode;
			this.tail = addedNode;
			return true;
		} else {
			Node addedNode = new Node(null, this.tail, obj);
			this.tail.next = addedNode;
			this.tail = addedNode;
			
			return true;
		}
		
	}

	//add String at parameter's index
	public boolean add(int index, String obj) {
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) {
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
	
}
