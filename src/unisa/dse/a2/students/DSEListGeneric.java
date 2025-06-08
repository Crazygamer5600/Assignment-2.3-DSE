package unisa.dse.a2.students;

import unisa.dse.a2.interfaces.ListGeneric;

/**
 * @author simont
 * @param <T>
 *
 */
public class DSEListGeneric<T> implements ListGeneric <T> {
	
	public NodeGeneric<T> head;
	private NodeGeneric<T> tail;

	public DSEListGeneric() {
		
	}
	public DSEListGeneric(NodeGeneric head_) {
		this.head = head_;	
	}
	
	//Takes a list then adds each element into a new list
	public DSEListGeneric(DSEListGeneric other) { // Copy constructor.
		this.head = other.head;
		
		NodeGeneric ogIterator = other.head.next; // iterator which is offset by one node to the next
		NodeGeneric cloneIterator = new NodeGeneric(null,null,other.head.get()); // deep copy of first original node
		this.head = cloneIterator; 
		while (ogIterator != null) {
			NodeGeneric nodeClone = new NodeGeneric(null, null, ogIterator.get()); // deep copy of the next node
			cloneIterator.next = nodeClone;//sets next of previous deep copy
			nodeClone.prev = cloneIterator;// sets prev of current deep copy
			cloneIterator = cloneIterator.next;
			ogIterator = ogIterator.next;// moves original iterator forward
		}
		this.tail = cloneIterator;// sets final node
	}

	//remove and return the item at the parameter's index
	public T remove(int index) {
		int x = this.size();
		if (index == 0){
			NodeGeneric<T> headCopy = this.head;
			this.head = this.head.next;
			headCopy.next = null;
			this.head = null;
			return headCopy.get();
		} 
		else if (index == this.size() - 1) {
			NodeGeneric<T> tailCopy = this.tail;
			this.tail = this.tail.prev;
			tailCopy.prev = null;
			this.tail.next = null;
			return tailCopy.get();
		}
		else {
			NodeGeneric currNode = this.head;
			for(int currIndex = 0; currIndex < this.size(); currIndex += 1) {
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
			return (T) this.get(index);
		} 
	}

	//returns the index of the String parameter 
	public int indexOf(T obj) {
		NodeGeneric currNode = this.head;
		int currNodeIndex = 0;
		
		while (currNodeIndex < this.size()) {
			if (currNode.get().equals(obj) == true) {
				break;
			}
			currNode = currNode.next;
			currNodeIndex += 1;
		}
		return currNodeIndex;
	}
	
	//returns item at parameter's index
	public T get(int index) {
		NodeGeneric<T> currNode = this.head;
		int currNodeIndex = 0;
		int listSize = this.size();
		
		if (listSize >= index && listSize != 0 && index >= 0) {
			while (currNodeIndex < index) {
				currNode = currNode.next;
				currNodeIndex += 1;
			}
			return currNode.get();
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
		NodeGeneric currNode = this.head;
		int size = 0;
		while (currNode != null) {
			currNode = currNode.next;
			size+=1;
		}
		return size;
	}
	
	//Take each element of the list a writes them to a string 
	@Override
	public String toString() {
		NodeGeneric currNode = this.head;
		String concatLinkedList = "";
		
		while(currNode != null){
			if (currNode != tail) {
				concatLinkedList += currNode.get() + " ";
			} else {
				concatLinkedList += currNode.get();
				break;
			}	
			currNode = currNode.next;
		}	
		return concatLinkedList;
	}

	//add the parameter item at of the end of the list
	public boolean add(Object obj) {
		if (this.head == null) {
			NodeGeneric addedNode = new NodeGeneric(null, null, obj);
			this.head = addedNode;
			this.tail = addedNode;
			return true;
		} else {
			NodeGeneric addedNode = new NodeGeneric(null, this.tail, obj);
			this.tail.next = addedNode;
			this.tail = addedNode;
			
			return true;
		}
	}

	//add item at parameter's index
	public boolean add(int index, Object obj) {
		if (index == 0) {
			NodeGeneric headClone = this.head;
			NodeGeneric nodeMaker = new NodeGeneric(this.head, null, obj); 
			this.head = nodeMaker;
			headClone.prev = nodeMaker;
			return true;	
		}
		else if (index == this.size()) {
			//NodeGeneric tailClone = this.tail;
			NodeGeneric nodeMaker = new NodeGeneric(null, this.tail, obj);
			this.tail.next = nodeMaker;
			this.tail = nodeMaker;
			//tailClone.next = nodeMaker;
			return true;
		}
		else if (index == this.size() - 1) {
			NodeGeneric currNode = this.head;
			NodeGeneric nodeMaker = new NodeGeneric(this.tail, this.tail.prev, obj); 
			this.tail.prev.next = nodeMaker;
			this.tail.prev = nodeMaker;
			return true;
		}	
		else if (index < this.size() - 1 && index > 0) {
			NodeGeneric currNode = this.head;
			for(int currIndex = 0; currIndex <= this.size() - 1; currIndex += 1) {
				if (currIndex == index) {
					NodeGeneric nodeMaker = new NodeGeneric(currNode.next, currNode, obj); 
					currNode.next.prev = nodeMaker;
					currNode.next = nodeMaker;
					break;
				}
				currNode = currNode.next;
			}	
			return true;
		}
		else {
			return false;
		}
	}

	//searches list for parameter's String return true if found
	public boolean contains(Object obj) {
		NodeGeneric currNode = this.head;
		boolean isInList = false;
		while (currNode != null) {
			if (currNode.get().equals(obj) == true) {
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

	//removes the parameter's item form the list
	public boolean remove(T obj) {
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