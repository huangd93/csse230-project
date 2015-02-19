public class PlacesTree {

	Place root = null;
	Integer size = 0;

	public boolean insert(Place place) {
		if (place == null) {
			throw new IllegalArgumentException("Null argument");
		}
		if (this.size == 0) {
			this.root = place;
			return true;
		} else if (this.size > 0) {
			boolean hasBeenPlaced = positionFurtherDownTree(place, this.root);
			if (hasBeenPlaced) {
				size++;
			}
			return hasBeenPlaced;
		}
		return false;
	}

	/**
	 * We want to allow duplicates. This insert adds the Place with duplicate
	 * rating values as the right child of the node that has same rating,
	 * maintaining BST form.
	 * 
	 * If finds an instance of a place with the same rating, will immediately
	 * put the new place as it's right child.
	 * 
	 * If doesn't find a pre-existing instance of place with same rating, then
	 * finds the place where the place should belong and inserts it as a leaf.
	 * 
	 * @param place
	 * @param comparisonNode
	 * @return boolean
	 */
	public boolean positionFurtherDownTree(Place place, Place compNode) {
		if (place.getRating().compareTo(compNode.getRating()) == 0) {
			if (compNode.rightChild == null) {
				compNode.rightChild = place;
				return true;
			} else if (compNode.rightChild != null) {
				Place temp = compNode.rightChild;
				compNode.rightChild = place;
				place.rightChild = temp;
				return true;
			}
		} else if (place.getRating().compareTo(compNode.getRating()) > 0) {
			if (compNode.leftChild == null) {
				compNode.leftChild = place;
				return true;
			} else if (compNode.leftChild != null) {
				positionFurtherDownTree(place, compNode.leftChild);
			}
		} else if (place.getRating().compareTo(compNode.getRating()) < 0) {
			if (compNode.rightChild == null) {
				compNode.rightChild = place;
				return true;
			} else if (compNode.rightChild != null) {
				positionFurtherDownTree(place, compNode.rightChild);
			}
		}
		return false;
	}
	
	public void clear(){
		this.root = null;
	}
	
	public int getSize(){
		this.size = 0;
		return this.size;
	}

}
