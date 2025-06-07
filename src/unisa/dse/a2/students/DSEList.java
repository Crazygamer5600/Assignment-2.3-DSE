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
		if (index == 1){
			Node headCopy =this.head;
			this.head = this.head.next;
			headCopy.next = null;
			this.head.prev = null;
			return this.toString();
		} 
		else if (index == this.size()) {
			Node tailCopy = this.tail;
			this.tail = this.tail.prev;
			tailCopy.prev = null;
			this.tail.next = null;
			return this.toString();
		}
		else if (index>1 && index<this.size()) {
			Node currNode = this.head;
			for(int currIndex = 0; currIndex < index; currIndex+=1) {
				if (currIndex == index-1) {
					currNode.prev.next = currNode.next;
					currNode.next.prev = currNode.prev;
					currNode.next = null;
					currNode.prev = null;
				}
				else {
					currNode = currNode.next;
				}
			}	
			return this.toString();
		}
		else {
			return this.toString();
		}
		
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		Node currNode = this.head;
		int currNodeIndex = 0;
		
		while (currNodeIndex < this.size()) {
			if (currNode.getString().equals(obj) == true) {
				currNodeIndex += 1;
				break;
			} else if (currNodeIndex == this.size()-1 && currNode.getString().equals(obj) != true) {
				currNodeIndex = -1;
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
		
		if (listSize >= index && listSize != 0 && index>=0) {
			while (currNodeIndex < index) {
			currNode = currNode.next;
			currNodeIndex += 1;
			}
			return currNode.getString();
		} else {
			return null;
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
			if (currNode!= tail) {
				concatLinkedList+=currNode.getString() + " ";
			} else {
				concatLinkedList+=currNode.getString();
			}	
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
		if (index < this.size()+1 && index > 1) {
			Node currNode = this.head;
			for(int currIndex = 0; currIndex < index-1; currIndex+=1) {
				if (currIndex == index-2) {
					Node nodeMaker = new Node(currNode.next, currNode, obj); 
					currNode.next.prev = nodeMaker;
					currNode.next = nodeMaker;
					break;
				}
				currNode = currNode.next;
			}	
			return true;
		}else if (index == 1) {
			Node headClone = this.head;
			Node nodeMaker = new Node(this.head, null, obj); 
			this.head = nodeMaker;
			headClone.prev = nodeMaker;
			return true;
		}else if (index == this.size()+1) {
			Node tailClone = this.tail;
			Node nodeMaker = new Node(null, this.tail, obj); 
			this.tail = nodeMaker;
			tailClone.next = nodeMaker;
			return true;
		}
		else { 
			return false;
		}
	}

	//searches list for parameter's String return true if found
	public boolean contains(String obj) {
		Node currNode = this.head;
		boolean isInList = false;
		while (currNode != null) {
			if (currNode.getString().equals(obj) == true) {
				isInList = true;
			}
			if (currNode.next == null) {
				break;
			}
			currNode = currNode.next;
		}
		return isInList;
	}

	//removes the parameter's String form the list
	public boolean remove(String obj) {
		if (this.contains(obj) == true) {
			this.remove(this.indexOf(obj));
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object other) {
		return true;
	}
	
}
