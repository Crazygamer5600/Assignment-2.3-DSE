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
	this.head = other.head;
		
		Node ogIterator = other.head.next; // iterator which is offset by one node to the next
		Node cloneIterator = new Node(null,null,other.head.getString()); // deep copy of first original node
		this.head = cloneIterator; 
		while (ogIterator != null) {
			Node nodeClone = new Node(null, null, ogIterator.getString()); // deep copy of the next node
			cloneIterator.next = nodeClone;//sets next of previous deep copy
			nodeClone.prev = cloneIterator;// sets prev of current deep copy
			cloneIterator = cloneIterator.next; //moves clone iterator forward
			ogIterator = ogIterator.next;// moves original iterator forward
		}
		this.tail = cloneIterator;// sets final node
	}

	//remove the String at the parameter's index
	public String remove(int index) {
		if (index == 0 && this.size() > 1){// condition first index needs removing and something comes after
			Node headCopy = this.head;
			this.head = this.head.next;
			headCopy.next = null;
			this.head.prev = null;
			return headCopy.getString();
		} 
		else if (index == 0){// condition first index needs removing and nothing comes after
			Node headCopy = this.head;
			headCopy.next = null;
			this.head = null;
			return headCopy.getString();
		} 
		else if (index == this.size() - 1) {//condition that item is removed from tail
			Node tailCopy = this.tail;
			this.tail = this.tail.prev;
			tailCopy.prev = null;
			this.tail.next = null;
			return tailCopy.getString();
		}
		else {
			Node currNode = this.head;
			for(int currIndex = 0; currIndex < this.size(); currIndex += 1) {// condition something is being removed somewhere between tail and head
				if (currIndex == index) {
					currNode.prev.next = currNode.next;
					currNode.next.prev = currNode.prev;
					currNode.next = null;
					currNode.prev = null;
					break;
				}
				else {
					currNode = currNode.next;
				}
			}
			return this.get(index);
		}
		
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		Node currNode = this.head;
		int currNodeIndex = 0;
		
		while (currNodeIndex < this.size()) {
			if (currNode.getString().equals(obj) == true) {
				return currNodeIndex; //once found returns index
			}
			currNode = currNode.next;
			currNodeIndex += 1;
		}
		return -1; // if never found returns -1
	}
	
	//returns String at parameter's index
	public String get(int index) {
		Node currNode = this.head;
		int currNodeIndex = 0;
		int listSize = this.size();
		
		if (listSize >= index && !this.isEmpty() && index >= 0) { // index doesn't exceed list size list is not empty index is equal to or exceeds 0
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
		if (this.size() == 0) {// if linked list size is 0 then it is empty
			return true;
		}
		else {
			return false;
		}
	}

	//return the size of the list
	public int size() {
		Node currNode = this.head;
		int size = 0;
		while (currNode != null) {// cycles through nodes until null
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
			} else {// does not add a space at final node
				concatLinkedList+=currNode.getString();
			}	
			currNode = currNode.next;
		}	
		return concatLinkedList;
	}

	//add the parameter String at of the end of the list
	public boolean add(String obj) {
		if (this.isEmpty()) {
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
		if (index == 0) {// adds at head
			Node headClone = this.head;
			Node nodeMaker = new Node(this.head, null, obj); 
			this.head = nodeMaker;
			headClone.prev = nodeMaker;
			return true;	
		}
		else if (index == this.size()) {// adds after tail
			Node nodeMaker = new Node(null, this.tail, obj);
			this.tail.next = nodeMaker;
			this.tail = nodeMaker;
			return true;
		}
		else if (index == this.size() - 1) {// adds at tail
			Node nodeMaker = new Node(this.tail, this.tail.prev, obj); 
			this.tail.prev.next = nodeMaker;
			this.tail.prev = nodeMaker;
			return true;
		}	
		else if (index < this.size() - 1 && index > 0) {// adds between tail and head
			Node currNode = this.head;
			for(int currIndex = 0; currIndex <= this.size() - 1; currIndex += 1) {// cycles through until reaching tail
				if (currIndex == index) {
					Node nodeMaker = new Node(currNode.next, currNode, obj); 
					currNode.next.prev = nodeMaker;
					currNode.next = nodeMaker;
					break;
				}
				currNode = currNode.next;
			}	
			return true;
		}
		else {// if number is out of bounds
			return false;
		}
	}
	
	public boolean contains(String obj) {
		Node currNode = this.head;
		boolean isInList = false;
		while (currNode != null) {// while node has a value
			if (currNode.getString().equals(obj) == true) {// if the node has the same value
				isInList = true;
				break;
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
