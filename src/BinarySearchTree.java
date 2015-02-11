import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> implements Iterable<T> {
	private BinaryNode root;
	private int modCount = 0;
	
	/**
	 * Create an empty BinarySearchTree
	 */
	public BinarySearchTree(){
		root = null;
	}
	/**
	 * Create a BinarySearchTree with a root holding the input element
	 * @param n
	 */
	public BinarySearchTree(BinaryNode n){
		root = n;
	}
	
	/**
	 * A function to find the height of the binary tree.
	 * @return The integer height of the tree
	 */
	public int height() {
		if (isEmpty()) {
			return -1;
		}
		return root.getHeight();
	}
	
	/**
	 * A function to return the size of the binary tree
	 * @return The integer size of the binary tree
	 */
	public int size() {
		return toArrayList().size();
	}
	
	/**
	 * A function to test if the binary tree is empty
	 * @return Whether the tree is empty
	 */
	public boolean isEmpty() {
		if(root == null) {
			return true;
		}
		return false;
	}
	
	/**
	 * A function to get an in order string for the binary tree
	 * @return A string
	 */
	public String toString() {
		return toArrayList().toString();
	}
	
	/**
	 * A function to get an array representing the binary tree in order
	 * @return An array
	 */
	public Object[] toArray() {
		return toArrayList().toArray();
	}
	
	/**
	 * Returns an ArrayList of all the elements in the tree in order
	 * @return
	 */
	public ArrayList<T> toArrayList() {
		if (isEmpty()) return new ArrayList<T>();
		return root.toArrayList();
	}
	
	/**
	 * Recursively inserts the input element into the binary tree in order
	 * @param o The element to be inserted
	 * @return True if the element was inserted successfully, false otherwise
	 * @throws IllegalArgumentException
	 */
	public boolean insert(T o) throws IllegalArgumentException {
		if(o == null) throw new IllegalArgumentException();
		if(isEmpty()) {
			root = new BinaryNode(o);
			modCount++;
			return true;
		}
		if(root.insert(o)) {
			modCount++;
			return true;
		}
		return false;
	}
	
	/**
	 * Remove the node with the input element from the tree
	 * @param element
	 * @return A boolean value showing if the node was properly removed
	 * @throws IllegalArgumentException
	 */
	public boolean remove(T element) throws IllegalArgumentException {
		if(element == null) throw new IllegalArgumentException();
		if(isEmpty()) return false;
		if(root.element == element) {
			if(root.leftChild == null && root.rightChild == null) {
				root = null;
				modCount++;
				return true;
			}
			if(root.leftChild != null && root.rightChild == null) {
				root = root.leftChild;
				modCount++;
				return true;
			}
			if(root.rightChild != null && root.leftChild == null) {
				root = root.rightChild;
				modCount++;
				return true;
			}
			T largest = root.leftChild.getLargest().element;
			root.remove(largest);
			root.element = largest;
			modCount++;
			return true;
		}
		BinaryNode removed = root.remove(element);
		if(removed != null) {
			modCount++;
			return true;
		}
		return false;
	}

	/**
	 * Returns a lazy pre order iterator for the binary tree
	 * @return A PreOrderIterator
	 */
	public Iterator<T> preOrderIterator() {
		return this.new PreOrderIterator();
	}
	
	
	/**
	 * Returns a lazy in order iterator for the binary tree
	 * @return An InOrderIterator
	 */
	public Iterator<T> iterator() {
		return this.new InOrderIterator();
	}
	
	/**
	 * A lazy pre order iterator
	 * @author huangd
	 */
	private class PreOrderIterator implements Iterator<T> {
		Stack<BinaryNode> stack;
		private int initialModCount;
		private BinaryNode lastNode;
		
		public PreOrderIterator() {
			initialModCount = modCount;
			lastNode = null;
			stack = new Stack<BinaryNode>();
			if(isEmpty()) return;
			if(root.rightChild != null) {
				stack.push(root.rightChild);
			}
			if(root.leftChild != null) {
				stack.add(root.leftChild);
			}
			stack.add(root);
		}
		
		public boolean hasNext() {
			try {
				stack.peek();
				return true;
			} catch (EmptyStackException e) {
				return false;
			}
		}

		public T next() throws NoSuchElementException, ConcurrentModificationException {
			if(stack.isEmpty()) throw new NoSuchElementException();
			if(initialModCount != modCount) throw new ConcurrentModificationException();
			BinaryNode result = stack.pop();
			lastNode = result;
			if(hasNext()) {
				BinaryNode temp = stack.pop();
				if(temp.rightChild != null) {
					stack.push(temp.rightChild);
				}
				if(temp.leftChild != null) {
					stack.add(temp.leftChild);
				}
				stack.push(temp);
			}
			
			return result.element;
		}

		public void remove() throws IllegalStateException {
			if(lastNode == null) throw new IllegalStateException();
			BinarySearchTree.this.remove(lastNode.element);
			lastNode = null;
		}
	}
	
	/**
	 * A lazy in order iterator
	 * @author huangd
	 */
	private class InOrderIterator implements Iterator<T> {
		Stack<BinaryNode> stack;
		private int initialModCount;
		private BinaryNode lastNode;
		
		public InOrderIterator() {
			initialModCount = modCount;
			lastNode = null;
			stack = new Stack<BinaryNode>();
			if(isEmpty()) return;
			BinaryNode node = root;
			while(node != null) {
				stack.push(node);
				node = node.leftChild;
			}
		}
		
		public boolean hasNext() {
			try {
				stack.peek();
				return true;
			} catch (EmptyStackException e) {
				return false;
			}
		}

		public T next() throws NoSuchElementException, ConcurrentModificationException {
			if(stack.isEmpty()) throw new NoSuchElementException();
			if(initialModCount != modCount) throw new ConcurrentModificationException();
			BinaryNode result = stack.pop();
			lastNode = result;
			BinaryNode node = result.rightChild;
			while(node != null) {
				stack.push(node);
				node = node.leftChild;
			}
			return result.element;
		}

		public void remove() throws IllegalStateException {
			if(lastNode == null) throw new IllegalStateException();
			BinarySearchTree.this.remove(lastNode.element);
			lastNode = null;
		}
	}
	
	/**
	 * A binary node, holding up to two children and an element
	 * @author huangd
	 *
	 * @param <T>
	 */
	private class BinaryNode {
		private T element;
		private BinaryNode leftChild;
		private BinaryNode rightChild;
		
		public BinaryNode(T element){
			this.element = element;
			this.leftChild = null;
			this.rightChild = null;		
		}
		
		/**
		 * Returns the height of the node
		 * @return integer height of the node
		 */
		public int getHeight() {
			int leftHeight = -1;
			int rightHeight = -1;
			if(leftChild != null) {
				leftHeight = leftChild.getHeight();
			}
			if(rightChild != null) {
				rightHeight = rightChild.getHeight();
			}
			return Math.max(leftHeight, rightHeight) + 1;
		}
		
		/**
		 * Returns the size of the tree under the node.
		 * @return integer size of the tree under the node
		 */
		public int getSize() {
			int leftSize = 0;
			int rightSize = 0;
			if(leftChild != null) {
				leftSize = leftChild.getSize();
			}
			if(rightChild != null) {
				rightSize = rightChild.getSize();
			}
			return leftSize + rightSize + 1;
		}
		
		/**
		 * Returns an ArrayList of the tree elements in order under and including this node
		 * @return Arraylist of elements
		 */
		public ArrayList<T> toArrayList() {
			ArrayList<T> left = new ArrayList<T>();
			ArrayList<T> right = new ArrayList<T>();
			if(leftChild != null) left = leftChild.toArrayList();
			if(rightChild != null) right = rightChild.toArrayList();
			left.add(element);
			left.addAll(right);
			return left;
		}
		
		/**
		 * Inserts a node with the given element in order.
		 * @param o The element to insert
		 * @return A boolean representing if the new node was inserted correctly
		 */
		public boolean insert(T o) {
			if(o.compareTo(element) < 0) {
				if(leftChild != null) {
					return leftChild.insert(o);
				} else {
					leftChild = new BinaryNode(o);
					return true;
				}
			} else if (((Comparable<T>)o).compareTo(element) == 0) {
				return false;
			} else if (((Comparable<T>)o).compareTo(element) > 0) {
				if(rightChild != null) {
					return rightChild.insert(o);
				} else {
					rightChild = new BinaryNode(o);
					return true;
				}
			}
			return false;
		}
		
		/**
		 * Removes the node with the given element from the tree
		 * @param o The element to delete
		 * @return The removed node
		 */
		public BinaryNode remove(T o) {
			// If it's on the left side
			if(o.compareTo(element) < 0) {
				if(leftChild != null) {
					if(o.compareTo(leftChild.element) == 0) {
						BinaryNode result = leftChild;
						if(leftChild.leftChild == null && leftChild.rightChild == null) {
							leftChild = null;
							return result;
						}
						if(leftChild.leftChild != null && leftChild.rightChild == null) {
							leftChild = leftChild.leftChild;
							return result;
						}
						if(leftChild.rightChild != null && leftChild.leftChild == null) {
							leftChild = leftChild.rightChild;
							return result;
						}
						T largest = leftChild.leftChild.getLargest().element;
						leftChild = new BinaryNode(largest);
						leftChild.leftChild = result.leftChild;
						leftChild.rightChild = result.rightChild;
						remove(largest);
						return result;
					}
					return leftChild.remove(o);
				}
				return null;
			}
			// If it's on the right side
			if(rightChild != null) {
				if(o.compareTo(rightChild.element) == 0) {
					BinaryNode result = rightChild;
					if(rightChild.leftChild == null && rightChild.rightChild == null) {
						rightChild = null;
						return result;
					}
					if(rightChild.leftChild != null && rightChild.rightChild == null) {
						rightChild = rightChild.leftChild;
						return result;
					}
					if(rightChild.rightChild != null && rightChild.leftChild == null) {
						rightChild = rightChild.rightChild;
						return result;
					}
					T largest = rightChild.leftChild.getLargest().element;
					rightChild = new BinaryNode(largest);
					rightChild.leftChild = result.leftChild;
					rightChild.rightChild = result.rightChild;
					remove(largest);
					return result;
				}
			}
			return null;
		}
		
		/**
		 * Get and return the largest node under and including this node.
		 * @return The BinaryNode with the largest element under and including this node
		 */
		public BinaryNode getLargest() {
			if(rightChild != null) {
				return rightChild.getLargest();
			}
			return this;
		}
	}
}
