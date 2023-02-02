

/**
 * BinaryTreeADT defines the interface to a binary tree data structure.
 *
 * @author Lewis and Chase
 * @version 4.0
 * 
 * Modified by Jiayin Wang for CSIT212 Lab 4
 */
import java.util.Iterator;

public interface BinaryTreeADT<T> 
{
   /** Removes the left subtree of the root of this binary tree. */
   public void removeLeftSubtree();

   /**  Removes the right subtree of the root of this binary tree. */
   public void removeRightSubtree();

   /**  Removes all elements from this binary tree. */
   public void removeAllElements();

   /**  Returns true if this binary tree is empty and false otherwise. */
   public boolean isEmpty();

   /**  Returns the number of elements in this binary tree. */
   public int size();

   /**  Returns true if the binary tree contains an element that matches
        the specified element and false otherwise. */
   public boolean contains (T targetElement);

   /**  Returns a reference to the specified element if it is found in 
        this binary tree.  Returns a null value if the specified element
        is not found.*/
   public T find (T targetElement);

   /**  Returns the string representation of the binary tree. */
   public String toString();

   /**  Performs an inorder traversal on this binary tree by calling an 
        overloaded, recursive inorder method that starts with the root. */
   public Iterator<T> iteratorInOrder();

   /**  Performs a preorder traversal on this binary tree by calling an 
        overloaded, recursive preorder method that starts with the root. */
   public Iterator<T> iteratorPreOrder();

   /**  Performs a postorder traversal on this binary tree by calling an 
        overloaded, recursive postorder method that starts with the root. */
   public Iterator<T> iteratorPostOrder();

   /**  Performs a levelorder traversal on the binary tree, using a queue. */
   public Iterator<T> iteratorLevelOrder();
}
