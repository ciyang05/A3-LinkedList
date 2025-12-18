/**
 * Class to implement a singly linked list
 *
 * @author Halie Rando
 * @version Spring 2024
 */
public class SLL<T> implements Phase1SLL<T>, Phase2SLL<T>, Phase4SLL<T> {

  // Attributes
  /**
   * Head of the SLL
   */
  private NodeSL<T> head;

  /**
   * Tail of the SLL
   */
  private NodeSL<T> tail;

  /**
   * Current number of nodes in SLL
   */
  int size;

  /**
   * Single Linked List holding type T
   */
  SLL<T> SLL;

  /**
   * Creates an empty list
   */
  public SLL(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }


  /**
   * Copy constructor, creates deep copy of LL object that's passed in
   * @param other LL to make a deep copy of
   */
  public SLL(SLL<T> other) {
    this.head = null;
    this.tail = null;
    this.size = 0;

    NodeSL<T> current = other.getHead();

    while (current != null) {
      this.addLast(current.getData());
      current = current.getNext();
    }

  }

  /**
   * Accessor for head node
   * 
   * @return head node
   */
  public NodeSL<T> getHead() {
    return head;
  }

  /**
   * Accessor for tail node
   * 
   * @return the tail node
   */
  public NodeSL<T> getTail() {
    return tail;
  }

  /**
   * Determines whether a list is empty
   * 
   * @return T/F is the list empty?
   */
  public boolean isEmpty() {
    if (head == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Inserts the given item at the head of the list
   * 
   * @param v item to insert
   */
  public void addFirst(T v) {
    NodeSL<T> newNode = new NodeSL<>(v, head);
    head = newNode;
    if (tail == null) {
      tail = newNode;
    }
    size++;
  }

  /**
   * Converts to string representation
   */
  public String toString() {
    StringBuilder result = new StringBuilder("[");
    NodeSL<T> current = head;
    while (current != null) {
      result.append(current.getData());
      if (current.getNext() != null) {
        result.append(", ");
      }

      current = current.getNext();
    }
    result.append("]");
    return result.toString().trim();

  }

  /**
   * Inserts the given item at the tail of the list
   * 
   * @param item to insert
   */
  public void addLast(T v) {
    NodeSL<T> newNode = new NodeSL<>(v, null);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      tail.setNext(newNode);
      // changed tail.newNode into tail = newNode
      tail = newNode;
    }
    size++;
  }

  // referenced geeksforgeeks
  /**
   * Inserts the given item after the specified node
   * 
   * @param here node to insert after
   * @param v    item to insert
   */
  public void addAfter(NodeSL<T> here, T v) {
    // throws an error if node to insert after is null
    if (here == null) {
      throw new MissingElementException("Cannot insert an element after a null node");
    } else {
      // create a newNode with data v and have it link to the next node of here
      NodeSL<T> newNode = new NodeSL<>(v, here.getNext());
      // set here to link to the newNode
      here.setNext(newNode);

      // if here node is the tail, set the new tail to be newNode
      if (here == tail) {
        tail = newNode;
      }
    }

  }

  /**
   * Removes the given item from the head of the list
   * 
   * @return v item removed
   * @throws MissingElementException if the list is empty
   */
  public T removeFirst() {
    if (isEmpty()) {
      throw new MissingElementException("Cannot remove from empty list");
    }

    T data = head.getData();
    head = head.getNext();

    if (head == null) {
      tail = null;
    }
    size--;

    return data;
  }

  /**
   * Removes the given item from the tail of the list
   * 
   * @return item removed
   * @throws MissingElementException if the list is empty
   */
  public T removeLast() {
    if ((isEmpty())) {
      throw new MissingElementException("Cannot remove from empty list");
    }

    if (head == tail) {
      T data = head.getData();
      head = null;
      tail = null;
      size--;
      return data;
    }

    NodeSL<T> current = head;
    while (current.getNext() != tail) {
      current = current.getNext();
    }

    T data = tail.getData();
    tail = current;
    tail.setNext(null);
    size--;

    return data;
  }

  /**
   * Removes the node after the given position
   * 
   * @param here marks position to remove after
   * @return item removed
   */
  public T removeAfter(NodeSL<T> here) {
    // this means here is before the head, so it is null
    if (here == null) {
      // create a new node reference that points to head
      NodeSL<T> toRemove = head;
      // get the data of the new node
      T data = toRemove.getData();

      // reassign head to the next node of head
      head = head.getNext();
      // if the node to be removed is also the tail, make the tail null
      if (toRemove == tail) {
        tail = null;
      }

      return data;
    }
    if (isEmpty()) {
      throw new MissingElementException("Cannot remove in an empty list");
    }
    if (here.getNext() == null) {
      throw new MissingElementException("Cannot remove an element that does not exist");
    }

    // create node reference to next node of here, the one to be removed
    NodeSL<T> removedNode = here.getNext();
    // get data of node to be removed
    T data = removedNode.getData();

    // link here to the node after the node to be removed
    here.setNext(removedNode.getNext());

    // if the node to be removed is the tail, reassign tail to here
    if (removedNode == tail) {
      tail = here;
    }

    return data;

  }

  /**
   * Returns a count of the number of elements in the list
   * 
   * @return current number of nodes
   */
  public int size() {
    // counter to keep track of number of elements in list, initialized to 0
    int count = 0;
    NodeSL<T> pointer = head;

    // checks if next node isn't null, then increments 1 to counter
    while (pointer != null) {
      count++;
      pointer = pointer.getNext();

    }

    return count;
  }

  /**
   * Makes a copy of elements from the original list
   * 
   * @param here starting point of copy
   * @param n    number of items to copy
   * @return copied list
   */
  public SLL<T> subseqByCopy(NodeSL<T> here, int n) {

    // if the started point is null, then exception
    if (here == null) {
      throw new IllegalArgumentException("Head can not be null.");
    }

    // if no nodes, then exception
    if (n < 0) {
      throw new IllegalArgumentException("You must have nodes or the number of nodes can not be negative.");
    }

    // empty list
    SLL<T> copy = new SLL<>(null);

    for (int i = 0; i < n; i++) {
      T data = here.getData();
      copy.addLast(data);
      here = here.getNext();
    }

    return copy;

  }

  /**
   * Places copy of the provided list into this after the specified node.
   * 
   * @param list      the list to splice in a copy of
   * @param afterHere marks the position in this where the new list should go
   */
  public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere) {
    if (this == list) {
      throw new SelfInsertException("Cannot splice a list into itself");
    }
    // copying nodes of list
    SLL<T> copy = new SLL<>(list);

    // while (afterHere != null) {
    // NodeSL<T> pointer = copy.getHead();
    // NodeSL<T> newNode;

    // pointer.setNext(afterHere.getNext());
    // afterHere.setNext(pointer);
    // pointer = pointer.getNext();
    // afterHere = afterHere.getNext();
    // }

    tail = copy.getHead();

    while (tail.getNext() != null) { // while the next node after the head is not empty
      tail = tail.getNext(); // keep moving until the node has null as the next node aka the last node,
                             // making it the tail
    }

    // set the next node after the tail to be the next element after the afterHere
    tail.setNext(afterHere.getNext());

    // make afterHere's next node to be the head of the copied list
    afterHere.setNext(copy.getHead());

  }

  /**
   * extract a subseq from this list and returns it as a new SLL
   * the subseq starts after afterHere and ends at toHere
   * 
   * @param afterHere the node after which extraction begins (null mean start
   *                  fromhead)
   * @param toHere    the last node to extract
   * @return a new SLl that contains the extracted subseq
   * @throws MissingElementException if toHere is null or nodes are not in the
   *                                 list or has invalid range
   */
  public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere) {
    if (toHere == null) {
      throw new MissingElementException("toHere cannot be null");
    }

    // case 1 : Extract from the head (afterHere == null)
    if (afterHere == null) {
      if (head == null || head == toHere.getNext()) {
        throw new MissingElementException("invalid extraction range");
      }
      // find toHere starting from head
      NodeSL<T> pointer = head;
      boolean found = false;
      while (pointer != null) {
        if (pointer == toHere) {
          found = true;
          break;
        }
        pointer = pointer.getNext();
      }
      if (!found) {
        throw new MissingElementException("toHere not found in list");
      }
      SLL<T> result = new SLL<>();
      result.head = head;
      result.tail = toHere;

      // count nodes in extracted segment
      int count = 0;
      pointer = head;
      while (pointer != null) {
        count++;
        if (pointer == toHere)
          break;
        pointer = pointer.getNext();
      }
      result.size = count;

      // update this list
      head = toHere.getNext();
      if (head == null) {
        tail = null;
      }
      size -= result.size;

      toHere.setNext(null);
      return result;
    }

    // case 2: afterHere is not null(check it exists)
    NodeSL<T> pointer = head;
    boolean afterHereFound = false;
    while (pointer != null) {
      if (pointer == afterHere) {
        afterHereFound = true;
        break;
      }
      pointer = pointer.getNext();
    }
    if (!afterHereFound) {
      throw new MissingElementException("afterHere not found in list");
    }

    if (afterHere.getNext() == null) {
      throw new MissingElementException("No nodes after afterHere to extract");
    }

    // check toHere is reachable from afterhere
    pointer = afterHere.getNext();
    boolean toHereFound = false;
    while (pointer != null) {
      if (pointer == toHere) {
        toHereFound = true;
        break;
      }
      pointer = pointer.getNext();
    }
    if (!toHereFound) {
      throw new MissingElementException("toHere not found after afterHere");
    }

    // Perform extracton
    SLL<T> result = new SLL<>();
    result.head = afterHere.getNext();
    result.tail = toHere;

    // count extracted nodes
    int count = 0;
    pointer = result.head;
    while (pointer != null) {
      count++;
      if (pointer == toHere)
        break;
      pointer = pointer.getNext();
    }
    result.size = count;

    // rewrite this list
    afterHere.setNext(toHere.getNext());
    if (toHere.getNext() == null) {
      tail = afterHere;
    }
    size -= result.size;

    toHere.setNext(null);
    return result;
  }

  /**
   * Transfer all nodes from list into this list, inserting them after afterHere
   * leaves the source list empty
   * 
   * @param list      the SLL whose nodes is transfered
   * @param afterHere the node after which to insert
   * @throws MissingElementException if afterHere is not in this list
   */
  public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere) {
    if (list == null || list.isEmpty()) {
      return;
    }
    if (this == list) {
      throw new SelfInsertException("Cannot splice list into itself");
    }

    if (afterHere == null) {
      // Insert at head

      if (this.isEmpty()) {
        this.head = list.head;
        this.tail = list.tail;
      } else {
        list.tail.setNext(this.head);
        this.head = list.head;
      }
      this.size += list.size;
    } else {

      // verify afterHere is in thi list
      NodeSL<T> pointer = this.head;
      boolean found = false;
      while (pointer != null) {
        if (pointer == afterHere) {
          found = true;
          break;
        }
        pointer = pointer.getNext();
      }
      if (!found) {
        throw new MissingElementException("afterHere not found in this list");
      }

      // insert list after afterHere

      list.tail.setNext(afterHere.getNext());
      afterHere.setNext(list.head);

      // update tail if inserted at end
      if (afterHere == this.tail) {
        this.tail = list.tail;
      }
      this.size += list.size;
    }

    /*
     * empty the source list
     */
    list.head = null;
    list.tail = null;
    list.size = 0;
  }
}
