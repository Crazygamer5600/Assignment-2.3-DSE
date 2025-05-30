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
		NodeGeneric headClone = new NodeGeneric(null,null,other.head.get());
		this.head = headClone;
		
		NodeGeneric ogIterator = other.head;
		NodeGeneric cloneIterator = headClone;
		while (ogIterator != null) {
			NodeGeneric nodeClone = new NodeGeneric(null, null, ogIterator.get());
			cloneIterator.next = nodeClone;
			nodeClone.prev = cloneIterator;	
			cloneIterator = cloneIterator.next;
			ogIterator = ogIterator.next;
		}
		this.tail = cloneIterator;
	}

	//remove and return the item at the parameter's index
	public NodeGeneric remove(int index) {
		if (index == 1){
			NodeGeneric headCopy =this.head;
			this.head = this.head.next;
			headCopy.next = null;
			this.head.prev = null;
			return this.head;
		} 
		else if (index == this.size()) {
			NodeGeneric tailCopy = this.tail;
			this.tail = this.tail.prev;
			tailCopy.prev = null;
			this.tail.next = null;
			return this.tail;
		}
		else if (index>1 && index<this.size()) {
			NodeGeneric currNode = this.head;
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
			return this.get(index);
		} else {
			return null;
		}
	}

	//returns the index of the String parameter 
	public int indexOf(String obj) {
		NodeGeneric currNode = this.head;
		int currNodeIndex = 0;
		
		while (currNodeIndex < this.size()) {
			if (currNode.get() == obj) {
				currNodeIndex += 1;
				break;
			}else if (currNodeIndex == this.size()-1 && currNode.get() != obj) {
				currNodeIndex = -1;
				break;
			}
			currNode = currNode.next;
			currNodeIndex += 1;
		}
		return currNodeIndex;
	}
	
	//returns item at parameter's index
	public NodeGeneric get(int index) {
		NodeGeneric currNode = this.head;
		int currNodeIndex = 0;
		int listSize = this.size();
		
		if (listSize >= index && listSize != 0) {
			while (currNode != null && currNodeIndex < index-1) {
			currNode = currNode.next;
			currNodeIndex += 1;
			}
			return currNode;
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
		
		while(currNode!= null){
			concatLinkedList+=currNode.get() + " ";
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
		if (index < this.size()+1 && index > 1) {
			NodeGeneric currNode = this.head;
			for(int currIndex = 0; currIndex < index-1; currIndex+=1) {
				if (currIndex == index-2) {
					NodeGeneric nodeMaker = new NodeGeneric(currNode.next, currNode, obj); 
					currNode.next.prev = nodeMaker;
					currNode.next = nodeMaker;
					break;
				}
				currNode = currNode.next;
			}	
			return true;
		}else if (index == 1) {
			NodeGeneric headClone = this.head;
			NodeGeneric nodeMaker = new NodeGeneric(this.head, null, obj); 
			this.head = nodeMaker;
			headClone.prev = nodeMaker;
			return true;
		}else if (index == this.size()+1) {
			NodeGeneric tailClone = this.tail;
			NodeGeneric nodeMaker = new NodeGeneric(null, this.tail, obj); 
			this.tail = nodeMaker;
			tailClone.next = nodeMaker;
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
		while (currNode.next != null || currNode.get() == obj) {
			if (currNode.get() == obj) {
				isInList = true;
			}
			if (currNode.next == null) {
				break;
			}
			currNode = currNode.next;
		}
		return isInList;
	}

	//removes the parameter's item form the list
	public boolean remove(Object obj) {
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
	@Override
	public int indexOf(Object node) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
