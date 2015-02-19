import java.util.ArrayList;
import java.util.Iterator;


@SuppressWarnings("serial")
public class PriorityQueue<T extends Comparable<T>> extends ArrayList<T>{
	/**
	 * Construct an empty PriorityQueue
	 */
	public PriorityQueue() {
	}

	/**
	 * Inserts the specified element into this priority queue.
	 * @param e The element to add
	 * @return true 
	 */
	public boolean add(T e) {
		if(e == null) throw new NullPointerException();
		return offer(e);
	}

	/**
	 * Inserts the specified element into this priority queue.
	 * @param e The element to add
	 * @return true 
	 */
	public boolean offer(T e) throws NullPointerException {
		if(e == null) throw new NullPointerException();
		super.add(e);
		bubbleUp();
		return true;
	}
	
	/**
	 * Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
	 * @return the head of this queue, or null if this queue is empty
	 */
	public T peek() {
		if(size() == 0) return null;
		return get(0);
	}
	
	/**
	 * Removes a single instance of the specified element from this queue, if it is present.
	 * @param o element to be removed from this queue, if present
	 * @return true if this queue changed as a result of the call
	 */
	public boolean remove(T o) {
		if(contains(o)) {
			int index = indexOf(o);
			swap(size() - 1, index);
			remove(size() - 1);
			bubbleDown(index);
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if this queue contains the specified element
	 * @param o object to be checked for containment in this queue
	 * @return true if this queue contains the specified element
	 */
	public boolean contains(T o) {
		return super.contains(o);
	}
	
	/**
	 * Returns an array containing all of the elements in this queue.
	 */
	public Object[] toArray() {
		return super.toArray();
	}
	
	/**
	 * Returns an array containing all of the elements in this queue; 
	 * the runtime type of the returned array is that of the specified array.
	 */
	public T[] toArray(T[] a) {
		return super.toArray(a);
	}
	
	/**
	 * Returns an iterator over the elements in this queue.
	 */
	public Iterator<T> iterator() {
		return super.iterator();
	}
	
	/**
	 * Returns the number of elements in this collection.
	 */
	public int size() {
		return super.size();
	}
	
	/**
	 * Removes all of the elements from this priority queue. 
	 */
	public void clear() {
		super.clear();
	}
	
	/**
	 * Retrieves and removes the head of this queue, or returns null if this queue is empty.
	 * @return the head of this queue, or null if this queue is empty
	 */
	public T poll() {
		if(!super.isEmpty()) {
			T result = get(0);
			swap(0, size() - 1);
			remove(size() - 1);
			bubbleDown(0);
			return result;
		}
		return null;
	}
	
	
	
	/**
	 * Bubble up the inserted element, swapping with its parent if it is smaller than the parent
	 */
	public void bubbleUp() {
		int i = size() - 1;
		while(parentIndex(i) >= 0) {
			if(get(i).compareTo(parent(i)) < 0) {
				swap(i, parentIndex(i));
			} else {
				break;
			}
			i = parentIndex(i);
		}
	}
	
	/**
	 * Bubble down starting at the index of the deleted element, 
	 * swapping with its smallest child if it is larger than that child
	 * @param i The index of deletion to start bubbling down from
	 */
	public void bubbleDown(int i) {
		// Check that this node has children
		int rightChildIndex = (i + 1) * 2;
		while(rightChildIndex <=  size()) {
			// Check if this node has a right child. If so, find the smallest child and bubble down
			if(rightChildIndex <= size() - 1) {
				int min = findMin(rightChildIndex, rightChildIndex - 1);
				if(get(i).compareTo(get(min)) > 0) {
					swap(i, min);
					i = min;
				} else break;
			}
			// If this node has no right child, bubble down with the left child.
			if(get(i).compareTo(get(rightChildIndex - 1)) > 0) {
				swap(i, rightChildIndex - 1);
				i = rightChildIndex - 1;
			} else break;
			rightChildIndex = (i + 1) * 2;
		}
	}
	
	/**
	 * Find the index with the smaller element of the two given
	 * @param x First element index
	 * @param y Second element index
	 * @return The index of the smaller element
	 */
	public int findMin(int x, int y) {
		if(get(x).compareTo(get(y)) < 0) {
			return x;
		}
		return y;
	}
	
	/**
	 * Swap the elements at the two specified indices
	 * @param x
	 * @param y
	 */
	public void swap(int x, int y) {
		T t = get(x);
		set(x, get(y));
		set(y, t);
	}
	
	/**
	 * Return the parent element of the specified index
	 * @param index The index to get the parent element of
	 * @return The parent element of the index
	 */
	public T parent(int index) {
		return get(parentIndex(index));
	}
	
	/**
	 * Return the parent index of the specified index
	 * @param index Index to find the parent of
	 * @return The index of the parent
	 */
	public int parentIndex(int index) {
		return ((index + 1) / 2) - 1;
	}
	
}
