// This LinkedList implementation has no remove function since we have no use for it.

public class LinkedList<T>{
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
	}
}
