/**
 * Class to implement a singly linked list
 *
 * @author 
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
    
  // Phase 1

  /**
   * Copy constructor 
   */
  public SLL(){
    this.head = null;
    this.tail = null;
    this.size = 0;
  }

  //making new empty constructor
  SLL <String> list = new SLL<>();



  /** 
   *  Accessor for head node
   *  @return the head node
   */
  public NodeSL<T> getHead(){
    return head;
  }
  
  /** 
   *  Accessor for tail node
   *  @return the tail node
   */
  public NodeSL<T> getTail(){
    return tail;
  }

  /** 
   *  Determines whether a list is empty
   *  @return T/F is the list empty?
   */
  public boolean isEmpty(){
    if (head == null){
        return true;
    }
    else{
        return false;
    }
  }

  /** 
   *  Inserts the given item at the head of the list
   *  @param v item to insert 
   */
  public void addFirst(T v){
    NodeSL<T> newNode = new NodeSL<>(v, head);
    head = newNode;
  }
  
  /** Converts to a string representation */
  public String toString(){
    StringBuilder result = new StringBuilder();
    NodeSL<T> current = head;
    while (current != null){
        result.append(current.getNext())
              .append(" ");
        current = current.getNext();
    }
    
    return result.toString();

  }

  // Phase 2

  /** 
   *  Inserts the given item at the tail of the list
   *  @param item to insert 
   */
  public void addLast(T v){
     // to do
  }


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
  public T removeFirst(){
    return null;
  }

  /** 
   *  Removes the given item from the tail of the list
   *  @return item removed
   */
  public T removeLast(){
    //to do
  }

  
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


  // Phase 4

  //copy constructor
  public SLL(SLL<T> other){
    this.head = null;
    this.tail = null;
    this.size = 0;

    NodeSL<T> current = other.getHead();

    while(current != null){
      this.addLast(current.getData());
    }

    current = current.getNext();


  }



  /** 
   *  Makes a copy of elements from the original list
   *  @param here  starting point of copy
   *  @param n  number of items to copy
   *  @return copied list
   */
  public SLL<T> subseqByCopy(NodeSL<T> here, int n){

    //if the started point is null, then exception
    if(here == null){
      throw new IllegalArgumentException("Head can not be null.");
    }

    //if no nodes, then exception
    if(n < 0){
      throw new IllegalArgumentException("You must have nodes or the number of nodes can not be negative.");
    }

    //empty list
    SLL <T> copy = new SLL<>();

    for(int i = 0; i < n; i++){
      T data = here.getData();
      copy.addLast(data);
      here = here.getNext();
    }

    return copy;

  }

  
  /**
   * Places copy of the provided list into this after the specified node.
   * @param list the list to splice in a copy of
   * @param afterHere  marks the position in this where the new list should go
   */
  public void spliceByCopy(SLL<T> list, NodeSL<T> afterHere){
    
    //copying list
    SLL<T> copy = new SLL<>(list);


    NodeSL<T> tail = copy.getHead();

     while(tail.getNext() != null){ // while the next node after the head is not empty
        tail = tail.getNext(); //keep moving until the node has null as the next node aka the last node, making it the tail
     }

     //set the next node after the tail to be the next element after the afterHere
     tail.setNext(afterHere.getNext());

     //make afterHere's next node to be the head of the copied list
     afterHere.setNext(copy.getHead());



  }
  



 }
