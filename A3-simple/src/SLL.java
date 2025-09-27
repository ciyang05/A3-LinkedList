/**
 * Class to implement a singly linked list
 *
 * @author 
 * @version Spring 2024
 */

 public class SLL<T> {

  // Attributes 

  /**
   * Head of the SLL
   */
  NodeSL<T> head;
  /**
   * Tail of the SLL
   */
  NodeSL<T> tail;
  /**
   * Current number of nodes in SLL
   */
  int size; 
  /**
   * Single Linked List holding type T
   */
  SLL<T> SLL; 
    


  // Phase 2

  /** 
   *  Inserts the given item at the tail of the list
   *  @param item to insert 
   */
  public void addLast(T v);


  // NOT tested yet
  // referenced geeksforgeeks
  // Chiashi
  /** 
   *  Inserts the given item after the specified node
   *  @param here node to insert after
   *  @param v item to insert 
   */
  public void addAfter(NodeSL<T> here, T v) {
    // Initializes pointer reference to head
    NodeSL<T> pointer = head;

    // iterate over list to find node to insert item after
    while (pointer != null) {
      // checks if pointer data matches node to insert after data
      if (pointer == here) {
        // for testing purposes
        System.out.println("The node exists.");
        break;
      }
      // reassigns pointer to next node in list
      pointer = pointer.getNext();
    }

    // creates newNode that sets v as its data and links to pointer's next node
    NodeSL<T> newNode = new NodeSL<T>(v, pointer.getNext());
    // links pointer to newNode 
    pointer.setNext(newNode);

    // for testing purposes
    // prints SLL to see if item got added
    System.out.println("This is the SLL after adding item: " + SLL.toString());

  }


  /** 
   *  Removes the given item from the head of the list
   *  @return v item removed
   */
  public T removeFirst();

  /** 
   *  Removes the given item from the tail of the list
   *  @return item removed
   */
  public T removeLast();

  
  // NOT tested yet
  // Chiashi
  /** 
   *  Removes the node after the given position
   *  @param here marks position to remove after
   *  @return item removed
   */
  public T removeAfter(NodeSL<T> here) {
    NodeSL<T> pointer = head;

    while (pointer != null) {
      if (pointer == here) {
        System.out.println("The node exists");
        break;
      }
      pointer = pointer.getNext();
    }

    // assigns removedItem to variable to return later
    NodeSL<T> removedNode = pointer.getNext();
    // for testing purposes
    // prints removedNode before link to pointer updates
    System.out.println("This is the removedNode: " + removedNode.getData());

    // updates pointer's link to next next node
    pointer.setNext(pointer.getNext().getNext());
    // for testing purposes
    // prints removedNode after linking to pointer updates 
    System.out.println("This is the removedNode after updating pointer " + removedNode.getData());

    // for testing purposes
    // prints SLL to see if item got removed
    System.out.println("This is the updated SLL after removing item: " + SLL.toString());


    return removedNode.getData();

  }


  // NOT tested yet
  // Chiashi
  /**
   *  Returns a count of the number of elements in the list
   *  @return current number of nodes
   */
  public int size() {
    // counter to keep track of number of elements in list, initialized to 0
    int count = 0;
    NodeSL<T> pointer = head;

    // checks if next node isn't null, then increments 1 to counter
    while(pointer.getNext() != null) {
      count = count + 1;
    }

    // updates size attribute to counter
    this.size = count;

    // for testing purposes
    // checks if count and current size match
    System.out.println("This is the count: " + count);
    System.out.println("This is the current size: " + size);

    return count;
  }


 }
