import java.util.NoSuchElementException;

// import org.junit.platform.engine.support.hierarchical.Node;

/** Keeps track of position in a linked list */
public class SLL_Iterator<T> implements Phase5SLL_Iterator<T> {

    // Attributes 

    /**
     * position of iterator is on either side of this node
     */
    private NodeSL<T> pos;
    /**
     * Tracks if iterator is on left or right of node
     */
    private boolean onLeft;


    /**
     * Constructor
     * Creates a new iterator on the given list
     * Default position is leftmost
     * 
     * @param list the list to iterate on
     */
    public SLL_Iterator(SLL<T> list) {
        pos = list.getHead();
        onLeft = true;

    }


    /**
     * Tests whether there are any more
     * 
     * @return T/F is it safe to call next()?
     */
    public boolean hasNext() {
        // checks if position is not null AND if onLeft is T/f or next node is not null
        return ((pos != null) && (onLeft || (pos.getNext() != null)));
    }


    /**
     * Returns next or throws an exception
     * and advances the iterator
     * 
     * @return the next element
     */
    public T next() {
        // checks if hasNext is null or there is no next node
        if (!hasNext()) {
            throw new NoSuchElementException("There is no next node. It is null.");
        // checks if onLeft is True
        } else if (onLeft) {
            onLeft = false;
        // else update position to next node
        } else {
            pos = pos.getNext();
        }
        // return position's data
        return pos.getData();
    }


    /**
     * Sets the data for the element just passed
     * 
     * @param data value to set
     */
    public void set(T data) {
        // if iterator is not on the left of pos thus on the right of pos
        if (!onLeft) {
            pos.setData(data);
        }
    }


    /**
     * Returns the data for the element just passed
     * 
     * @return data value in the element just passed
     */
    public T get() {
        // if iterator is not on the left of pos thus on the right of pos
        if (!onLeft) {
            return pos.getData();
        }
        // returns null if iterator is on left 
        return null;
    }

    /**
     * Inserts a node with the specified data
     * Cannot be called twice in a row without intervening next()
     * @param data the value to insert
     */
    public void add(T data) {
        // exits function if iterator is on left of node
        // if (onLeft) {
        //     return;
        // }

        // if (pos == null) {
        //     NodeSL<T> newNode = new NodeSL<>(data, null);
        //     newNode = pos.getData();
        // } else {
        //     while (pos.getNext() != null) {
        //         pos = pos.getNext();
        //     }
        //     NodeSL<T> newNode = new NodeSL<>(data, null);
        //     // links pos to newNode
        //     pos.setNext(newNode);

        // }
    }

    /**
     * Removes the node just passed
     * Cannot be called twice in a row without intervening next()
     */
    public void remove() {
        // if true, that means iterator hasn't moved and is not on the right of a node. 
        // returns
        if (onLeft) {
            return;
        } else {
            // create a node to keep track of the previous node of the node we want to remove
            NodeSL<T> prev = new NodeSL<>(pos.getData(), pos.getNext());
            // sets the prev node to point to the next next node, removing the node we want
            prev.setNext(pos.getNext().getNext());
        }        

    }
}
