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
        result.append(current.getData())
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


  // NOT tested yet
  // referenced geeksforgeeks
  // Chiashi
  /** 
   *  Inserts the given item after the specified node
   * 
   *  @param here node to insert after
   *  @param v item to insert 
   */
  public void addAfter(NodeSL<T> here, T v) {
    // Initializes pointer reference to head
    NodeSL<T> pointer = head;
    if (here == null){
      throw new MissingElementException("Cannot insert an element after a null node");
    }
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
   *  @throws MissingElementException if the list is empty
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
   *  Removes the given item from the tail of the list
   *  @return item removed
   *  @throws MissingElementException if the list is empty
   */
  public T removeLast() {
    if  ((isEmpty())) {
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

  
  // NOT tested yet
  // Chiashi
  /** 
   *  Removes the node after the given position
   * 
   *  @param here marks position to remove after
   *  @return item removed
   */
  public T removeAfter(NodeSL<T> here) {
    if (isEmpty()){
      throw new MissingElementException("Cannot remove in an empty list");
    }
    if (here == null){
      throw new MissingElementException("Node is null");
    }
    if (here.getNext()== null){
      throw new MissingElementException("Cannot remove an element that does not exist");
    }
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
    System.out.println("This is the removedNode before link to pointer updates: " + removedNode.getData());

    // updates pointer's link to next next node
    pointer.setNext(pointer.getNext().getNext());
    // for testing purposes
    // prints removedNode after linking to pointer updates 
    System.out.println("This is the removedNode after updating pointer: " + removedNode.getData());

    // for testing purposes
    // prints SLL to see if item got removed
    System.out.println("This is the updated SLL after removing item: " + SLL.toString());


    return removedNode.getData();

  }


  // NOT tested yet
  // Chiashi
  /**
   *  Returns a count of the number of elements in the list
   * 
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
  /**
 * extract a subseq from this list and returns it as a new SLL
 * the subseq starts after afterHere and ends at toHere
 * 
 * @param afterHere the node after which extraction begins (null mean start fromhead)
 * @param toHere the last node to extract
 * @return a new SLl that contains the extracted subseq
 * @throws  MissingElementException if toHere is null or nodes are not in the list or has invalid range
 */
public SLL<T> subseqByTransfer(NodeSL<T> afterHere, NodeSL<T> toHere) {
  if (toHere == null) {
    throw new MissingElementException("toHere cannot be null");
  }

  /*
   * case 1 : Extract from the head (afterHere == null)
   */
  if (afterHere == null) {
    if (head == null || head == toHere.getNext()) {
      throw new MissingElementException("invalid extraction range");
  }
    //find toHere starting from head
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
      if (pointer == toHere) break;
      pointer = pointer.getNext();
    }
    result.size = count;

    //update this list
    head = toHere.getNext();
    if (head== null) {
      tail = null;
    }
    size -= result.size;

    toHere.setNext(null);
    return result;
    }

    //case 2: afterHere is not null(check it exists)
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

    //check toHere is reachable from afterhere
    pointer = afterHere.getNext();
    boolean toHereFound = false;
    while (pointer != null){
      if (pointer == toHere) {
        toHereFound = true;
        break;
      }
      pointer = pointer.getNext();
    }
    if (!toHereFound) {
      throw new MissingElementException("toHere not found after afterHere");
    }

    //Perform extracton 
    SLL<T> result = new SLL<>();
    result.head = afterHere.getNext();
    result.tail = toHere;

    //count extracted nodes
    int count = 0;
    pointer = result.head;
    while (pointer != null) {
      count++;
      if (pointer == toHere) break;
      pointer = pointer.getNext();
    }
    result.size = count;

    //rewrite this list
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
 * @param list the SLL whose nodes is transfered 
 * @param afterHere the node after which to insert
 * @throws MissingElementException if afterHere is not in this list
 */
public void spliceByTransfer(SLL<T> list, NodeSL<T> afterHere) {
  if (list == null || list.isEmpty()) {
    return; 
  }
  if (this == list){
    throw new SelfInsertException("Cannot splice list into itself");
  }
  if (afterHere == null) {
    //Insert at head
      
    if (this.isEmpty()) {
      this.head = list.head;
      this.tail = list.tail;
    } else {
      list.tail.setNext(this.head);
      this.head = list.head;
    }
    this.size += list.size;
  } else {

    //verify afterHere is in thi list
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

    //insert list after afterHere
    
    list.tail.setNext(afterHere.getNext());
    afterHere.setNext(list.head);

    //update tail if inserted at end
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


 



