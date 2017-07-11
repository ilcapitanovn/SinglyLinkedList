package SinglyLinkedList;

public class SinglyLinkedList<T> {

	private Node head;
	private Node tail;
	private int size;

	public SinglyLinkedList() {
	    head = null;
	    tail = null;
	    size = 0;
	}

	public void insert(T data, int index) {

	    if (index > size) {
	        throw new IllegalArgumentException("The index [" + index
	                + "] is greater than the currentent size [" + size + "].");
	    } else {

	        Node temp = new Node(data);
	        Node current = getNode(index);

	        if (index == 0) {
	            temp.setNext(head);
	            head = temp;
	            tail = head;
	        } else {
	            temp.setNext(current.getNext());
	            current.setNext(temp);
	            tail = temp;
	        }
	        
	        size++;
	    }
	}

	public void append(T data) {
	    insert(data, size);
	}

	public void replace(T data, int index) {
	    getNode(index).setData(data);
	}

	public void remove(int index) {

	    if (index == 0) {
	        head = head.getNext();
	    } else {
	        getNode(index).setNext(getNode(index).getNext().getNext());
	    }

	    this.size--;
	}
	
	public void removeTail() {
		Node prev = head;
		Node current = prev.next;
		while (current.getNext() != null) {
			prev = current;
			current = current.getNext();
		}
		
		prev.next = null;
		tail = prev;
		this.size--;
	}
	
	public void removeGreatThan(T data) {
		if (data != null && data instanceof Integer) {
			Node current = head;
			int target = (Integer)data;
			int index = 0;
			while (current != null) {
				int currentData = (Integer)current.getData();
				if (currentData > target) {
					current = current.next;
					remove(index);
				}
				else {
					current = current.next;
					index++;
				}
			}
		}
	}

	private Node getNode(int index) {

	    if ( index > size ) {
	        throw new IllegalArgumentException("The index [" + index + "] is greater than the current size [" + size + "].");
	    }
	    Node current = head;
	    for (int i = 1; i < index; i++) {
	        current = current.getNext();
	    }

	    return current;
	}

	public T get(int index) {
	    return getNode(index).getData();
	}

	public int size() {
	    return this.size;
	}

	public String toString() {
	    StringBuilder builder = new StringBuilder();

	    Node current = head;
	    while( current != null ) {
	        builder.append("[" + current.getData() + "]");
	        current = current.getNext();
	    }

	    return builder.toString();

	}



	private class Node {

	    Node next;
	    T data;

	    public Node(T data) {
	        this(data, null);
	    }

	    public Node(T data, Node next) {
	        this.next = next;
	        this.data = data;
	    }

	    public T getData() {
	        return this.data;
	    }

	    public void setData(T data) {
	        this.data = data;
	    }

	    public Node getNext() {
	        return this.next;
	    }

	    public void setNext(Node nextNode) {
	        this.next = nextNode;
	    }

	}
}