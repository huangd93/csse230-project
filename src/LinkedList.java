import java.util.Iterator;

/**
 * Generic LinkedList implementation
 * @author huangd
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {
	Node root;
	Node tail;
	
	/**
	 * Construct an empty LinkedList
	 */
	public LinkedList() {
		root = null;
		tail = null;
	}
	
	/**
	 * Construct a LinkedList with one node of element e
	 * @param e Element of first node
	 */
	public LinkedList(T e) {
		root = new Node(e);
		tail = new Node(e);
	}
	
	/**
	 * Inserts a new node at the tail
	 * @return
	 */
	public void insert(T e) {
		Node temp = new Node(e);
		if(root == null) {
			root = temp;
		} else {
			tail.setChild(temp);
		}
		tail = temp;
	}
	
	/**
	 * Recursively checks if this LinkedList contains a node with the given element
	 * @param e Element to check for
	 * @return True if the element is found
	 */
	public boolean contains(T e) {
		if(root == null) return false;
		return root.contains(e);
	}

	/**
	 * Returns an iterator for the LinkedList
	 */
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	/**
	 * Removes the node with the given element
	 * @param e Element to be removed
	 * @return True if the node was succeessfully removed from the list
	 */
	public boolean remove(T e) {
		Iterator<T> t = iterator();
		while(t.hasNext()) {
			if(t.next().equals(e)) {
				t.remove();
				return true;
			}
		}
		return false;
	}
	
	/**
	 * LinkedList node
	 * @author huangd
	 *
	 */
	public class Node {
		private T element;
		private Node child;
		
		/**
		 * Create a node with element e and no child
		 * @param e Element of node
		 */
		public Node(T e) {
			element = e;
			child = null;
		}
		
		/**
		 * Create a node with element e and child c
		 * @param e Element of node
		 * @param c Child node
		 */
		public Node(T e, Node c) {
			element = e;
			child = c;
		}
		
		/**
		 * Sets the child to the given node
		 * @param o Node to set as child of this
		 */
		public void setChild(Node o) {
			child = o;
		}
		
		/**
		 * Returns the child of this node
		 * @return Child of this node
		 */
		public Node getChild() {
			return child;
		}
		
		/**
		 * Returns the element of this node
		 * @return Element of this node
		 */
		public T getElement() {
			return element;
		}
		
		/**
		 * Recursively checks if this LinkedList contains a node with the given element
		 * @param e Element to check for
		 * @return True if the element is found
		 */
		public boolean contains(T e) {
			if(element.equals((Object)e)) return true;
			if(child == null) return false;
			return child.contains(e);
		}
	}
	
	/**
	 * Iterates the Linked List from root to tail
	 * @author huangd
	 *
	 */
	private class LinkedListIterator implements Iterator<T> {
		Node parent;
		Node current;
		
		/**
		 * Creates a LinkedListIterator
		 */
		public LinkedListIterator() {
			parent = null;
			current = new Node(null, root);
		}

		/**
		 * Returns true if there is a next
		 */
		public boolean hasNext() {
			if(current == null) return false;
			if(current.child != null) return true;
			return false;
		}

		/**
		 * Moves to the next node and returns its element
		 */
		public T next() {
			if(!hasNext()) return null;
			current = current.child;
			return current.element;
		}

		/**
		 * Removes the current node.
		 */
		public void remove() {
			if(parent == null) {
				root = null;
				current = null;
				tail = null;
			} else {
				parent.child = current.child;
				current = current.child;
			}
			if(current == tail) tail = parent;
		}
	}
}
