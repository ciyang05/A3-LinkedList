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

    


  // Phase 2

  /** 
   *  Inserts the given item at the tail of the list
   *  @param item to insert 
   */
  public void addLast(T v);


  // NOT RETURNING ANYTHING so will be reassigning linkedList variable to 
  // Chiashi
  /** 
   *  Inserts the given item after the specified node
   *  @param here node to insert after
   *  @param v item to insert 
   */
  public void addAfter(NodeSL<T> here, T v) {
     
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

  // Chiashi
  /** 
   *  Removes the node after the given position
   *  @param here marks position to remove after
   *  @return item removed
   */
  public T removeAfter(NodeSL<T> here) {
    return T;

  }

  // Chiashi
  /**
   *  Returns a count of the number of elements in the list
   *  @return current number of nodes
   */
  public int size() {
    return 0;
  }


 }
